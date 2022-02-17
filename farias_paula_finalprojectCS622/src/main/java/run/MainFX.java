package run;

/*
import java.util.*;

import com.itextpdf.layout.element.Text;

import accounts.*;
import database.*;
import pdf.*;
import resume.*;
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class runs program as JavaFX
 */
public class MainFX extends Application {  
 
	// Code
    // C = contact + summary
    // Ex = experience
    // Ed = education
    // Sk = skills

	// Prompts
	private String contactPrompt = " \"Enter full name and email separated by a comma";
	private String summaryPrompt = "Enter 3 sentences that describe your goals"
								+ "separated by a comma";
	private String titlePrompt = "Enter position title and company name separated by a comma";
	private String dutiesPrompt = "Enter your 3 most important job duties separated by a comma";
	//private String degPrompt = "Enter degree program and school name separated by a comma";
	private String startPrompt = "Enter start date (yyyy-mm)";
	private String endPrompt = "Enter end date (yyyy-mm)";

	// Scene list
	
    VBox layoutC = new VBox(10);
    Scene sceneC = new Scene(layoutC, 600, 800);
    VBox layoutEx = new VBox(10);
    Scene sceneEx = new Scene(layoutEx, 600, 800);
    VBox layoutEd = new VBox(10);
    Scene sceneEd = new Scene(layoutEd, 600, 800);
  
    // Resume resume = new Resume();
    
    /**
     * Desc: Method adds prompts to text field
     * Param: TextFied to edit, String text to use as prompt
     * Return: 
    */
    public void addPromptText(TextField field, String text) {
		field.setPromptText(text);
		field.setFocusTraversable(false);
    }
    
    /**
     * Desc: Method adds a set of prompts to text fields
     * Param: TextFieds to edit
     * Return: 
    */
    public void addPromptSetExp(TextField title, TextField start, TextField end, TextField duties) {
    	addPromptText(title, titlePrompt);
    	addPromptText(start, startPrompt);
    	addPromptText(end, endPrompt);
    	addPromptText(duties, dutiesPrompt);
    }
 
    /**
     * Desc: Method creates the scene for contact and summary
     * Param: Stage primary, Vbox layout
     * Return: 
    */
    public void createSceneC(Stage primaryStage, VBox layoutC) {
    	Label headerLabel = new Label("Basic Information");
    	headerLabel.setFont(Font.font("verdana", FontWeight.BOLD, 20));
		TextField contactField = new TextField();
		addPromptText(contactField, contactPrompt);
		TextField summaryField = new TextField();	
		addPromptText(summaryField, summaryPrompt);
		Button next = new Button("Next");
		next.setOnAction(e -> 
	    {
	    	/*
	    	Section contact = new Contact(contactField.getText());
	    	Section summary = new Summary(summaryField.getText());   
	    	
	    	resume.setContactSection(contact);
	    	resume.setSummarySection(summary);
	    	*/
	    	primaryStage.setScene(sceneEx);
	    });
		layoutC.getChildren().addAll(headerLabel, contactField, summaryField, next);
    }
    
    /**
     * Desc: Method creates the scene for experience
     * Param: Stage primary, Vbox layout
     * Return: 
    */
    public void createSceneEx(Stage primaryStage, VBox layoutExp) {
    	// sceneExp 
	    Label headerLabel = new Label("Professional Background");
    	headerLabel.setFont(Font.font("verdana", FontWeight.BOLD, 20));
	    Label label1 = new Label("\nExperience 1\n");
	        TextField t1 = new TextField();
	        TextField s1 = new TextField();
	        TextField en1 = new TextField();
	        TextField d1 = new TextField();
	    addPromptSetExp(t1, s1, en1, d1);
		Label label2 = new Label("\nExperience 2\n");
	        TextField t2 = new TextField();
	        TextField s2 = new TextField();
	        TextField en2 = new TextField();
	        TextField d2 = new TextField();
	    addPromptSetExp(t2, s2, en2, d2);
		Label label3 = new Label("\nExperience 3\n");
	        TextField t3 = new TextField();
	        TextField s3 = new TextField();
	        TextField en3 = new TextField();
	        TextField d3 = new TextField();
		addPromptSetExp(t3, s3, en3, d3);
	  	Button next = new Button("Next");
		next.setOnAction(e -> 
	    {
	    	/*
	    	ArrayList<Section> experiencesArr = new ArrayList<Section>();
	    	
	    	createObj(experiencesArr, t1, s1, en1, d1);
	    	createObj(experiencesArr, t2, s2, en2, d2);
	    	createObj(experiencesArr, t3, s3, en3, d3);
	    
	    	resume.setExperienceSection(experiencesArr);
	    	*/
	    	primaryStage.setScene(sceneEd);
	    });
		layoutEx.getChildren().addAll(headerLabel,label1, t1, 
	    		s1, en1,d1, label2, t2, s2, en2, d2,
	    		label3, t3, s3, en3, d3, next);
    }
    
    /**
     * Desc: Method sets up stage for JavaFX
     * Param: Stage primary
     * Return: 
    */
   	@Override 
	public void start(Stage primaryStage){
		primaryStage.setTitle("RB");
		createSceneC(primaryStage, layoutC);
		createSceneEx(primaryStage, layoutEx);

	    primaryStage.setScene(sceneC);
	    primaryStage.show(); 
     
   	}
   	
/*
   	
    /**
     * Desc: Method launches JavaFX program
     * Param: String args
     * Return: 
   	public static void main(String[] args) {
        launch(args);
    }


public void createObj(ArrayList<Section> arr, TextField title, TextField start, 
		TextField end, TextField duties) {
	Section e = new Experience(title.getText());
	e.setDates(start.getText(), end.getText());
	ArrayList<String> dutiesArr = Section.splitInput(duties.getText());
	e.setContentList(dutiesArr);
	arr.add(e);
}
*/
   	
}