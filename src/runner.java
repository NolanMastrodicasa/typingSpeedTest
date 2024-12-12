import java.util.Scanner;
public class runner{
    public static void main(String[] args){


        //checks if user wants to use custom writing prompt.
        //TODO ask turner if Scanner counts as used object? Also does main class count as a student made class?

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
        System.out.println("Time (Seconds): " + timeTakenSec);
        int numWords = howManyWords(typedText);
        System.out.println("Number of words: "+numWords);

        double wpm = numWords / timeTakenSec * 60;

        System.out.println("Bronze = 40 WPM" );
        System.out.println("Silver = 60 WPM" );
        System.out.println("Gold = 75 WPM" );
        System.out.println("Elite = 90 WPM" );
        System.out.println("Champion = 110 WPM" );
        System.out.println("Unreal = 140 WPM" );

        System.out.println("WPM = " + wpm);


        if (wpm >= 40 && wpm < 60) {
            System.out.println("Your rank is Bronze");
        } else if (wpm >= 60 && wpm < 75) {
            System.out.println("Your rank is Silver");
        } else if (wpm >= 75 && wpm < 90) {
            System.out.println("Your rank is Gold");
        } else if (wpm >= 90 && wpm < 110) {
            System.out.println("Your rank is Elite");
        } else if (wpm >= 110 && wpm < 140) {
            System.out.println("Your rank is Champion");
        } else if (wpm >= 140) {
            System.out.println("Your rank is Unreal");
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

