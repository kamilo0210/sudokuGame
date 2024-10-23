package com.example.sudokugame.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Board class represents the logic behind the Sudoku game board.
 * It contains two main boards: a complete board (solution) and an incomplete board (puzzle).
 * This class allows for random selection of pre-defined Sudoku boards and provides methods to access and modify these boards.
 */
public class Board {

    private int[][] boardSolution;    // The complete solution of the Sudoku board
    private int[][] boardIncomplete;  // The incomplete version of the Sudoku board (puzzle)

    /**
     * Constructs a new Board object.
     * Initializes both the complete and incomplete Sudoku boards with predefined values.
     * A random selection of one of the predefined Sudoku puzzles is chosen on initialization.
     */
    public Board() {
        boardSolution = new int[6][6];
        boardIncomplete = new int[6][6];

        // Predefined complete Sudoku boards
        int[][] sudokuComplete1 = {
                {1, 2, 3, 4, 5, 6},
                {4, 5, 6, 1, 2, 3},
                {2, 3, 1, 6, 4, 5},
                {5, 6, 4, 3, 1, 2},
                {3, 1, 2, 5, 6, 4},
                {6, 4, 5, 2, 3, 1}
        };

        int[][] sudokuComplete2 = {
                {1, 4, 5, 6, 2, 3},
                {3, 6, 2, 5, 4, 1},
                {2, 3, 6, 1, 5, 4},
                {5, 1, 4, 3, 6, 2},
                {6, 2, 1, 4, 3, 5},
                {4, 5, 3, 2, 1, 6}
        };

        // Predefined incomplete Sudoku boards
        int[][] sudokuIncomplete1 = {
                {0, 0, 0, 0, 5, 0},
                {0, 5, 6, 0, 0, 3},
                {0, 0, 0, 0, 4, 0},
                {0, 6, 4, 0, 1, 0},
                {3, 0, 2, 0, 0, 4},
                {0, 0, 0, 0, 3, 0}
        };

        int[][] sudokuIncomplete2 = {
                {0, 0, 5, 0, 2, 0},
                {3, 0, 0, 0, 0, 1},
                {0, 3, 0, 1, 0, 0},
                {5, 0, 0, 0, 6, 0},
                {6, 0, 0, 0, 3, 0},
                {4, 0, 0, 0, 0, 6}
        };

        // Lists of complete and incomplete Sudoku boards
        ArrayList<int[][]> incompleteSudokus = new ArrayList<>();
        incompleteSudokus.add(sudokuIncomplete1);
        incompleteSudokus.add(sudokuIncomplete2);

        ArrayList<int[][]> completeSudokus = new ArrayList<>();
        completeSudokus.add(sudokuComplete1);
        completeSudokus.add(sudokuComplete2);

        // Randomly select a Sudoku puzzle
        int randomSudoku = new Random().nextInt(incompleteSudokus.size());
        boardIncomplete = incompleteSudokus.get(randomSudoku);  // Select a random incomplete Sudoku
        boardSolution = completeSudokus.get(randomSudoku);      // Select the corresponding complete solution
    }

    /**
     * Returns the complete Sudoku solution.
     *
     * @return The complete Sudoku board as a 2D array.
     */
    public int[][] getBoardSolution() {
        return boardSolution;
    }

    /**
     * Returns the incomplete Sudoku puzzle.
     *
     * @return The incomplete Sudoku board as a 2D array.
     */
    public int[][] getBoardIncomplete() {
        return boardIncomplete;
    }

    /**
     * Sets the incomplete Sudoku board (puzzle).
     *
     * @param boardIncomplete A 2D array representing the new incomplete Sudoku board.
     */
    public void setBoardIncomplete(int[][] boardIncomplete) {
        this.boardIncomplete = boardIncomplete;
    }

    /**
     * Sets the complete Sudoku solution board.
     *
     * @param boardSolution A 2D array representing the new complete Sudoku solution board.
     */
    public void setBoardSolution(int[][] boardSolution) {
        this.boardSolution = boardSolution;
    }
}
