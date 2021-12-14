
public class MyGenerics {

	public <E> int partOne(E[] array, int length, E e) {
		int i;
		boolean isFound = false;
		for(i = 0; i < length ; i++) {
			if (e.equals(array[i])) {
				System.out.print("The element " + e + " is fount at index: ");
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.print("The element " + e + " is not found in this array whose length is ");
		}
		return i;
	}

	
	
	public <V extends MyObject>  String greaterThan( V o1, V o2) {
		System.out.println(o1.getName() + " has a value of " + o1.getValue() + " ,while " + o2.getName() + " has a value of " + o2.getValue());
		String s = "";
		if (o1.getValue() == o2.getValue()) {
			System.out.println("The 2 objects have tha same value.");
		}
		else if (o1.getValue() > o2.getValue()) {
			s = o1.getName();
		}
		else {
			s = o2.getName();
		}
		return s;
		
	}
	
	public <K extends MyObject> String partTwo(K o1, K o2){
		
		return greaterThan(o1,o2);
		
	}
	
	
	

}
