import java.util.Stack;

public class StackCalc {

	Stack<String> stack;
	Stack<String> newStack = new Stack<>();
	Double right;
	Double left;
	Double result;




	public  StackCalc() {
		stack = new Stack<String>();
	}

	public double answer() {
		for(String var:stack) {
			if(Character.isDigit(var.charAt(0))) {
				newStack.push(var);
			}
			else if ( var.equals("+") || var.equals("-") || var.equals("*") || var.equals("/")|| var.equals("%")) {
				right = Double.parseDouble(newStack.pop());
				left = Double.parseDouble(newStack.pop());
				switch (var.charAt(0)){
				case '+' :
					result = right + left;
					break;
				case '-' :
					result = left - right;
					break;
				case '*' :
					result = right * left;
					break;
				case '/' :
					result = left / right;
					break;
				default:
					result = 0.0;
					break;
				}
				newStack.push(Double.toString(result));

			}
		}

		return result;
	}


}





