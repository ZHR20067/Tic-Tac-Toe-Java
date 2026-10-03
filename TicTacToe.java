/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author إزهار و براءه (8 شعبة) ||| فاطمة و تاله(7 شعبة) 
 * this game can give you 3 outcomes ( X is the winner , computer is the winner 
 * and the game is tie. it also can tell you if you choose an unavailable spot , enjoy ! <3
 */
import java.util.Random;
import java.util.Scanner;

//  Abstraction 
abstract class Game {
abstract void startGame();
abstract boolean checkWinner(char symbol);
}

// Inheritance 
public class TicTacToe extends Game {

//  Encapsulation 
private char[][] gameBoard;
private String winner = "";

public TicTacToe() {
 gameBoard = new char[][] {
  {' ', '|', ' ', '|', ' '},
  {'-', '+', '-', '+', '-'},
  {' ', '|', ' ', '|', ' '},
  {'-', '+', '-', '+', '-'},
  {' ', '|', ' ', '|', ' '}
 };
}

// starting the game
@Override
void startGame() {
Scanner sc = new Scanner(System.in);
 Random rand = new Random();
  printGameBoard();

while (true) {
   System.out.println(" choose a spot from 1 to 9 :");
       int player_pos = sc.nextInt();

while (!isAvailable(player_pos)) {
   System.out.println(player_pos + " is not available");
   System.out.println("choose again from 1 to 9 ::");
        player_pos = sc.nextInt();
}

// Human player is X
placePiece(player_pos, "player");
   if (checkWinner('X')) {
   winner = "X";
   break;
  }
   
 if (isGameOver()) {
    winner = "Tie";
    break;
    }

 // computer plays O
int cpu_pos = rand.nextInt(9) + 1;
 while (!isAvailable(cpu_pos)) {
 cpu_pos = rand.nextInt(9) + 1;
}

 placePiece(cpu_pos, " computer ");
 if (checkWinner('O')) {
    winner = "computer";
    break;
}
 
if (isGameOver()) {
    winner = "Tie";
    break;
 }

 printGameBoard();
}

 printGameBoard();
 System.out.println("Game Over!");
 if (winner.equals("Tie")) {
 System.out.println("THE GAME IS TIE");
    } else {
        System.out.println(winner + " is the WIINNER");
 }
}

// printing the game
public void printGameBoard() {
   for (char[] row : gameBoard) {
    for (char c : row) {
    System.out.print(c + " ");
}
    System.out.println();
 }
}

// checking for spot availablity
public boolean isAvailable(int pos) {
    switch (pos) {
    case 1: return (gameBoard[0][0] == ' ');
    case 2: return (gameBoard[0][2] == ' ');
    case 3: return (gameBoard[0][4] == ' ');
    case 4: return (gameBoard[2][0] == ' ');
    case 5: return (gameBoard[2][2] == ' ');
    case 6: return (gameBoard[2][4] == ' ');
    case 7: return (gameBoard[4][0] == ' ');
    case 8: return (gameBoard[4][2] == ' ');
    case 9: return (gameBoard[4][4] == ' ');
    default: return false;
    }
}

// placing the X or O
public void placePiece(int pos, String usr) {
    char symbol = (usr.equals("player")) ? 'X' : 'O';
    switch (pos) {
    case 1: gameBoard[0][0] = symbol; break;
    case 2: gameBoard[0][2] = symbol; break;
    case 3: gameBoard[0][4] = symbol; break;
    case 4: gameBoard[2][0] = symbol; break;
    case 5: gameBoard[2][2] = symbol; break;
    case 6: gameBoard[2][4] = symbol; break;
    case 7: gameBoard[4][0] = symbol; break;
    case 8: gameBoard[4][2] = symbol; break;
    case 9: gameBoard[4][4] = symbol; break;
    }
}

// checking who won
@Override
public boolean checkWinner(char symbol) {
// rows
if ((gameBoard[0][0] == symbol && gameBoard[0][2] == symbol && gameBoard[0][4] == symbol) ||
    (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol && gameBoard[2][4] == symbol) ||
    (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol && gameBoard[4][4] == symbol))
    return true;

// columns
if ((gameBoard[0][0] == symbol && gameBoard[2][0] == symbol && gameBoard[4][0] == symbol) ||
    (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol && gameBoard[4][2] == symbol) ||
    (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol && gameBoard[4][4] == symbol))
    return true;

// other possible outcomes
if ((gameBoard[0][0] == symbol && gameBoard[2][2] == symbol && gameBoard[4][4] == symbol) ||
    (gameBoard[0][4] == symbol && gameBoard[2][2] == symbol && gameBoard[4][0] == symbol))
    return true;
    return false;
}

// checking if the board is full
public boolean isGameOver() {
    for (int i = 0; i < gameBoard.length; i++) {
    for (int j = 0; j < gameBoard[i].length; j++) {
    if (gameBoard[i][j] == ' ') {
    return false;
    }
   }
  }
return true;
}

// Polymorphism
public void startGame(String msg) {
    System.out.println(msg);
    startGame(); 
}

// start
public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    game.startGame("Welcome to our TicTacToe Game! ");
    }
}