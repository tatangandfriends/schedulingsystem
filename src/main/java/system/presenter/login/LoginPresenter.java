/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author dennis
 */
public class LoginPresenter implements Initializable{
    @FXML
    private Label message;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private TextField user;
    
    @FXML
    private PasswordField pass;
    
    @FXML
    
    private void btnLoginAction(ActionEvent event)throws Exception{
        
        if(user.getText().equals("admin") && pass.getText().equals("admin")){
            user.setText("");
            pass.setText("");
            message.setText("");
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("/system.presenter.main/main.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("View Schedules");
            stage.show();
        }else{
                    message.setText("Sorry! " + user.getText()+ " your " 
                            + "Username or Password is Invalid!");
                    user.setText("");
                    pass.setText("");
        }
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
