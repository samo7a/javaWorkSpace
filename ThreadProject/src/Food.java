
public class Food {
	

	// delete synchronized to test the second scenario 
	public synchronized void eat()  {
		System.out.println( "I am hungry, I am going to eat.");
		try {
			System.out.println("mmmmmmmmmm, yummy");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Inturrupted");

		}
		System.out.println( "I'm full, let's get back to the race.");

		
	}
}
