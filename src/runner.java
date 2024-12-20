/**
 * a typing test that calculates words per min, accuracy, and provides a rank.
 * users can either create a custom prompt or randomly generate one, both are used to calculate score.
 */
// imports scanner
import java.util.Scanner;

/**
 * main class for running program
 */
public class runner {

    /**
     * ANSI color codes to format the rank color.
     */
    static final String RESET = "\u001B[0m";
    static final String BRONZE = "\u001B[33m";
    static final String SILVER = "\u001B[37m";
    static final String GOLD = "\u001B[33m";
    static final String ELITE = "\u001B[30m";
    static final String CHAMPION = "\u001B[31m";
    static final String UNREAL = "\u001B[97m";

    /**
     * the main method for the program, shows the user a menu with options to start a test,
     * use a custom prompt, check the rank requirements, or exit.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        prompt prompt = new prompt();
        boolean running = true;

        while (running) {
            System.out.println("Typing Test");
            System.out.println("1. Start Test (random prompt)");
            System.out.println("2. Use Custom Prompt");
            System.out.println("3. Rank Requirements");
            System.out.println("4. Exit");
            int choice = input.nextInt();
            input.nextLine();
            String toBeTyped;

            if (choice == 1) {
                toBeTyped = prompt.getPrompt();
                System.out.println("Starting the test with default prompt!");
                try {
                    startTest(toBeTyped, input);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            } else if (choice == 2) {
                System.out.println("Type custom prompt here:");
                toBeTyped = prompt.setCustomPrompt(input);
                System.out.println("Starting the test with custom prompt!");
                try {
                    startTest(toBeTyped, input);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            } else if (choice == 3) {
                System.out.println("Unranked < 40 WPM");
                System.out.println("Bronze = 40 WPM");
                System.out.println("Silver = 60 WPM");
                System.out.println("Gold = 75 WPM");
                System.out.println("Elite = 90 WPM");
                System.out.println("Champion = 110 WPM");
                System.out.println("Unreal = 140+ WPM");
                break;

            } else {
                System.out.println("Exiting.");
                break;
            }
        }
    }

    /**
     * startTest displays prompt and reads user input calculating stats.
     * @param text  the prompt that the user will type
     * @param input the previously used scanner object to capture input
     * @throws InterruptedException if the program is interrupted during the countdown.
     */
    public static void startTest(String text, Scanner input) throws InterruptedException {
        System.out.println("Get ready!");
        for (int count = 3; count > 0; count--) {
            System.out.printf("Starting in %d!\n", count);
            Thread.sleep(1000);
        }
        clearConsole();
        System.out.println(text);
        long startTime = System.currentTimeMillis();
        String typedText = input.nextLine();
        long endTime = System.currentTimeMillis();
        long timeTakenMillis = endTime - startTime;
        double timeTakenSec = timeTakenMillis / 1000.0;
        int numWords = prompt.howManyWords(typedText);
        double wpm = numWords / timeTakenSec * 60;
        wpm = Math.round(wpm);
        int accuracy = calculateAccuracy(text.replace(" ", ""), typedText.replace(" ", ""));
        System.out.println("===================================");
        System.out.println("          Typing Test Results");
        System.out.println("===================================");
        if (accuracy < 85) {
            System.out.println("FAIL! Your accuracy was " + accuracy + "%, get it to 85% for a rank!");
        } else {
            System.out.print("WPM: ");
            System.out.printf("%.1f\n", wpm);
            System.out.println("Accuracy: " + accuracy + "%");
            System.out.println("Time (Seconds): " + timeTakenSec);
            rank(wpm);
        }
    }

    /**
     * calculates the typing accuracy as a percentage.
     *
     * @param toBeTyped the original text that should be typed
     * @param typedText the text that was actually typed by the user
     * @return int the accuracy calculated.
     */
    public static int calculateAccuracy(String toBeTyped, String typedText) {
        float lettersTypedProperly = 0;
        int lengthToCheck = Math.min(toBeTyped.length(), typedText.length());
        for (int i = 0; i < lengthToCheck; i++) {
            if (toBeTyped.charAt(i) == typedText.charAt(i)) {
                lettersTypedProperly++;
            }
        }
        return Math.round((lettersTypedProperly / toBeTyped.length()) * 100);
    }

    /**
     * calculates the users rank based off the requirements, and the calculated words per min
     * @param wpm the users wpm score calculated based off the recent test
     */
    public static void rank(double wpm) {
        if (wpm >= 40 && wpm < 60) {
            System.out.println("Your rank is " + BRONZE + "Bronze" + RESET);
            System.out.println("Next rank: Silver, you need " + (60 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 60 && wpm < 75) {
            System.out.println("Your rank is " + SILVER + "Silver" + RESET);
            System.out.println("Next rank: Gold, you need " + (75 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 75 && wpm < 90) {
            System.out.println("Your rank is " + GOLD + "Gold" + RESET);
            System.out.println("Next rank: Elite, you need " + (90 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 90 && wpm < 110) {
            System.out.println("Your rank is " + ELITE + "Elite" + RESET);
            System.out.println("Next rank: Champion, you need " + (110 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 110 && wpm < 140) {
            System.out.println("Your rank is " + CHAMPION + "Champion" + RESET);
            System.out.println("Next rank: Unreal, you need " + (140 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 140) {
            System.out.println("Your rank is " + UNREAL + "Unreal" + RESET);
            System.out.println("You have achieved the highest rank!");
        } else {
            System.out.println("You are Unranked.");
            System.out.println("Next rank: Bronze, you " + (40 - wpm) + "more to reach it.");
        }
    }

    /**
     * "clears" the console by printing 50 blank lines.
     */
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
