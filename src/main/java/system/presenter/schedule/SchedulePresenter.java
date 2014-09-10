/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.schedule;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import system.business.models.Section;

/**
 * FXML Controller class
 *
 * @author BlackBox
 */
public class SchedulePresenter implements Initializable {
    @FXML
    private AnchorPane currentPane;
    @FXML
    private ComboBox<Section> sectionCb;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button doneBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
