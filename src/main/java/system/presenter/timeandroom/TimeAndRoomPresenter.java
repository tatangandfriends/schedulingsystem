/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.timeandroom;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import system.business.models.Course;
import system.business.models.Room;
import system.business.models.Subject;
import system.business.models.Teacher;
import system.business.models.Time;
import system.presenter.addstudent.AddStudView;
import system.presenter.main.MainView;

/**
 * FXML Controller class
 *
 * @author BlackBox
 */
public class TimeAndRoomPresenter implements Initializable {
    @FXML
    private AnchorPane currentPane;
    @FXML
    private ComboBox<Integer> time1;
    @FXML
    private ComboBox<Integer> time2;
    @FXML
    private ComboBox<Integer> time3;
    @FXML
    private ComboBox<Integer> time4;
    @FXML
    private ComboBox<Integer> time9;
    @FXML
    private ComboBox<Integer> time10;
    @FXML
    private ComboBox<Integer> time11;
    @FXML
    private ComboBox<Integer> time12;
    @FXML
    private ComboBox<Integer> roomCb1;
    @FXML
    private ComboBox<Integer> roomCb2;
    @FXML
    private ComboBox<Integer> roomCb3;
    @FXML
    private ComboBox<Integer> roomCb4;
    @FXML
    private ComboBox<Integer> labTime12;
    @FXML
    private ComboBox<Integer> labTime11;
    @FXML
    private ComboBox<Integer> labTime10;
    @FXML
    private ComboBox<Integer> labTime9;
    @FXML
    private ComboBox<Integer> labTime4;
    @FXML
    private ComboBox<Integer> labTime3;
    @FXML
    private ComboBox<Integer> labTime2;
    @FXML
    private ComboBox<Integer> labTime1;
    @FXML
    private ComboBox<Subject> subName1;
    @FXML
    private ComboBox<Subject> subName3;
    @FXML
    private ComboBox<Subject> subName4;
    @FXML
    private ComboBox<Subject> subName8;
    @FXML
    private ComboBox<Subject> subName7;
    @FXML
    private ComboBox<Subject> subName6;
    @FXML
    private ComboBox<Subject> subName5;
    @FXML
    private ComboBox<Integer> labTime5;
    @FXML
    private ComboBox<Integer> labTime6;
    @FXML
    private ComboBox<Integer> labTime7;
    @FXML
    private ComboBox<Integer> labTime8;
    @FXML
    private ComboBox<Integer> labTime13;
    @FXML
    private ComboBox<Integer> labTime14;
    @FXML
    private ComboBox<Integer> labTime15;
    @FXML
    private ComboBox<Integer> labTime16;
    @FXML
    private ComboBox<Integer> roomCb8;
    @FXML
    private ComboBox<Integer> roomCb7;
    @FXML
    private ComboBox<Integer> roomCb6;
    @FXML
    private ComboBox<Integer> roomCb5;
    @FXML
    private ComboBox<Integer> time16;
    @FXML
    private ComboBox<Integer> time15;
    @FXML
    private ComboBox<Integer> time14;
    @FXML
    private ComboBox<Integer> time13;
    @FXML
    private ComboBox<Integer> time8;
    @FXML
    private ComboBox<Integer> time7;
    @FXML
    private ComboBox<Integer> time6;
    @FXML
    private ComboBox<Integer> time5;
    @FXML
    private Button viewTableBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private ComboBox<Teacher> teachName5;
    @FXML
    private ComboBox<Teacher> teachName6;
    @FXML
    private ComboBox<Teacher> teachName7;
    @FXML
    private ComboBox<Teacher> teachName8;
    @FXML
    private ComboBox<Teacher> teachName4;
    @FXML
    private ComboBox<Teacher> teachName3;
    @FXML
    private ComboBox<Teacher> teachName2;
    @FXML
    private ComboBox<Teacher> teachName1;
    @FXML
    private ScrollPane scrollPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        roomCb1.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        roomCb2.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        roomCb3.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        roomCb4.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        roomCb5.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        roomCb6.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        roomCb7.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        roomCb8.setItems(FXCollections.observableArrayList(201, 202, 203, 204, 205));
        
    }
    
    
    
    
    
    
    
    
    @FXML
    private void cancel(){
         AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new MainView().getView());            
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    