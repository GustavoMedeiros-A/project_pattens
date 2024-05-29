package memento;

import java.util.List;

public interface GameState {
    String getPlayerPosition();

    List<String> getInventory();

    String getEnemyState();
}
