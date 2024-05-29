package memento;

public class Main {
    public static void main(String[] args) {
        var game = new Game();
        var manager = new GameStateManager();

        game.setPlayerPosition("Start");
        game.addItemToInvetory("Sword");
        game.setEnemyState("Alive");

        System.out.println("Inital State 123   " + game.toString());
        manager.saveState(game.save());
        System.out.println();

        game.setPlayerPosition("In Cave");
        game.addItemToInvetory("Shield");
        game.setEnemyState("Dead");

        System.out.println("Inital State " + game.toString());
        manager.saveState(game.save());

        game.restore(manager.loadState(0));
        System.out.println("State restored to begin" + game);

        game.restore(manager.loadState(1));
        System.out.println("State restored to in Cave" + game);
    }
}
