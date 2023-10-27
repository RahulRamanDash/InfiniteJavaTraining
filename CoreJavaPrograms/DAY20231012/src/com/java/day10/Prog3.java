package com.java.day10;

import java.util.ArrayList;
import java.util.List;

class CricketPlayer {
    String name;
    List<Integer> runsScored = new ArrayList<>();

    CricketPlayer(String name) {
        this.name = name;
    }

    void addRuns(int runs) {
        runsScored.add(runs);
    }

    double calculateAverageRuns() {
        int totalRuns = 0;
        for (int runs : runsScored) {
            totalRuns += runs;
        }
        return (double) totalRuns / runsScored.size();
    }
}

public class Prog3 {
    public static void main(String[] args) {
        List<CricketPlayer> players = new ArrayList<>();
        CricketPlayer player1 = new CricketPlayer("Sachin");
        player1.addRuns(100);
        player1.addRuns(50);
        CricketPlayer player2 = new CricketPlayer("Virat");
        player2.addRuns(75);
        player2.addRuns(90);

        players.add(player1);
        players.add(player2);

        for (CricketPlayer player : players) {
            double averageRuns = player.calculateAverageRuns();
            System.out.println(player.name + "'s Average Runs: " + averageRuns);
        }
    }
}
