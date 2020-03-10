package inf112.RoboRally.app.views.Cards;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.Random;

public class CardUI {

    private Random random;

    public Card card, card2, card3, card4, card5, card6,
            card7, card8, card9;

    public Table cards;

    public Table show () {
        cards = new Table();
        cards.right().padRight(230).padTop(240);
        cards.setFillParent(true);

        random = new Random();

        card = new Card();
        card2 = new Card();
        card3 = new Card();
        card4 = new Card();
        card5 = new Card();
        card6 = new Card();
        card7 = new Card();
        card8 = new Card();
        card9 = new Card();

        cards.add(card.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.add(card2.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.row().padTop(270);
        cards.add(card3.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.add(card4.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.row().padTop(270);
        cards.add(card5.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.add(card6.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.row().padTop(270);
        cards.add(card7.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.add(card8.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        cards.row().padTop(270);
        cards.add(card9.init(random.nextInt(6), random.nextInt(1999))).padLeft(205);

        return cards;
    }

}
