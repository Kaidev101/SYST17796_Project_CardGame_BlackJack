/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Group Not Done
 */

public class BlackjackRules {

    public boolean isBlackjack(Hand hand) {
        return hand.isBlackjack();
    }

    public boolean isBust(Hand hand) {
        return hand.isBust();
    }

    public boolean dealerMustHit(Hand hand) {
        return hand.value() < 17;
    }

    public Outcome calculateOutcome(Hand playerHand, Hand dealerHand) {
        if (playerHand.isBust()) {
            return Outcome.BUST;
        }
        if (dealerHand.isBust()) {
            return Outcome.WIN;
        }
        if (playerHand.value() > dealerHand.value()) {
            return Outcome.WIN;
        }
        if (playerHand.value() < dealerHand.value()) {
            return Outcome.LOSE;
        }
        if (playerHand.isBlackjack() && !dealerHand.isBlackjack()) {
            return Outcome.BLACKJACK;
        }
        return Outcome.PUSH;
    }

    public int payout(Outcome outcome, int bet) {
        switch (outcome) {
            case WIN:
                return bet * 2;
            case BLACKJACK:
                return (int) (bet * 2.5);
            case PUSH:
                return bet;
            default:
                return 0;
        }
    }
}


