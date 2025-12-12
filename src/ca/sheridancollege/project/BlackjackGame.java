/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Group Not Done
 */
import java.util.Scanner;

public class BlackjackGame extends Game {

    private GroupOfCards deck;
    private Dealer dealer;
    private BlackjackRules rules;
    private BlackjackPlayer player;

    public BlackjackGame(String name) {
        super(name);
        deck = DeckFactory.buildStandardBlackjackDeck();
        dealer = new Dealer();
        rules = new BlackjackRules();
    }

    public void setPlayer(BlackjackPlayer p) {
        this.player = p;
    }

    public void setDealer(Dealer d) {
        this.dealer = d;
    }

    private PlayingCard drawCard() {
        return (PlayingCard) deck.getCards().remove(0);
    }

    @Override
    public void play() {
        deck.shuffle();
        dealInitialCards();

        if (!processPlayerActions()) {
            return;
        }

        processDealerActions();
        declareWinner();
    }

    private void dealInitialCards() {

        // player takes 2 cards
        player.getHand().addCard(drawCard());
        player.getHand().addCard(drawCard());

        // dealer takes 2 cards
        dealer.getHand().addCard(drawCard());
        dealer.getHand().addCard(drawCard());

        System.out.println("Initial player hand: " + player.getHand().getCards());
        System.out.println("Initial dealer visible card: " + dealer.getHand().getCards().get(0));
    }

    private boolean processPlayerActions() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n---- PLAYER TURN ----");
            System.out.println("Your hand: " + player.getHand().getCards());
            System.out.println("Value: " + player.getHand().value());

            if (player.getHand().isBlackjack()) {
                System.out.println("BLACKJACK!");
                return true;
            }

            if (player.getHand().isBust()) {
                System.out.println("You BUST! Dealer wins immediately.");
                return false;
            }

            System.out.print("Choose action (HIT / STAND): ");
            String action = sc.nextLine().trim().toUpperCase();

            if ("HIT".equals(action)) {
                PlayingCard card = drawCard();
                player.getHand().addCard(card);
                System.out.println("You drew: " + card);
            } else if ("STAND".equals(action)) {
                System.out.println("You stand at: " + player.getHand().value());
                return true;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    private void processDealerActions() {

        System.out.println("\n---- DEALER TURN ----");
        System.out.println("Dealer starts with: " + dealer.getHand().getCards());
        System.out.println("Value: " + dealer.getHand().value());

        while (rules.dealerMustHit(dealer.getHand())) {

            PlayingCard card = drawCard();
            dealer.getHand().addCard(card);

            System.out.println("Dealer draws: " + card);
            System.out.println("Dealer hand: " + dealer.getHand().getCards());
            System.out.println("Value: " + dealer.getHand().value());

            if (dealer.getHand().isBust()) {
                System.out.println("Dealer BUSTS! Player wins.");
                return;
            }
        }

        System.out.println("Dealer stands at: " + dealer.getHand().value());
    }

    @Override
    public void declareWinner() {

        System.out.println("\n---- RESULTS ----");

        Outcome result = rules.calculateOutcome(player.getHand(), dealer.getHand());
        System.out.println("Outcome: " + result);

        int payout = rules.payout(result, player.getBet().getAmount());

        System.out.println("You bet: $" + player.getBet().getAmount());
        System.out.println("Payout: $" + payout);
    }
}


