import java.util.Random;

/*The objective here is to demonstrate the behavior of threads that share data, and use synchronized methods.
 *   You do not NOT use wait/ notify/ notifyAll in this exercise.

When the above race working, add to it in the following way.

Create a class called Food.  It is not a Thread, and does not run.  
It's just a class that represents some data that will be shared by multiple threads.

Simulating an animal eating, simply means that the thread will sleep for some length of time. 
 This is the same as the "resting" that the turtle an rabbit did in part I.

There is one instance of the Food class that is shared by both of the animals.
  Pass it to the constructor of the Animal class for both the turtle and the rabbit.

There is a method in the Food class called eat().  This method is synchronized, i.e., only one Animal can be eating at a time.

The rabbit eats the food (the thread will sleep) for a longer time than the turtle, thus giving an advantage to the rabbit.

But, the turtle must wait until the rabbit is done eating until it can eat, so the advantage is reduced.

Print out the message inside the eat method when the animal begins to eat, and when it is done eating.
  Indicate which animal it is that starts to eat.

Try making the eat method not synchronized, 
and observe the different behavior if the eat method allows the rabbit to begin eating before the turtle is done eating.

*Note that this program will have in some cases exception handling. 
* Make sure that all exceptions are handled according to standard programming practices.

*/
public class Animal implements Runnable{
	protected String name;
	protected double position;
	protected double speed;
	protected int restMax;
	protected static boolean winner = false;
	final double RACE_LENGTH = 100;
	Random r = new Random();
	Food f ;
	public Animal(String name, double position, double speed, int restMax, Food f) {
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.restMax = restMax;
		this.f = f;
		
		
	}
	public Animal(String name, double position, double speed, int restMax) {
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.restMax = restMax;
		
	}
	
	public  void run() {
		while( !Animal.winner) {
			//System.out.println(winner);
			this.position = this.position + speed ;
			System.out.println("The " + name + " is running ");
			System.out.println("The " + name + " is at " + position + " yard from the start.");
			
			// comment f.eat() to test partI of the project, leave it as it is to test partII.
			f.eat();
			
			if (!winner) {
				if (this.position >= RACE_LENGTH) {
					Animal.winner = true;
					System.out.println("********* The " + name + " won the race.");
				} 
				else {
					try {
						int sleep = r.nextInt(restMax );
						System.out.println( "The " + name + " is going to sleep for "+ sleep + " ms.");
						Thread.sleep( sleep);
						

					} catch (InterruptedException e) {
						System.out.println(name + " Inturpted!!");
					}
				}
				
			}
			


		}

	}

	public double getPosition() {
		return position;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getRestMax() {
		return restMax;
	}
	public void setRestMax(int restMax) {
		this.restMax = restMax;
	}
	public static boolean isWinner() {
		return winner;
	}
	public static void setWinner(boolean winner) {
		Animal.winner = winner;
	}
	public String getName() {
		return name;
	}




}
