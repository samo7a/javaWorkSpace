import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ConcertTickets {
	ArrayList<String> line;
	Queue <String> waitList ;
	LinkedList <String> ticketHolders ;

	// constructor
	public ConcertTickets(ArrayList<String> listOfPeople) {
		line = listOfPeople;
		waitList = new LinkedList <>();
		ticketHolders = new LinkedList<String>();
		
	}
	//done
	public void insertInFront(String string) {
		line.add(0, string);

	}
	//done
	public void insertIntoLine(String string) {
		line.add(string);

	}
	//done
	public void removeFromLine(String string) {
		line.remove(string);

	}

	public void assignedTicket() { 
		int numOfPeopleInLine = line.size();

		if (numOfPeopleInLine < 10) {
			for (int i = 0; i < numOfPeopleInLine; i++) {
				ticketHolders.add(line.get(i));
			} 
		}
		else if (numOfPeopleInLine >= 10 && numOfPeopleInLine < 16) {
			for (int i = 0; i < 10; i++) {
				ticketHolders.add(line.get(i));
			}
			for(int i = 10; i < numOfPeopleInLine; i++) {
				addToWaitList(line.get(i));
			}
		}
		else if (numOfPeopleInLine >= 16) {
			for (int i = 0; i < 10; i++) {
				ticketHolders.add(line.get(i));
			}
			for(int i = 10; i < 15; i++) {
				addToWaitList(line.get(i));
			}
		} 

	}
	//FixMe
	public LinkedList<String> listOfTicketHolders() {
		System.out.println("List of ticket holders: ");
		return ticketHolders;
	}

	public Queue<String> printWaitlist() {
		assignedTicket();
		System.out.println("Wait list: ");
		return waitList;
	}
	public void addToWaitList(String string) {
		waitList.add(string);

	}

}
