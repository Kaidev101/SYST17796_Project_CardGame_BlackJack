/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Group Not Done
 */

public class Dealer extends BlackjackPlayer {

    public Dealer() {
        super("Dealer");
    }

    public boolean mustHitOnSoft17(Hand hand) {
        return hand.value() == 17;
    }

    @Override
    public void play() {
    }
}


