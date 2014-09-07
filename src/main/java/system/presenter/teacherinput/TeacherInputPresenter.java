/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.teacherinput;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.business.models.Course;
import system.business.models.Student;
import system.business.models.Teacher;
import system.business.services.TeacherService;
import system.presenter.addstudent.AddStudView;
import system.presenter.teacher.TeacherView;

/**
 * FXML Controller class
 *
 * @author BlackBox
 */
public class TeacherInputPresenter implements Initializable {
    @FXML
    private AnchorPane currentPane;
    @FXML
    private Button saveBtn;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Button backBtn;
    
    private ObjectProperty<Teacher> selectedTeacher;

   @Inject
   TeacherService ts;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         selectedTeacher = new SimpleObjectProperty<>(new Teacher());
        selectedTeacher.addListener(selectedTeacherListener());
//        currentPane.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {            
//            if(event.getCode() == KeyCode.ENTER){                   
//                savyy();
//            }
//        });
    }
    
    @FXML
    private void saveTeacher(ActionEvent event) {
        savyy();
    }
    
    private void savyy(){
        if(!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()){
            getSelectedTeacher().get().setFname(firstNameField.textProperty().get());
            getSelectedTeacher().get().setLname(lastNameField.textProperty().get());
//            if(courseCb.getSelectionModel().getSelectedItem() != null){
//                Course c = courseCb.getSelectionModel().getSelectedItem();                
//                getSelectedStudent().get().setCourse(c);
//            }else{
//                Course c;
//                try {
//                    c = ss.findCourse(courseCb.getEditor().textProperty().get());
//                } catch (Exception e) {
//                    c = null;
//                }
//                getSelectedStudent().get().setCourse(c);
//            }
            
            ts.save(getSelectedTeacher().get());
            AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new TeacherView().getView());            
        }
    }
    public ObjectProperty<Teacher> getSelectedTeacher() {
        return selectedTeacher;
    }
    
    private ChangeListener<Teacher> selectedTeacherListener(){
       ChangeListener<Teacher> selectedTeacherListener = new ChangeListener<Teacher>() {
            @Override
            public void changed(ObservableValue<? extends Teacher> observable, Teacher oldValue, Teacher newValue) {
                if (newValue != null) {                    
                    firstNameField.setText(newValue.getFname());
                    lastNameField.setText(newValue.getLname());
//                    courseCb.getSelectionModel().select(newValue.getCourse());
                } else {
                    
                }
            }
        };
       return selectedTeacherListener;
    }
    
    @FXML
    private void cancelTeacher(ActionEvent event) {
        cancel();
    }
    
    private void cancel(){
         AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new TeacherView().getView());            
        
    }
}
