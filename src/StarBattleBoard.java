import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StarBattleBoard {
    private int size;                // N x N grid
    private int starsPerRow;         // K stars per row/column/region
    private char[][] regions;        // Region labels
    private char[][] board;          // Board content (* or .)

    // Constructor
    public StarBattleBoard(int size, int starsPerRow) {
        this.size = size;
        this.starsPerRow = starsPerRow;
        this.regions = new char[size][size];
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], '.'); // initialize empty
        }
    }

    // read file
    public static StarBattleBoard fromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("puzzle.txt"));

        String[] firstLine = br.readLine().trim().split("\\s+");
        int size = Integer.parseInt(firstLine[0]);
        int starsPerRow = Integer.parseInt(firstLine[1]);

        StarBattleBoard sb = new StarBattleBoard(size, starsPerRow);

        for (int i = 0; i < size; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < size; j++) {
                sb.regions[i][j] = line.charAt(j);
            }
        }

        br.close();
        return sb;
    }

    // Print the board
    public void printBoard() {
        System.out.println("Star Battle Board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Print the regions
    public void printRegions() {
        System.out.println("Regions:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(regions[i][j] + " ");
            }
            System.out.println();
        }
    }

    // main method
    public static void main(String[] args) {
        try {
            StarBattleBoard test = StarBattleBoard.fromFile("puzzle.txt");
            test.printRegions();
            test.printBoard();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
