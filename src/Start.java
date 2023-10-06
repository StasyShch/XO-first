import View.View;
import model.Desk;
import model.Figure;
import model.Game;
import model.Player;

import java.io.IOException;


public class Start {



    public static void main(String[] args) throws IOException {
        View view = new View();
        Game game = new Game(view);
        game.start();


    }
}

