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
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.presenter.views.subject.SubjectView;

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
    
     private static final String subjectViewAll = "subjectViewAll";
     SubjectView subjectView;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        viewController = new ViewController();
        group = new Group();
        centerPane.getChildren().add(group);
    }    

    @FXML
    private void viewAllSubjectAction(ActionEvent event) {
        subjectView = new SubjectView();
        viewController.loadScreen(subjectViewAll, subjectView);
        group.getChildren().add(viewController);
        
    }

    @FXML
    private void addNewSubjectAction(ActionEvent event) {
    }

    @FXML
    private void viewAllTeacherAction(ActionEvent event) {
    }

    @FXML
    private void addNewTeacherAction(ActionEvent event) {
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
