import java.util.ArrayList;
import java.util.Collections;

public class WordsList {
    private ArrayList<String> words;

    public WordsList() {
        this.words = new ArrayList<String>();
    };

    public void append(String current_word) {
        words.add(current_word);
    }

    public void print() {
        Collections.sort(words);
        for (String word : words) {
            System.out.println(word);
        }
    }

}
