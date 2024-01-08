import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class GameTest {
    @Test
    public void FirstPlayerWin() {
        Player vika = new Player(34, "Vika", 10);
        Player nastya = new Player(65, "Nastya", 9);

        Game game = new Game();

        game.register(vika);
        game.register(nastya);

        int actual = game.round("Vika", "Nastya");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerWin() {
        Player vika = new Player(34, "Vika", 38);
        Player nastya = new Player(65, "Nastya", 50);

        Game game = new Game();

        game.register(vika);
        game.register(nastya);

        int actual = game.round("Vika", "Nastya");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerNotRegister() {
        Player vika = new Player(34, "Vika", 38);
        Player nastya = new Player(65, "Nastya", 50);
        Player petya = new Player(87, "Petya", 68);

        Game game = new Game();

        game.register(petya);
        game.register(nastya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vika", "Nastya");
        });
    }

    @Test
    public void SecondPlayerNotRegister() {
        Player vika = new Player(34, "Vika", 38);
        Player nastya = new Player(65, "Nastya", 50);
        Player petya = new Player(87, "Petya", 68);

        Game game = new Game();

        game.register(petya);
        game.register(vika);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vika", "Nastya");
        });
    }

    @Test
    public void BothOfPlayers() {
        Player vika = new Player(34, "Vika", 38);
        Player nastya = new Player(65, "Nastya", 50);
        Player petya = new Player(87, "Petya", 50);

        Game game = new Game();

        game.register(petya);
        game.register(nastya);

        int actual = game.round("Petya", "Nastya");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}
