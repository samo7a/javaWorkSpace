import java.util.Random;

import javafx.application.Platform;

	// the worst piece of code i have ever written, but it do the job.
	// the fact that i created 60 variables in the file handler class make it like that.
	// loops will not going to work, it has to be like that.

public class ThreadManager extends FileHandler<Integer,Double,String,Character>{

	static int qNumber = 1;
	static FileHandler<Integer,Double,String,Character> fh = new FileHandler<>();
	static Random rndm = new Random();


	
		// changes the question 
	public synchronized void questionSetter() {

		importData();
		


		if (qNumber == 1) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q1a + " + " + fh.Q1b + " ?");
			qNumber ++;
			
			// this random number will allow us to rotate the right answer every time
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A1a.toString());
				Main.ans2.setText(fh.A1b.toString());
				Main.ans3.setText(fh.A1c.toString());
				Main.ans4.setText(fh.A1d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A1d.toString());
				Main.ans2.setText(fh.A1a.toString());
				Main.ans3.setText(fh.A1b.toString());
				Main.ans4.setText(fh.A1c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A1c.toString());
				Main.ans2.setText(fh.A1d.toString());
				Main.ans3.setText(fh.A1a.toString());
				Main.ans4.setText(fh.A1b.toString());
			}
			else  {
				Main.ans1.setText(fh.A1b.toString());
				Main.ans2.setText(fh.A1c.toString());
				Main.ans3.setText(fh.A1d.toString());
				Main.ans4.setText(fh.A1a.toString());
			}

			

		}

		else if (qNumber == 2) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q2a + " + " + fh.Q2b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A2a.toString());
				Main.ans2.setText(fh.A2b.toString());
				Main.ans3.setText(fh.A2c.toString());
				Main.ans4.setText(fh.A2d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A2d.toString());
				Main.ans2.setText(fh.A2a.toString());
				Main.ans3.setText(fh.A2b.toString());
				Main.ans4.setText(fh.A2c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A2c.toString());
				Main.ans2.setText(fh.A2d.toString());
				Main.ans3.setText(fh.A2a.toString());
				Main.ans4.setText(fh.A2b.toString());
			}
			else  {
				Main.ans1.setText(fh.A2b.toString());
				Main.ans2.setText(fh.A2c.toString());
				Main.ans3.setText(fh.A2d.toString());
				Main.ans4.setText(fh.A2a.toString());
			}
			// sets the time stamp for each question
			Main.timeStamp1.setText(Main.sdf.format(Main.timestamp));

		}
		else if (qNumber == 3) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q3a + " + " + fh.Q3b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A3a.toString());
				Main.ans2.setText(fh.A3b.toString());
				Main.ans3.setText(fh.A3c.toString());
				Main.ans4.setText(fh.A3d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A3d.toString());
				Main.ans2.setText(fh.A3a.toString());
				Main.ans3.setText(fh.A3b.toString());
				Main.ans4.setText(fh.A3c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A3c.toString());
				Main.ans2.setText(fh.A3d.toString());
				Main.ans3.setText(fh.A3a.toString());
				Main.ans4.setText(fh.A3b.toString());
			}
			else  {
				Main.ans1.setText(fh.A3b.toString());
				Main.ans2.setText(fh.A3c.toString());
				Main.ans3.setText(fh.A3d.toString());
				Main.ans4.setText(fh.A3a.toString());
			}
			Main.timeStamp2.setText(Main.sdf.format(Main.timestamp));

		}
		else if (qNumber == 4) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q4a + " + " + fh.Q4b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A4a.toString());
				Main.ans2.setText(fh.A4b.toString());
				Main.ans3.setText(fh.A4c.toString());
				Main.ans4.setText(fh.A4d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A4d.toString());
				Main.ans2.setText(fh.A4a.toString());
				Main.ans3.setText(fh.A4b.toString());
				Main.ans4.setText(fh.A4c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A4c.toString());
				Main.ans2.setText(fh.A4d.toString());
				Main.ans3.setText(fh.A4a.toString());
				Main.ans4.setText(fh.A4b.toString());
			}
			else  {
				Main.ans1.setText(fh.A4b.toString());
				Main.ans2.setText(fh.A4c.toString());
				Main.ans3.setText(fh.A4d.toString());
				Main.ans4.setText(fh.A4a.toString());
			}
			Main.timeStamp3.setText(Main.sdf.format(Main.timestamp));

		}
		else if (qNumber == 5) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q5a + " + " + fh.Q5b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A5a.toString());
				Main.ans2.setText(fh.A5b.toString());
				Main.ans3.setText(fh.A5c.toString());
				Main.ans4.setText(fh.A5d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A5d.toString());
				Main.ans2.setText(fh.A5a.toString());
				Main.ans3.setText(fh.A5b.toString());
				Main.ans4.setText(fh.A5c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A5c.toString());
				Main.ans2.setText(fh.A5d.toString());
				Main.ans3.setText(fh.A5a.toString());
				Main.ans4.setText(fh.A5b.toString());
			}
			else  {
				Main.ans1.setText(fh.A5b.toString());
				Main.ans2.setText(fh.A5c.toString());
				Main.ans3.setText(fh.A5d.toString());
				Main.ans4.setText(fh.A5a.toString());
			}
			Main.timeStamp4.setText(Main.sdf.format(Main.timestamp));

		}
		else if (qNumber == 6) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q6a + " + " + fh.Q6b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A6a.toString());
				Main.ans2.setText(fh.A6b.toString());
				Main.ans3.setText(fh.A6c.toString());
				Main.ans4.setText(fh.A6d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A6d.toString());
				Main.ans2.setText(fh.A6a.toString());
				Main.ans3.setText(fh.A6b.toString());
				Main.ans4.setText(fh.A6c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A6c.toString());
				Main.ans2.setText(fh.A6d.toString());
				Main.ans3.setText(fh.A6a.toString());
				Main.ans4.setText(fh.A6b.toString());
			}
			else  {
				Main.ans1.setText(fh.A6b.toString());
				Main.ans2.setText(fh.A6c.toString());
				Main.ans3.setText(fh.A6d.toString());
				Main.ans4.setText(fh.A6a.toString());
			}
			Main.timeStamp5.setText(Main.sdf.format(Main.timestamp));

		}
		else if (qNumber == 7) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q7a + " + " + fh.Q7b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A7a.toString());
				Main.ans2.setText(fh.A7b.toString());
				Main.ans3.setText(fh.A7c.toString());
				Main.ans4.setText(fh.A7d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A7d.toString());
				Main.ans2.setText(fh.A7a.toString());
				Main.ans3.setText(fh.A7b.toString());
				Main.ans4.setText(fh.A7c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A7c.toString());
				Main.ans2.setText(fh.A7d.toString());
				Main.ans3.setText(fh.A7a.toString());
				Main.ans4.setText(fh.A7b.toString());
			}
			else  {
				Main.ans1.setText(fh.A7b.toString());
				Main.ans2.setText(fh.A7c.toString());
				Main.ans3.setText(fh.A7d.toString());
				Main.ans4.setText(fh.A7a.toString());
			}
			Main.timeStamp6.setText(Main.sdf.format(Main.timestamp));

		}
		else if (qNumber == 8) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q8a + " + " + fh.Q8b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A8a.toString());
				Main.ans2.setText(fh.A8b.toString());
				Main.ans3.setText(fh.A8c.toString());
				Main.ans4.setText(fh.A8d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A8d.toString());
				Main.ans2.setText(fh.A8a.toString());
				Main.ans3.setText(fh.A8b.toString());
				Main.ans4.setText(fh.A8c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A8c.toString());
				Main.ans2.setText(fh.A8d.toString());
				Main.ans3.setText(fh.A8a.toString());
				Main.ans4.setText(fh.A8b.toString());
			}
			else  {
				Main.ans1.setText(fh.A8b.toString());
				Main.ans2.setText(fh.A8c.toString());
				Main.ans3.setText(fh.A8d.toString());
				Main.ans4.setText(fh.A8a.toString());
			}
			Main.timeStamp7.setText(Main.sdf.format(Main.timestamp));
		}

		else if (qNumber == 9) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q9a + " + " + fh.Q9b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A9a.toString());
				Main.ans2.setText(fh.A9b.toString());
				Main.ans3.setText(fh.A9c.toString());
				Main.ans4.setText(fh.A9d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A9d.toString());
				Main.ans2.setText(fh.A9a.toString());
				Main.ans3.setText(fh.A9b.toString());
				Main.ans4.setText(fh.A9c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A9c.toString());
				Main.ans2.setText(fh.A9d.toString());
				Main.ans3.setText(fh.A9a.toString());
				Main.ans4.setText(fh.A9b.toString());
			}
			else  {
				Main.ans1.setText(fh.A9b.toString());
				Main.ans2.setText(fh.A9c.toString());
				Main.ans3.setText(fh.A9d.toString());
				Main.ans4.setText(fh.A9a.toString());
			}
			Main.timeStamp8.setText(Main.sdf.format(Main.timestamp));

		}
		else if (qNumber == 10) {
			Main.questionLabel.setText(qNumber +") What is the result of " + fh.Q10a + " + " + fh.Q10b + " ?");
			qNumber ++;
			int a = rndm.nextInt(3) + 1;
			if (a == 1) {
				Main.ans1.setText(fh.A10a.toString());
				Main.ans2.setText(fh.A10b.toString());
				Main.ans3.setText(fh.A10c.toString());
				Main.ans4.setText(fh.A10d.toString());
			}
			else if (a == 2) {
				Main.ans1.setText(fh.A10d.toString());
				Main.ans2.setText(fh.A10a.toString());
				Main.ans3.setText(fh.A10b.toString());
				Main.ans4.setText(fh.A10c.toString());
			}
			else if (a == 3) {
				Main.ans1.setText(fh.A10c.toString());
				Main.ans2.setText(fh.A10d.toString());
				Main.ans3.setText(fh.A10a.toString());
				Main.ans4.setText(fh.A10b.toString());
			}
			else  {
				Main.ans1.setText(fh.A10b.toString());
				Main.ans2.setText(fh.A10c.toString());
				Main.ans3.setText(fh.A10d.toString());
				Main.ans4.setText(fh.A10a.toString());
			}
			Main.timeStamp9.setText(Main.sdf.format(Main.timestamp));
		}
		else {
			Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
				Platform.runLater(
						() -> {
							Main.timerObject.setDisable(true);
							Main.timerObject.setOpacity(0);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
				Main.timeStamp10.setText(Main.sdf.format(Main.timestamp));
		}
		

	}
	
	// gets the data from the file
	public void importData() {
		fh.openFile("input.txt");
		fh.Q1a = Double.parseDouble(fh.assignVar());
		fh.Q1b = Integer.parseInt(fh.assignVar());
		fh.A1a = Double.parseDouble(fh.assignVar());
		fh.A1b = Integer.parseInt(fh.assignVar());
		fh.A1c = Integer.parseInt(fh.assignVar());
		fh.A1d = Integer.parseInt(fh.assignVar());

		fh.Q2a = Double.parseDouble(fh.assignVar());
		fh.Q2b = Double.parseDouble(fh.assignVar());
		fh.A2a = Integer.parseInt(fh.assignVar());
		fh.A2b = Double.parseDouble(fh.assignVar());
		fh.A2c = Integer.parseInt(fh.assignVar());
		fh.A2d = Integer.parseInt(fh.assignVar());

		fh.Q3a = fh.assignVar();
		fh.Q3b = fh.assignVar();
		fh.A3a = fh.assignVar();
		fh.A3b = fh.assignVar();
		fh.A3c = fh.assignVar();
		fh.A3d = fh.assignVar();

		fh.Q4a = fh.assignVar().charAt(0);
		fh.Q4b = fh.assignVar().charAt(0);
		fh.A4a = fh.assignVar();
		fh.A4b = fh.assignVar();
		fh.A4c = Integer.parseInt(fh.assignVar());
		fh.A4d = Integer.parseInt(fh.assignVar());

		fh.Q5a = Integer.parseInt(fh.assignVar());
		fh.Q5b = Integer.parseInt(fh.assignVar());
		fh.A5a = Integer.parseInt(fh.assignVar());
		fh.A5b = Integer.parseInt(fh.assignVar());
		fh.A5c = Integer.parseInt(fh.assignVar());
		fh.A5d = Integer.parseInt(fh.assignVar());

		fh.Q6a = fh.assignVar();
		fh.Q6b = fh.assignVar();
		fh.A6a = fh.assignVar();
		fh.A6b = Integer.parseInt(fh.assignVar());
		fh.A6c = Double.parseDouble(fh.assignVar());
		fh.A6d = Integer.parseInt(fh.assignVar());

		fh.Q7a = fh.assignVar();
		fh.Q7b = fh.assignVar();
		fh.A7a = fh.assignVar();
		fh.A7b = fh.assignVar();
		fh.A7c = fh.assignVar();
		fh.A7d = fh.assignVar();

		fh.Q8a = fh.assignVar();
		fh.Q8b = Integer.parseInt(fh.assignVar());
		fh.A8a = fh.assignVar();
		fh.A8b = Double.parseDouble(fh.assignVar());
		fh.A8c = Integer.parseInt(fh.assignVar());
		fh.A8d = Integer.parseInt(fh.assignVar());

		fh.Q9a = fh.assignVar();
		fh.Q9b = fh.assignVar();
		fh.A9a = fh.assignVar();
		fh.A9b = fh.assignVar();
		fh.A9c = fh.assignVar();
		fh.A9d = fh.assignVar();

		fh.Q10a = Integer.parseInt(fh.assignVar());
		fh.Q10b = Integer.parseInt(fh.assignVar());
		fh.A10a = Integer.parseInt(fh.assignVar());
		fh.A10b = Integer.parseInt(fh.assignVar());
		fh.A10c = Integer.parseInt(fh.assignVar());
		fh.A10d = Integer.parseInt(fh.assignVar());
		fh.closeFile();

	}

	public  synchronized void startTimer() throws Throwable {

		if (qNumber == 1) {
			
			Platform.runLater(() -> {
				Main.timerObject.startTimer();
				questionSetter();
			});
			
			wait(5050);

			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);

			}
			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			wait(5050);
			
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}




		}
		if (qNumber == 2) {
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}
			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			wait(5050);
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}

		}
		if (qNumber == 3) {

			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			wait(5050);
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}

		}
		if (qNumber == 4) {


			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			wait(5050);
			
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}

		}
		if (qNumber == 5) {

			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			
			wait(5050);
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}

		}
		if (qNumber == 6) {


			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			wait(5050);
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}

		}
		if (qNumber == 7) {



			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			
			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}

		}

		if (qNumber == 8) {




			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			
			wait(5050);
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}
		}
		if (qNumber == 9) {





			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);




			}

			wait(5050);
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			
			wait(5050);
			
			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
						}
						);
			}

		}
		if (qNumber == 10) {






			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							Main.timerObject.restartTimer();
							questionSetter();
						}
						);






			}
			
			wait(5050);


			if (Main.timerObject.timer.getText().equals("0")) {
				Platform.runLater(
						() -> {
							// opens the generateReport button and closes the 4 choices buttons.
							Main.questionLabel.setText("Game Over!, Click generate report to see the score board.");
							Main.timerObject.setDisable(true);
							Main.ans1.setDisable(true);
							Main.ans2.setDisable(true);
							Main.ans3.setDisable(true);
							Main.ans4.setDisable(true);
							Main.generateReport.setDisable(false);
							
						}
						);
			}

		}


	}
}

