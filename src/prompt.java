/**
 * gives functionality to create prompts, validate custom made prompts, and calculate how many words are in specific prompts.
 */
import java.util.Scanner;
public class prompt {

    /**
     * create a default constructor
     */
    public prompt() {
    }

    /**
     * generates a random prompt consisting of 20 words.
     * @return a String containing 20 randomly picked words separated by spaces.
     */
    public String getPrompt() {
        String[] words = {
                "the", "be", "of", "and", "a", "to", "in", "he", "have", "it", "that", "for", "they", "I",
                "with", "as", "not", "on", "she", "at", "by", "this", "we", "you", "do", "but", "from",
                "or", "which", "one", "would", "all", "will", "there", "say", "who", "make", "when",
                "can", "more", "if", "no", "man", "out", "other", "so", "what", "time", "up", "go",
                "about", "than", "into", "could", "state", "only", "new", "year", "some", "take",
                "come", "these", "know", "see", "use", "get", "like", "then", "first", "any", "work",
                "now", "may", "such", "give", "over", "think", "most", "even", "find", "day", "also",
                "after", "way", "many", "must", "look", "before", "great", "back", "through", "long",
                "where", "much", "should", "well", "people", "down", "own", "just", "because", "good",
                "each", "those", "feel", "seem", "how", "high", "too", "place", "little", "world",
                "very", "still", "nation", "hand", "old", "life", "tell", "write", "become", "here",
                "show", "house", "both", "between", "need", "mean", "call", "develop", "under", "last",
                "right", "move", "thing", "general", "school", "never", "same", "another", "begin",
                "while", "number", "part", "turn", "real", "leave", "might", "want", "point", "form",
                "off", "child", "few", "small", "since", "against", "ask", "late", "home", "interest",
                "large", "person", "end", "open", "public", "follow", "during", "present", "without",
                "again", "hold", "govern", "around", "possible", "head", "consider", "word", "program",
                "problem", "however", "lead", "system", "set", "order", "eye", "plan", "run", "keep",
                "face", "fact", "group", "play", "stand", "increase", "early", "course", "change",
                "help", "line", "adventure", "balance", "butterfly", "challenge", "clarity", "courage",
                "create", "design", "dynamic", "effort", "empower", "explore", "fantasy", "freedom",
                "garden", "growth", "hero", "horizon", "imagine", "innovation", "journey", "keyboard",
                "legend", "moment", "nature", "oasis", "ocean", "puzzle", "radiant", "rocket",
                "provoke", "spark", "strength", "success", "thrive", "vibrant", "vintage", "vision",
                "wander", "wisdom", "writing"
        };
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            //adds a random word to the String text from the words array.
            text.append(words[(int) (Math.random() * words.length)]);
            if (i < 19) {
                //adds a space after each word to make the prompt valid.
                text.append(" ");
            }
        }
        return text.toString();
    }

    /**
     * counts the numer of whole words in a specific text
     * @param inputPrompt the String to be analysed
     * @return an Int the number of words within the String
     */
    public static int howManyWords(String inputPrompt) {
        int words = 0;
        Scanner s = new Scanner(inputPrompt);
        while (s.hasNext()) {
            words++;
            s.next();
        }
        return words;
    }

    /**
     * sets a custom prompt given by the user
     * @param scanner the Scanner object to read user input
     * @return a valid prompt as a String
     */
    public String setCustomPrompt(Scanner scanner) {
        String prompt = "";
        while (!isValidPrompt(prompt)) {
            prompt = scanner.nextLine();
        }
        return prompt;
    }

    /**
     * validates a custom prompt to make sure it fits proper criteria
     * @param prompt the input String to be validated
     * @return boolean, whether the prompt is valid or not.
     */
    public boolean isValidPrompt(String prompt) {
        if (prompt == null || prompt.isEmpty()) {
            System.out.println("Prompt is blank, please enter a valid prompt.");
            return false;
        }
        if (howManyWords(prompt) < 20) {
            System.out.printf("Not enough words, add %d more.\n", 20 - howManyWords(prompt));
            return false;
        }
        return true;
    }
}
