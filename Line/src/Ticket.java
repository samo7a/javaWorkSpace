import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ticket {
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

	protected enum Position {VIP, Front, Rear, Balacony};
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Position position;
	private int ticketNumber;
	private double price;
	private boolean isShowedUp;
	public Ticket() {
		this.firstName = "";
		this.lastName = "";
		this.phoneNumber = "";
		this.position = Position.VIP;
		this.ticketNumber = 0;
		this.isShowedUp = false;
		setPrice(position);
	}
	public Ticket(String firstName, String lastName, String phoneNumber, Position position, int ticketNumber,
			boolean isShowedUp) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.ticketNumber = ticketNumber;
		this.isShowedUp = false;
		setPrice(position);

	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		}
		else {
			AlertBox.display("Error", "This is not a valid Phone number");
		}
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		if(this.position == Position.VIP) {
			if (ticketNumber == 0) {
				AlertBox.display("Error", "Ticket no. cannot be zero");

			}
			else if (ticketNumber > 3) {
				AlertBox.display("Error", "Ticket no. has to be a number between 1 and 3");
			}
			else {
				
				if (ticketNumber == 1 && !vip1.getIfTaken()) {
					vip1.setIfTaken(true);
					this.ticketNumber = ticketNumber;
					
				}
				else if (ticketNumber == 2 && !vip2.getIfTaken()) {
					vip2.setIfTaken(true);
					this.ticketNumber = ticketNumber;
					
				}
				else if (ticketNumber == 3 && !vip3.getIfTaken()) {
					vip3.setIfTaken(true);
					this.ticketNumber = ticketNumber;
					
				}
				else {
					AlertBox.display("Occupied", "This Ticket is already purchaced.\n Try another ticket or send to the wait list. ");
				}

			} 

		}
	}
	//this.ticketNumber = ticketNumber;

	public double getPrice() {
		return price;
	}
	public void setPrice(Position p) {
		if (p == Position.VIP) {
			price = 100;
		}
		else if (p == Position.Balacony) {
			price = 75;
		}
		else {
			price = 50;
		}

	}
	public boolean isShowedUp() {
		return isShowedUp;
	}
	public void setShowedUp(boolean isShowedUp) {
		this.isShowedUp = isShowedUp;
	}



}
