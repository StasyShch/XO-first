import java.util.Arrays;

public class Desk {
    private int size;
    private int countOfCell ;
  private   String[][] desk;



    public Desk(int size){
        this.size=size;
        countOfCell=size*size;
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

    public void changeSymbol(int coordinate, String symbol){
        double place=coordinate-0.2;
        int lineNumber=(int)(place/3);
        int placeNumber=(int)place%3;

        desk[lineNumber][placeNumber]=symbol;
    }

    public int getSize(){
        return size;
    }

    public int getCountOfCell() {
        return countOfCell;
    }

    public boolean checkWin(Player player) {
        boolean result;
        int countOfSameSymbols = 0;

        double place=player.getLastStepCoordinate()-0.2;
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

