package org.example;

import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    private static int spaces = 0;
    private static int numberOfBombs = 0;
    static String[][] playGrid;

    public static boolean[][] grid(int n, int d) {
        boolean[][] grid = new boolean[n][n];
        spaces = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Random rand = new Random();
                boolean bomb = rand.nextInt(d)==0;
                grid[i][j] = bomb;
                if (!bomb) {
                    spaces++;
                }
            }
        }
        return grid;
    }
    public static void showGrid(boolean[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
            System.out.printf("Grid [%d][%d] = %b%n", i, j, grid[i][j]);
        }
    }
    public static void makePlayGrid(int n) {
        playGrid = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                playGrid[i][j] = " ";
            }
        }
    }
    public static void showPlayGrid(int n) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.printf("   ");
        for (int j = 0; j < n; j++) {
            System.out.printf(" %d ", j + 1);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ", i + 1);
            for (int j = 0; j < n; j++) {
                System.out.printf("[%s]", playGrid[i][j]);
            }
            System.out.println();
        }
    }
    public static void checkForBomb(boolean[][] grid, int n) {
        boolean GameOver = false;
        numberOfBombs = 0;
        showPlayGrid(n);
        while (!GameOver) {
            System.out.println("Please type in the x coordinate to check for a bomb");
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            System.out.println("Please type in the y coordinate to check for a bomb");
            int y = scan.nextInt();
            System.out.println();

//            x = x - 1;
//            x = y - 1;

            if (x > n || y > n) {
                System.out.println("You fell off the grid! Please try again!");
            }
            else if (grid[x-1][y-1]) {
                playGrid[y-1][x-1] = "X";
                showPlayGrid(n);
                System.out.println();
                System.out.println("Boooooom!");
                System.out.println();
                System.out.println("You have found the bomb! Unfortunately that means you are dead, thanks for playing!");
                System.out.println();
                GameOver = true;
            } else {
                System.out.println("Lucky you, there is no bomb on this spot");
                System.out.println();
                spaces--;

                if (spaces == 0 ) {
                    System.out.println("Wow you found all of the bomb! Congratulations! You Win! Live life to the fullest!");
                    System.out.println();
                    GameOver = true;
                }

                if (!GameOver) {

                    for (int i = x - 1; i < y + 1; i++) {
                        for (int j = x - 1; j < y + 1; j++) {
                            if (i > n - 1 || j > n - 1 || i < 0 || j < 0) {
                            } else if (grid[i][j]) {
                                numberOfBombs++;
                            }
                        }
                    }
                    showGrid(grid, n);
                    playGrid[y-1][x-1] = String.valueOf(numberOfBombs);
                    showPlayGrid(n);
                    if (numberOfBombs == 0) {
                        System.out.printf("There are no bombs around this spot%n%n");
                    } else if (numberOfBombs == 1) {
                        System.out.printf("There is %d bomb around this spot%n%n", numberOfBombs);
                    } else {
                        System.out.printf("There are %d bombs around this spot%n%n", numberOfBombs);
                    }
                    numberOfBombs = 0;

                    if (spaces == 0 ) {
                        System.out.println("Wow you found all of the bomb! Congratulations! You Win! Live life to the fullest!");
                        System.out.println();
                        GameOver = true;
                    }
                }
            }
        }
        System.out.println("That was fun wasn't it? Would you like to play again?");
        System.out.println("Press Y or yes to play again, or smash the keyboard with your head to leave.");
        Scanner scan = new Scanner(System.in);
        String PlayAgain = scan.nextLine();
        if (PlayAgain.toLowerCase().equals("y") || PlayAgain.toLowerCase().equals("yes")) {
            GameOver = false;
            Start();
        }
        else
            System.out.println("We hope you had fun playing, enjoy the rest of your life!");
    }
    public static void Start() {
        boolean[][] grid;
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Please type in a number for grid size n * n");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.printf("Please type in probability of mines in the grid%n(larger number means lower probability)%n");
        int d = scan.nextInt();
        System.out.println();
        grid = grid(n, d);
        makePlayGrid(n);
        showGrid(grid, n);
        System.out.printf("You are now in a minefield that is %d * %d in size%n", n, n);
        checkForBomb(grid, n);
    }
}
