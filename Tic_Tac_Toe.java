
package com.tillu.Tic_Tac_Toe;

import java.util.*;

class Tic_Tac_Toe {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    char[][] table = new char[3][3];
    int chances = 4;
    
    
    
    void Play(){
        boolean game_over_status = false;
        while(chances>0){
            Computer_Turn();
            if(Check()){
                System.out.println("Game Over");
                return;
            }
            Player_Turn();
            if(Check()){
                System.out.println("Game Over");
                return;
            }
            if(chances == 1 && Logic()==false){
                System.out.println("Draw");
                return;
            }
            chances--;
        }
    }
    
    boolean Check(){
        boolean game_over_status = false;
        if(chances < 3){
            return Logic();
        }
        return false;
    }
    
    boolean Logic(){
        boolean key_flag = true;
        boolean side_flag = false;
        
        //row logic
        for(int i=0;i<table.length;i++){
            key_flag = true;
            for(int j=0;j<table[i].length-1 && key_flag == true;j++){
                if(table[i][j] == table[i][j+1])
                    side_flag = key_flag = true;
                else
                    side_flag = key_flag = false;
            }
            if(side_flag ){
                System.out.println("row logic");
                if(table[i][0] == 'X')
                    System.out.println("Computer wins");
                if(table[i][0] == 'O')
                    System.out.println("Player wins");
                return true;
            }
        }
        
        
        //column logic
        for(int i=0;i<table.length;i++){
            key_flag = true;
            for(int j=0;j<table[i].length-1 && key_flag == true;j++){
                if(table[j][i] == table[j+1][i])
                    side_flag = key_flag = true;
                else
                    side_flag = key_flag = false;
            }
            if(side_flag ){
                System.out.println("column logic");
                if(table[i][0] == 'X')
                    System.out.println("Computer wins");
                if(table[i][0] == 'O')
                    System.out.println("Player wins");
                return true;
            }
        }
        
        //left diagonal logic
        if(table[0][0]==table[1][1]&&table[1][1]==table[2][2]){
            System.out.println("left diagonal logic");
            if(table[1][1] == 'X')
                System.out.println("Computer wins");
            if(table[1][1] == 'O')
                System.out.println("Player wins");
            if(table[1][1] == '\u0000')
                return false;
            return true;
        }
        
        //right diagonal logic
        if(table[0][2]==table[1][1]&&table[1][1]==table[2][0]){
            System.out.println("right diagonal logic");
            if(table[1][1] == 'X')
                System.out.println("Computer wins");
            if(table[1][1] == 'O')
                System.out.println("Player wins");
            if(table[1][1] == '\u0000')
                return false;
            return true;
        }
        return false;
    }
    
    void Computer_Turn(){
        boolean flag = true;
        int computer_row,computer_column;
        do{
            //Computer turn
            computer_row = rand.nextInt(3);
            computer_column = rand.nextInt(3);
            
            if(table[computer_row][computer_column] != '\u0000' ){
                System.out.println("Invalid Input");
            }
            else{
                table[computer_row][computer_column] = 'X';
                flag = false;
            }
            //printing table 
            Print();
        }while(flag);
    }
    
    void Player_Turn(){
        boolean flag = true;
        int player_row,player_column;
        do{
            System.out.print("Enter the row and column : ");
            player_row = in.nextInt();
            player_column = in.nextInt();
            if(table[player_row][player_column] != '\u0000'){
                System.out.println("Invalid Input");
            }
            else{
                table[player_row][player_column] = 'O';
                flag = false;
            }
            //printing table after player turn
            Print();
        }while(flag);
        //Player turn
    }
    
    void Print(){
        for (int i = 0; i < table.length; i++) {           
            for (int j = 0; j < table[i].length; j++) {
                if(table[i][j] == '\u0000')                    
                    System.out.print("  "+" ");
                else                    
                    System.out.print("  "+table[i][j]+"");
                if(j<2)                    
                    System.out.print("  |");
                if(j == 2 && i<2){                    
                    System.out.println();
                    System.out.print("  ___  ___  ___");                
                }
            }            
            System.out.println("\n");
        }  
        System.out.println("\n\n\n\n");
    }
    
}
