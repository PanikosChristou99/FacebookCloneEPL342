package application;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UserView {

	Stage primaryStage;
	TabPane tabPane;
	UserController controller;

	public void setController(UserController controller) {
		this.controller = controller;
	}

	public UserView(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void generateTabPane() {
		this.tabPane = new TabPane();
		int index = 0;

		Tab TicketsTab = new Tab("Profile", this.getProfileView(index++));

		tabPane.getTabs().add(TicketsTab);

	}

	protected static boolean is_field_sensitive(String filed_name) {
		String[] sensitive_info = { "password", "SSN", "isAdmin" };
		boolean is_sensitive = false;
		for (int index = 0; index < sensitive_info.length; index++) {
			if (filed_name.equals(sensitive_info[index])) {
				is_sensitive = true;
				break;
			}
		}
		return is_sensitive;
	}

	private void prepareProfileScene(GridPane grid) {
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setHgap(18);
		grid.setVgap(18);
		// grid.setPadding(new Insets(00, 00, 00, 00));
		Text scenetitle = new Text(this.controller.getUser().getUsername() + "'s Profile");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		grid.add(scenetitle, 1, 1, 10, 1);
	}

	private ArrayList<Field> getAllFields() {
		Field[] all_fields = User.class.getDeclaredFields();
		ArrayList<Field> fields = new ArrayList<Field>();
		for (int i = 0; i < all_fields.length; i++) {
			String field_name = all_fields[i].getName();
			if (this.is_field_sensitive(field_name) == false) {
				fields.add(all_fields[i]);
//				grid.addColumn(fields.size(), new Label(field_name));
			}
		}
		return fields;
	}

	private ArrayList<Field> getAllFieldsNames() {
		Field[] all_fields = User.class.getDeclaredFields();
		ArrayList<Field> fields = new ArrayList<Field>();
		for (int i = 0; i < all_fields.length; i++) {
			String field_name = all_fields[i].getName();
			if (this.is_field_sensitive(field_name) == false) {
				fields.add(all_fields[i]);
//				grid.addColumn(fields.size(), new Label(field_name));
			}
		}
		return fields;
	}
	
	private GridPane getProfileView(int tabIndex) {
		GridPane grid = new GridPane();
		this.prepareProfileScene(grid);
		int xlevel = 1;
		int ylevel = 2;
		// set dimentions of the grid.
		grid.setHgap(8); // horizontal
		grid.setVgap(10);// vertical

		ArrayList<Field> fields = getAllFields();
		
		int initXlevel = 0;
		int initYlevel = 2;
		int rowCount = fields.size() + 1;
		User user = this.controller.getUser();
		
		
		for (int field_index = 0; field_index < fields.size(); field_index++) {
			try {
				Object field = fields.get(field_index).get(user);
				Object fieldName = fields.get(field_index);
				if (field != null) {
					grid.add(new Label(fields.get(field_index).getName() +": "+ field.toString() + " "), initXlevel + 1, field_index + initYlevel);// adding
																														// 2
																														// because
																														// i
																														// start
																														// from
																														// (2,3)
				} else {
					grid.add(new Label("field " + fields.get(field_index).getName() + " is null "), initXlevel + 1,
							field_index + initYlevel);// adding 2 because i start from (2,3)
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

//			Button showButton = new Button("Show Password");
//			showButton.setOnAction(event -> {
//				this.controller.showUserPassword(user);
//			});
//			grid.add(showButton, rowCount + initXlevel + 1, user_index + initYlevel); // adding 2 because i start from
//																						// (2,3)
//
//			if (user.isAdmin() == true) {
//				Button removeAdminCap = new Button("Remove Admin Capabilities");
//				removeAdminCap.setOnAction(event -> this.controller.removeAdminCapabilities(tabIndex, user.id));
//				grid.add(removeAdminCap, rowCount + initXlevel + 2, user_index + initYlevel); // adding 2 because i
//																								// start from (2,3)
//			} else {
//				Button giveAdminCap = new Button("Give Admin Capabilities");
//				giveAdminCap.setOnAction(event -> this.controller.giveAdminCapabilities(tabIndex, user.id));
//				grid.add(giveAdminCap, rowCount + initXlevel + 2, user_index + initYlevel); // adding 2 because i start
//																							// from (2,3)
//			}
//			Button fireUserButton = new Button("Fire User");
//			fireUserButton.setOnAction(event -> this.controller.fireUser(tabIndex, user.id));
//			grid.add(fireUserButton, rowCount + 3 + initXlevel, user_index + initYlevel); // adding 2 because i start
//																							// from (2,3)
//		}
		Button logout = new Button("Logout");
		logout.setOnAction(eventR -> {
			AuthenticationController.startController(primaryStage);
		});

		Button editInfo = new Button("Edit Info");
		editInfo.setOnAction(eventR -> {
			try {
				this.controller.showEditInfoView(tabIndex);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		grid.add(logout, rowCount + 3, 0);
		grid.add(editInfo, rowCount + 3, 1);

		return grid;

	}

	

	public void startView() {
		VBox vBox = new VBox(this.tabPane);
		Scene scene = new Scene(vBox, 600, 275);
		primaryStage.setScene(scene);
		primaryStage.setTitle("BookFace");
		primaryStage.show();
	}

	public GridPane getEditInfoView(int tabnum) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setHgap(18);
		grid.setVgap(18);
		grid.setPadding(new Insets(00, 00, 00, 00));
		Text scenetitle = new Text("Edit Info screen");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		grid.add(scenetitle, 1, 1, 5, 1);

		User user = this.controller.getUser();

		ArrayList<Field> fields = getAllFields();

		int initXlevel = 0;
		int initYlevel = 2;
		int rowCount = fields.size() + 1;

		for (int field_index = 0; field_index < fields.size(); field_index++) {
			try {
				Object field = fields.get(field_index).get(user);

				grid.add(new TextArea("field " + field.toString() + " "), initXlevel + 1, field_index + initYlevel);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return grid;
	}

}
