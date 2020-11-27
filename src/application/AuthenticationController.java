package application;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AuthenticationController {
	AuthenticationView view;
	AuthenticationModel model;

	public AuthenticationController(Stage primaryStage) {
		this.view = new AuthenticationView(primaryStage);
		this.model = new AuthenticationModel();
		this.view.setController(this);
		this.model.setController(this);
	}

	public void showRegisterView()   {
		Scene newScene = new Scene(this.view.getRegisterView(),800,800);
		this.view.primaryStage.setScene(newScene);
		this.view.primaryStage.show();
	}

	public void showLogInView()  {
		Scene newScene = new Scene(this.view.getLogInView(),800,800);
		this.view.primaryStage.setScene(newScene);
		this.view.primaryStage.show();
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
//	public static User generateDummyUser() {
//		return  new User("Stylianos", "Herodotou", "email@ucy.ac.cy","www.ucy.com",
//				null, null, 'M',null,null,null,
//					false,null,null, "sherod01","password");
//		
//	}
	public static User generateDummyUser() {
		return  new User("sherod01","");
		
	}
	
	public void signIn(String username, String password)  {
//		User user=this.model.getUser(username);
		User user= generateDummyUser();
		
		
		
		if (user.getPassword().equals(password)) {
//			this.displayPopUp("correct password signed in");
			UserController.startController(this.view.primaryStage, user);
		}
		else {
			//oste na men tou pis oti exi tuto to username. gia na spamari meta. gia safty
			this.displayPopUp("There is no user with this username or with this password\n");
			// TODO Auto-generated method stub
		}
	}

	public static void startController(Stage primaryStage)   {
		AuthenticationController controller = new AuthenticationController(primaryStage);

		controller.view.startView();
	}

	public void signUp()   {
		this.showLogInView();
	}

	public HashMap<String, Integer> getLocations() {
		
		HashMap<String ,Integer> temp = new HashMap<String ,Integer>();
		temp.put("Larnaka", 1);
		temp.put("Lefkosia", 2);
		return temp;
		// TODO Auto-generated method stub
	}

	public void registerUser(User newUser) {
		boolean wasSuccessfull=this.model.registerUser(newUser);
				if (wasSuccessfull==false) {
					String message = "Could not register User";
					displayPopUp(message);
				}
				else {
					this.showLogInView();
					
				}
	}
}
