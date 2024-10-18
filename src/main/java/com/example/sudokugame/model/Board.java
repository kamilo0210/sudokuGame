package com.example.sudokugame.model;


import java.util.ArrayList;
import java.util.Random;


public class Board {
    private int[][] boardSolution;
    private int[][] boardIncomplete;


    public Board() {
        boardSolution = new int[6][6];
        boardIncomplete = new int[6][6];


        // Sudokus completos
        int[][] sudokuComplete1 = {
                {1, 2, 3, 4, 5, 6},
                {4, 5, 6, 1, 2, 3},
                {2, 3, 1, 6, 4, 5},
                {5, 6, 4, 3, 1, 2},
                {3, 1, 2, 5, 6, 4},
                {6, 4, 5, 2, 3, 1}
        };


        // Puedes añadir más sudokus completos de 6x6 siguiendo este formato...


        // Sudokus incompletos (con dos números por celda)
        int[][] sudokuIncomplete1 = {
                {0, 0, 0, 0, 5, 0},
                {0, 5, 6, 0, 0, 3},
                {0, 0, 0, 0, 4, 0},
                {0, 6, 4, 0, 1, 0},
                {3, 0, 2, 0, 0, 4},
                {0, 0, 0, 0, 3, 0}
        };



        // Listas de sudokus completos e incompletos
        ArrayList<int[][]> incompleteSudokus = new ArrayList<>();
        incompleteSudokus.add(sudokuIncomplete1);

        // Añadir más sudokus incompletos si se crean...


        ArrayList<int[][]> completeSudokus = new ArrayList<>();
        completeSudokus.add(sudokuComplete1);


        // Selección aleatoria de un sudoku
        int randomSudoku = new Random().nextInt(incompleteSudokus.size());
        boardIncomplete = incompleteSudokus.get(randomSudoku);  // Selecciona un sudoku incompleto aleatorio
        boardSolution = completeSudokus.get(randomSudoku);
    }


}
