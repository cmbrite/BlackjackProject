package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.Hand;

public class BlackJackApplication {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApplication app = new BlackJackApplication();
		app.run();
	}

	public void run() {
		playGame();
	}

	public void playGame() {
		// Creates user and dealer hands
		Hand user = new Hand();
		Hand dealer = new Hand();
		Deck deck = new Deck();
		deck.shuffle();
		boolean bust = false;

		// Deals user cards
		user.addCard(deck.dealCard());
		user.addCard(deck.dealCard());
		// Sysout to show user cards
		System.out.println("Player hand" + user.toString() + " = " + user.getHandValue());

		// Deals dealer cards
		dealer.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		// Sysout to show dealer cards
		System.out.println("Dealer hand" + dealer.toString() +  " = " + dealer.getHandValue());
		String input;
		
		do {
			System.out.println("Would you like to hit? Y/N");
			System.out.println("Enter Y for another card or N to stand.");
			input = sc.nextLine();
			// If player chooses to hit
			if(user.getHandValue() == 21) {
				System.out.println(" BLACKJACK! You have won!");
				bust = true;
			}
			if (input.equalsIgnoreCase("Y")) {
				user.addCard(deck.dealCard());
				System.out.println("Player drew another card to total " + user.getHandValue() + " " + user.toString());
				if (user.getHandValue() > 21) {
					System.out.println(user.getHandValue() + " Player Bust!");
					bust = true;
				}
			}
			// If player chooses to stay
			if (input.equalsIgnoreCase("N")) {
				System.out.println("Player stays with total of " + user.getHandValue());
			}
			// Dealer logic
			if (user.getHandValue() < 22 && dealer.getHandValue() < 17) {
				dealer.addCard(deck.dealCard());
				System.out.println("Dealer drew another card to total " + dealer.getHandValue() + " " + dealer.toString());

			}
			if (dealer.getHandValue() > 16) {
				System.out.println("Dealer stands at " + dealer.getHandValue());

			}
			if (dealer.getHandValue() > 21) {
				System.out.println(dealer.getHandValue() + " Dealer bust!");
				bust = true;
			}
		} while (bust = false);
		// Game winner
		if (dealer.getHandValue() < 22 && dealer.getHandValue() > user.getHandValue()) {
			System.out.println("Dealer wins this time!");
		}
		if (user.getHandValue() > 22 && dealer.getHandValue() < 22) {
			System.out.println("Dealer wins this time!");
		}
		if (user.getHandValue() < 22 && user.getHandValue() > dealer.getHandValue()) {
			System.out.println("Player wins this time!");
		}
		if (user.getHandValue() < 22 && dealer.getHandValue() > 22) {
			System.out.println("Player wins this time!");
		}
		if (dealer.getHandValue() == user.getHandValue()) {
			System.out.println("Dealer push!");
		}
	}
}
