/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.forms.timeform;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.inject.Inject;
import system.business.models.TimeType;
import system.business.services.MainService;
import system.presenter.main.MainPresenter;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.presenter.views.time.TimeView;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class TimeFormPresenter implements Initializable, ControlledScreen {
    @FXML
    private Button saveButton;
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> timeStartComboBox;
    @FXML
    private ComboBox<String> timeEndComboBox;

    ViewController viewController;
    ObservableList<String> timeData;
    
    private ObjectProperty<TimeType> timeType;
    
    @Inject
    MainService service;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeData = FXCollections
                .observableArrayList("7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00");
        timeStartComboBox.setItems(timeData);
        timeEndComboBox.setItems(timeData);
        
        timeType = new SimpleObjectProperty<>();
        timeType.addListener(
                (ObservableValue<? extends TimeType> observable, TimeType oldValue, TimeType newValue) -> {
            nameField.setText(newValue.getName());
            timeStartComboBox.getSelectionModel().select(newValue.getTimeStart());
            timeEndComboBox.getSelectionModel().select(newValue.getTimeEnd());
            saveButton.setText("Update");
        });
        
    }
    
    
    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        TimeType timett;
        if(getTimeType().get() == null){
            timett = new TimeType();
        }else{
            timett = getTimeType().get();
        }
        timett.setName(nameField.textProperty().get());
        timett.setTimeStart(timeStartComboBox.getSelectionModel().getSelectedItem());
        timett.setTimeEnd(timeEndComboBox.getSelectionModel().getSelectedItem());
        service.save(timett);
        viewController.unloadScreen(MainPresenter.timeViewAll);
        TimeView timeView = new TimeView();
        viewController.loadScreen(MainPresenter.timeViewAll, timeView);  
        viewController.setScreen(MainPresenter.timeViewAll);
        
    }
    public void setTimeType(TimeType time){
        this.timeType.set(time);
    }

    /**
     * @return the timeType
     */
    public ObjectProperty<TimeType> getTimeType() {
        return timeType;
    }

    /**
     * @param timeType the timeType to set
     */
    public void setTimeType(ObjectProperty<TimeType> timeType) {
        this.timeType = timeType;
    }
    
}
