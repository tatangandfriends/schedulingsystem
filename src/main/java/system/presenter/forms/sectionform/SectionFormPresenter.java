/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.presenter.forms.sectionform;

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
import system.business.models.ClassSection;
import system.business.services.MainService;
import system.presenter.main.MainPresenter;
import system.presenter.main.screensfw.ControlledScreen;
import system.presenter.main.screensfw.ViewController;
import system.presenter.views.section.SectionView;


/**
 * FXML Controller class
 *
 * @author Hadouken
 */
public class SectionFormPresenter implements Initializable, ControlledScreen {

    ViewController viewController;
    @FXML
    private TextField classSectionField;
    @FXML
    private Button saveSectionButton;
    
    private ObjectProperty<ClassSection> classSection;
    
    @Inject
    MainService service;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setClassSection(new SimpleObjectProperty<>());
        getClassSection().addListener((ObservableValue<? extends ClassSection> observable, ClassSection oldValue, ClassSection newValue) -> {
            classSectionField.setText(newValue.getSectionCode());
            saveSectionButton.setText("Update");
        });
        
        
    }    

    @Override
    public void setScreenParent(ViewController screenParent) {
        viewController = screenParent;
    }
    @FXML
    private void saveSectionButton(ActionEvent event) {
        ClassSection cs;
        if(getClassSection().get() == null){
            cs = new ClassSection();
        }else{
            cs = getClassSection().get();
        }
        cs.setSectionCode(classSectionField.textProperty().get());
        service.save(cs);
        viewController.unloadScreen(MainPresenter.sectionViewAll);
        SectionView sectionView = new SectionView();
        viewController.loadScreen(MainPresenter.sectionViewAll, sectionView);  
        viewController.setScreen(MainPresenter.sectionViewAll);
    }

    public ObjectProperty<ClassSection> getClassSection() {
        return classSection;
    }

    public void setClassSection(ObjectProperty<ClassSection> classSection) {
        this.classSection = classSection;
    }
    
    public void setClassSection(ClassSection classSection){
        this.classSection.set(classSection);
    }
    
    
    
}
