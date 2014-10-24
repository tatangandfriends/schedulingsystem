/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.views.schedule;

import com.sun.javafx.tk.quantum.MasterTimer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.business.models.Schedule;
import system.business.services.MainService;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class SchedulePresenter implements Initializable, ControlledScreen {

    ViewController viewController;
    
    @Inject
    MainService service;
    @FXML
    private AnchorPane currentPane;
    @FXML
    private TableView<Schedule> scheduleTableView;
    @FXML
    private TableColumn<Schedule, String> teacherNameColumn;
    @FXML
    private TableColumn<Schedule, String> roomNameColumn;
    @FXML
    private TableColumn<Schedule, String> timeNameColumn;
    @FXML
    private TableColumn<Schedule, String> sectionNameColumn;
    @FXML
    private Button editActionButton;
    @FXML
    private Button removeActionButton;
    
    ObservableList<Schedule> masterData;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        masterData = FXCollections.observableArrayList(service.getAllSchedules());
        scheduleTableView.setItems(masterData);
        teacherNameColumn.setCellValueFactory((cellData) -> cellData.getValue().getTeacher().lastNameProperty().concat(" , ")
        .concat(cellData.getValue().getTeacher().firstNameProperty()));
        roomNameColumn.setCellValueFactory((cellData) -> new SimpleStringProperty(""+cellData.getValue().getRoom().roomNumberProperty()));
        timeNameColumn.setCellValueFactory((cellData) -> cellData.getValue().getTime().timeStartProperty()
                .concat(" - ").concat(cellData.getValue().getTime().timeEndProperty()));
        sectionNameColumn.setCellValueFactory((cellData) -> cellData.getValue().getSection().sectionCodeProperty());
    }    

    @Override
    public void setScreenParent(ViewController screenParent) {
       viewController = screenParent;
    }

    @FXML
    private void editActionButton(ActionEvent event) {
        
    }

    @FXML
    private void removeActionButton(ActionEvent event) {
        
        
    }
    
    
    
}
