package inf112.RoboRally.app.models.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Timer {

    final private Skin SKIN = new Skin(Gdx.files.internal("assets/ButtonSkin/button-ui.json"));
    private Table timeTable;
    private Label timeLabel;

    private Game game;
    private boolean timerIsActive;
    private float timeCount;
    private final int SECONDS_TO_CHOOSE_CARDS;
    private int secondsToChooseCards;

    public Timer(Game game) {
        SECONDS_TO_CHOOSE_CARDS = 30;
        secondsToChooseCards = SECONDS_TO_CHOOSE_CARDS;
        timerIsActive = true;
        this.game = game;
        timeCount = 0;
        timeTable = new Table();
    }

    public Table getTimeTable() {
        timeTable.pad(1050, 2280, 0, 0);

        timeLabel = new Label(String.format("%02d", secondsToChooseCards), SKIN);

        timeTable.add(timeLabel);

        return timeTable;
    }

    public void updateTimer(float delta) {
        timeCount += delta;
        if (timerIsActive) {
            if (secondsToChooseCards > 0) {
                if (timeCount >= 1) {
                    secondsToChooseCards--;
                    timeLabel.setText(String.format("%02d", secondsToChooseCards));
                    timeCount = 0;
                }
            } else {
                secondsToChooseCards = SECONDS_TO_CHOOSE_CARDS;
                timerIsActive = false;
                game.executeRound();
            }
        }
    }

    public void reset() {
        timerIsActive = true;
        game.newRound();
    }

    public boolean timerIsActive() {
        return timerIsActive;
    }

    public void forceStartRoundIfPlayerIsReady() {
        secondsToChooseCards = SECONDS_TO_CHOOSE_CARDS;
        timerIsActive = false;
        game.executeRound();
    }
}
