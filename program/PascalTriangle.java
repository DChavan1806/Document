package program;

import java.util.*;

public class PascalTriangle {


    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> pascalTriangle(int rowSize) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int row=1;row<=rowSize;row++)
        {
            pascalTriangle.add(addRows(row));
        }
        return pascalTriangle;
    }

    private static List<Integer> addRows(int rowSize) {
        long rowValue = 1;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int col = 1; col < rowSize ; col++) {
            rowValue = rowValue * (rowSize - col);
            rowValue = rowValue / col;
            row.add((int)rowValue);
        }
        return row;
    }
}
