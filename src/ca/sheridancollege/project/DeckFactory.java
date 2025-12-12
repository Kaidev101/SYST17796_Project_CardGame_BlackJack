/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 *
 * @author Group Not Done
 */

public class DeckFactory {

    public static GroupOfCards buildStandardBlackjackDeck() {
        GroupOfCards deck = new GroupOfCards(52);
        ArrayList<Card> cards = deck.getCards();

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String s : suits) {
            for (String r : ranks) {
                int value;

                switch (r) {
                    case "J":
                    case "Q":
                    case "K": value = 10;
                        break;
                    case "A": value = 11;
                        break;
                    default:
                        value = Integer.parseInt(r);
                }

                cards.add(new PlayingCard(s, r, value));
            }
        }
        return deck;
    }
}

