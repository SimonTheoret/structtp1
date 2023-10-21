import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class InputReader {

    String flag;

    public InputReader(String flag) {
        /* Constructor for the input reader */
        this.flag = flag;
    }

    public void readInput() {
        /* Creates the trie and the grid objects. */
        try {
            File file = new File(this.flag);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { // Checks if input file is empty or all read
                String data = reader.nextLine();
                String[] gridSize = data.split(" ");

                int height = Integer.parseInt(gridSize[0]);
                int width = Integer.parseInt(gridSize[1]);
                String[] gridContent = new String[height];
                for (int i = 0; i < height; i++) {
                    gridContent[i] = reader.nextLine();
                }
                Grid2D grid = new Grid2D(width, height, gridContent);
                String[] words = reader.nextLine().split(" ");
                Trie trie = new Trie(words);
                Player player = new Player(grid, trie);
                player.play();

            }
            reader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
