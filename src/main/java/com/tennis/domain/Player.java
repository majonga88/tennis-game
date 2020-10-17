package com.tennis.domain;

public enum Player {

    BORG(0),
    MCENROE(0);

    private int point;
    private int score;

    Player(int score) {
        this.score = score;
    }

    public void score() {
        this.score++;
        this.point = Point.pointScore(this.score);
    }

    public void resetScore() {
        this.score = 0;
        this.point = 0;
    }

    public int getPointScore() {
        return point;
    }

    public int getScore() {
        return score;
    }

    enum Point {

        LOVE(0),
        FIFTEEN(15),
        THIRTY(30),
        FORTY(40);

        private final int point;

        Point(int point) {
            this.point = point;
        }

        public int value() {
            return point;
        }

        public static int pointScore(int score) {
            switch (score) {
                case 1:
                    return Point.FIFTEEN.value();
                case 2:
                    return Point.THIRTY.value();
                case 3:
                    return Point.FORTY.value();
                default:
                    return Point.LOVE.value();
            }
        }
    }
}
