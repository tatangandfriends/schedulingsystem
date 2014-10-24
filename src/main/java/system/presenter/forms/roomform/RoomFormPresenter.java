/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.forms.roomform;

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
import system.business.models.Room;
import system.business.services.MainService;
import system.presenter.main.MainPresenter;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.presenter.views.room.RoomView;


/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class RoomFormPresenter implements Initializable, ControlledScreen {

    ViewController viewController;
    @FXML
    private TextField roomNumberField;
    @FXML
    private Button saveSectionButton;
    
    private ObjectProperty<Room> room;
    
    @Inject
    MainService service;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setRoom(new SimpleObjectProperty<>());
        getRoom().addListener((ObservableValue<? extends Room> observable, Room oldValue, Room newValue) -> {
            roomNumberField.setText(Integer.toString(newValue.getRoomNumber()));
            saveSectionButton.setText("Update");
        });
        
        
    }    

    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }
    @FXML
    private void saveRoomButton(ActionEvent event) {
        Room r;
        if(getRoom().get() == null){
            r = new Room();
        }else{
            r = getRoom().get();
        }
        r.setRoomNumber(Integer.parseInt(roomNumberField.textProperty().get()));
        service.save(r);
        viewController.unloadScreen(MainPresenter.roomViewAll);
        RoomView roomView = new RoomView();
        viewController.loadScreen(MainPresenter.roomViewAll, roomView);  
        viewController.setScreen(MainPresenter.roomViewAll);
    }

    public ObjectProperty<Room> getRoom() {
        return room;
    }

    public void setRoom(ObjectProperty<Room> room) {
        this.room = room;
    }
    
    public void setRoom(Room room){
        this.room.set(room);
    }
    
    
    
}
