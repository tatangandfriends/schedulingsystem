/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.forms.scheduleform;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javax.inject.Inject;
import system.business.models.ClassSection;
import system.business.models.Room;
import system.business.models.Schedule;
import system.business.models.Subject;
import system.business.models.Teacher;
import system.business.models.TimeType;
import system.business.models.enums.Days;
import system.business.services.MainService;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class ScheduleFormPresenter implements Initializable, ControlledScreen {
    
    ViewController viewController;
    @FXML
    private Button saveButton;
    @FXML
    private ComboBox<Subject> subjectComboBox;
    @FXML
    private ComboBox<Teacher> teacherComboBox;
    @FXML
    private ComboBox<Room> roomComboBox;
    @FXML
    private ComboBox<TimeType> timeComboBox;
    @FXML
    private ComboBox<ClassSection> sectionComboBox;
    
    @Inject
    MainService service;
    
    ObjectProperty<Schedule> schedule;
    @FXML
    private ComboBox<Days> dayComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeComboBox.setItems(FXCollections.observableArrayList(service.getAllTime()));
        roomComboBox.setItems(FXCollections.observableArrayList(service.getAllRooms()));
        teacherComboBox.setItems(FXCollections.observableArrayList(service.getAllTeachers()));
        subjectComboBox.setItems(FXCollections.observableArrayList(service.getAllSubjects()));
        dayComboBox.setItems(FXCollections.observableArrayList(Days.values()));
        sectionComboBox.setItems(FXCollections.observableArrayList(service.getAllSection()));
        
        schedule = new SimpleObjectProperty<>();
        schedule.addListener((ObservableValue<? extends Schedule> observable, Schedule oldValue, Schedule newValue) -> {
            timeComboBox.getSelectionModel().select(newValue.getTime());
            roomComboBox.getSelectionModel().select(newValue.getRoom());
            teacherComboBox.getSelectionModel().select(newValue.getTeacher());
            sectionComboBox.getSelectionModel().select(newValue.getSection());
            subjectComboBox.getSelectionModel().select(newValue.getSubject());
        });
        
    }    

    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        Schedule sched;
        if(schedule.get() == null){
            sched = new Schedule();
        }else{
            sched = schedule.get();
        }
        
        sched.setDay(dayComboBox.getSelectionModel().getSelectedItem());
        sched.setRoom(roomComboBox.getSelectionModel().getSelectedItem());
        
    }
    
}
