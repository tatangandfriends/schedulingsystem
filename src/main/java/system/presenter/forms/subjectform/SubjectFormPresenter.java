/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.forms.subjectform;

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
import system.business.models.Subject;
import system.business.services.MainService;
import system.presenter.main.MainPresenter;
import static system.presenter.main.MainPresenter.subjectViewAll;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.presenter.views.subject.SubjectView;


/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class SubjectFormPresenter implements Initializable, ControlledScreen {

    ViewController viewController;
    @FXML
    private TextField nameField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField unitField;
    @FXML
    private Button saveSubjectButton;
    
    private ObjectProperty<Subject> subject;
    
    @Inject
    MainService service;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setSubject(new SimpleObjectProperty<>());
        getSubject().addListener((ObservableValue<? extends Subject> observable, Subject oldValue, Subject newValue) -> {
            nameField.setText(newValue.getName());
            codeField.setText(newValue.getCode());
            unitField.setText(newValue.getUnit());
            saveSubjectButton.setText("Update");
        });
        
        
    }    

    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void saveSubjectButton(ActionEvent event) {
        Subject sub;
        if(getSubject().get() == null){
            sub = new Subject();
        }else{
            sub = getSubject().get();
        }
        sub.setName(nameField.textProperty().get());
        sub.setCode(codeField.textProperty().get());
        sub.setUnit(codeField.textProperty().get());
        service.save(sub);
        viewController.unloadScreen(MainPresenter.subjectViewAll);
        SubjectView subjectView = new SubjectView();
        viewController.loadScreen(MainPresenter.subjectViewAll, subjectView);  
        viewController.setScreen(MainPresenter.subjectViewAll);
    }

    public ObjectProperty<Subject> getSubject() {
        return subject;
    }

    public void setSubject(ObjectProperty<Subject> subject) {
        this.subject = subject;
    }
    
    public void setSubject(Subject subject){
        this.subject.set(subject);
    }
    
    
    
}
