import java.util.Scanner;

public class prompt {

    public prompt(){
    }

    public String getPrompt(){
        String[] words = {"the", "place", "trees", "apple", "computer", "classroom", "happy", "around", "with", "even"};
        StringBuilder text = new StringBuilder();
        for (int i = 0; i<20; i++) {
            text.append(words[(int) (Math.random() * words.length)]);
            if (i<19){
                text.append(" ");
            }
        }

        return text.toString();
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


    public String setCustomPrompt(Scanner scanner){
        String prompt = "";
        while (!isValidPrompt(prompt)){
            prompt = scanner.nextLine();
            }
        return prompt;

    }

    public boolean isValidPrompt(String prompt){
        if (prompt == null || prompt.isEmpty()){
            System.out.println("Prompt is blank, please enter a valid prompt.");
            return false;
        }
        if (howManyWords(prompt)<20){
            System.out.printf("Not enough words, add %d more.\n",20-howManyWords(prompt));
            return false;
        }

        return true;


    }





}
