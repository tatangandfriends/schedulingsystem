/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.studentinput;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
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
    private Button saveBtn;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    
    private ObjectProperty<Student> selectedStudent;
    @Inject
    StudentService ss;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectedStudent = new SimpleObjectProperty<>(new Student());
        selectedStudent.addListener(selectedStudentListener());
        currentPane.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {            
            if(event.getCode() == KeyCode.ENTER){                   
                savyy();
            }
        });
    }    
    @FXML
    private void saveStudent(ActionEvent event) {
        savyy();
    }
    
    private void savyy(){
        if(!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()){
            getSelectedStudent().get().setFname(firstNameField.textProperty().get());
            getSelectedStudent().get().setLname(lastNameField.textProperty().get());
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
                } else {
                    
                }
            }
        };
       return selectedStudentListener;
    }
    
}
