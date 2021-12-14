import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rndm = new Random();
		Thread car1 = new Thread(new Car("Ferrari", rndm.nextInt(10000), rndm.nextInt(10000) ));
		Thread car2 = new Thread(new Car("Volvo", rndm.nextInt(10000), rndm.nextInt(10000) ));
		Thread car3 = new Thread(new Car("Fiat", rndm.nextInt(10000), rndm.nextInt(10000) ));
		Thread car4 = new Thread(new Car("Tesla", rndm.nextInt(10000), rndm.nextInt(10000) ));
		
		car1.start();
		car2.start();
		car3.start();
		car4.start();

	}

}
