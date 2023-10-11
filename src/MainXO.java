import View.View;
import controller.WinnerController;
import model.Desk;
import model.Figure;
import model.Game;
import model.Player;

import java.awt.*;
import java.io.IOException;

public class MainXO {

    public static void main(String[] args) throws IOException {
        View view =new View();
        boolean endOfGame = false;
        String message = "Nobody won!";
        Player[] players= new Player[Game.NUMBER_OF_PLAYERS];
        //initialization of players
        for (int i = 0; i <players.length; i++) {
            players[i]=new Player(view.getPlayerName(), Figure.values()[i]);
        }
        int inputSize=view.getDeskSize();
        Desk desk = new Desk(inputSize);
        view.printDesk(desk);
        Game game = new Game(players,desk);
        WinnerController controller = new WinnerController();
        Point inputPoint;

        while (!endOfGame) {
            for (int j = 0; j < players.length; j++) {
                if (game.getStepsCounter() < desk.getCountOfCell()) {
                    inputPoint = view.getStepCoordinate(players[j]);
                    game.makeStep(players[j],inputPoint);
                    view.printDesk(desk);
                    if (controller.winnerFound(desk,players[j].getLastStepCoordinate()) == true) {
                        message="Congratulations, "+players[j].getName()+" won!";
                        endOfGame= true;
                        break;
                    }
                }
                else{
                endOfGame= true;
                break;
                }
            }
        }
        view.printMessage(message);
    }
}
