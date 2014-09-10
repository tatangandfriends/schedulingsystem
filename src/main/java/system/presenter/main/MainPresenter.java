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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.business.services.StudentService;
import system.presenter.studentinput.StudentinputPresenter;
import system.presenter.studentinput.StudentinputView;
import system.presenter.addstudent.AddStudPresenter;
import system.presenter.addstudent.AddStudView;
import system.presenter.course.CourseView;
import system.presenter.subject.SubjectView;
import system.presenter.teacher.TeacherView;
import system.presenter.timeandroom.TimeAndRoomView;



public class MainPresenter implements Initializable{
    
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuItem addStud;
    
    @FXML 
    private MenuItem addTeach;
    
    @FXML
    private MenuItem addTimeAndRoom;
    
    private AddStudPresenter addStudPresenter;
 
    private StudentinputPresenter studentInputPresenter;
    

    
    
    @Inject
    StudentService ss;
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void addStud(ActionEvent event){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(new AddStudView().getView());
    }
     @FXML
    private void addCourse(ActionEvent event){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(new CourseView().getView());
    }
    @FXML
    private void studentList(ActionEvent event){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(new StudentinputView().getView());
    }
    @FXML
    private void addTeacher(ActionEvent event){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(new TeacherView().getView());
    }
    @FXML
    private void addSubject(ActionEvent event){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(new SubjectView().getView());
    }
    
    @FXML
    private void addTimeAndRoom(ActionEvent event){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(new TimeAndRoomView().getView());
    }
   
    
    
}    