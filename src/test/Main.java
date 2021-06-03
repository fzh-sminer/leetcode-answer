package test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<List<Integer>> newArrays (int[][] a) {
        List<List<Integer>> paths = new ArrayList<>();
        if (a.length == 0) {
            return paths;
        }

        helper(a, 0, paths, new ArrayList<>());

        return paths;
    }

    public void helper(int[][] a, int index, List<List<Integer>> paths, List<Integer> path) {
        if (index >= a.length) {
            paths.add(path);
        } else {
            for (int i = 0; i < a[index].length; i++) {
                List<Integer> p = new ArrayList<>(path);
                p.add(a[index][i]);
                helper(a, index + 1, paths, p);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> paths = new Main().newArrays(a);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
