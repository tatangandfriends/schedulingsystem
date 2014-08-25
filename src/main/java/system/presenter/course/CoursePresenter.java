/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.course;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.business.models.Course;
import system.business.models.Student;
import system.business.services.StudentService;
import system.presenter.addstudent.AddStudView;
import system.presenter.studentinput.StudentinputView;

/**
 * FXML Controller class
 *
 * @author dennis
 */
public class CoursePresenter implements Initializable {
    @FXML
    private AnchorPane coursePane;
    @FXML
    private Button courseBtn;
    @FXML
    private ComboBox<Course> courseCb;
    @FXML
    private TextField courseField;
    
    private ObjectProperty<Student> selectedStudent;
    @Inject
    StudentService ss;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void saveCourse(ActionEvent event) {
        savyy();
    }
    
    private void savyy(){
        if(!courseCb.getSelectionModel().isEmpty()){
            getSelectedStudent().get().setCourse(courseCb.getSelectionModel().getSelectedItem());
            ss.save(getSelectedStudent().get());
            AnchorPane anchorPane = (AnchorPane)coursePane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new StudentinputView().getView());            
        }
    }
    
       public ObjectProperty<Student> getSelectedStudent() {
        return selectedStudent;
       }
}
