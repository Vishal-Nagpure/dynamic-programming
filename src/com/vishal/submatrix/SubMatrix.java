package com.vishal.submatrix;

public class SubMatrix {

    public static int squareSubMatrix(boolean[][] matrix) {

        int max = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                max = Math.max(max, squareSubMatrix(matrix, row, column));
            }
        }

        return max;
    }

    private static int squareSubMatrix(boolean[][] matrix, int row, int column) {

        // boundary checks
        if (row == matrix.length || column == matrix[row].length) return 0;

        if (matrix[row][column] == false) return 0;

        return 1 + Math.min(
                Math.min(squareSubMatrix(matrix, row + 1, column), squareSubMatrix(matrix, row, column + 1)),
                squareSubMatrix(matrix, row + 1, column + 1));
    }

    public static void main(String[] args) {

        boolean[][] matrix = {{true, true, true, true, true},
                {true, true, true, true, false},
                {true, true, true, true, false},
                {false, true, true, true, false},
                {true, false, false, false, false}};

        int subMatrix = squareSubMatrix(matrix);
        System.out.println(subMatrix);
    }
}
