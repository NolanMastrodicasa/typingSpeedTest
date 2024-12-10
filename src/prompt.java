import java.util.Scanner;

public class prompt {
    private String text;

    public prompt(){
        text = "The quick brown fox jumps over the lazy dog.";
    }

    public String getPrompt(){
        return text;
    }


    public String setCustomPrompt(Scanner scanner){
        return scanner.nextLine();

    }





}
