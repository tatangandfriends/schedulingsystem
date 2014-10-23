/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.views.teacher;

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
import system.business.models.Teacher;
import system.business.services.MainService;
import system.presenter.forms.subjectform.SubjectFormPresenter;
import system.presenter.forms.subjectform.SubjectFormView;
import system.presenter.forms.teacherform.TeacherFormPresenter;
import system.presenter.forms.teacherform.TeacherFormView;
import system.presenter.main.MainPresenter;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class TeacherPresenter implements Initializable, ControlledScreen {
    @FXML
    private Button editButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button addNewButton;
    @FXML
    private TableView<Teacher> teacherTableView;
    @FXML
    private TableColumn<Teacher, String> teacherFirstNameColumn;
    @FXML
    private TableColumn<Teacher, String> teacherLastNameColumn;
    
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
        teacherFirstNameColumn.setCellValueFactory((cellData) -> cellData.getValue().firstNameProperty());
        teacherLastNameColumn.setCellValueFactory((cellData) -> cellData.getValue().lastNameProperty());
        updateData();
        removeButton.disableProperty().bind(teacherTableView.getSelectionModel().selectedItemProperty().isNull());
        editButton.disableProperty().bind(teacherTableView.getSelectionModel().selectedItemProperty().isNull());
    }    

    
    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void editButtonAction(ActionEvent event) {
        viewController.unloadScreen(MainPresenter.subjectForm);
        TeacherFormView tFv = new TeacherFormView();
        TeacherFormPresenter tFp = (TeacherFormPresenter) tFv.getPresenter();
        tFp.setTeacher(teacherTableView.getSelectionModel().getSelectedItem());        
        viewController.loadScreen(MainPresenter.subjectForm, tFv);
        viewController.setScreen(MainPresenter.subjectForm);
    }

    @FXML
    private void removeButtonAction(ActionEvent event) {
       service.delete(teacherTableView.getSelectionModel().getSelectedItem());
       updateData();
    }

    @FXML
    private void addNewButtonAction(ActionEvent event) {
        
    }
    
    private void updateData(){
//        subjectTableView.getSelectionModel().clearSelection();
        teacherTableView.setItems(FXCollections.observableArrayList(service.getAllTeachers()));
    }
    
}
