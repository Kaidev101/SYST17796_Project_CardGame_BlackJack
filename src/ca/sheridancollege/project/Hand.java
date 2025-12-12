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

public class Hand {

    private ArrayList<PlayingCard> cards = new ArrayList<>();

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public void clear() {
        cards.clear();
    }

    public int value() {
        int value = 0;
        int aces = 0;

        for (PlayingCard c : cards) {
            value += c.getValue();
            if (c.getValue() == 11) {
                aces++;
            }
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && value() == 21;
    }

    public boolean isBust() {
        return value() > 21;
    }
}


