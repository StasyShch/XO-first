package controller;

import model.Desk;

import java.awt.*;

public class WinnerController {

    public boolean winnerFound(Desk desk, Point point){
        boolean result;
        int countOfSameSymbols = 0;
        int x=point.x;
        int y=point.y;

        for (int i = 0; i <desk.getDesk()[x].length ; i++) {
            if(desk.getDesk()[x][i]!=null &&desk.getDesk()[x][i].equals(desk.getDesk()[x][y]))
                countOfSameSymbols++;
            else {
                countOfSameSymbols=0;
                break;}
        }

        if(x==y & countOfSameSymbols!=desk.getSize()){
            for (int i = 0; i <desk.getDesk().length ; i++) {
                if (desk.getDesk()[i][i]!=null&&desk.getDesk()[i][i].equals(desk.getDesk()[x][y])) {
                    countOfSameSymbols++;
                }
                else {
                    countOfSameSymbols=0;
                    break;}
            }
        }


        if(x+y==desk.getSize()-1 & countOfSameSymbols!=desk.getSize()){
            for (int i = 0; i <desk.getDesk().length ; i++) {
                if(desk.getDesk()[i][desk.getSize()-1-i]!=null&&desk.getDesk()[i][desk.getSize()-1-i].equals(desk.getDesk()[x][y]))
                    countOfSameSymbols++;
                else {
                    countOfSameSymbols=0;
                    break;}

            }
        }

        if(countOfSameSymbols!=desk.getSize()) {
            for (int i = 0; i < desk.getDesk().length; i++) {
                if (desk.getDesk()[i][y]!=null&&desk.getDesk()[i][y].equals(desk.getDesk()[x][y]))
                    countOfSameSymbols++;
                else {
                    countOfSameSymbols = 0;
                    break;
                }
            }
        }
        return result=countOfSameSymbols==desk.getSize()?true:false;
    }

}



