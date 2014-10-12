//
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package system.presenter.login;
//
//import java.net.Authenticator;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.beans.property.ObjectProperty;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//import javax.inject.Inject;
//import system.business.services.Accounts;
//import system.presenter.main.MainView;
//
//
//public class LoginPresenter implements Initializable{
//    @FXML
//    private Label message;
//    
//    @FXML
//    private AnchorPane anchorPane;
//    @Inject
//    Accounts acc;
//    
//    @FXML
//    private TextField user;
//    
//    @FXML
//    private PasswordField pass;
//    
//    private void btnLogin(ActionEvent event)throws Exception{
//        
//        if(!user.getText().isEmpty() && !pass.getText().isEmpty()){          
//            try{
//           
//                        LoginView adminView = new LoginView();
//                        LoginPresenter = LoginView.getPresenter();
//                       
//                    }else{
//                        changeContentPane(new MainView().getView());
//                    }
//            }catch(NullPointerException e){
//                incorrectPasswordLabel.setVisible(true);                
//            }
//        }
//         
//    }
//     public TextField getUser() {
//        return user;
//    }
//    
//    /**
//     * Initializes the controller class.
//     * @param url
//     * @param rb
//     */
//    
//    
//    
//}
