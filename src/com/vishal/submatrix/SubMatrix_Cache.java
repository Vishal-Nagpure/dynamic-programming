package com.vishal.submatrix;

public class SubMatrix_Cache {

    public static int squareSubMatrix(boolean[][] matrix) {

        int max = 0;

        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                max = Math.max(max, squareSubMatrix(matrix, row, column, cache));
            }
        }

        return max;
    }

    private static int squareSubMatrix(boolean[][] matrix, int row, int column, int[][] cache) {

        // boundary checks
        if (row == matrix.length || column == matrix[row].length) return 0;

        if (matrix[row][column] == false) return 0;

        // Look up cache
        if(cache[row][column] != 0) return cache[row][column];

        cache[row][column] = 1 + Math.min(
                Math.min(squareSubMatrix(matrix, row + 1, column, cache), squareSubMatrix(matrix, row, column + 1, cache)),
                squareSubMatrix(matrix, row + 1, column + 1, cache));

        return cache[row][column];
    }

    public static void main(String[] args) {

        boolean[][] matrix = {{true, true, true, true, true},
                {true, true, true, true, false},
                {true, true, true, true, false},
                {true, true, true, true, false},
                {true, false, false, false, false}};

        int subMatrix = squareSubMatrix(matrix);
        System.out.println(subMatrix);
    }
}
