public class Mechanic implements Runnable{
	Methods m;
	
	public Mechanic (Methods m) {
		this.m = m;
	}
	@Override
	public void run() {
		m.changeTire();
		
	}
	
	

}