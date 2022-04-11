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

		// Deals user cards
		user.addCard(deck.dealCard());
		user.addCard(deck.dealCard());
		// Sysout to show user cards
		System.out.println("Player hand" + user.toString());

		// Deals dealer cards
		dealer.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		// Sysout to show dealer cards
		System.out.println("Dealer hand" + dealer.toString());

		System.out.println("Would you like to hit? Y/N");
		System.out.println("Enter Y for another card or N to stand.");
		String input = sc.nextLine();
		if (input.equalsIgnoreCase("Y")) {
			user.addCard(deck.dealCard());
			System.out.println("Player hand" + user.toString());

		}

	}
}
