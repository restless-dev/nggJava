package numbergg;

import javax.swing.*;

public class NumberGG {
    public static void main(String[] args) {
        int answerNumber = (int) (Math.random()*100+1);
        System.out.println("Random number selected! Waiting for user guess...");
        int guessNumber = 0;
        int countOfGuesses = 1;
        while(guessNumber != answerNumber){
            String userInput = JOptionPane.showInputDialog(null, "Please, pick a number between 1 and 100!", "NumberGG", 3);
            guessNumber = Integer.parseInt(userInput);
            JOptionPane.showMessageDialog(null, "" + guessVerifier(guessNumber, answerNumber, countOfGuesses));
            countOfGuesses++;
        }
    }

    public static String guessVerifier(int guessNumber, int answerNumber, int count){
        if(guessNumber <= 0 || guessNumber > 100){
            return "This number is invalid... Please select a number between 1 and 100!";
        } else if(guessNumber > answerNumber){
            return "This number is too big... Try again!\nTotal guesses: " + count;
        } else if(guessNumber < answerNumber){
            return "This number is too small... Try again!\nTotal guesses: " + count;
        } else if(guessNumber == answerNumber){
            return "You got it! The right number was " + answerNumber + "!\nTotal guesses: " + count + "... Not bad!";
        } else {
            return "This number is not the correct one... Try again!";
        }
    }
}
