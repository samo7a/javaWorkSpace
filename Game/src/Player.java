import java.util.Random;

// simple player class with score and name fields to help us with the data base
public class Player {
	private static Random rndm = new Random();
	private static int noOfPlayers = rndm.nextInt(99);
	private int score = 0;
	private String name;
	public Player() {
		this.name = "Player # " + Integer.toString(noOfPlayers);
	}
	public Player(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
