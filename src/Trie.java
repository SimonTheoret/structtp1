import java.util.HashMap;
import java.util.Map;

public class Trie implements Words
{
    /**
     * TODO: description
     *
     * @author Simon Théorêt
     */
    private static class TrieNode
    {
        private Map<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            this.isWord = false;
        }

        @Override
        public String toString() {
            return "Node <" + this.children.size() + " children, is a word? " + this.isWord + ">";
        }
    }

    private final TrieNode root = new TrieNode(); // Root of the Trie

    public void insert(String word) {
        // Insert a word in the Trie
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            // If there is no node with char c in the children, create it
            if (node.children.get(c) == null) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public Trie(String[] words) {
        for (String word : words)
            this.insert(word);
    }

    public boolean verifyIfPartialWordExists(String w){
        TrieNode node = root;
        for (char c : w.toCharArray()){
            if (node.children.get(c) == null) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
    public boolean verifyIfWordExists(String w){
        TrieNode node = root;
        for (char c : w.toCharArray()){
            if (node.children.get(c) == null) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isWord;
    }
}
