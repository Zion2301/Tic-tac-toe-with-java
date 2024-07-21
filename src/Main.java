import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] gameboard = new char[3][3];
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < 3; j++) {
                gameboard[i][j] = '-';
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to my little game");
        System.out.print("Enter your name player 1: ");
        String firstplayer = scan.nextLine();
        System.out.print("Enter your name player 2: ");
        String secondplayer = scan.nextLine();

        boolean player1 = true;
        boolean gameOver = false;

        while (!gameOver) {
            createBoard(gameboard);

            if(player1) {
                System.out.println(firstplayer + "'s turn (x)");
            }
            else {
                System.out.println(secondplayer + "'s turn (o)");
            }

            char a = '-';
            if (player1) {
                a = 'x';
            }
            else {
                a = 'o';
            }

            int row = 0;
            int column = 0;

            while(true) {
                System.out.println("Enter your row: ");
                row = scan.nextInt();
                System.out.println("Enter your column: ");
                column = scan.nextInt();

                if (row < 0 || column < 0 || row >= 3 || column >= 3){
                    System.out.println("This position is not in the board, choose another");
                }
                else if (gameboard[row][column] != '-') {
                    System.out.println("This spot is already taken");
                }
                else {
                    break;
                }
            }
            gameboard[row][column] = a;

            if (playerWon(gameboard) == 'x'){
                System.out.println(firstplayer + " won");
                gameOver = true;
            } else if (playerWon(gameboard) == 'o') {
                System.out.println(secondplayer + " won");
                gameOver = true;
            }
            else {
                if (Tie(gameboard)){
                    System.out.println("It's a tie");
                    gameOver = true;
                }
                else {
                    player1 = !player1;
                }
            }
        }
        createBoard(gameboard);
    }

    public static void createBoard(char[][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                System.out.print(gameboard[i][j]);
                if (j < gameboard[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < gameboard.length - 1) {
                System.out.println("---------");
            }
        }
    }

    public static char playerWon(char[][] gameboard){
        for (int i = 0; i < gameboard.length; i++) {
            boolean inrow = true;
            char option = gameboard[i][0];
            if (option == '-') {
                inrow = false;
            }
            else {
                for (int j = 1; j < gameboard[i].length; j++) {
                    if (gameboard[i][j] != option) {
                        inrow = false;
                        break;
                    }
                }
            }
            if (inrow) {
                return option;
            }
        }
        for (int j = 0; j < gameboard[0].length; j++) {
            boolean incol = true;
            char option = gameboard[0][j];
            if (option == '-') {
                incol = false;
            }
            else {
                for (int i = 0; i < gameboard.length; i++) {
                    if (gameboard[i][j] != option) {
                        incol = false;
                        break;
                    }
                }
            }
            if (incol) {
                return option;
            }
        }
        boolean indiagon1 = true;
        char option1 = gameboard[0][0];
        if (option1 == '-'){
            indiagon1 = false;
        }
        else {
            for (int i = 0; i < gameboard.length; i++) {
                if (gameboard[i][i] != option1) {
                    indiagon1 = false;
                    break;
                }
            }
        }
        if (indiagon1) {
            return option1;
        }

        boolean indiagon2 = true;
        char option2 = gameboard[0][gameboard.length-1];
        if (option2 == '-'){
            indiagon2 = false;
        }
        else {
            for (int i = 0; i < gameboard.length; i++) {
                if (gameboard[i][gameboard.length-1-i] != option2) {
                    indiagon2 = false;
                    break;
                }
            }
        }
        if (indiagon2) {
            return option2;
        }

        return ' ';
    }

    public static boolean Tie(char [][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (gameboard[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}
