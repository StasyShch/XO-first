import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Start {
   public static int size=3;
    String nameOf2Player;

    public static void main(String[] args) throws IOException, TooMuch {
        View view = new View();
        Desk mainDesk = new Desk(view.getDeskSize());
        view.printDesk(mainDesk);

        Player[] players = new Player[2];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(view);
        }
        Game game = new Game(mainDesk,players,view);
        game.startGame();


    }
}

