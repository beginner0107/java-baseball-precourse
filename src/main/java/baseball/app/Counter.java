package baseball.app;

public class Counter {
    private int strike;
    private int ball;
    private boolean nothing;

    public Counter() {
        this.strike = 0;
        this.ball = 0;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    private void calculateNothing() {
        this.nothing = (strike == 0 && ball == 0);
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeBall() {
        return ball == 3;
    }


    public boolean isNothing() {
        calculateNothing();
        return nothing;
    }
}
