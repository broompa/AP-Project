/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class level1Controller  {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label xLabel;
    @FXML
    private Label yLabel;
    
    
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    
    
    // test function to check pixel boundation
     public void clickTest(MouseEvent e) throws IOException{
         xLabel.setText(Double.toString(e.getSceneX()));
         yLabel.setText(Double.toString(e.getSceneY()));
    }
    
}
