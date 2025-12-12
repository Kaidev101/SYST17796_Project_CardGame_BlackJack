/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * @author Group Not Done
 */

public class Main {
    private static int readBetAmount(Scanner sc) {
        int betAmount;

        while (true) {
            System.out.print("Enter your bet amount (must be a positive integer): ");

            String input = sc.nextLine().trim();

            try {
                betAmount = Integer.parseInt(input);

                if (betAmount > 0) {
                    return betAmount;
                } else {
                    System.out.println("Bet must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a NUMBER (e.g., 10).");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Game game = new BlackjackGame("Blackjack");

        int betAmount = readBetAmount(sc);

        BlackjackPlayer player = new BlackjackPlayer("Player");
        player.placeBet(betAmount);

        Dealer dealer = new Dealer();

        ((BlackjackGame) game).setPlayer(player);
        ((BlackjackGame) game).setDealer(dealer);

        game.play();
    }
}



