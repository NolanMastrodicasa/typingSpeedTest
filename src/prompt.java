import java.util.Scanner;

public class prompt {

    public prompt(){
    }

    public String getPrompt(){
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
                "serene", "spark", "strength", "success", "thrive", "vibrant", "vintage", "vision",
                "wander", "wisdom", "writing"
        };
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
        if (howManyWords(prompt)<20) {
            System.out.printf("Not enough words, add %d more.\n", 20 - howManyWords(prompt));
            return false;
        }

        return true;


    }





}
