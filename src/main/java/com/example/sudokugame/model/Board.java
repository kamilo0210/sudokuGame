package com.example.sudokugame.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Board class represents the logic behind the Sudoku game board.
 * It contains two main boards: a complete board (solution) and an incomplete board (puzzle).
 * This class allows for random selection of pre-defined Sudoku boards and provides methods to access and modify these boards.
 */
public class Board {

    private int[][] boardSolution;
    private int[][] boardIncomplete;

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

        int[][] sudokuComplete3 = {
                {4, 5, 6, 2, 3, 1},
                {3, 1, 2, 5, 4, 6},
                {5, 6, 4, 1, 2, 3},
                {1, 2, 3, 6, 5, 4},
                {2, 3, 1, 4, 6, 5},
                {6, 4, 5, 3, 1, 2}
        };

        int[][] sudokuComplete4 = {
                {1, 2, 4, 5, 3, 6},
                {6, 5, 3, 1, 4, 2},
                {2, 4, 1, 6, 5, 3},
                {5, 3, 6, 4, 2, 1},
                {3, 1, 5, 2, 6, 4},
                {4, 6, 2, 3, 1, 5}
        };

        int[][] sudokuComplete5 = {
                {2, 5, 6, 4, 3, 1},
                {3, 1, 4, 6, 5, 2},
                {4, 6, 5, 1, 2, 3},
                {1, 2, 3, 5, 6, 4},
                {6, 3, 1, 2, 4, 5},
                {5, 4, 2, 3, 1, 6}
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

        int[][] sudokuIncomplete3 = {
                {0, 5, 0, 0, 3, 0},
                {0, 1, 0, 5, 0, 0},
                {0, 6, 0, 0, 2, 3},
                {0, 0, 3, 0, 0, 0},
                {0, 0, 1, 0, 0, 5},
                {6, 0, 0, 0, 1, 0}
        };

        int[][] sudokuIncomplete4 = {
                {1, 0, 0, 0, 0, 6},
                {0, 0, 3, 1, 0, 0},
                {0, 4, 0, 0, 0, 3},
                {0, 3, 0, 4, 0, 0},
                {0, 1, 0, 0, 6, 0},
                {4, 0, 0, 0, 1, 0}
        };

        int[][] sudokuIncomplete5 = {
                {2, 0, 0, 4, 0, 1},
                {3, 0, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0},
                {0, 0, 3, 0, 6, 4},
                {0, 0, 1, 0, 0, 0},
                {0, 4, 0, 3, 1, 0}
        };


        // Lists of complete and incomplete Sudoku boards
        ArrayList<int[][]> incompleteSudokus = new ArrayList<>();
        incompleteSudokus.add(sudokuIncomplete1);
        incompleteSudokus.add(sudokuIncomplete2);
        incompleteSudokus.add(sudokuIncomplete3);
        incompleteSudokus.add(sudokuIncomplete4);
        incompleteSudokus.add(sudokuIncomplete5);

        ArrayList<int[][]> completeSudokus = new ArrayList<>();
        completeSudokus.add(sudokuComplete1);
        completeSudokus.add(sudokuComplete2);
        completeSudokus.add(sudokuComplete3);
        completeSudokus.add(sudokuComplete4);
        completeSudokus.add(sudokuComplete5);

        // Randomly select a Sudoku puzzle
        int randomSudoku = new Random().nextInt(incompleteSudokus.size());
        boardIncomplete = incompleteSudokus.get(randomSudoku);
        boardSolution = completeSudokus.get(randomSudoku);
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
