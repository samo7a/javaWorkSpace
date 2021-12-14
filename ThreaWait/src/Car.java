
public class Car implements Runnable{
	Methods m;
	
	public Car (Methods m) {
		this.m = m;
	}
	@Override
	public void run() {
		m.pitStop();
		
	}
	
	

}
