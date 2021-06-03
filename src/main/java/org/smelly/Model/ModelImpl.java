package org.smelly.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;

public class ModelImpl implements Model {

  private int[][] board = new int[10][4];
  private int[] solution = new int[4];
  private Integer[][] clues = new Integer[10][4];
  private final List<ModelObserver> observerList = new ArrayList<>();
  private int activeCol;
  private int activeIndex;
  private boolean isSolved;

  private int[] solCounter = new int[6];
  private int[] codeCounter = new int[6];

  public ModelImpl() {
    activeCol = 0;
    activeIndex = 0;
    isSolved = false;
    newSolution();

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 4; j++) {
        clues[i][j] = 0;
      }
    }

  }

  @Override
  public int[][] getBoard() {
    return board;
  }

  @Override
  public int getActiveCol() {
    return activeCol;
  }

  @Override
  public int getActiveIndex() {
    return activeIndex;
  }

  @Override
  public boolean getIsSolved() {
    return isSolved;
  }

  @Override
  public int getValue(int col, int index) {
    return board[col][index];
  }

  @Override
  public int getClueVal(int col, int index) {
    return clues[col][index];
  }

  @Override
  public int[] getSolution() {
    return solution;
  }

  @Override
  public void setVal(int x) {
    if (activeIndex >= 0 && activeIndex < 4) {
      board[activeCol][activeIndex] = x;
      activeIndex++;
    }
    notifyObservers();
  }

  @Override
  public void newSolution() {
    for (int i = 0; i < 4; i++) {
      solution[i] = ThreadLocalRandom.current().nextInt(1, 7);
    }
    /*for (int i = 0; i < 4; i++) {
      System.out.print(solution[i] + " ");
    }
    System.out.println("\n"); */
    isSolved = false;
    notifyObservers();
  }

  @Override
  public void setActiveCol(int x) {
    this.activeCol = x;
  }

  @Override
  public void setActiveIndex(int x) {
    this.activeIndex = x;
  }

  @Override
  public void resetClues() {
    this.clues = new Integer[10][4];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 4; j++) {
        clues[i][j] = 0;
      }
    }
    notifyObservers();
  }

  @Override
  public void resetBoard() {
    this.board = new int[10][4];
  }


  public void addObserver(ModelObserver observer) {
    observerList.add(observer);
  }


  public void removeObserver(ModelObserver observer) {
    observerList.remove(observer);
  }

  public void notifyObservers() {
    for (ModelObserver o : observerList) {
      o.update(this);
    }
  }

  @Override
  public void setNextVal(int i) {
    if (activeIndex >= 0 && activeIndex < 4) {
      board[activeCol][activeIndex] = i;
      activeIndex++;
    }
    notifyObservers();
  }

  @Override
  public void deleteVal() {
    if (activeIndex > 0) {
      activeIndex--;
      board[activeCol][activeIndex] = 0;
    }
    notifyObservers();
  }

  @Override
  public void resetLine() {
    activeIndex = 0;
    for (int i = 0; i < 4; i++) {
      board[activeCol][activeIndex] = 0;
    }
    notifyObservers();
  }

  @Override
  public void submit() {
    if (activeIndex >= 4) {
      isSolved = true;
      for (int i = 0; i < 4; i++) {
        if (board[activeCol][i] != solution[i]) {
          isSolved = false;
          break;
        }
      }
      activeCol++;
      activeIndex = 0;
    }
    notifyObservers();

  }

  @Override
  public void assignClues() {
    if (activeIndex != 4) {
      return;
    }

    int[] tempSol = solution.clone();
    int y = 0;


    this.solCounter = new int[6];
    for (int i = 0; i < 4; i++) {
      solCounter[tempSol[i] -1]++;
    }

    this.codeCounter = new int[6];
    for (int i = 0; i < 4; i++) {
      codeCounter[board[activeCol][i] -1]++;
    }

    // Cycling through each val on line
    for (int i = 0; i < 4; i++) {

      // Checking to see if its already in right spot
      if (board[activeCol][i] == tempSol[i]) {
        // System.out.println("Found match at index: " + i);
        clues[activeCol][y] = 2;
        y++;
        solDecrement(board[activeCol][i]);
        tempSol[i] = 0;
        codeCounter[board[activeCol][i] - 1]--;
      } else {

        if ((codeCounter[board[activeCol][i] -1 ] == 1) && solCounter[board[activeCol][i] - 1] >= 1) {
          // System.out.println("First if: there is 1 of " + board[activeCol][i] + " in code and >= 1 of " + board[activeCol][i] + " in solution");
          clues[activeCol][y] = 1;
          y++;
          solDecrement(board[activeCol][i]);
          codeCounter[board[activeCol][i] - 1]--;
        } else if ((codeCounter[board[activeCol][i] -1 ] <= solCounter[board[activeCol][i] - 1]) && codeCounter[board[activeCol][i] - 1] > 0) {
          // System.out.println("there is less " + board[activeCol][i] + " in code than in solution and there is more than 0 of " + board[activeCol][i]);
          clues[activeCol][y] = 1;
          y++;
          solDecrement(board[activeCol][i]);
          codeCounter[board[activeCol][i] - 1]--;
        } else {
          // System.out.println("Else. Decrementing.");
          codeCounter[board[activeCol][i] -1]--;
        }
      }


    }

    // Rearranging the clue
    Arrays.sort(clues[activeCol], Collections.reverseOrder());

  }

  private void solDecrement(int x) {
    solCounter[x - 1]--;
  }

}
