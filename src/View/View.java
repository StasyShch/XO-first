package View;

import controller.WinnerController;
import exceptions.InvalidCoordinateException;
import exceptions.PointOccupiedException;
import model.Desk;
import model.Figure;
import model.Game;
import model.Player;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class View {
    int numberOfPlayers;
    WinnerController winnerController = new WinnerController();

    public String getPlayerName() throws IOException {
        numberOfPlayers++;


        System.out.println("print name of "+ numberOfPlayers+" player");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfPlayer = reader.readLine();

        return nameOfPlayer;
    }
    public Point getStepCoordinate( Player player) throws IOException{
        System.out.println(player.getName()+" choose line and column where to put symbol");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        String[] coordinates = number.trim().split(",");
        int x=Integer.parseInt(coordinates[0].trim());
        int y=Integer.parseInt(coordinates[1].trim());

        return new Point(x,y);
    }

    public int getDeskSize() throws IOException {
        System.out.println("choose size of desk");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        int sizeOfDesk = Integer.parseInt(number);

        return sizeOfDesk;
    }

    public void printFinalMessage(String message) {
            System.out.println(message);
        }

    public void printDesk(Desk desk){
        for (int x = 0; x < desk.getSize() ; x++) {
            printLine(desk,x);
            if(x<desk.getSize()-1)
                printSeparator(desk);
        }
    }
    private void printLine(Desk desk,
                           int x) {
        Figure figure;
        for (int y = 0; y <desk.getSize() ; y++) {
            if(y!=0)
                System.out.print("|");
            try {
                figure =desk.getFigure(new Point(x,y));

            } catch (InvalidCoordinateException e) {
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
        }
        System.out.println();
    }
    private void printSeparator(Desk desk){
        for (int i = 0; i < desk.getSize()+desk.getSize()-1; i++) {
            System.out.print("-");
        }
        System.out.println();// should be flexible length, depend on size of a game
    }



    public boolean canMakeOneMoreMove(Player currentPlayer,Desk desk) throws IOException {
        if (desk.getStepsCounter()>=desk.getCountOfCell()){
        System.out.println("Nobody won");
        return false;
        }
        Point inputPoint = getStepCoordinate(currentPlayer);

        try {
            if (desk.getFigure(inputPoint) != null) {
                throw new PointOccupiedException();
            }
            desk.setFigure(inputPoint, currentPlayer.getSymbol());
            currentPlayer.setLastStepCoordinate(inputPoint);
            printDesk(desk);
            if (winnerController.winnerFound(desk, currentPlayer.getLastStepCoordinate()) == true) {
                System.out.println("Congratulations, " + currentPlayer.getName() + " won!");
                return false;//for next player
            }
            return true;

        } catch (InvalidCoordinateException e) {
            System.out.println("invalid coordinate, try again");
            canMakeOneMoreMove(currentPlayer, desk);
        } catch (PointOccupiedException e) {
            System.out.println("place is already occupied, try again");
            canMakeOneMoreMove(currentPlayer, desk);
        }
        return true;

    }
}









