public class Player implements WordFinder {
    int[] pos = { 0, 0 };
    Grid grid;
    Words words;
    String current_word;

    Player(Grid g, Words w) {
        this.grid = g;
        this.words = w;
        current_word = "";
    }

    public void play() {
        for (int[] letters : this.grid) {
            int x = letters[0];
            int y = letters[1];
            test(x, y, "");
        }
    }

    private void test(int x, int y, String current_word) {
        String letter = grid.getValue(x, y);
        if (this.words.verifyIfPartialWordExists(current_word + letter)) {
            if (this.words.verifyIfWordExists(current_word + letter)){
                System.out.println(current_word + letter);
            }
            String new_word = current_word + letter;
            String[][] neighbors = grid.getNeighbors(x, y);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (neighbors[i][j] != null) {
                        test(x + i - 1, y + j - 1, new_word);
                        // System.out.println(new_word);
                    }
                }
            }
        }
    }
}
