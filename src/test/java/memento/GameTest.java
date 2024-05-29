package memento;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;
    private GameStateManager manager;

    @BeforeEach
    public void loadMemento() {
        game = new Game();
        manager = new GameStateManager();

    }

    @Test
    void shouldSetAndLoadInitalState() {
        game.setPlayerPosition("Start");
        game.addItemToInvetory("Sword");
        game.setEnemyState("Alive");

        manager.saveState(game.save());

        assertEquals(game.toString(), "Player Position: Start, Inventory: [Sword], Enemy State: Alive");
    }

    @Test
    void shouldSetTwoStatesAndGetTheFirstState() {
        game.setPlayerPosition("Start");
        game.addItemToInvetory("Sword");
        game.setEnemyState("Alive");

        manager.saveState(game.save());

        game.setPlayerPosition("In Cave");
        game.addItemToInvetory("Shield");
        game.setEnemyState("Dead");

        manager.saveState(game.save());

        game.restore(manager.loadState(0));
        assertEquals(game.toString(), "Player Position: Start, Inventory: [Sword], Enemy State: Alive");

    }

    @Test
    void shouldThrowAErroWhenPassInvalidIndex() {
        try {
            game.restore(manager.loadState(0));
            fail();
        } catch (Exception e) {
            assertEquals("Invalid index", e.getMessage());
        }
    }
}
