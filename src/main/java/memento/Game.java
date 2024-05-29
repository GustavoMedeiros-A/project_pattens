package memento;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String playerPosition;
    private List<String> inventory;
    private String enemyState;

    public Game() {
        this.inventory = new ArrayList<String>();
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void setEnemyState(String enemyState) {
        this.enemyState = enemyState;
    }

    public void addItemToInvetory(String item) {
        this.inventory.add(item);
    }

    public void removeItemFromInvetory(String item) {
        this.inventory.remove(item);
    }

    public GameState save() {
        return new GameMemento(playerPosition, new ArrayList<>(inventory), enemyState);
    }

    public void restore(GameState state) {
        this.playerPosition = state.getPlayerPosition();
        this.inventory = state.getInventory();
        this.enemyState = state.getEnemyState();
    }

    @Override
    public String toString() {
        return "Player Position: " + playerPosition + ", Inventory: " + inventory + ", Enemy State: " + enemyState;
    }

}
