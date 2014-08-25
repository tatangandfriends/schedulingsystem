/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.addstudent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javax.inject.Inject;
import system.business.models.Course;
import system.business.models.Student;
import system.business.services.StudentService;
import system.presenter.main.MainView;
import system.presenter.studentinput.StudentinputPresenter;
import system.presenter.studentinput.StudentinputView;

/**
 * FXML Controller class
 *
 * @author dennis
 */
public class AddStudPresenter implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ComboBox<?> semesterCb;
    @FXML
    private ComboBox<Course> courseCb;
    @FXML
    private TextField searchField;
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button clearButton;
    private ObservableList<Course> courseList;
    
   
    @FXML
    private StackPane stackPane;

    private ObjectProperty<Student> selectedStudent;
    
    ObservableList<Student> students;   
    TableView<Student> studentTable;
    ProgressIndicator progressIndicator;    
    Region veil;    
    Task<ObservableList<Student>> task;
    
   
    @Inject
    StudentService ss;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        courseList = FXCollections.observableArrayList(ss.findAllCourse());
        courseCb.setItems(courseList);
        selectedStudent = new SimpleObjectProperty<>();
        students = FXCollections.observableArrayList();
        prepareTable();
        getAllFromDB();
        searchField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(newValue.isEmpty()){
                getAllFromDB(); 
            }
//            }else{
//                getAllFromDB();
//            }
        });
        anchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {            
            if(event.getCode() == KeyCode.ENTER){                   
                
                sarche();
            }
        });
        
       courseCb.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Course> observable, Course oldValue, Course newValue) -> {
           
            if(newValue != oldValue){
                getAllFromDB(); 
            }
        });
       
    }
    
    @FXML
    private void studentList(ActionEvent event){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(new StudentinputView().getView());
    }
    
    
    private void prepareTable(){
        studentTable = new TableView<>();
        this.studentTable.setEditable(false);
        ObservableList columns = studentTable.getColumns();
        final TableColumn firstNameColumn = createTextColumn("fname", "First Name");
        columns.add(firstNameColumn);
        final TableColumn lastNameColumn = createTextColumn("lname", "Last Name");
        columns.add(lastNameColumn);
        TableColumn<Student, Course> courseColumn= new TableColumn<>("Course");
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        courseColumn.setCellFactory(new Callback<TableColumn<Student, Course>, TableCell<Student, Course>>() {
        @Override
        public TableCell<Student, Course> call(TableColumn<Student, Course> param) {
        return new TableCell<Student, Course>() {
            @Override
            protected void updateItem(Course item, boolean empty) {
                super.updateItem(item, empty);
                if(!empty){
                    if(item != null){
                        setText(item.getCourseCode());
                    }
                    
                }else {
                setText(null);
              }
            }
        };
        }
        });
       columns.add(courseColumn);
        studentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        studentTable.setItems(students);
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);        
    }
    
    //create text column
    private TableColumn createTextColumn(String name, String caption) {
        TableColumn column = new TableColumn(caption);
        column.setCellValueFactory(new PropertyValueFactory<>(name));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        return column;
    }
    
    
    
    private void sarche(){
        if(!searchField.getText().isEmpty()){
           getAllFromDB();
        }
    }
    @FXML
    private void editStudent(ActionEvent event) {
        if(studentTable.getSelectionModel().getSelectedItem() != null){
            StudentinputView sIv = new StudentinputView();                    
            StudentinputPresenter sIP= (StudentinputPresenter) sIv.getPresenter();
            sIP.getSelectedStudent().set(studentTable.getSelectionModel().getSelectedItem());
//            selectedEmployee.bindBidirectional(eIP.getSelectedEmployee());
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(sIv.getView());
        }
    }
    @FXML
    private void clearSelection(ActionEvent event) {
        courseCb.getSelectionModel().clearSelection();
        searchField.setText("");
        getAllFromDB();
    }
    
    
     //load all candidates from DB
    private void getAllFromDB() {
        stackPane.getChildren().clear();
        progressIndicator = new ProgressIndicator();
        progressIndicator.setMaxSize(150, 150);
        veil = new Region();
        veil.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
        task = new Task<ObservableList<Student>>() {
            @Override
            protected ObservableList<Student> call() throws Exception {                
                    List<Student> studentList= ss.getAll();
                if(!searchField.getText().isEmpty()){
                    studentList = ss.findByName(searchField.textProperty().get());
                }                
                if(courseCb.getSelectionModel().getSelectedItem() != null){
                    studentList = FXCollections.observableArrayList(ss.findByCourseCode(courseCb.getSelectionModel().getSelectedItem()));
                }
                Thread.sleep(5);
                students = FXCollections.observableArrayList(studentList);                
                return students;
            }
        };
        progressIndicator.progressProperty().bind(task.progressProperty());
        veil.visibleProperty().bind(task.runningProperty());
        progressIndicator.visibleProperty().bind(task.runningProperty());
        studentTable.itemsProperty().bind(task.valueProperty()); 
        stackPane.getChildren().addAll(studentTable,veil,progressIndicator);
        new Thread(task).start();
    }
    
}