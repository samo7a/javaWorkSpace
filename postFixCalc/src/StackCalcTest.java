public class StackCalcTest {
	public static void main(String[] args) {
		StackCalc stackCalc = new StackCalc();
		String[] values = {"3", "5", "9", "*", "+"};
		for(int i = 0; i < 5; i++) {
			stackCalc.stack.push(values[i]);
			}
		System.out.println(stackCalc.stack);
		System.out.println(stackCalc.answer());
		}
	}