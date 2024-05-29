package memento;

import java.util.List;

public class GameMemento implements GameState {
    private final String playerPosition;
    private final List<String> inventory;
    private final String enemyState;

    public GameMemento(String playerPosition, List<String> inventory, String enemyState) {
        this.playerPosition = playerPosition;
        this.inventory = inventory;
        this.enemyState = enemyState;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public String getEnemyState() {
        return enemyState;
    }

}
