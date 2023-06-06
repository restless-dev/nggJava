package numbergg;

import javax.swing.*;

public class NumberGG {
    public static void main(String[] args) {
        String difficultyIni = JOptionPane.showInputDialog(null, "Please, select the difficulty of the game:\nType 1 for Easy (1 - 10)\nType 2 for Normal (1 - 100) [RECOMENDED]\nType 3 for Hard (1 - 1000)", "NumberGG: Difficulty", 3);
        int difficulty = Integer.parseInt(difficultyIni);
        String warning = "";
        int answer = 0;
        String userInput = "";
        int max = 0;
        switch (difficulty) {
            case 1 -> {
                Difficulty easyDiff = easyDifficulty(warning, answer, userInput, max);
                warning = easyDiff.warningD;
                answer = easyDiff.answerD;
                System.out.println(answer);
                userInput = easyDiff.userInputD;
                max = easyDiff.maxD;
            }
            case 2 -> {
                Difficulty normalDiff = normalDifficulty(warning, answer, userInput, max);
                warning = normalDiff.warningD;
                answer = normalDiff.answerD;
                userInput = normalDiff.userInputD;
                max = normalDiff.maxD;
            }
            case 3 -> {
                Difficulty hardDiff = hardDifficulty(warning, answer, userInput, max);
                warning = hardDiff.warningD;
                answer = hardDiff.answerD;
                userInput = hardDiff.userInputD;
                max = hardDiff.maxD;
            }
            default -> {
                Difficulty defaultDiff = normalDifficulty(warning, answer, userInput, max);
                warning = "Invalid number! The recommended difficulty has been selected!";
                answer = defaultDiff.answerD;
                userInput = defaultDiff.userInputD;
                max = defaultDiff.maxD;
            }
        }
        System.out.println(warning);
        System.out.println("Random number selected! Waiting for user guess...");
        int guessNumber = 0;
        int countOfGuesses = 1;
        while(guessNumber != answer){
            guessNumber = Integer.parseInt(userInput);
            JOptionPane.showMessageDialog(null, "" + guessVerifier(guessNumber, answer, countOfGuesses, max));
            countOfGuesses++;
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
        String difficulty = JOptionPane.showInputDialog(null, "Please, select the difficulty of the game:\nType 1 for Easy (1 - 10)\nType 2 for Normal (1 - 100) [RECOMENDED]\nType 3 for Hard (1 - 1000)", "NumberGG: Difficulty", 3);
        int answerD;
        String userInputD;
        int maxD;
        String warningD;

        Difficulty(String warningP, int answerP, String userInputP, int maxP) {
            warningD = warningP;
            answerD = answerP;
            userInputD = userInputP;
            maxD = maxP;
        }
    }
        static Difficulty easyDifficulty(String w, int a, String u, int m) {
            a = (int)(Math.random() * 10 + 1);
            u = JOptionPane.showInputDialog(null, "Please, pick a number between 1 and 10!", "NumberGG - Easy", 3);
            return new Difficulty("You picked the Easy difficulty! Good luck!", a, u,10);
        }
        static Difficulty normalDifficulty(String w, int a, String u, int m) {
            a = (int)(Math.random() * 100 + 1);
            u = JOptionPane.showInputDialog(null, "Please, pick a number between 1 and 100!", "NumberGG - Normal", 3);
            return new Difficulty("You picked the Normal difficulty! Good luck!", a, u, 100);
        }
        static Difficulty hardDifficulty(String w, int a, String u, int m) {
            a = (int) (Math.random() * 1000 + 1);
            u = JOptionPane.showInputDialog(null, "Please, pick a number between 1 and 1000!", "NumberGG - Hard", 3);;
            return new Difficulty("You picked the Hard difficulty! Good luck!", a, u, 1000);
        }

}

