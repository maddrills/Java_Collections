package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        List<Card> deck = Card.getStandardDeck();
//        Card.printDeck(deck);
//
//        Card[] cardArray = new Card[13];
//        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
//
//        Arrays.fill(cardArray, aceOfHearts);
//        Card.printDeck(Arrays.asList(cardArray), "Aces Of Hearts", 1);
//
//
//        List<Card> cards = new ArrayList<>(52);
////        it doesn't populate the array
//        Collections.fill(cards, aceOfHearts);
//
////        the workaround
//
//        System.out.print(cards);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
//        fill cant copy into cards because cards is an empty list
//        the copy works by iterating over located memory sections in cards so there is no iteration limit
//        52 here is just an initial capacity and does not act like array [52]
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

//        n copy you provide the iteration limit
        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

//        here cars gets filled because addAll uses cardArray as a copy limit
        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

    }
}
