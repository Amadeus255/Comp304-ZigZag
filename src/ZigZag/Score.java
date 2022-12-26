package ZigZag;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Score {
    
    private float currentScore = 0;
    private int currentSessionScore;
    private int highScore;

    public Score() {
    	readHighScore();
    }
	public int getCurrentSessionScore() {
		return currentSessionScore;
	}

	public float getCurrentScore() {
		return currentScore;
	}

	public int getHighScore() {
		return highScore;
	}

	public void updateScore(float ballSpeed) {
		if(currentSessionScore==0) // the ball has not yet crashed
			currentScore += ballSpeed/20;

	}

	public void storeSessionScore() {
		currentSessionScore = (int) currentScore;
		if(currentSessionScore > highScore){
			writeHighScore(currentSessionScore);
			highScore = currentSessionScore;
		}
	}

	public void setCurrentSessionScore(int currentSessionScore) {
		this.currentSessionScore = currentSessionScore;
	}

	public void setCurrentScore(float currentScore) {
		this.currentScore = currentScore;
	}
	
	public void readHighScore(){
		try {
			FileReader reader = new FileReader("res/score/highScore.txt");
			char[] score = new char[5];
			char r;
			StringBuilder builder = new StringBuilder(); 
			
			while(Character.isDigit(r=(char) reader.read())){
				builder.append(r);
			}
			
			highScore = Integer.parseInt(builder.toString());
			
		} catch (IOException | NumberFormatException e) {
			// No high score
			highScore = 0;
			System.out.println("No high score found");
		}
	}
	
	public void writeHighScore(int score){
		try {
			FileWriter writer = new FileWriter("res/score/highScore.txt", false);
			writer.write(String.valueOf(score));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}