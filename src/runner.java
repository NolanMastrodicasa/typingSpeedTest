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
            System.out.println("3. Exit");
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
                toBeTyped = prompt.setCustomPrompt(input);
                System.out.println("Starting the test with custom prompt!");
                try {
                    startTest(toBeTyped, input);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }else{
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
        System.out.println("your time in seconds is: " + timeTakenSec);
        int numWords = howManyWords(typedText);
        System.out.println("Number of words in the typed text is: "+numWords);


    }

    public static int howManyWords(String inputPrompt){
        int words = 0;
        String recycledWord;
        Scanner s = new Scanner(inputPrompt);
        while (s.hasNext()){
            words++;
            recycledWord = s.next();
        }
        return words;
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }







}

