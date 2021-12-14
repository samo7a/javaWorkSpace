
public class Main {

	public static void main(String[] args) {
		Methods m = new Methods();
		Thread car = new Thread(new Car(m));
		Thread mechanic = new Thread(new Mechanic(m));
		
		
		car.start();
		mechanic.start();
		

	}

}
