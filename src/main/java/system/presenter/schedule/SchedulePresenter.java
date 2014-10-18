/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.schedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import system.business.models.Section;
import system.business.models.Subject;
import system.business.models.Time;

/**
 * FXML Controller class
 *
 * @author johnrey
 */
public class SchedulePresenter implements Initializable {
    @FXML
    private AnchorPane currentPane;
    @FXML
    private ComboBox<String> dayCb;
    @FXML
    private ComboBox<String> timeCb;
    @FXML
    private ComboBox<Integer> timeCb1;
    @FXML
    private ComboBox<Subject> subjectCb;
    @FXML
    private ComboBox<Integer> roomCb;
    @FXML
    private ComboBox<Section> sectionCb4;
    @FXML
    private ComboBox<?> sectionCb5;
    
    final List<String> listOfDays = Arrays.asList("Monday","Tuesday","Wednesday");
    ObservableList<String> daysList = FXCollections.observableArrayList();    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        daysList.addAll(listOfDays);
        
        
    }    
    
}
