import Vue.Game.GameLauncher;

public class Main {

    private GameLauncher gameLauncher;

    public Main() {
        this.gameLauncher = new GameLauncher();
        this.gameLauncher.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }


}