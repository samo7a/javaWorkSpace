import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

// animation class to create the timer
public class Clock extends Pane implements Runnable{
	
	ThreadManager tm;
	private Timeline animation;
	 Label timer = new Label("5");
	private int time = 5;
	private String s = "";
	public String getS() {
		return s;
	}
	// the constructor will add this node to any layout we want in the main method
	// notice the (this) keyword
	public Clock(ThreadManager tm){
		this.tm = tm;
		this.getChildren().add(timer);
		
		// every one second timeLabel() method will be executed.
		animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> timeLabel()));
		animation.setCycleCount(Timeline.INDEFINITE);
		
	}

	
	public void startTimer() {
		//System.out.println("running startTimer");    (testing purposes)
		animation.play();
		//System.out.println("finished startTimer");     (testing purposes)
	}
	
	//stops the timer , set it to zero , and play it again >>>>> restart it.
	public void restartTimer() {

		animation.stop();
		timer.setText("5");
		time = 5;
		animation.play();

	}
	
	// decrement the time and set its value to the label 
	private void timeLabel() {
		
			if (time > 0) {
				time--;
			}
		
		s = time + "";
		timer.setText(s);
	}
	

	@Override
	// run method for the thread.
	public void run() {
		try {
			tm.startTimer();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
	}



}
