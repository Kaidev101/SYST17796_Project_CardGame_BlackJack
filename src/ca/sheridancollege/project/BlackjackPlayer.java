/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Group Not Donex

 */
// BlackjackPlayer.java

public class BlackjackPlayer extends Player {

    private Hand hand = new Hand();
    private Bet currentBet;

    public BlackjackPlayer(String name) {
        super(name);
    }

    public Hand getHand() {
        return hand;
    }

    public void placeBet(int amount) {
        currentBet = new Bet(amount);
    }

    public Bet getBet() {
        return currentBet;
    }

    @Override
    public void play() {
    }
}


