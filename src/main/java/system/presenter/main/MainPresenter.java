/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.business.services.MainService;
import system.presenter.forms.subjectform.SubjectFormView;
import system.presenter.forms.teacherform.TeacherFormView;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.presenter.views.subject.SubjectView;
import system.presenter.views.teacher.TeacherView;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class MainPresenter implements Initializable, ControlledScreen {
    
    
    
    @FXML
    private AnchorPane centerPane;
    
    ViewController viewController;
    Group group;
    
    public static final String subjectViewAll = "subjectViewAll";
    SubjectView subjectView;
    public static final String subjectForm = "subjectForm";
    SubjectFormView subjectFormView;
    
    public static final String teacherViewAll = "teacherViewAll";
    TeacherView teacherView;
    public static final String teacherForm = "teacherForm";
    TeacherFormView teacherFormView;
    
    
    @Inject
    MainService service;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        viewController = new ViewController();
        group = new Group();
        group.getChildren().addAll(viewController);
        centerPane.getChildren().add(group);
    }    

    @FXML
    private void viewAllSubjectAction(ActionEvent event) {
        viewController.unloadScreen(subjectViewAll);
        subjectView = new SubjectView();
        viewController.loadScreen(subjectViewAll, subjectView);  
        viewController.setScreen(MainPresenter.subjectViewAll);
    }

    @FXML
    private void addNewSubjectAction(ActionEvent event) {
        viewController.unloadScreen(subjectForm);
        subjectFormView = new SubjectFormView();
        viewController.loadScreen(subjectForm, subjectFormView);  
        viewController.setScreen(MainPresenter.subjectForm);
    }
    
    @FXML
    private void viewAllTeacherAction(ActionEvent event) {
        viewController.unloadScreen(teacherViewAll);
        teacherView = new TeacherView();
        viewController.loadScreen(teacherViewAll, teacherView);  
        viewController.setScreen(MainPresenter.teacherViewAll);
    }
    
    @FXML
    private void addNewTeacherAction(ActionEvent event) {
        viewController.unloadScreen(subjectForm);
        teacherFormView = new TeacherFormView();
        viewController.loadScreen(teacherForm, teacherFormView);  
        viewController.setScreen(MainPresenter.teacherForm);
    }

    @FXML
    private void viewAllRoomAction(ActionEvent event) {
    }

    @FXML
    private void addNewRoomAction(ActionEvent event) {
    }

    @FXML
    private void viewAllSectionAction(ActionEvent event) {
    }

    @FXML
    private void addNewSectionAction(ActionEvent event) {
    }

    @FXML
    private void viewAllTimeAction(ActionEvent event) {
    }

    @FXML
    private void addNewTimeAction(ActionEvent event) {
    }

    @FXML
    private void viewAllSchedule(ActionEvent event) {
    }

    @FXML
    private void addNewScheduleAction(ActionEvent event) {
    }

    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }
    
    
}
