package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class level1Controller  {
    @FXML
    private Label sunCount;
    private static int sunValue ;
    @FXML
    private ImageView menuButton;
    @FXML
    private StackPane container;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private Label warning;
    
    private static String isSelected = null;
    private static float  opacity ;
    private static String wText;
    private static level1Controller reference;
    
    private static final ArrayList<Integer> xPixels = new ArrayList<Integer>(Arrays.asList(305,405,495,589,680,775,871,956,1050)); 
    private static ArrayList<Integer> yPixels = new ArrayList<Integer> (Arrays.asList(115,222,340,463,584));
    //private static ArrayList<Integer> yPixels = new ArrayList<Integer> (Arrays.asList(115,222,340,463,574));
    private static HashMap<String, Integer>  cost = new HashMap<String , Integer>();
    private static HashMap<String , Long> timeInstant = new HashMap<String , Long>();
    private static HashMap<String , Float > clickDelay = new HashMap<String , Float>();
    {// initialization
        cost.put("shooter",25);
        cost.put("sunflower",25);
        cost.put("walnut",25);
        cost.put("PotatoMine",25);
        
        ///////////
        
        
        timeInstant.put("shooter",0L);
        timeInstant.put("sunflower",0L);
        timeInstant.put("walnut",0L);
        timeInstant.put("PotatoMine",0L);
        

        ///////////////
        
        clickDelay.put("shooter",5f);
        clickDelay.put("sunflower",5f);
        clickDelay.put("walnut",5f);
        clickDelay.put("PotatoMine",5f);
        
        reference = this;
        
    
    }
    
    public static void restart(){
        timeInstant.put("shooter",0L);
        timeInstant.put("sunflower",0L);
        timeInstant.put("walnut",0L);
        timeInstant.put("PotatoMine",0L);
        sunValue = 0;
        reference = null;
    }
    
    
    
    public static level1Controller getReference(){return reference;}
    







    public static String whatSelected(){ return isSelected;}
    
    public static int getXPixel(int x ){
       int var = 0;
        try {
            var = xPixels.get(x);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("xPixel Bug");
        }
        return var;
    }
    
    
    
    
    public static int getYPixel(int y ){
       int var = 0;
        try {
            var = yPixels.get(y);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("yPixel Bug");
        }
        return var;
    }
    
    public void inGameMenu(MouseEvent event ) throws IOException{
        if (Project.setState(3)){
            Parent root = FXMLLoader.load(getClass().getResource("ingameMenu.fxml"));
            Scene sc = menuButton.getScene();
            root.translateYProperty().set(sc.getHeight());
            container.getChildren().add(root);
            Timeline t = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
            t.getKeyFrames().add(kf);
            t.setOnFinished(t1->{
                container.getChildren().remove(anchorRoot);
            });
            t.play();

            Project.stopAnimation();
        }
    }
       
    
    public void userWon() throws IOException{
        if (Project.setState(8)){
            Parent root = FXMLLoader.load(getClass().getResource("levelCompleted.fxml"));
            Scene sc = menuButton.getScene();
            root.translateYProperty().set(sc.getHeight());
            if (container == null){
                System.out.println("www");
            }
            container.getChildren().add(root);
            Timeline t = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
            t.getKeyFrames().add(kf);
            t.setOnFinished(t1->{
                container.getChildren().remove(anchorRoot);
            });
            t.play();
            Project.stopAnimation();
        }
    
    }
    
    public void lose() throws IOException{
        if (Project.setState(9)){
            Parent root = FXMLLoader.load(getClass().getResource("levelLost.fxml"));
            Scene sc = menuButton.getScene();
            root.translateYProperty().set(sc.getHeight());
            container.getChildren().add(root);
            Timeline t = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
            t.getKeyFrames().add(kf);
            t.setOnFinished(t1->{
                container.getChildren().remove(anchorRoot);
            });
            t.play();
            Project.stopAnimation();
        }
    }
    
    
    
    
    
    public static void  setSunCount(int val ){
        sunValue = val;
    }
    public static int getSunCount(){ return sunValue;}
    public static void setOpacity(float o ){opacity = o;}
    public static void setWarning (String x){ wText = x;}
    public static float getOpacity(){return opacity;}
    public static String getWarning(){return wText;}
    public void updateSunCountLabel(MouseEvent e ) throws IOException{
        sunCount.setText(Integer.toString( sunValue));
        warning.setText(wText );
        warning.setOpacity(opacity );
    }
    
    // test function to check pixel boundation
    public void clickTest(MouseEvent e) throws IOException{
        double x = e.getX();
        double y = e.getY();
        System.out.println("("+x+","+y+")");
        
        
        if (isSelected!=null&&(x>=305 && x<=1144)  && (y>=116 &&y<=696)){
            if (isSelected.equals("shovel")){
                Project.getUser().getLevelInstance().removePlant(getGridNumber(x, y));
            }
            else if (cost.get(isSelected)<=sunValue  && System.currentTimeMillis() - timeInstant.get(isSelected) >=clickDelay.get(isSelected)*1000 ){
                levelHandler.addPlant(x,y,getGridNumber(x, y),isSelected);
                sunValue = sunValue - cost.get(isSelected);
                timeInstant.put(isSelected,System.currentTimeMillis());
            }
        }
        
        if(y>6 && y< 98){
            if (x>384 && x<440){ 
                System.out.println("shooter selected");
                isSelected="shooter";
            }
            else if (x>451 && x<507 && Project.getUser().getLevel() >= 2){
                System.out.println("sunflower selected");
                isSelected="sunflower"; 
            }
            else if (x<574 && x> 520 && Project.getUser().getLevel() >= 4){
                System.out.println("walnut");
                isSelected = "walnut";
            }
            else if (x>590 && x<645 && Project.getUser().getLevel() >= 5){
                
                isSelected = "PotatoMine";
            }
            else if (x>800 && x<878 && Project.getUser().getLevel() >= 3){
                isSelected = "shovel";
            }
            else {
                isSelected =null;
                
            }
        }
        else {
            isSelected = null;
        }
        
        
    }
    private int getGridNumber(double x , double y){
        int x_offset = -1;
        int y_offset = -1;
        if (305<=x && x<405){
            x_offset = 1;
        }
        else if (405<=x && x<495){
            x_offset =2 ;
        }
        else if (495<=x && x<589){
            x_offset= 3;
        }
        else if (589<=x && x<680){
            x_offset= 4;
        }
        else if (680<=x && x<775){
            x_offset= 5;
        }
        else if (775<=x && x<871){
            x_offset= 6;
        }
        else if (871<=x && x<956){
            x_offset= 7;
        }
        else if (956<=x && x<1050){
            x_offset= 8;
        }
        else if (1050<=x && x<1144){
            x_offset= 9;
        }
        
        if (115<=y && y<222){
            y_offset = 0;
        }
        else if (222<=y && y<340){
            y_offset =1 ;
        }
        else if (340<=y && y<463){
            y_offset= 2;
        }
        else if (463<=y && y<574){
            y_offset= 3;
        }
        else if (574<=y && y<697){
            y_offset= 4;
        }
        
        return 9*y_offset + x_offset;
     }
    public void menuButtonEnter(MouseEvent e){
        menuButton.setOpacity(0.75);
    }
    public void menuButtonExit(MouseEvent e ){
        menuButton.setOpacity(1);
    } 
     
}
