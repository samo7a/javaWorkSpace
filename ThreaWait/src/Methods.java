
public class Methods {
	
	public synchronized void pitStop() {
		System.out.println("Driver: I need to have a quick pit stop");
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("wait Inturrupted");
			
		}
		System.out.println("Driver : Thank you, heading back to the race");
		
		
	}
	
	public synchronized void changeTire() {
		System.out.println("Mechanic : Changing tires so quick.....");
		notify();
		
	}
	

}
