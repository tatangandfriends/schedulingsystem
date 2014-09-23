/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.studentinput;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.business.models.Course;
import system.business.models.Student;
import system.business.services.StudentService;
import system.presenter.addstudent.AddStudView;

/**
 * FXML Controller class
 *
 * @author dennis
 */
public class StudentinputPresenter implements Initializable {
    
    @FXML
    private AnchorPane currentPane;
    @FXML
    private ComboBox<Course> courseCb;
    @FXML
    private Button saveBtn;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    
    private ObjectProperty<Student> selectedStudent;
    private ObservableList<Course> courseList;
   
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
        selectedStudent = new SimpleObjectProperty<>(new Student());
        selectedStudent.addListener(selectedStudentListener());
        currentPane.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {            
            if(event.getCode() == KeyCode.ENTER){                   
                savyy();
            }
        });
    }    
     @FXML
    private void preparedCourseBox(Event event){
        courseList = FXCollections.observableList(ss.findCourseAll(courseCb.getEditor().textProperty().get()));
        courseCb.setItems(courseList);
    }
    public void preparedCourseBox(){

        ObservableList<Course> courseList1 = FXCollections.observableArrayList(courseList);
        courseCb.setItems(courseList1);
    }
    @FXML
    private void saveStudent(ActionEvent event) {
        savyy();
    }
    
    private void savyy(){
        if(!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()){
            getSelectedStudent().get().setFname(firstNameField.textProperty().get());
            getSelectedStudent().get().setLname(lastNameField.textProperty().get());
            if(courseCb.getSelectionModel().getSelectedItem() != null){
                Course c = courseCb.getSelectionModel().getSelectedItem();                
                getSelectedStudent().get().setCourse(c);
        }else{
                Course c;
                try {
                    c = ss.findCourse(courseCb.getEditor().textProperty().get());
                } catch (Exception e) {
                    c = null;
                }
                getSelectedStudent().get().setCourse(c);
            }
            
            ss.save(getSelectedStudent().get());
            AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new AddStudView().getView());            
        }
    }
 
 

    /**
     * @return the selectedStudent
     */
    public ObjectProperty<Student> getSelectedStudent() {
        return selectedStudent;
    }
    
    private ChangeListener<Student> selectedStudentListener(){
       ChangeListener<Student> selectedStudentListener = new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                if (newValue != null) {                    
                    firstNameField.setText(newValue.getFname());
                    lastNameField.setText(newValue.getLname());
                    courseCb.getSelectionModel().select(newValue.getCourse());
                } else {
                    
                }
            }
        };
       return selectedStudentListener;
    }
    
   @FXML
    private void cancelStudent(ActionEvent event) {
        cancel();
    }
    
    private void cancel(){
         AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new AddStudView().getView());            
        }
    }

