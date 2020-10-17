package com.tennis;

import com.tennis.domain.Player;

public enum Match {

    INSTANCE;

    public String getScore(Player a, Player b) {

        int scorePlayerA = a.getScore();
        int scorePlayerB = b.getScore();

        if (scorePlayerA > 3 && scorePlayerB > 3) {

            if (scorePlayerA == scorePlayerB) {
                return "Deuce !";
            }
            if (scorePlayerA - scorePlayerB == 1) {
                return String.format("The player %s take advantage on player %s !", a.name(), b.name());
            }
            if (scorePlayerB - scorePlayerA == 1) {
                return String.format("The player %s take advantage on player %s !", b.name(), a.name());
            }
        }
        if (scorePlayerA > 3) {
            return String.format("The player %s wins the game !", a.name());
        }
        if (scorePlayerB > 3) {
            return String.format("The player %s wins the game !", b.name());
        }
        return String.format("%s for %s - %s for %s",
                a.getPointScore(), a.name(), b.getPointScore(), b.name());
    }

    public void resetScore(Player a, Player b) {
        a.resetScore();
        b.resetScore();
    }
}
