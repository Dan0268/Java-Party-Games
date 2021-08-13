package org.example;

import java.util.Scanner;

public class Menu {
    public static void Start() {

//        for (int i = 0; i < 50; i++) {
//            System.out.println();
//        }

        System.out.println("Welcome to Dan's Party Games!");
        System.out.println("Pick one of the following fun games to play!");
        String[] menu = new String[2];
        menu[0] = "1. Minesweeper";
        menu[1] = "X  Exit";
        System.out.println("1. Minesweeper");
        System.out.println("X  Exit");
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        switch (command.toLowerCase()) {
            case "1":
                Minesweeper.Start();
                break;
            case "x":
                System.out.println("Thank you for playing!");
                break;
            default:
                System.out.println("Please enter a valid option");
                Start();
                break;

        }
            
    }
}
