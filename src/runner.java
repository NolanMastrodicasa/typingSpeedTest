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
            String toBeTyped;

            if (choice == 1) {
                toBeTyped = prompt.getPrompt();
                startTest(toBeTyped);
                System.out.println("Starting the test with default prompt!");
                System.out.println(toBeTyped);
            }else if (choice == 2){
                toBeTyped = prompt.setCustomPrompt(input);
                startTest(toBeTyped);
                System.out.println("Starting the test with custom prompt!");
                System.out.println(toBeTyped);
            }else{
                System.out.println("Exiting.");
                break;
            }


        }








    }
}

