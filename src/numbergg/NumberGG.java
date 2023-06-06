package numbergg;

import javax.swing.*;

public class NumberGG {
    public static void main(String[] args) {
        try {
            int difficulty = Integer.parseInt(JOptionPane.showInputDialog(null, "Please, select the difficulty of the game:\nType 1 for Easy (1 - 10)\nType 2 for Normal (1 - 100) [RECOMMENDED]\nType 3 for Hard (1 - 1000)", "NumberGG: Difficulty", 3));
            String warning = "";
            int answer = 0;
            String userInput = "";
            int max = 0;
            switch (difficulty) {
                case 1 -> {
                    Difficulty easyDiff = easyDifficulty(warning, answer, max);
                    warning = easyDiff.warningD;
                    answer = easyDiff.answerD;
                    max = easyDiff.maxD;
                }
                case 2 -> {
                    Difficulty normalDiff = normalDifficulty(warning, answer, max);
                    warning = normalDiff.warningD;
                    answer = normalDiff.answerD;
                    max = normalDiff.maxD;
                }
                case 3 -> {
                    Difficulty hardDiff = hardDifficulty(warning, answer, max);
                    warning = hardDiff.warningD;
                    answer = hardDiff.answerD;
                    max = hardDiff.maxD;
                }
                default -> {
                    Difficulty defaultDiff = normalDifficulty(warning, answer, max);
                    warning = "Invalid number! The recommended difficulty has been selected!";
                    answer = defaultDiff.answerD;
                    max = defaultDiff.maxD;
                }
            }
            JOptionPane.showMessageDialog(null, warning, "Starting Game!",1);
            System.out.println("Random number selected! Waiting for user guess...");
            int guessNumber = 0;
            int countOfGuesses = 1;
            while(guessNumber != answer){
                userInput = JOptionPane.showInputDialog(null, "Please, pick a number between 1 and " + max + "!", "NumberGG", 3);
                guessNumber = Integer.parseInt(userInput);
                JOptionPane.showMessageDialog(null, "" + guessVerifier(guessNumber, answer, countOfGuesses, max));
                countOfGuesses++;
            }
        } catch (Exception e){
            System.out.println("Thank you for playing!");
        }
    }

    public static String guessVerifier(int guessNumber, int answerNumber, int count, int max){
        if(guessNumber <= 0 || guessNumber > max){
            return "This number is invalid... Please select a number between 1 and " + max + "!";
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

    static class Difficulty {
        int answerD;
        int maxD;
        String warningD;

        Difficulty(String warningP, int answerP, int maxP) {
            warningD = warningP;
            answerD = answerP;
            maxD = maxP;
        }
    }
        static Difficulty easyDifficulty(String w, int a, int m) {
            return new Difficulty("You picked the Easy difficulty! Good luck!", (int)(Math.random() * 10 + 1),10);
        }
        static Difficulty normalDifficulty(String w, int a, int m) {
            return new Difficulty("You picked the Normal difficulty! Good luck!", (int)(Math.random() * 100 + 1), 100);
        }
        static Difficulty hardDifficulty(String w, int a, int m) {
            return new Difficulty("You picked the Hard difficulty! Good luck!", (int) (Math.random() * 1000 + 1), 1000);
        }

}

