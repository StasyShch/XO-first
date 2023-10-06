package model;

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
        desk = new Figure[size][size];
        countOfCell=desk.length*desk.length;
        minStepsOfGame=size*2-1;


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

    public void setFigure(Point point, Figure figure) throws InvalidCoordinateException {
       if(!validityOfInputPoint(point)){
           throw new InvalidCoordinateException();
       }

        desk[point.x][point.y]=figure;
    }

    public boolean validityOfInputCoordinate(int coordinate){
        return coordinate>=0&&coordinate<=this.getSize();
    }
    public boolean validityOfInputPoint(Point point){
        return validityOfInputCoordinate(point.x)&&validityOfInputCoordinate(point.y);
    }






}

