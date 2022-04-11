package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private ArrayList<Card> playerHand;
	
	public Hand() {
		this.playerHand = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		playerHand.add(card);
	}

	public int getHandValue() {
		int handValue = 0;
		for (Card card : playerHand) {
			handValue += card.getRank().getValue();
		}
		return handValue;
	}

	
	//Update toString for better output
	@Override
	public String toString() {
		return "Hand [playerHand=" + playerHand + "]";
	}
	
	
}
