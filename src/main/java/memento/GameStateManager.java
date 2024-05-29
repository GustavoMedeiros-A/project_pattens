package memento;

import java.util.ArrayList;
import java.util.List;

public class GameStateManager {

    private final List<GameState> savedStatus = new ArrayList<>();

    public void saveState(GameState state) {
        savedStatus.add(state);
    }

    public GameState loadState(int index) {
        if (index < 0 || index >= savedStatus.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return savedStatus.get(index);
    }

    public List<GameState> getAllStates() {
        return new ArrayList<>(savedStatus);
    }

}
