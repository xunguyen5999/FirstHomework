/*
* created by Nguyen Hai Anh
*
* */

import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {


    static void printArr(String arr[][]){

        for(int i = 0; i < 4;i++){
            System.out.println("");
            for(int j = 0; j< 4; j++){
                System.out.print(arr[i][j]);
            }
        }

    }

    public static void main(String[] args) {
        String[][] boardGame = new String[4][4];
        for(int i = 0; i < 4; i++){
            System.out.println("");
            for(int j = 0; j < 4; j++){
                boardGame[i][j]="*";
            }
        }

        //printArr(boardGame);
        int x = 0;
        int y = 0;
        boardGame[x][y] = "P";

        int n1=0, n2=0, n3=0, n4 = 0;

        if((n1 == n2 && n3==n4) || (n1 == 0 && n3==0) || (n2==0 && n4==0) ){
            Random random1 = new Random();
            n1 = random1.nextInt(4);
            Random random2 = new Random();
            n2 = random2.nextInt(4);
            Random random3 = new Random();
            n3 = random3.nextInt(4);
            Random random4 = new Random();
            n4 = random1.nextInt(4);
        }

        boardGame[n1][n3]="X";
        boardGame[n2][n4]="X";


        printArr(boardGame);
        while(true){

            Scanner scanner =  new Scanner(System.in);
            String move = scanner.nextLine();
            int dx=0;
            int dy=0;

            boardGame[n1][n3]="*";
            boardGame[n2][n4]="*";

            n1++;
            n4++;
            if(n1 == 4){
                n1=0;
            }
            if(n4==4){
                n4=0;
            }
            boardGame[n1][n3]="X";
            boardGame[n2][n4]="X";


            if(move.equalsIgnoreCase("A")){
                dy=-1;
            }else if(move.equalsIgnoreCase("S")){
                dx = 1;
            }else if(move.equalsIgnoreCase("D")){
                dy =1;
            }else if(move.equalsIgnoreCase("W")){
                dx =-1;
            }



            if(x+dx == -1){
                boardGame[x][y]="*";
                x=3;
                boardGame[x][y]="P";
                //printArr(boardGame);
            }else if(x+dx==4){
                boardGame[x][y]="*";
                x=0;
                boardGame[x][y]="P";
                //printArr(boardGame);
            }else if(y+dy==-1){
                boardGame[x][y]="*";
                y=3;
                boardGame[x][y]="P";
                //printArr(boardGame);
            }else if(y+dy==4){
                boardGame[x][y]="*";
                y=0;
                boardGame[x][y]="P";
                //printArr(boardGame);
            }else{
                boardGame[x][y]="*";
                x = x+dx;
                y = y+dy;
                boardGame[x][y]="P";
                //printArr(boardGame);

            }

            boardGame[n1][n3]="X";
            boardGame[n2][n4]="X";
            printArr(boardGame);


        }


















    }




}

