import java.io.IOException;

public class Game {
    Desk desk;
    Player[] players;
    View view;

    boolean winnerFound = false;
    int stepsCounter =0;

    public Game(Desk desk,Player[] players, View view){
        this.desk=desk;
        this.players=players;
        this.view=view;
    }

    public void startGame() throws TooMuch, IOException {
        while (stepsCounter < desk.getCountOfCell()) {
            for (int j = 0; j < players.length; j++) {
                players[j].makeStep(view, desk);// refactor here!
                view.printDesk(desk);
                stepsCounter++;
                if (stepsCounter >= desk.getSize() * 2 - 1 & desk.checkWin(players[j]) == true) {
                    view.printWinMessage(players[j]);
                    winnerFound=true;
                    stepsCounter = desk.getCountOfCell();
                    break;
                }
                if (stepsCounter == desk.getCountOfCell()) {
                    view.printMessage();
                    break;
                }
            }
        }

    }
}
