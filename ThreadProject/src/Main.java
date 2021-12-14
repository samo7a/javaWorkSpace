
public class Main{

	public static void main(String[] args) {
		Food f = new Food();
		//                                    name,  initial position , speed,    maxRest
		Thread rabbit = new Thread(new Animal("rabbit",     0,           4.2,       162,      f));
		Thread turtle = new Thread(new Animal("turtle",     0,           2.9,       94,       f));

		
		rabbit.start();
		turtle.start();
	}
}


