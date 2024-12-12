import java.util.Scanner;
public class runner{

    static final String RESET = "\u001B[0m"; // Reset to default
    static final String BRONZE = "\u001B[33m"; // Yellow (close to bronze)
    static final String SILVER = "\u001B[37m"; // White (as silver representation)
    static final String GOLD = "\u001B[33m"; // Bright yellow for gold
    static final String ELITE = "\u001B[30m"; // Black
    static final String CHAMPION = "\u001B[31m"; // Red
    static final String UNREAL = "\u001B[97m"; // Bright white

    public static void main(String[] args){



        //TODO create a method that calculates how many characters were typed wrong. Then calculates accruacy %.
        //IF accuracy is not at least 90%, fail test.

        Scanner input = new Scanner(System.in);
        prompt prompt = new prompt();
        boolean running = true;

        while (running){
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
            }else if (choice == 2){
                System.out.println("Type custom prompt here:");
                toBeTyped = prompt.setCustomPrompt(input);
                System.out.println("Starting the test with custom prompt!");
                try {
                    startTest(toBeTyped, input);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }else if (choice == 3){
                System.out.println("Unranked < 40 WPM");
                System.out.println("Bronze = 40 WPM" );
                System.out.println("Silver = 60 WPM" );
                System.out.println("Gold = 75 WPM" );
                System.out.println("Elite = 90 WPM" );
                System.out.println("Champion = 110 WPM" );
                System.out.println("Unreal = 140+ WPM" );
                break;

            } else {
                System.out.println("Exiting.");
                break;
            }



        }

    }


    public static void startTest(String text, Scanner input) throws InterruptedException {
        System.out.println("Get ready!");
        for (int count = 3; count>0; count--){
            System.out.printf("Starting in %d!\n",count);
            Thread.sleep(1000);
        }
        clearConsole();
        System.out.println(text);
        long startTime = System.currentTimeMillis();
        String typedText = input.nextLine();
        long endTime = System.currentTimeMillis();
        long timeTakenMillis = endTime - startTime;
        double timeTakenSec = timeTakenMillis / 1000.0;
        int numWords = howManyWords(typedText);
        double wpm = numWords / timeTakenSec * 60;
        wpm = Math.round(wpm);
        rank(wpm);
        int typedCorrectly = calculateAccuracy(text, typedText);
        System.out.println("===================================");
        System.out.println("          Typing Test Results");
        System.out.println("===================================");
        System.out.print("WPM: ");
        System.out.printf("%.1f\n", wpm);
        System.out.println("Accuracy: " + typedCorrectly + "%");
        System.out.println("Time (Seconds): " + timeTakenSec);

        int random = (int) (Math.random() * 5);

        if (random == 0) {
            System.out.println("Too slow!");
        } else if (random == 1) {
            System.out.println("Make sure to warm up your fingers!");
        } else if (random == 2) {
            System.out.println("My Grandma types faster!");
        } else if (random == 3) {
            System.out.println("Get better!");
        } else if (random == 4) {
            System.out.println("Your geeked!");
        } else if (random == 5) {
            System.out.println("Maybe its time to put down the geekbar");
        }





    }
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






    public static void rank(double wpm) {
        if (wpm >= 40 && wpm < 60) {
            System.out.println("Your rank is "+BRONZE+"Bronze"+RESET);
            System.out.println("Next rank: Silver, you need " + (60 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 60 && wpm < 75) {
            System.out.println("Your rank is "+SILVER+"Silver"+RESET);
            System.out.println("Next rank: Gold, you need " + (75 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 75 && wpm < 90) {
            System.out.println("Your rank is "+GOLD+"Gold"+RESET);
            System.out.println("Next rank: Elite, you need " + (90 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 90 && wpm < 110) {
            System.out.println("Your rank is "+ELITE+"Elite"+RESET);
            System.out.println("Next rank: Champion, you need " + (110 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 110 && wpm < 140) {
            System.out.println("Your rank is "+CHAMPION+"Champion"+RESET);
            System.out.println("Next rank: Unreal, you need " + (140 - wpm) + " WPM more to reach it.");
        } else if (wpm >= 140) {
            System.out.println("Your rank is "+UNREAL+"Unreal"+RESET);
            System.out.println("You have achieved the highest rank!");
        } else {
            System.out.println("You are Unranked.");
            System.out.println("Next rank: Bronze, you " + (40 - wpm) +"more to reach it.");

        }
    }



    public static int howManyWords(String inputPrompt){
        int words = 0;
        Scanner s = new Scanner(inputPrompt);
        while (s.hasNext()){
            words++;
            s.next();
        }
        return words;
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }









}

