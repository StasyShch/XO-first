import java.util.Arrays;
import java.awt.*;

public class Desk {
    private final int size;
    private int minStepsOfGame;
    private  int countOfCell ;
    private   String[][] desk;// restruct to enum


    public Desk(int size){
        this.size=size;
        countOfCell=size*size;
        minStepsOfGame=size*2-1;
        desk = new String[size][size];
        int f =1;
        for (int i = 0; i < desk.length; i++) {

            for (int j = 0; j <desk[i].length ; j++) {
                desk[i][j]=""+(j+f);
            }
            f+=size;
        }
    }

    public String[][] getDesk(){
       return desk;
    }

    public  int getCountOfCell(){
        return countOfCell;
    }

    public int getSize(){
        return size;
    }

    public int getMinStepsOfGame(){
        return minStepsOfGame;
    }

    public String getFigure(Point point){

        return desk[point.x][point.y];
    }

    public void setFigure(Point point,Figure figure){
        desk[point.x][point.y]=figure.toString();
    }

    public boolean checkValidityOfInputCoordinate(int coordinate){
        return coordinate>=1&&coordinate<=this.getCountOfCell();
    }


    public boolean checkWin(Player player, int position) {
        boolean result;
        int countOfSameSymbols = 0;

        double place=position-0.2;
        int lineNumber=(int)(place/3);
        int placeNumber=(int)place%3;

        for (int i = 0; i <desk[lineNumber].length ; i++) {
            if(desk[lineNumber][i].equals(player.getSymbol()))
                countOfSameSymbols++;
            else {
                countOfSameSymbols=0;
                break;}
        }

        if(lineNumber==placeNumber & countOfSameSymbols!=size){
            for (int i = 0; i <desk.length ; i++) {
                if (desk[i][i].equals(player.getSymbol())) {
                    countOfSameSymbols++;
                }
                else {
                    countOfSameSymbols=0;
                    break;}
            }
        }


        if(lineNumber+placeNumber==size-1 & countOfSameSymbols!=size){
            for (int i = 0; i <desk.length ; i++) {
                if(desk[i][size-1-i].equals(player.getSymbol()))
                    countOfSameSymbols++;
                else {
                    countOfSameSymbols=0;
                    break;}

            }
        }

    if(countOfSameSymbols!=size) {
        for (int i = 0; i < desk.length; i++) {
            if (desk[i][placeNumber].equals(player.getSymbol()))
                countOfSameSymbols++;
            else {
                countOfSameSymbols = 0;
                break;
            }
        }
    }
        return result=countOfSameSymbols==size?true:false;
    }

}

