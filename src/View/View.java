package View;

import exceptions.InvalidCoordinateException;
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

    public void printMessage(String message){
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
}







