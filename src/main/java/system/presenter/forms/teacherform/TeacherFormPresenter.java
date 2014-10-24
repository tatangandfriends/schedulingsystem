/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.forms.teacherform;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.inject.Inject;
import system.business.models.Teacher;
import system.business.services.MainService;
import system.presenter.main.MainPresenter;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.presenter.views.subject.SubjectView;
import system.presenter.views.teacher.TeacherView;


/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class TeacherFormPresenter implements Initializable, ControlledScreen {

    ViewController viewController;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Button saveTeacherButton;
    
    private ObjectProperty<Teacher> teacher;
    
    @Inject
    MainService service;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTeacher(new SimpleObjectProperty<>());
        getTeacher().addListener((ObservableValue<? extends Teacher> observable, Teacher oldValue, Teacher newValue) -> {
            firstNameField.setText(newValue.getFname());
            lastNameField.setText(newValue.getLname());
            saveTeacherButton.setText("Update");
        });
        
        
    }    

    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void saveTeacherButton(ActionEvent event) {
        Teacher teacher;
        if(getTeacher().get() == null){
            teacher = new Teacher();
        }else{
            teacher = getTeacher().get();
        }
        teacher.setFname(firstNameField.textProperty().get());
        teacher.setLname(lastNameField.textProperty().get());
        service.save(teacher);
        viewController.unloadScreen(MainPresenter.teacherViewAll);
        TeacherView teacherView = new TeacherView();
        viewController.loadScreen(MainPresenter.teacherViewAll, teacherView);  
        viewController.setScreen(MainPresenter.teacherViewAll);
    }

    public ObjectProperty<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(ObjectProperty<Teacher> teacher) {
        this.teacher = teacher;
    }
    
    public void setTeacher(Teacher teacher){
        this.teacher.set(teacher);
    }
  
}
