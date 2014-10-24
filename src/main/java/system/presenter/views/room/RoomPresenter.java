/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.views.room;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.business.models.Room;
import system.business.services.MainService;
import system.presenter.forms.roomform.RoomFormPresenter;
import system.presenter.forms.roomform.RoomFormView;
import system.presenter.forms.sectionform.SectionFormView;
import system.presenter.forms.sectionform.SectionFormPresenter;
import system.presenter.main.MainPresenter;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class RoomPresenter implements Initializable, ControlledScreen {
    @FXML
    private Button editButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button addNewButton;
    @FXML
    private TableView<Room> roomTableView;
    @FXML
    private TableColumn<Room, String> roomNameColumn;
    @Inject
    MainService service;
    
    ViewController viewController;
    @FXML
    private AnchorPane currentPane;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
//        roomNameColumn.setCellValueFactory((cellData) -> cellData.getValue().roomNumberProperty());
        updateData();
        removeButton.disableProperty().bind(roomTableView.getSelectionModel().selectedItemProperty().isNull());
        editButton.disableProperty().bind(roomTableView.getSelectionModel().selectedItemProperty().isNull());
    }    
    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void editButtonAction(ActionEvent event) {
        viewController.unloadScreen(MainPresenter.subjectForm);
        RoomFormView rFv = new RoomFormView();
        RoomFormPresenter rFp = (RoomFormPresenter) rFv.getPresenter();
        rFp.setRoom(roomTableView.getSelectionModel().getSelectedItem());        
        viewController.loadScreen(MainPresenter.roomForm, rFv);
        viewController.setScreen(MainPresenter.roomForm);
    }

    @FXML
    private void removeButtonAction(ActionEvent event) {
       service.delete(roomTableView.getSelectionModel().getSelectedItem());
       updateData();
    }

    @FXML
    private void addNewButtonAction(ActionEvent event) {
        
    }
    
    private void updateData(){
//        subjectTableView.getSelectionModel().clearSelection();
        roomTableView.setItems(FXCollections.observableArrayList(service.getAllRooms()));
    }
    
}
