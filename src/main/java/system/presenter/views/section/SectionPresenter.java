/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.views.section;

import java.net.URL;
import java.util.ResourceBundle;
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
import system.business.models.ClassSection;
import system.business.services.MainService;
import system.presenter.forms.sectionform.SectionFormView;
import system.presenter.forms.sectionform.SectionFormPresenter;
import system.presenter.main.MainPresenter;

/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class SectionPresenter implements Initializable, ControlledScreen {
    @FXML
    private Button editButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button addNewButton;
    @FXML
    private TableView<ClassSection> sectionTableView;
    @FXML
    private TableColumn<ClassSection, String> sectionNameColumn;
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
        sectionNameColumn.setCellValueFactory((cellData) -> cellData.getValue().sectionCodeProperty());
        updateData();
        removeButton.disableProperty().bind(sectionTableView.getSelectionModel().selectedItemProperty().isNull());
        editButton.disableProperty().bind(sectionTableView.getSelectionModel().selectedItemProperty().isNull());
    }    

    
    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }

    @FXML
    private void editButtonAction(ActionEvent event) {
        viewController.unloadScreen(MainPresenter.subjectForm);
        SectionFormView sFv = new SectionFormView();
        SectionFormPresenter sFp = (SectionFormPresenter) sFv.getPresenter();
        sFp.setClassSection(sectionTableView.getSelectionModel().getSelectedItem());        
        viewController.loadScreen(MainPresenter.sectionForm, sFv);
        viewController.setScreen(MainPresenter.sectionForm);
    }

    @FXML
    private void removeButtonAction(ActionEvent event) {
       service.delete(sectionTableView.getSelectionModel().getSelectedItem());
       updateData();
    }

    @FXML
    private void addNewButtonAction(ActionEvent event) {
        
    }
    
    private void updateData(){
//        subjectTableView.getSelectionModel().clearSelection();
        sectionTableView.setItems(FXCollections.observableArrayList(service.getAllSection()));
    }
    
}
