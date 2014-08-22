/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.inject.Inject;
import system.business.services.StudentService;

/**
 * FXML Controller class
 *
 * @author Telafas
 */
public class MainPresenter implements Initializable {
    
    @Inject
    StudentService service;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
