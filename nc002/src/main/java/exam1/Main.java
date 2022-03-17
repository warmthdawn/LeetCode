package exam1;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int q = 0; q < T; q++) {
            int[][] grid = new int[3][3];
            int[][] group = new int[3][3];
            int emptyCount = 0;

            for (int i = 0; i < 3; i++) {
                String row = sc.next();
                for (int j = 0; j < 3; j++) {
                    char ch = row.charAt(j);
                    if (ch == '*') {
                        grid[i][j] = 0;
                        emptyCount++;
                    } else {
                        grid[i][j] = ch - '0';
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    group[a][b] = i;
                }
            }

            boolean[] flags = new boolean[3 * 3 * 3];

            //预处理
            int[][] emptyPositions = new int[emptyCount][2];
            int p = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] != 0) {
                        int v = grid[i][j];
                        setFlag(flags, group[i][j], i, j, v);
                    } else {
                        emptyPositions[p][0] = i;
                        emptyPositions[p][1] = j;
                        p++;
                    }
                }
            }

            Solution solution = new Solution(group, emptyPositions, grid);
            solution.fill(0, flags);

            if(solution.result == 0) {
                System.out.println("No");
            }else if(solution.result == 1) {
                System.out.println("Unique");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(solution.uniqueResult[i][j]);
                    }
                    System.out.println();
                }
            }else {

                System.out.println("Multiple");
            }

        }


    }

    //flags = (row + column + group) * 3
    public static void setFlag(boolean[] flags, int g, int i, int j, int v) {
        v--;
        flags[i * 3 + v] = true;
        flags[9 + j * 3 + v] = true;
        flags[18 + g * 3 + v] = true;
    }

    public static boolean canPut(boolean[] flags, int g, int i, int j, int v) {
        v--;
        return !(flags[i * 3 + v] || flags[9 + j * 3 + v] || flags[18 + g * 3 + v]);
    }

    static class Solution {
        private int[][] group;
        private int[][] emptyPositions;

        public Solution(int[][] group, int[][] emptyPositions, int[][] grid) {
            this.group = group;
            this.emptyPositions = emptyPositions;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    uniqueResult[i][j] = grid[i][j];
                }
            }


        }

        private int result = 0;
        private int[][] uniqueResult = new int[3][3];

        public void fill(int index, boolean[] flagsIn) {
            if (result > 1) {
                return;
            }
            if (index >= emptyPositions.length) {
                result++;
                return;
            }


            int i = emptyPositions[index][0];
            int j = emptyPositions[index][1];
            int g = group[i][j];

            for (int v = 1; v < 4; v++) {
                if (canPut(flagsIn, g, i, j, v)) {
                    uniqueResult[i][j] = v;
                    boolean[] flagsNext = new boolean[3 * 3 * 3];
                    System.arraycopy(flagsIn, 0, flagsNext, 0, 3 * 3 * 3);
                    setFlag(flagsNext, g, i, j, v);
                    fill(index + 1, flagsNext);
                }
            }

        }


    }
}