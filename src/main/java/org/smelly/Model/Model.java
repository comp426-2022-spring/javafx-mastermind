package org.smelly.Model;

public interface Model {

  /** Constructor should call generateNewPuzzle */

  /** Getter methods */
  int[][] getBoard();

  int getActiveCol();

  int getActiveIndex();

  boolean getIsSolved();

  int getValue(int col, int index);

  int getClueVal(int col, int index);

  /** Setter method */
  void setVal(int x);

  void newSolution();

  void setActiveCol(int x);

  void setActiveIndex(int x);

  void resetClues();

  void resetBoard();

  void setNextVal(int i);

  /** Deletes the most recent value set. If ActiveIndex == 0, then it does nothing but does not throw an exception */
  void deleteVal();

  /** Deletes the entire line. If ActiveIndex == 0, then it does nothing but does not throw an exception */
  void resetLine();

  /** Submits that line's code, assuming it has filled all of the code slots. If the code is correct than isSolved is true. */
  void submit();

  /** Populates the array corresponding with activeCol, with 1 = Right color wrong spot, 2 = Right Color right spot */
  void assignClues();

}
