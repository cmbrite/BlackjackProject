package com.skilldistillery.blackjack;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.Hand;

public class BlackJackApplication {
	public static void main(String[] args) {
		BlackJackApplication app = new BlackJackApplication();
		app.run();
	}
	
	public void run() {
		//Creates user and dealer hands
		Hand user = new Hand();
		Hand dealer = new Hand();
		Deck deck = new Deck();
		deck.shuffle();
			
		//Deals user cards
		user.addCard(deck.dealCard());
		user.addCard(deck.dealCard());
		//Sysout to test user cards
//		System.out.println(user.toString());
		
		}
	}

