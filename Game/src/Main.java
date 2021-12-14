//important imports
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

public class Main extends Application {
	//Most of the program fields that has to be declared outside the start method.
	Random rndm = new Random();
	int qNumber = 1;
	static Stage window;
	BorderPane mainLayout;
	HBox topLayout; 
	String s;
	static ThreadManager tm = new ThreadManager();
	Label nameLabel = new Label(s);
	// timerObject and time thread to take care of the timer, changing questions
	static Clock timerObject =  new Clock(tm);
	Thread timeThread = new Thread(new Clock(tm));
	
	VBox rightLayout;
	static Label timeStamp1, timeStamp2, timeStamp3, timeStamp4, timeStamp5, timeStamp6, timeStamp7, timeStamp8, timeStamp9, timeStamp10;
	VBox centerLayout;
	static Label scoreUpdate;
	static Button ans1;
	static Button ans2;
	static Button ans3;
	static Button ans4;
	static Button generateReport;
	static Label questionLabel;
	HBox answerLayout;
	HBox bottomLayout;
	Player p = new Player();
	Scene mainScene;
	FileHandler<Integer,Double,String,Character> fh = new FileHandler<>();
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		//Connecting to the database
		DataBase.createNewDataBase("GreatestScore.db");
		DataBase.connectAndCreateTable();

		//first scene
		Button startButton = new Button("Start Game");
		TextField nameField = new TextField();

		nameField.setFocusTraversable(false);
		nameField.setPromptText("Enter Your Name.....(optional)");
		nameField.setMaxHeight(TextField.USE_COMPUTED_SIZE);
		nameField.setMaxWidth(TextField.USE_COMPUTED_SIZE);


		startButton.setMaxSize(Button.USE_COMPUTED_SIZE, Button.USE_COMPUTED_SIZE);
		//the start button will get the name entered from the user, if the user did not enter a name, the game will
		//produce a random name with this format _------> (Player # x)
		//the name will appear at the left top of the main window
		//the button will insert the player name to the data base with score = 0
		//and then will switch the screen to the main scene and will start the time thread
		startButton.setOnAction(e-> {
			if (nameField.getText().isEmpty()){
				s = p.getName();
			}
			else {
				s = nameField.getText();
			}
			p.setName(s);
			nameLabel.setText("Player Name: " + s);
			DataBase.insertPlayer(p);
			window.setScene(mainScene);
			window.centerOnScreen();
			timeThread.start();
			try {
				timerObject.startTimer();
			} catch (Throwable e1) {
				
				System.out.println(e1.getMessage());
			}
		});
		//creating a layout and all the children nodes to it.
		VBox loginLayout = new VBox(10);
		loginLayout.setAlignment(Pos.CENTER);
		VBox.setMargin(nameField, new Insets(0,50,0,50));
		loginLayout.getChildren().addAll(nameField,startButton);
		// end of the first scene 



		//second scene

		//topLayout
		
		Label timeLeftLabel = new Label("Time Left for The next Question: ");
		Label score = new Label("Score: " );
		scoreUpdate = new Label("0");
		topLayout = new HBox(100);
		topLayout.setAlignment(Pos.CENTER);
		topLayout.getChildren().addAll(nameLabel,score,scoreUpdate,timeLeftLabel,timerObject);

		//rightLayout
		rightLayout = new VBox(15);
		timeStamp1 = new Label("");
		timeStamp2 = new Label("");
		timeStamp3 = new Label("");
		timeStamp4 = new Label("");
		timeStamp5 = new Label("");
		timeStamp6 = new Label("");
		timeStamp7 = new Label("");
		timeStamp8 = new Label("");
		timeStamp9 = new Label("");
		timeStamp10 = new Label("");
		rightLayout.setAlignment(Pos.CENTER_LEFT);
		rightLayout.getChildren().addAll(timeStamp10,timeStamp9,timeStamp8,timeStamp7,timeStamp6,timeStamp5,timeStamp4,timeStamp3,timeStamp2,timeStamp1);	

