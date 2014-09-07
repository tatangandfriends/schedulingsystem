/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.teacher;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javax.inject.Inject;
import system.business.models.Course;
import system.business.models.Student;
import system.business.models.Teacher;
import system.business.services.StudentService;
import system.business.services.TeacherService;
import system.presenter.teacherinput.TeacherInputPresenter;
import system.presenter.teacherinput.TeacherInputView;

/**
 * FXML Controller class
 *
 * @author dennis
 */
public class TeacherPresenter implements Initializable {
    @FXML
    private AnchorPane currentPane;
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button backBtn;
    @FXML
    private StackPane stackPane;

    
    private ObjectProperty<Teacher> selectedTeacher;
    
    ObservableList<Teacher> teachers;   
    TableView<Teacher> teacherTable;
    ProgressIndicator progressIndicator;    
    Region veil;    
    Task<ObservableList<Teacher>> task;
    
   
    @Inject
    TeacherService ts;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectedTeacher = new SimpleObjectProperty<>();
        teachers = FXCollections.observableArrayList();
        prepareTable();
        getAllFromDB();
        
    }    
     @FXML
    private void teacherList(ActionEvent event){
        currentPane.getChildren().clear();
        currentPane.getChildren().add(new TeacherInputView().getView());
    }
    
    
    private void prepareTable(){
        teacherTable = new TableView<>();
        this.teacherTable.setEditable(false);
        ObservableList columns = teacherTable.getColumns();
        final TableColumn firstNameColumn = createTextColumn("fname", "First Name");
        columns.add(firstNameColumn);
        final TableColumn lastNameColumn = createTextColumn("lname", "Last Name");
        columns.add(lastNameColumn);
//        TableColumn<Student, Course> courseColumn= new TableColumn<>("Course");
//        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
//        courseColumn.setCellFactory(new Callback<TableColumn<Student, Course>, TableCell<Student, Course>>() {
//        @Override
//        public TableCell<Student, Course> call(TableColumn<Student, Course> param) {
//        return new TableCell<Student, Course>() {
//            @Override
//            protected void updateItem(Course item, boolean empty) {
//                super.updateItem(item, empty);
//                if(!empty){
//                    if(item != null){
//                        setText(item.getCourseCode());
//                    }
//                    
//                }else {
//                setText(null);
//              }//            }

//        };
//        }
//        });
//       columns.add(courseColumn);
        teacherTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        teacherTable.setItems(teachers);
        teacherTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);        
    }
    private TableColumn createTextColumn(String name, String caption) {
        TableColumn column = new TableColumn(caption);
        column.setCellValueFactory(new PropertyValueFactory<>(name));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        return column;
    }
    
    private void getAllFromDB() {
        stackPane.getChildren().clear();
        progressIndicator = new ProgressIndicator();
        progressIndicator.setMaxSize(150, 150);
        veil = new Region();
        veil.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
        task = new Task<ObservableList<Teacher>>() {
            @Override
            protected ObservableList<Teacher> call() throws Exception {                
                    List<Teacher> teacherList= ts.getAll();
//                if(!searchField.getText().isEmpty()){
//                    teacherList = ts.findByName(searchField.textProperty().get());
//                }                
////                if(courseCb.getSelectionModel().getSelectedItem() != null){
////                    studentList = FXCollections.observableArrayList(ss.findByCourseCode(courseCb.getSelectionModel().getSelectedItem()));
////                }
                Thread.sleep(5);
                teachers = FXCollections.observableArrayList(teacherList);                
                return teachers;
                
            }
        };
                          
        progressIndicator.progressProperty().bind(task.progressProperty());
        veil.visibleProperty().bind(task.runningProperty());
        progressIndicator.visibleProperty().bind(task.runningProperty());
        teacherTable.itemsProperty().bind(task.valueProperty()); 
        stackPane.getChildren().addAll(teacherTable,veil,progressIndicator);
        new Thread(task).start();
         
    }
    @FXML
    private void editTeacher(ActionEvent event) {
        if(teacherTable.getSelectionModel().getSelectedItem() != null){
            TeacherInputView tIv = new TeacherInputView();                    
            TeacherInputPresenter tIP= (TeacherInputPresenter) tIv.getPresenter();
            tIP.getSelectedTeacher().set(teacherTable.getSelectionModel().getSelectedItem());
//            selectedEmployee.bindBidirectional(eIP.getSelectedEmployee());
            currentPane.getChildren().clear();
            currentPane.getChildren().add(tIv.getView());
        }
    }
    
    @FXML
    private void cancelHome(ActionEvent event) {
        cancel();
    }
    
    private void cancel(){
         AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new TeacherView().getView());            
        
    }
}
