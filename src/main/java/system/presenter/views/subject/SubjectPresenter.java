/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.views.subject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class SubjectPresenter implements Initializable, ControlledScreen {

    ViewController ViewController;
           
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ViewController screenParent) {
        ViewController = screenParent;
    }
    
}
