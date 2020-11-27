package application;

import java.io.FileInputStream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.sql.Date;
import java.util.ArrayList;

import com.sun.scenario.effect.impl.prism.PrImage;
import com.sun.security.auth.NTSidPrimaryGroupPrincipal;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public  class AuthenticationView{
	Stage primaryStage;
	AuthenticationController controller;
	
	public AuthenticationView(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	public void setController(AuthenticationController controller) {
		this.controller=controller;
	}
	
	public void startView()  {

	    Scene scene = new Scene(this.getLogInView(), 800,800);
        this.primaryStage.setScene(scene);
        primaryStage.setTitle("BookFace");
        primaryStage.show();
	}

	
	public void prepareSceneLogin(GridPane grid) {

		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setHgap(18);
		grid.setVgap(18);
		// grid.setPadding(new Insets(00, 00, 00, 00));
		Text scenetitle = new Text("Welcome to BookFace");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		grid.add(scenetitle, 1, 1, 10, 1);


	}
	
	public GridPane getLogInView()  {

		GridPane grid = new GridPane();
		this.prepareSceneLogin(grid);
		//grid.setAlignment(Pos.CENTER);
		//grid.setHgap(10);
		//grid.setVgap(10);
		//grid.setPadding(new Insets(25, 25, 25, 25));
		//Text scenetitle = new Text("Welcome to ATOS Help Desk");
		//scenetitle.setTextAlignment(TextAlignment.CENTER);
		//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		//grid.add(scenetitle, 0, 0, 10, 1);

		Label userNameLabel = new Label("User Name:");
		grid.add(userNameLabel, 2, 3);

		TextField userTextField = new TextField();
		userTextField.setAlignment(Pos.CENTER);
		grid.add(userTextField, 4, 3);

		Label passwordLabel = new Label("Password:");
		grid.add(passwordLabel, 2, 4);

		PasswordField passwordField = new PasswordField();
		passwordField.setAlignment(Pos.CENTER);
		grid.add(passwordField, 4, 4);

		Button signInButton = new Button("Sign in");
		signInButton.setOnAction(event-> {
			String username =userTextField.getText();
			String password = passwordField.getText();
			this.controller.signIn(username,password);
			});
		HBox horizonalBox= new HBox(50);
		horizonalBox.setAlignment(Pos.BOTTOM_RIGHT);

		Button register_btn = new Button("Sign up");
		register_btn.setOnAction(event-> {
		this.controller.showRegisterView();

		} );
		horizonalBox.getChildren().add(register_btn);
		horizonalBox.getChildren().add(signInButton);
		grid.add(horizonalBox, 4, 6);
		
		
		return grid;
	}
	
	public static void displayPopUp(String message) {
		Stage popupwindow = new Stage();
		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Pop Up Window");
		Label label1 = new Label(message);
		Button button1 = new Button("Close");
		button1.setOnAction(e -> popupwindow.close());
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label1, button1);
		layout.setAlignment(Pos.CENTER);
		Scene scene1 = new Scene(layout, 300, 250);
		popupwindow.setScene(scene1);
		popupwindow.showAndWait();

	}
	
	public void prepareSceneRegister(GridPane grid)  {

		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setHgap(18);
		grid.setVgap(18);
		// grid.setPadding(new Insets(00, 00, 00, 00));
		Text scenetitle = new Text("Registration ");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		grid.add(scenetitle, 1, 1, 10, 1);

	}
	
	public static String[] convert(Set<String> setOfString) 
    { 
  
        // Create String[] of size of setOfString 
        String[] arrayOfString = new String[setOfString.size()]; 
  
        // Copy elements from set to string array 
        // using advanced for loop 
        int index = 0; 
        for (String str : setOfString) 
            arrayOfString[index++] = str; 
  
        // return the formed String[] 
        return arrayOfString; 
    }
	public GridPane getRegisterView()  {

		GridPane grid = new GridPane();
		this.prepareSceneRegister(grid);
		HashMap<String, Integer> locationHashmap = this.controller.getLocations();
		String [] locations= convert(locationHashmap.keySet());
		
		int yLevelIndex=3;
		int xStartinglevel=2;

		Label name = new Label("Name :");
		grid.add(name, xStartinglevel,yLevelIndex );
		TextField nameField = new TextField();
		grid.add(nameField, xStartinglevel+1, yLevelIndex++);
		
		Label surname = new Label("Surname :");
		grid.add(surname, xStartinglevel, yLevelIndex);
		TextField surnameField = new TextField();
		grid.add(surnameField, xStartinglevel+1, yLevelIndex++);
		
		Label genderLabel = new Label("Gender:");
		grid.add(genderLabel, xStartinglevel, yLevelIndex);
		String[] genders= {"Male","Female"};
		ComboBox genderBox = new ComboBox(FXCollections.observableArrayList(genders)); 
		genderBox.getSelectionModel().selectFirst();
		grid.add(genderBox, xStartinglevel+1, yLevelIndex++);
		
		Label hometownLabel = new Label("hometown:");
		grid.add(hometownLabel, xStartinglevel, yLevelIndex);
		ComboBox hometownBox = new ComboBox(FXCollections.observableArrayList(locations)); 
		hometownBox.getSelectionModel().selectFirst();
		grid.add(hometownBox, xStartinglevel+1, yLevelIndex++);
		
		Label livesInLabel = new Label("live in :");
		grid.add(livesInLabel, xStartinglevel, yLevelIndex);
		ComboBox livesInBox = new ComboBox(FXCollections.observableArrayList(locations)); 
		livesInBox.getSelectionModel().selectFirst();
		grid.add(livesInBox, xStartinglevel+1, yLevelIndex++);
		
		Label comptel = new Label("Email");
		grid.add(comptel, xStartinglevel, yLevelIndex);
		TextField emailField = new TextField();
		grid.add(emailField, xStartinglevel+1, yLevelIndex++);
		
		Label comp = new Label("Website");
		grid.add(comp, xStartinglevel, yLevelIndex);
		TextField websiteField = new TextField();
		grid.add(websiteField, xStartinglevel+1, yLevelIndex++);
		
		Label linkLabel = new Label("link:");
		grid.add(linkLabel, xStartinglevel, yLevelIndex);
		TextField linkField = new TextField();
		grid.add(linkField, xStartinglevel+1, yLevelIndex++);
		
		Label birthdayLabel = new Label("birthday");
		grid.add(birthdayLabel, xStartinglevel, yLevelIndex);
		DatePicker datePicker = new DatePicker();
		grid.add(datePicker, xStartinglevel+1, yLevelIndex++);
		
		Label workedAtLabel = new Label("previous employment Places * symbol between employments.");
		grid.add(workedAtLabel, xStartinglevel, yLevelIndex);
		TextField workedAtField = new TextField();
		grid.add(workedAtField, xStartinglevel+1, yLevelIndex++);
		
		Label educationPlacesLabel = new Label("Education * symbol between employments.");
		grid.add(educationPlacesLabel, xStartinglevel, yLevelIndex);
		TextField educationField = new TextField();
		grid.add(educationField, xStartinglevel+1, yLevelIndex++);
		
		Label quotesLabel = new Label("Quotes * symbol between employments.");
		grid.add(quotesLabel, xStartinglevel, yLevelIndex);
		TextField quotesField = new TextField();
		grid.add(quotesField, xStartinglevel+1, yLevelIndex++);
		
		
		Label label1 = new Label("Username:");
		grid.add(label1, xStartinglevel, yLevelIndex); // i am starting from xStartinglevel,xStartinglevel+1
		TextField UserNameField = new TextField();
		grid.add(UserNameField, xStartinglevel+1, yLevelIndex++);
		
		Label pw = new Label("Password:");
		grid.add(pw, xStartinglevel, yLevelIndex);
		PasswordField passwordField = new PasswordField();
		grid.add(passwordField, xStartinglevel+1, yLevelIndex++);
		
		Button button = new Button();
		button.setText("Create account");
		button.setOnAction(event->{
			String firstName=nameField.getText();
			String lastName=surnameField.getText();
			String email=emailField.getText();
			String website=websiteField.getText();
			String link=linkField.getText();
			Date birthday = null;
			try {
				 birthday=Date.valueOf(		
						datePicker.getValue());
				
			} catch (Exception e) {
//				birthday=new Date(System.currentTimeMillis());
				displayPopUp("Wrong date!");
				this.startView();
				System.out.println("aadadasfasfas");
			}
			
			String strGender=(String) genderBox.getValue();
			char gender='F';
			if(strGender.equals("Male")) {
				gender='M';
			}
			String tempString=workedAtField.getText();
			if(tempString==null) {
				System.out.println("null");
			}
			else if(tempString.equals("")){
			System.out.println("it is empty");
			ArrayList<String> workedForPlaces=null;
			}
			ArrayList<String> workedForPlaces = new ArrayList<String>(Arrays.asList(tempString.split("\\*",0)));
			System.out.println(workedForPlaces);
			ArrayList<String> educationPlaces=new ArrayList<String>(Arrays.asList(educationField.getText().split("\\*",0)));
			ArrayList<String> quotes=new ArrayList<String>(Arrays.asList(quotesField.getText().split("\\*",0)));;
			boolean isVerified=false;
			String strHometown= (String) hometownBox.getValue();
			Location hometown=new Location(locationHashmap.get(strHometown), strHometown);
			String strLivesInLocation=(String) livesInBox.getValue();
			Location livesIn=new Location(locationHashmap.get(strLivesInLocation), strLivesInLocation);

			
			// na ta valume tuta?
			String username= UserNameField.getText();
			String password=passwordField.getText();
			
			User newUser = new User(firstName, lastName, email, website,
					link, birthday, gender,workedForPlaces,educationPlaces,quotes,
					isVerified,hometown,livesIn, username, password);
			///
			
			this.controller.registerUser(newUser);
		});
		grid.add(button, xStartinglevel, ++yLevelIndex);
		
		prepareSceneRegister(grid);
		return grid;
	}

}
