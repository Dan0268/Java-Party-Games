package org.example;

import java.util.Random;
import java.util.Scanner;

public class PartyGames {
    public class MineSweeper {
        public boolean[][] grid(int n, int d) {
            boolean[][] grid = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Random rand = new Random();
                    boolean bomb = rand.nextInt(d)==0;
                    grid[i][j] = bomb;
                }
            }
            return grid;
        }
        public void showGrid(boolean[][] grid, int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.printf("Grid [%d][%d] = %b%n", i, j, grid[i][j]);
            }
        }

        public void checkForBomb(boolean[][] grid, int n) {
            boolean GameOver = false;
            int numberOfBombs = 0;

            while (!GameOver) {
                System.out.println("Please type in the x coordinate to check for a bomb");
                Scanner scan = new Scanner(System.in);
                int x = scan.nextInt();
                System.out.println("Please type in the y coordinate to check for a bomb");
                int y = scan.nextInt();
                System.out.println();

                if (x >= n || y >= n) {
                    System.out.println("You fell off the grid! Please try again!");
                }
                else if (grid[x][y]) {
                    System.out.println("Boooooom!");
                    System.out.println("You have found the bomb! Unfortunately that means you are dead, thanks for playing!");
                    GameOver = true;
                } else {
                    System.out.println("Lucky you, there is no bomb on this spot");
                    for (int i = x - 1; i < x + 1; i++) {
                        for (int j = y - 1; j < y + 1; j++) {
                            if (i > n - 1 || j > n - 1 || i < 0 || j < 0) {}
                            else if (grid[i][j]) numberOfBombs++;
                        }
                    }

                    if (numberOfBombs == 0) {
                        System.out.printf("There are no bombs around this spot");
                    } else if (numberOfBombs == 1){
                        System.out.printf("There is %d bomb around this spot%n%n", numberOfBombs);
                    } else {
                        System.out.printf("There are %d bombs around this spot%n%n", numberOfBombs);
                    }
                    numberOfBombs = 0;
                }
            }
        }

        public void Start() {
            boolean[][] grid;
            System.out.println("Welcome to Minesweeper!");
            System.out.println("Please type in a number for grid size n * n");
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            System.out.printf("Please type in probability of mines in the grid%n(larger number means lower probability)%n");
            int d = scan.nextInt();
            System.out.println();
            grid = grid(n, d);
//        showGrid(grid, n);
            System.out.printf("You are now in a minefield that is %d * %d in size%n", n, n);
            checkForBomb(grid, n);
        }
    }
}
