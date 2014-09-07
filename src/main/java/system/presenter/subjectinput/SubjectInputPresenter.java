/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.subjectinput;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.business.models.Subject;
import system.business.models.Teacher;
import system.business.services.SubjectService;
import system.presenter.subject.SubjectView;

/**
 * FXML Controller class
 *
 * @author BlackBox
 */
public class SubjectInputPresenter implements Initializable {
    
    @FXML
    private AnchorPane currentPane;
    @FXML
    private TextField subCodeField;
    @FXML
    private TextField subDescField;
    @FXML
    private TextField unit;
    @FXML
    private Button saveBtn;
    
    private ObjectProperty<Subject> selectedSubject;

   @Inject
   SubjectService ss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectedSubject = new SimpleObjectProperty<>(new Subject());
        selectedSubject.addListener(selectedSubjectListener());
    }    
    @FXML
    private void saveSubject(ActionEvent event) {
        savyy();
    }
    
    private void savyy(){
        if(!subCodeField.getText().isEmpty() && !subDescField.getText().isEmpty() && !unit.getText().isEmpty()){
            getSelectedSubject().get().setSubCode(subCodeField.textProperty().get());
            getSelectedSubject().get().setSubName(subDescField.textProperty().get());
            getSelectedSubject().get().setUnit(Integer.parseInt(unit.getText()));
            
            ss.save(getSelectedSubject().get());
            AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new SubjectView().getView());         
        }
    }
    public ObjectProperty<Subject> getSelectedSubject() {
        return selectedSubject;
    }
     private ChangeListener<Subject> selectedSubjectListener(){
       ChangeListener<Subject> selectedSubjectListener = new ChangeListener<Subject>() {
            @Override
            public void changed(ObservableValue<? extends Subject> observable, Subject oldValue, Subject newValue) {
                if (newValue != null) {                    
                    subCodeField.setText(newValue.getSubCode());
                    subDescField.setText(newValue.getSubName());
                    unit.setText(Integer.toString(newValue.getUnit()));
//                    courseCb.getSelectionModel().select(newValue.getCourse());
                } else {
                    
                }
            }
        };
       return selectedSubjectListener;
    }
      @FXML
    private void cancelSubject(ActionEvent event) {
        cancel();
    }
    
    private void cancel(){
         AnchorPane anchorPane = (AnchorPane)currentPane.getParent();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(new SubjectView().getView());            
        
    }
}
