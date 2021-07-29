/**
*this class is a maze solver
*@author Vibha Gunturi
*/

import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {

    Scanner file = new Scanner(new File("Maze.txt"));

    char[][]maze;

    int rows = 0;
    int cols = 0;


    while (file.hasNext()){
      String s = file.nextLine();
      rows++;
      cols = s.length();
    }

    int colLength = cols-1;

    maze = new char[rows][cols];


    file = new Scanner(new File("Maze.txt"));

    int thisRow = 0;

    while(file.hasNext()) {
      String curRow = file.nextLine();
      for (int i = 0; i < cols; i++){
        maze[thisRow][i] = curRow.charAt(i);
      }
      thisRow++;
    }

    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++) {
        System.out.print(maze[r][c]);
      }
      System.out.println();
    }

    rows = 0;
    cols = 0;

    char place = (maze[rows][cols]);
    char start = '@';
    char finish = '$';
    char wall = '#';
    char path = '.';

 
    while (place != start){
      for (int a = 0; a < thisRow-1; a++){
        for (int i = 0; i < colLength; i++){
        cols++;
        place = (maze[rows][cols]);
        if (place == start){
          break;
        }
      }
      if (place == start){
          break;
      }
      cols = 0;
      rows++;
      place = (maze[rows][cols]);
      if (place == start){
          break;
      }
      }
    } 

    Stack rowNum = new Stack();
    rowNum.push(rows);
    Stack colNum = new Stack();
    colNum.push(cols);

    while (place != finish){

        // move 1 space down
        
        if (rows != thisRow-1){
        while ((maze[rows+1][cols] == path || maze[rows+1][cols] == finish) || (maze[rows+1][cols] == path && maze[rows][cols+1] == wall) || (maze[rows+1][cols] == path && maze[rows][cols-1] == wall)){
        rowNum.push(rows+1);
        colNum.push(cols);
        maze[rows][cols] = '#';
        rows++;
        place = maze[rows][cols];
        if (rows == thisRow-1){
          break;
        }
        }
        }

        if (place == finish){
          break;
        }

        // move 1 space up
        
        if (rows != 0){
        while ((maze[rows-1][cols] == path || maze[rows-1][cols] == finish) || (maze[rows-1][cols] == path && maze[rows][cols+1] == wall) || (maze[rows-1][cols] == path && maze[rows][cols-1] == wall)){
          rowNum.push(rows-1);
          colNum.push(cols);
          maze[rows][cols] = '#';
          rows--;
          place = maze[rows][cols];
          if (rows == 0){
          break;
        }
          }  
        }  

        if (place == finish){
          break;
        } 

        // move 1 space left
        
        if (cols != 0){
        while ((maze[rows][cols-1] == path || maze[rows][cols-1] == finish) || (maze[rows][cols-1] == path && maze[rows+1][cols] == wall) || (maze[rows][cols-1] == path && maze[rows-1][cols] == wall)){
          rowNum.push(rows);
          colNum.push(cols-1);
          maze[rows][cols] = '#';
          cols--;
          place = maze[rows][cols];
          if (cols == 0){
          break;
        }
        }
        }

        if (place == finish){
          break;
        }

        // move 1 space right
        
        if (cols != colLength){
        while ((maze[rows][cols+1] == path || maze[rows][cols+1] == finish) || (maze[rows][cols+1] == path && maze[rows+1][cols] == wall) || (maze[rows][cols+1] == path && maze[rows-1][cols] == wall)){
          rowNum.push(rows);
          colNum.push(cols+1);
          maze[rows][cols] = '#';
          cols++;
          place = maze[rows][cols];
          if (cols == colLength){
          break;
        }
        }
        }

        if (place == finish){
          break;
        }

        // go back
        
        if (cols == 0 && rows == 0 && maze[rows+1][cols] == wall && maze[rows][cols+1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

        if (cols == colLength && rows == 0 && maze[rows+1][cols] == wall && maze[rows][cols-1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }
        
        if (cols == 0 && rows == thisRow-1 && maze[rows-1][cols] == wall && maze[rows][cols+1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

        if (cols == colLength && rows == thisRow-1 && maze[rows-1][cols] == wall && maze[rows][cols-1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

        if (cols != 0 && cols != colLength && rows != 0 && rows != thisRow-1 && maze[rows+1][cols] == wall && maze[rows-1][cols] == wall && maze[rows][cols-1] == wall && maze[rows][cols+1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

        if (rows == 0 && cols != 0 && cols != colLength && maze[rows+1][cols] == wall && maze[rows][cols-1] == wall && maze[rows][cols+1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

        if (rows == thisRow-1 && cols != 0 && cols != colLength && maze[rows-1][cols] == wall && maze[rows][cols-1] == wall && maze[rows][cols+1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = rowNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

        if (cols == 0 && rows != thisRow-1 && rows != 0 && maze[rows+1][cols] == wall && maze[rows-1][cols] == wall && maze[rows][cols+1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

        if (cols == colLength && rows != thisRow-1 && rows != 0 && maze[rows+1][cols] == wall && maze[rows-1][cols] == wall && maze[rows][cols-1] == wall){
          maze[rows][cols] = '#';
          rowNum.pop();
          colNum.pop();
          rows = rowNum.peek();
          cols = colNum.peek();
          place = maze[rows][cols];
        }

        if (place == finish){
          break;
        }

    }
    
    Stack xCoord = new Stack();
    Stack yCoord = new Stack();
    int colSize = colNum.length();
    int rowSize = rowNum.length();

    for (int b = 0; b < rowSize; b++){
      xCoord.push(rowNum.pop());
    }

    for (int b = 0; b < colSize; b++){
      yCoord.push(colNum.pop());
    }

    for (int b = 0; b < colSize; b++){
      System.out.println(xCoord.peek() + "," + yCoord.peek());
      xCoord.pop();
      yCoord.pop();
    }

  }
}