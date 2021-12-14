import java.util.Random;

public class Car implements Runnable{
	
	String name;
	int speed;
	int pitTime;
	Random rndm = new Random();
	static int rank = 1;
	
	public synchronized void pitStop() throws InterruptedException {
		System.out.println(name + " entered the pit stop");
		Thread.sleep(rndm.nextInt(this.pitTime));
	}
	
	public Car(String name, int speed, int pitTime) {
		this.name = name;
		this.speed = speed;
		this.pitTime = pitTime;
	}
	public void run() {
		
		try {
			System.out.println(name + " started the race");
			pitStop();
			System.out.println(name + " finished the pit stop");
			Thread.sleep(rndm.nextInt(10000 - this.speed));
			System.out.println(name + " finished the race in the " + rank++ + " place");
		} catch (Exception e) {
			
			
		}
		
	}
	

}
