
import java.util.ArrayList;
public class ConcertTicketsTest {
	public static void main(String[] args) {
		ArrayList<String> listOfPeople = new ArrayList<String>();
		listOfPeople.add("Monica");
		listOfPeople.add("Chandler");
		listOfPeople.add("Rachel");
		listOfPeople.add("Phobe");
		listOfPeople.add("Joey");
		listOfPeople.add("Ross");
		listOfPeople.add("John");
		listOfPeople.add("Daenerys");
		listOfPeople.add("Arya");
		listOfPeople.add("Sansa");
		listOfPeople.add("Rob");
		listOfPeople.add("Ned");
		ConcertTickets concertTickets = new ConcertTickets(listOfPeople);
		concertTickets.removeFromLine("Ned");
		concertTickets.removeFromLine("Ross");
		concertTickets.insertInFront("Cersei");
		System.out.println(concertTickets.printWaitlist());
		System.out.println(concertTickets.listOfTicketHolders());
	}
}
