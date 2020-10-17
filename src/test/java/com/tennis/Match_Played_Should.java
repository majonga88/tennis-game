package com.tennis;

import com.tennis.domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Match_Played_Should {

    Player playerA = Player.BORG;
    Player playerB = Player.MCENROE;

    @Test
    void playerA_have_leads_on_player_B() {

        playerA.score();
        playerA.score();
        playerB.score();

        String score = Match.INSTANCE.getScore(playerA, playerB);

        Assertions.assertEquals("30 for BORG - 15 for MCENROE", score);
    }

    @Test
    void playerB_have_leads_on_player_A() {

        playerA.score();
        playerB.score();
        playerB.score();

        String score = Match.INSTANCE.getScore(playerA, playerB);

        Assertions.assertEquals("15 for BORG - 30 for MCENROE", score);
    }

    @Test
    void playerA_have_advantage_on_player_B() {

        playerA.score();
        playerA.score();
        playerA.score();
        playerA.score();
        playerA.score();
        playerB.score();
        playerB.score();
        playerB.score();
        playerB.score();

        String score = Match.INSTANCE.getScore(playerA, playerB);

        Assertions.assertEquals("The player BORG take advantage on player MCENROE !", score);
    }

    @Test
    void playerB_have_advantage_on_player_A() {

        playerA.score();
        playerA.score();
        playerA.score();
        playerA.score();
        playerB.score();
        playerB.score();
        playerB.score();
        playerB.score();
        playerB.score();

        String score = Match.INSTANCE.getScore(playerA, playerB);

        Assertions.assertEquals("The player MCENROE take advantage on player BORG !", score);
    }

    @Test
    void playerA_wins_the_game() {

        playerA.score();
        playerA.score();
        playerA.score();
        playerA.score();
        playerB.score();
        playerB.score();

        String score = Match.INSTANCE.getScore(playerA, playerB);

        Assertions.assertEquals("The player BORG wins the game !", score);
    }

    @Test
    void playerB_wins_the_game() {

        playerA.score();
        playerA.score();
        playerB.score();
        playerB.score();
        playerB.score();
        playerB.score();

        String score = Match.INSTANCE.getScore(playerA, playerB);

        Assertions.assertEquals("The player MCENROE wins the game !", score);
    }

    @Test
    void we_got_a_deuce() {

        playerA.score();
        playerA.score();
        playerA.score();
        playerA.score();
        playerB.score();
        playerB.score();
        playerB.score();
        playerB.score();

        String score = Match.INSTANCE.getScore(playerA, playerB);

        Assertions.assertEquals("Deuce !", score);
    }

    @AfterEach
    void tearDown() {
        Match.INSTANCE.resetScore(playerA, playerB);
    }
}