

import java.util.ArrayList;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	Seats vip1 = new Seats();
	Seats vip2 = new Seats();
	Seats vip3 = new Seats();
	Seats front1 = new Seats();
	Seats front2 = new Seats();
	Seats front3 = new Seats();
	Seats front4 = new Seats();
	Seats front5 = new Seats();
	Seats rear1 = new Seats();
	Seats rear2 = new Seats();
	Seats rear3 = new Seats();
	Seats rear4 = new Seats();
	Seats rear5 = new Seats();
	Seats balacony1 = new Seats();
	Seats balacony2 = new Seats();
	Seats balacony3 = new Seats();
	Seats balacony4 = new Seats();
	Seats balacony5 = new Seats();
	
	Stage window;
	Scene mainScene ;
	Scene tableScene;
	
	TableView<Ticket> table ;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		TableColumn <Ticket,String> firstNameColumn = new TableColumn<>("First Name");
		TableColumn<Ticket,String> lastNameColumn = new TableColumn<>("Last Name");
		TableColumn<Ticket,String> phoneNumberColumn = new TableColumn<>("Phone Number");
		TableColumn<Ticket,Ticket.Position> positionColumn = new TableColumn<>("Row");
		TableColumn<Ticket,Integer> ticketNoColumn = new TableColumn<>("Ticket Number");
		TableColumn<Ticket,Boolean> isShowedUpColumn = new TableColumn<>("Showed Up?");

		firstNameColumn.setMinWidth(200);
		lastNameColumn.setMinWidth(200);
		phoneNumberColumn.setMinWidth(200);
		positionColumn.setMinWidth(200);
		ticketNoColumn.setMinWidth(200);
		isShowedUpColumn.setMinWidth(200);

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
		ticketNoColumn.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
		isShowedUpColumn.setCellValueFactory(new PropertyValueFactory<>("isShowedUp"));

		table = new TableView<>();
		table.setItems(getTicket());
		table.getColumns().addAll(firstNameColumn,lastNameColumn,phoneNumberColumn,positionColumn,ticketNoColumn,isShowedUpColumn);
		table.setRowFactory(tv -> {
            TableRow<Ticket> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    
                }
            });
            return row ;
        });
		TextField firstNameField, lastNameField, phoneNumberField, ticketNoField;
		
		ChoiceBox<String> isShowedUpCBox, positionCBox;
		firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		firstNameField.setMinWidth(100);
		
		lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		lastNameField.setMinWidth(100);
		
		phoneNumberField = new TextField();
		phoneNumberField.setPromptText("Phone Number");
		phoneNumberField.setMinWidth(100);
		
		Label positionLabel = new Label("Select The Customer Row");
		positionCBox = new ChoiceBox<>();
		positionCBox.getItems().addAll("VIP","Balacony","Front","Rear");
		positionCBox.setMinWidth(100);
		
		ticketNoField = new TextField();
		ticketNoField.setPromptText("Ticket #");
		ticketNoField.setMinWidth(100);
		
		Label showUpLabel = new Label("Did the Customer show up?");
		isShowedUpCBox = new ChoiceBox<>();
		isShowedUpCBox.getItems().addAll("Yes","No");
		isShowedUpCBox.setValue("No");
		isShowedUpCBox.setMinWidth(100);
		
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> {
			Ticket ticket = new Ticket();
			try {
				
			ticket.setFirstName(firstNameField.getText());
			ticket.setLastName(lastNameField.getText());
			ticket.setPhoneNumber(phoneNumberField.getText());
			ticket.setPosition(positionCheck(positionCBox.getValue()));
			ticket.setTicketNumber(Integer.parseInt(ticketNoField.getText()));
			
			ticket.setShowedUp(showUpCheck (isShowedUpCBox.getValue()));
			
			
				table.getItems().add(ticket);
				
				
			} catch (Exception e1) {
				AlertBox.display("Error", "Make sure to fill all Blanks");
			}
		});
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e-> {
			ObservableList<Ticket> ticketSelected, allTickets;
			allTickets = table.getItems();
			ticketSelected = table.getSelectionModel().getSelectedItems();
			ticketSelected.forEach(allTickets::remove);
		});
		Button goBack = new Button("Back");
		goBack.setOnAction(e-> {
			window.setScene(mainScene);
		});
		

		Button reserveTicket = new Button("Reserve new Tickets");
		reserveTicket.setOnAction(e -> {
			//AddWindow.display("Table of Predicted Attendants");
			window.setScene(tableScene);
		});
		ListView<String> waitList = new ListView<>();
		Button addToWaitList = new Button("Add to Wait List");
		addToWaitList.setOnAction(e-> {
			waitList.getItems().add(firstNameField.getText() + " " +lastNameField.getText());
		});
		Label WaitListLabel = new Label("Wait List");
		





		
		


		BorderPane mainLayout = new BorderPane();
		VBox layout = new VBox(10);
		layout.getChildren().addAll(reserveTicket,WaitListLabel,waitList);
		mainLayout.setTop(layout);

		BorderPane tableLayout = new BorderPane();
		VBox tableFunctions = new VBox(10);
		tableFunctions.getChildren().addAll(firstNameField,lastNameField,phoneNumberField,positionLabel,positionCBox,ticketNoField,addButton,addToWaitList,deleteButton,goBack);
		tableLayout.setTop(table);
		tableLayout.setCenter(tableFunctions);




		 mainScene = new Scene(mainLayout,2096,2096);
		tableScene = new Scene(tableLayout,2096,2096);
		
		
		
		// window configuration
		Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
		window.getIcons().add(icon);
		window.setScene(mainScene);
		window.setTitle("Theatre Booking System");
		window.show();
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		} );
	}
	private void closeProgram() {
		boolean ans = ConfirmBox.display("Exit", "Are you sure you want to exit?");
		if (ans)
			window.close();
	}
	public static ObservableList<Ticket> getTicket(){
		ObservableList<Ticket> ticket = FXCollections.observableArrayList();
		ticket.add(new Ticket("Steven","Jo","XXX-XXX-XXXX",Ticket.Position.VIP,0,true));
		return ticket;
		
	}
	public static Ticket.Position positionCheck (String s) {
		Ticket.Position c;
		if (s.equals("VIP")) {
			c = Ticket.Position.VIP;
		}
		else if (s.equals("Balacony")) {
			c = Ticket.Position.Balacony;
		}
		else if (s.equals("Front")) {
			c = Ticket.Position.Front;
		}
		else  {
			c = Ticket.Position.Rear;
		}
		
		 return c;
	}
	public static boolean showUpCheck (String s) {
		boolean c;
		if (s.equals("Yes")) {
			c = true;
		}
		else  {
			c = false;
		}
		 return c;
	}
}
