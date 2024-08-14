package com.leetcode.codewars.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Game {
    public static void main(String[] args) {
        System.out.println(winner(new String[]{"A", "7", "8"}, new String[]{"K", "5", "9"}));
    }

    public static String winner(String[] deckSteve, String[] deckJosh) {
        if (deckSteve.length != deckJosh.length) {
            throw new IllegalArgumentException("deckSteve and deckJosh must be the same length");
        }

        var steveWinners = 0;
        var joshWinners = 0;
        Map<String, Integer> cards = cardValues();
        for (int i = 0; i < deckSteve.length; i++) {
            if (Objects.equals(cards.get(deckSteve[i]), cards.get(deckJosh[i]))) {
                joshWinners += 1;
                steveWinners += 1;
            } else if (cards.get(deckSteve[i]) < cards.get(deckJosh[i])) {
                joshWinners += 1;
            } else {
                steveWinners += 1;
            }
        }

        String result;
        if (steveWinners == joshWinners) {
            result = "Tie";
        } else if (steveWinners < joshWinners) {
            result = String.format("Josh wins %d to %d", joshWinners, steveWinners);
        } else {
            result = String.format("Steve wins %d to %d", steveWinners, joshWinners);
        }

        return result;
    }

    private static Map<String, Integer> cardValues() {
        Map<String, Integer> cardValues = new HashMap<>();
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("T", 10);
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 14);
        return cardValues;
    }
}
