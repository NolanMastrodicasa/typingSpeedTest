import java.util.Scanner;

public class prompt {
    private String text;

    public prompt(){
        //TODO add more of these, randomly choose a random prompt each time getPrompt is called.
        text = "The quick brown fox jumps over the lazy dog.";
    }

    public String getPrompt(){
        return text;
    }


    public String setCustomPrompt(Scanner scanner){
        return scanner.nextLine();

    }





}
