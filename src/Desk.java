import exceptions.InvalidCoordinateException;
import exceptions.PointOccupiedException;

import java.util.Arrays;
import java.awt.*;

public class Desk {
    private final int size;
    private int minStepsOfGame;
    private  int countOfCell ;
    private   Figure[][] desk;// restruct to enum


    public Desk(int size){
        this.size=size;
        countOfCell=size*size;
        minStepsOfGame=size*2-1;
        desk = new Figure[size][size];

        }


    public Figure[][] getDesk(){
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

    public Figure getFigure(Point point) throws InvalidCoordinateException{
        if(!validityOfInputPoint(point)){
            throw new InvalidCoordinateException();
        }

        return desk[point.x][point.y];
    }

    public void setFigure(Point point,Figure figure) throws InvalidCoordinateException, PointOccupiedException {
       if(!validityOfInputPoint(point)){
           throw new InvalidCoordinateException();
       }
        if(desk[point.x][point.y]!=null){//refactor point null should be
            throw new PointOccupiedException();
        }
        desk[point.x][point.y]=figure;
    }

    public boolean validityOfInputCoordinate(int coordinate){
        return coordinate>=0&&coordinate<=this.getSize();
    }
    public boolean validityOfInputPoint(Point point){
        return validityOfInputCoordinate(point.x)&&validityOfInputCoordinate(point.y);
    }




    public boolean checkWin(Player player, Point position) {
        boolean result;
        int countOfSameSymbols = 0;

        int x=position.x;
        int y=position.y;

        for (int i = 0; i <desk[x].length ; i++) {
            if(desk[x][i].equals(player.getSymbol()))
                countOfSameSymbols++;
            else {
                countOfSameSymbols=0;
                break;}
        }

        if(x==y & countOfSameSymbols!=size){
            for (int i = 0; i <desk.length ; i++) {
                if (desk[i][i].equals(player.getSymbol())) {
                    countOfSameSymbols++;
                }
                else {
                    countOfSameSymbols=0;
                    break;}
            }
        }


        if(x+y==size-1 & countOfSameSymbols!=size){
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
            if (desk[i][y].equals(player.getSymbol()))
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

