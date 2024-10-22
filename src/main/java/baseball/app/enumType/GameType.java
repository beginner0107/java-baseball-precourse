package baseball.app.enumType;

public enum GameType {
    NUMERIC_BASEBALL("숫자야구");

    private String gameName;

    GameType(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }
}
