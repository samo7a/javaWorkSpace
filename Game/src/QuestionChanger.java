import java.util.Random;
import javafx.application.Platform;

public class QuestionChanger implements Runnable {
	static int qNumber = 1;
	static FileHandler<Integer,Double,String,Character> fh = new FileHandler<>();
	static Random rndm = new Random();
	ThreadManager tm;


	public QuestionChanger(ThreadManager tm) {
		this.tm = tm;
	}
	
	// run method for the thread.
	@Override
	public void run() {
		
		//this method will change the values of some javafx attributes 
		//and javafx will not allow any external methods to change it and will generate an error 
		// so Platform.runLater will allow us to superpass this problem
		// solution found on the Internet
			Platform.runLater(
				() -> {
					tm.questionSetter();
				}
				);
		
		

	}




	





}