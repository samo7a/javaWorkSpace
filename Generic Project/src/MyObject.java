import java.util.Random;

public class MyObject {

	protected String name;
	protected int value;
	public String getName() {
		return name;
	}
	public int getValue() {
		return value;
	}

	public int value() {
		Random r = new Random();
		return r.nextInt(100);
	}

}
