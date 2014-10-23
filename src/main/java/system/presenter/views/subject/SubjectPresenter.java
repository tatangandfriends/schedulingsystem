/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.views.subject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.business.models.Subject;
import system.business.services.MainService;
import system.presenter.forms.subjectform.SubjectFormPresenter;
import system.presenter.forms.subjectform.SubjectFormView;
import system.presenter.main.MainPresenter;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class SubjectPresenter implements Initializable, ControlledScreen {
    @FXML
    private Button editButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button addNewButton;
    @FXML
    private TableView<Subject> subjectTableView;
    @FXML
    private TableColumn<Subject, String> subjectNameColumn;
    @FXML
    private TableColumn<Subject, String> subjectCodeColumn;
    @FXML
    private TableColumn<Subject, String> subjectUnitColumn;
    
    @Inject
    MainService service;
    
    ViewController viewController;
    @FXML
    private AnchorPane currentPane;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        subjectNameColumn.setCellValueFactory((cellData) -> cellData.getValue().nameProperty());
        subjectCodeColumn.setCellValueFactory((cellData) -> cellData.getValue().codeProperty());
        subjectUnitColumn.setCellValueFactory((cellData) -> cellData.getValue().unitProperty());
        updateData();
        removeButton.disableProperty().bind(subjectTableView.getSelectionModel().selectedItemProperty().isNull());
        editButton.disableProperty().bind(subjectTableView.getSelectionModel().selectedItemProperty().isNull());
    }    

    
    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void editButtonAction(ActionEvent event) {
        viewController.unloadScreen(MainPresenter.subjectForm);
        SubjectFormView sjv = new SubjectFormView();
        SubjectFormPresenter sjf = (SubjectFormPresenter) sjv.getPresenter();
        sjf.setSubject(subjectTableView.getSelectionModel().getSelectedItem());        
        viewController.loadScreen(MainPresenter.subjectForm, sjv);
        viewController.setScreen(MainPresenter.subjectForm);
    }

    @FXML
    private void removeButtonAction(ActionEvent event) {
       service.delete(subjectTableView.getSelectionModel().getSelectedItem());
       updateData();
    }

    @FXML
    private void addNewButtonAction(ActionEvent event) {
        
    }
    
    private void updateData(){
//        subjectTableView.getSelectionModel().clearSelection();
        subjectTableView.setItems(FXCollections.observableArrayList(service.getAllSubjects()));
    }
    
}
