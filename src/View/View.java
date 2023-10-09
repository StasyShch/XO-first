package View;

import model.Desk;
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

    public void printMessage(Desk desk){

        System.out.println("Nobody won");
        printDesk(desk);
    }
    public void printWinMessage(Player player,Desk desk){
        System.out.println("Congratulations, "+player.getName()+" won!");
        printDesk(desk);
    }

    public void printDesk(Desk desk){
        for (int i = 0; i < desk.getDesk().length; i++) {
            System.out.println(Arrays.toString(desk.getDesk()[i]));
        }
    }

}