		//Center layout
		centerLayout = new VBox(50);
		questionLabel = new Label("What is the result of " + "  " + "+ " + "  ");
		answerLayout = new HBox(50);
		// all 4 buttons will check for the correct answer and will increment the score if the correct answer is selected.
		//and then will restart the timer and will start a new Questions thread to change the question.
		ans1 = new Button();
		ans1.setOnAction(e-> {
			if (questionLabel.getText().equals("1) What is the result of 5.0 + 4 ?") && ans1.getText().equals("9.0")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("2) What is the result of 5.0 + 4.0 ?") && ans1.getText().equals("9")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("3) What is the result of Mickey + Mouse ?") && ans1.getText().equals("MickeyMouse")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore()));
			}
			else if(ans1.getText().equals("error") || ans1.getText().equals("16") || ans1.getText().equals("8.1f") || 
					ans1.getText().equals("JavaProgram") || ans1.getText().equals("6.3f") || ans1.getText().equals("MaryLamb") || 
					ans1.getText().equals("11") ) {
				
					p.setScore(p.getScore() + 1);
					scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			
			timerObject.restartTimer();
			Thread questions = new Thread(new QuestionChanger(tm));
			questions.start();
			
		});
		ans2 = new Button();
		ans2.setOnAction(e-> {
			if (questionLabel.getText().equals("1) What is the result of 5.0 + 4 ?") && ans2.getText().equals("9.0")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("2) What is the result of 5.0 + 4.0 ?") && ans2.getText().equals("9")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("3) What is the result of Mickey + Mouse ?") && ans2.getText().equals("MickeyMouse")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore()));
			}
			else if(ans2.getText().equals("error") || ans2.getText().equals("16") || ans2.getText().equals("8.1f") || 
					ans2.getText().equals("JavaProgram") || ans2.getText().equals("6.3f") || ans2.getText().equals("MaryLamb") || 
					ans2.getText().equals("11") ) {
				
					p.setScore(p.getScore() + 1);
					scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			
			timerObject.restartTimer();
			Thread questions = new Thread(new QuestionChanger(tm));
			questions.start();

		});
		ans3 = new Button();
		ans3.setOnAction(e-> {
			if (questionLabel.getText().equals("1) What is the result of 5.0 + 4 ?") && ans3.getText().equals("9.0")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("2) What is the result of 5.0 + 4.0 ?") && ans3.getText().equals("9")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("3) What is the result of Mickey + Mouse ?") && ans3.getText().equals("MickeyMouse")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore()));
			}
			else if(ans3.getText().equals("error") || ans3.getText().equals("16") || ans3.getText().equals("8.1f") || 
					ans3.getText().equals("JavaProgram") || ans3.getText().equals("6.3f") || ans3.getText().equals("MaryLamb") || 
					ans3.getText().equals("11") ) {
				
					p.setScore(p.getScore() + 1);
					scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			
			timerObject.restartTimer();
			Thread questions = new Thread(new QuestionChanger(tm));
			questions.start();
		});
		ans4 = new Button();
		ans4.setOnAction(e-> {
			if (questionLabel.getText().equals("1) What is the result of 5.0 + 4 ?") && ans4.getText().equals("9.0")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("2) What is the result of 5.0 + 4.0 ?") && ans4.getText().equals("9")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			else if (questionLabel.getText().equals("3) What is the result of Mickey + Mouse ?") && ans4.getText().equals("MickeyMouse")) {
				p.setScore(p.getScore() + 1);
				scoreUpdate.setText( Integer.toString(p.getScore()));
			}
			else if(ans4.getText().equals("error") || ans4.getText().equals("16") || ans4.getText().equals("8.1f") || 
					ans4.getText().equals("JavaProgram") || ans4.getText().equals("6.3f") || ans4.getText().equals("MaryLamb") || 
					ans4.getText().equals("11") ) {
				
					p.setScore(p.getScore() + 1);
					scoreUpdate.setText( Integer.toString(p.getScore())); 
			}
			
			timerObject.restartTimer();
			Thread questions = new Thread(new QuestionChanger(tm));
			questions.start();
		});
		
		// generate report button will be disabled during the game but only will will be available after the 10th question.
		// the button will update the score in the data base with the new score of the player
		// it will create a file with the highest 10 scores and will show it on a pop up window. 
		// after that it will cut the connection with the data base
		generateReport = new Button("Generate Report");
		generateReport.setDisable(true);
		generateReport.setOnAction(e-> {
			DataBase.updateScore(p);
			String msg = DataBase.showScore();
			AlertBox.display("Hall Of Fame!", msg);
			fh.addDataToFile();
			DataBase.closeConnection();
			generateReport.setDisable(true);
			
		});
		answerLayout.setAlignment(Pos.CENTER);
		answerLayout.getChildren().addAll(ans1,ans2,ans3,ans4);
		centerLayout.getChildren().addAll(questionLabel,answerLayout,generateReport);
		centerLayout.setAlignment(Pos.CENTER);

		//MainLayout
		mainLayout = new BorderPane();
		BorderPane.setMargin(topLayout, new Insets(30,50,30,50));
		BorderPane.setMargin(rightLayout, new Insets(30,50,30,50));
		BorderPane.setMargin(centerLayout, new Insets(30,50,30,50));
		mainLayout.setTop(topLayout);
		mainLayout.setRight(rightLayout);
		mainLayout.setCenter(centerLayout);
		
		
		
		//end of scene 2

		
		


		//window configurations
		window.centerOnScreen();
		window.setScene(new Scene(loginLayout,300,125));
		mainScene = new Scene(mainLayout,1048,600);
		window.setTitle("Game Boy");
		window.show();
		
		// some players maybe close the game accidentally while playing.
		// this method will prevent that from happening by asking the user to confirm his choice to close it.
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
			
			 
			
	       
		} );
		
		
		
		
		
	}
	
	private void closeProgram() {
		boolean ans = ConfirmBox.display("Exit", "Are you sure you want to exit?");
		if (ans) {
			window.close();
		// this will kill any threads that is playing in the background even if we closed the program.
					// I had this issue that slowed down my laptop and discovered that one of the threads did not end
					// after I closed the game, I found the solution on the worldWideWeb.
		Platform.setImplicitExit(true);
        Platform.exit();
        System.exit(0);
		}
	}
			
		
	
}

