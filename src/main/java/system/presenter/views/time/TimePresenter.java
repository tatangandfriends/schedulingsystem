/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.views.time;

import java.net.URL;
import java.util.ResourceBundle;
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
import system.business.models.TimeType;
import system.business.services.MainService;
import system.presenter.forms.timeform.TimeFormPresenter;
import system.presenter.forms.timeform.TimeFormView;
import system.presenter.main.MainPresenter;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class TimePresenter implements Initializable, ControlledScreen {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<TimeType> timeTableView;
    @FXML
    private TableColumn<TimeType, String> nameColumn;
    @FXML
    private TableColumn<TimeType, String> timeStartColumn;
    @FXML
    private TableColumn<TimeType, String> timeEndColumn;
    @FXML
    private Button editButton;
    @FXML
    private Button removeButton;
    
    ObservableList<TimeType> masterData;
    
    ViewController viewController;
    
    @Inject
    MainService service;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory((cellData) -> cellData.getValue().nameProperty());
        timeStartColumn.setCellValueFactory((cellData) -> cellData.getValue().timeStartProperty());
        timeEndColumn.setCellValueFactory((cellData) -> cellData.getValue().timeEndProperty());
        masterData = FXCollections.observableArrayList(service.getAllTime());
        timeTableView.setItems(masterData);
    }    
    
    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }
    @FXML
    private void editAction(ActionEvent event) {
        viewController.unloadScreen(MainPresenter.timeForm);
        TimeFormView tFv = new TimeFormView();
        TimeFormPresenter tFp = (TimeFormPresenter) tFv.getPresenter();
        tFp.setTimeType(timeTableView.getSelectionModel().getSelectedItem());        
        viewController.loadScreen(MainPresenter.timeForm, tFv);
        viewController.setScreen(MainPresenter.timeForm);
    }

    @FXML
    private void removeAction(ActionEvent event) {
       service.delete(timeTableView.getSelectionModel().getSelectedItem());
       updateData();
    }
    
    private void updateData(){
//        subjectTableView.getSelectionModel().clearSelection();
        timeTableView.setItems(FXCollections.observableArrayList(service.getAllTime()));
    }
    
}
