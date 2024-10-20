package program;

import java.util.*;

public class ZeroMatrix {

    //set matrix zero
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int rowSize = matrix.size();
        int colSize = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, rowSize, colSize);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int rowSize, int colSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if(matrix.get(i).get(j) == 0){
                    markRow(matrix, rowSize, i);
                    markCol(matrix, colSize, j);
                }
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if(matrix.get(i).get(j) == -1){
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    private static void markRow(ArrayList<ArrayList<Integer>> matrix, int rowSize, int i) {
        for (int j = 0; j < rowSize ; j++) {
            if(matrix.get(i).get(j) != 0)
            {
                matrix.get(i).set(j, -1);
            }
        }
    }

    private static void markCol(ArrayList<ArrayList<Integer>> matrix, int colSize, int j) {
        for (int i = 0; i < colSize; i++) {
            if(matrix.get(i).get(j) != 0)
            {
                matrix.get(i).set(j, -1);
            }
        }
    }


}

