package TriviaGame;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TriviaGame {
    public static String [] Questions = new String[10];
    public static String [] Answers = new String[10];
    public static void main(String[] args) {
        // Questions for user stored in an array
        Questions[0] = "How many countries are in Africa?\nA.1\nB.15\nC.54\nD.122";

        Questions[1] = "What large land animal kills the most people in Africa?\nA.Lion\nB.Buffalo\nC.Hippopotamus\nD.Elephant";

        Questions[2] = "Which is the largest country in Africa?\nA.Nigeria\nB.DRC\nC.Algeria\nD.Sudan";

        Questions[3] = "Evidence of the earliest modern humans were found in which African country?\nA.Egypt\nB.Ethiopia\nC.Libya\nD.Nigeria";

        Questions[4] = "What is the hottest planet in the solar system?\nA.Mercury\nB.Earth\nC.Venus\nD.Saturn";

        Questions[5] = "What is the name of the largest ocean on earth?\nA.Indian Ocean\nB.Antarctica Ocean\nC.Pacific Ocean\nD.The Nile";

        Questions[6] = "What is the largest animal in the world?\nA.Shark\nB.Elephant\nC.Blue Whale\nD.Rhino";

        Questions[7] = "How many continents are there in the world?\nA.6\nB.8\nC.7\nD.5";

        Questions[8] = "Where do penguins live?\nA.Indian Ocean\nB.Pacific Ocean\nC.Antarctica\nD.Red Sea";

        Questions[9] = "Which country is also a continent?\nA.Africa\nB.America\nC.Australia\nD.New Zealand";

        //Answers to the trivia questions
        Answers[0] = "C";
        Answers[1] = "C";
        Answers[2] = "C";
        Answers[3] = "B";
        Answers[4] = "C";
        Answers[5] = "C";
        Answers[6] = "C";
        Answers[7] = "C";
        Answers[8] = "C";
        Answers[9] = "C";

        //Function that has instruction for user
        welcomeMessage();
    }

    public static int i = 0;
    public static int j = 0;
    public static int count = Questions.length - 1;
    public static int score = 0;

    //Function that displays questions and prompts user for an answer
    public static void takeTest(String[] Questions) {
        Scanner userInput = new Scanner(System.in);

        // Statements are executed until count is less than 0
        do{
            System.out.println("Question" + i + "." + " \n" +Questions[i]);

            // Checks how long the user has taken to answer a question
            long startTime = System.nanoTime();
            String userAnswer = userInput.nextLine().toUpperCase();

            long stopTime = System.nanoTime();
            long elapsedTime = (stopTime - startTime)/1_000_000_000;

            System.out.println("You took: "+elapsedTime+"Seconds");

            if(userAnswer.equals(Answers[j])) {
                j++;
                score++;

                System.out.print("Your answer is:");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Correct!");
                next_question();
            }
            else  {
                System.out.print("Your answer is:");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("incorrect!"+"\nThe correct answer is: "+" "+Answers[j]);
                next_question();
            }


        } while (count >=0);
    }

    //function that asks user if they want to continue with the game
    public static void next_question() {

        System.out.println("Would you like to continue: ");
        Scanner answer = new Scanner(System.in);
        //Holds users answer in lowercase
        String ans = answer.nextLine().toLowerCase();

        //Condition that checks user's answer and executes depending on users answers
        if (ans.equals("yes")) {
            i++;
            count--;
        }

        else if (ans.equals("no")) {
            System.out.println("I hope you enjoyed the game.Thank you for playing, see you!\n" + " Your score is: " + score);
            System.exit(1);
        }

        else {
            System.out.println("Invalid response\nEnter yes or no: ");
            String sAns = answer.nextLine().toLowerCase();
            if (sAns.equals("yes")) {
                ++i;
                --count;
            }

            else if (sAns.equals("no")) {
                System.out.println("Goodbye!");
                System.exit(1);
            }

            else {
                System.out.println("Ooops sorry the program had to end");
                System.exit(1);
            }

        }
        if (score == 10) {
            System.out.println("Congratulations you answered all the questions correctly");
            System.exit(1);
        }
    }

    public static void welcomeMessage() {
        // As you run the code, you see a welcome message and give you instructions of the game.
        Scanner userChoice = new Scanner(System.in);
        System.out.println("Hello Welcome to our Trivia game!!! Whoop Whoop!!");

        // Instructions to the game
        System.out.printf("1.In this game you will only play it once\n2.You can end the game when you want to.\n3.At the end of the game your score will be displayed.\n4.Enjoy the game%n");

        // Asks user if they want to play
        System.out.println("Would you like to proceed ?");
        String choice = userChoice.nextLine().toLowerCase();

        // Conditions that check if user's answer is yes or no and executes
        if (choice.equals("yes")) {
            takeTest(Questions);
        }

        else if (choice.equals("no")) {
            System.exit(1);
        }

        else {
            System.out.println("Incorrect input! enter again(yes or no): ");
            String sChoice = userChoice.nextLine().toLowerCase();
            if(sChoice.equals("yes")) {
                takeTest(Questions);
            }

            else {
                System.exit(1);
            }
        }
    }
}

