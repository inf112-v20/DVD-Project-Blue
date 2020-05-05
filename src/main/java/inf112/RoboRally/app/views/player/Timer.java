package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Timer {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    private float timeCount;
    private int time;
    private Table timeTable;
    private Label timeLabel;

    protected Timer(int time) {
        this.time = time;
        timeCount = 0;
        timeTable = new Table();
    }

    protected Table getTimeTable() {
        timeTable.pad(0, 4830, 350, 0);

        timeLabel = new Label(String.format("%02d", time), SKIN);

        timeTable.add(timeLabel);

        return timeTable;
    }

    protected void updateTimer(float delta) {
        timeCount += delta;
        if (timeCount >= 1) {
            time--;
            timeLabel.setText(String.format("%02d", time));
            timeCount = 0;
        }
    }
}
