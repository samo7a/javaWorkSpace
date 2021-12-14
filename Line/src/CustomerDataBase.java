
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerDataBase {
	public static TableView<Ticket> table ;
	public static void display(String title) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(250);
		window.setTitle(title);
		
		
		 
		TableColumn <Ticket,String> firstName = new TableColumn<>("First Name");
		TableColumn<Ticket,String> lastName = new TableColumn<>("Last Name");
		TableColumn<Ticket,String> phoneNumber = new TableColumn<>("Phone Number");
		TableColumn<Ticket,Ticket.Position> position = new TableColumn<>("Row");
		TableColumn<Ticket,Integer> ticketNo = new TableColumn<>("Ticket Number");
		TableColumn<Ticket,Boolean> isShowedUp = new TableColumn<>("Showed Up?");
		
		firstName.setMinWidth(200);
		lastName.setMinWidth(200);
		phoneNumber.setMinWidth(200);
		position.setMinWidth(200);
		ticketNo.setMinWidth(200);
		isShowedUp.setMinWidth(200);
		
		firstName.setCellValueFactory(new PropertyValueFactory<>("First Name"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("Last Name"));
		phoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone Number"));
		position.setCellValueFactory(new PropertyValueFactory<>("Row"));
		ticketNo.setCellValueFactory(new PropertyValueFactory<>("Ticket Number"));
		isShowedUp.setCellValueFactory(new PropertyValueFactory<>("Showed Up?"));
		
		table = new TableView<>();
		table.setItems(getTicket());
		table.getColumns().addAll(firstName,lastName,phoneNumber,position,ticketNo,isShowedUp);
		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(table);
		
		Scene s = new Scene(layout, 1048, 720);
		window.setScene(s);
		window.showAndWait();
		
		
		
	}
	public static ObservableList<Ticket> getTicket(){
		ObservableList<Ticket> ticket = FXCollections.observableArrayList();
		ticket.add(new Ticket("Steven","Jo","XXX-XXX-XXXX",Ticket.Position.VIP,0,true));
		return ticket;
		
	}

}
