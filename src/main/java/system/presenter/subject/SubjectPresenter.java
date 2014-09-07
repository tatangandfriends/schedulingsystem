/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.subject;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javax.inject.Inject;
import system.business.models.Subject;
import system.business.models.Teacher;
import system.business.services.SubjectService;
import system.presenter.main.MainView;
import system.presenter.subjectinput.SubjectInputView;
import system.presenter.teacherinput.TeacherInputView;

/**
 * FXML Controller class
 *
 * @author BlackBox
 */
public class SubjectPresenter implements Initializable {
    @FXML
    private AnchorPane currentPane;
    @FXML
    private StackPane stackPane;
    @FXML
    private Button removeBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button addBtn;
    
    private ObjectProperty<Subject> selectedSubject;
    
    ObservableList<Subject> subjects;   
    TableView<Subject> subjectTable;
    ProgressIndicator progressIndicator;    
    Region veil;    
    Task<ObservableList<Subject>> task;
    
   
    @Inject
    SubjectService ss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectedSubject = new SimpleObjectProperty<>();
        subjects = FXCollections.observableArrayList();
        prepareTable();
        getAllFromDB();
    }    
     @FXML
    private void SubjectList(ActionEvent event){
        currentPane.getChildren().clear();
        currentPane.getChildren().add(new SubjectInputView().getView());
    }
    private void prepareTable(){
        subjectTable = new TableView<>();
        this.subjectTable.setEditable(false);
        ObservableList columns = subjectTable.getColumns();
        final TableColumn firstNameColumn = createTextColumn("subCode", "Subject Code");
        columns.add(firstNameColumn);
        final TableColumn lastNameColumn = createTextColumn("subDesc", "Subject Description");
        columns.add(lastNameColumn);
        final TableColumn unitColumn = createTextColumn("unit", "No. of Unit");
        columns.add(unitColumn);
        
        subjectTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        subjectTable.setItems(subjects);
        subjectTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);   
    
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
        task = new Task<ObservableList<Subject>>() {
            @Override
            protected ObservableList<Subject> call() throws Exception {                
                    List<Subject> subjectList= ss.getAll();
//                if(!searchField.getText().isEmpty()){
//                    teacherList = ts.findByName(searchField.textProperty().get());
//                }                
////                if(courseCb.getSelectionModel().getSelectedItem() != null){
////                    studentList = FXCollections.observableArrayList(ss.findByCourseCode(courseCb.getSelectionModel().getSelectedItem()));
////                }
                Thread.sleep(5);
                subjects = FXCollections.observableArrayList(subjectList);                
                return subjects;
                
            }
        };
                          
        progressIndicator.progressProperty().bind(task.progressProperty());
        veil.visibleProperty().bind(task.runningProperty());
        progressIndicator.visibleProperty().bind(task.runningProperty());
        subjectTable.itemsProperty().bind(task.valueProperty()); 
        stackPane.getChildren().addAll(subjectTable,veil,progressIndicator);
        new Thread(task).start();
     
        
        
    }
//      @FXML
//    private void editTeacher(ActionEvent event) {
//        if(subjectTable.getSelectionModel().getSelectedItem() != null){
//            TeacherInputView tIv = new TeacherInputView();                    
//            TeacherInputPresenter tIP= (TeacherInputPresenter) tIv.getPresenter();
//            tIP.getSelectedTeacher().set(teacherTable.getSelectionModel().getSelectedItem());
////            selectedEmployee.bindBidirectional(eIP.getSelectedEmployee());
//            currentPane.getChildren().clear();
//            currentPane.getChildren().add(tIv.getView());
//        }
//    }
    @FXML
    private void removeTeacher(ActionEvent event) {
        ss.remove(this.subjectTable.getSelectionModel().getSelectedItem());
        AnchorPane a = (AnchorPane) currentPane.getParent();
        a.getChildren().clear();
        a.getChildren().add(new SubjectView().getView());
    }
    
    @FXML
    private void cancelHome(ActionEvent event) {
        cancel();
    }
    
    private void cancel(){
         AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new MainView().getView());            
        
    }
    
    
}
