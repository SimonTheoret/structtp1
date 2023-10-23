public class Player implements WordFinder {
    int[] pos = { 0, 0 };
    Grid grid;
    Words words;
    WordsList wordList;
    String current_word;

    Player(Grid g, Words w) {
        this.grid = g;
        this.words = w;
        current_word = "";
        wordList = new WordsList();
    }

    public void play() {
        for (int[] letters : this.grid) {
            int x = letters[0];
            int y = letters[1];
            int nx = grid.getHeight() -y-1;
            int ny = x;
            playnext(x, y, "", "(" + nx + "," + ny + ")");
        }
    }

    private void playnext(int x, int y, String current_word, String positions) {
        String letter = grid.getValue(x, y);
        String new_word = current_word + letter;
        if (this.words.verifyIfPartialWordExists(new_word)) {
            if (this.words.verifyIfWordExists(new_word)) {
                String total_word = ( new_word + " " + positions );
                wordList.append(total_word);
            }
            String[][] neighbors = grid.getNeighbors(x, y);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (neighbors[i][j] != null) {
                        int nx = grid.getHeight() -y -1 - j + 1 ;
                        int ny = x + i -1 ;
                        playnext(x + i - 1, y + j - 1, new_word, positions + "->(" + nx + "," + ny + ")");
                    }
                }
            }
        }
    }
    public void print(){
        wordList.print();
    }
}
