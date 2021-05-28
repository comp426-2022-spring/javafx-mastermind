package org.smelly.Controller;

import org.smelly.Model.Model;

public class ControllerImpl implements Controller {

  private final Model model;

  public ControllerImpl(Model model) {
    if (model == null) {
      throw new IllegalArgumentException();
    } else {
      this.model = model;
    }
  }

  @Override
  public int[][] getBoard() {
    return model.getBoard();
  }

  @Override
  public int getActiveCol() {
    return model.getActiveCol();
  }

  @Override
  public int getActiveIndex() {
    return model.getActiveIndex();
  }

  @Override
  public boolean getIsSolved() {
    return model.getIsSolved();
  }

  @Override
  public int getValue(int col, int row) {
    return model.getValue(col, row);
  }

  @Override
  public int getClueVal(int col, int row) {
    return model.getClueVal(col, row);
  }

  @Override
  public void setVal(int x) {
    model.setVal(x);
  }

  @Override
  public void newSolution() {
    model.newSolution();
  }

  @Override
  public void setActiveCol(int x) {
    model.setActiveCol(x);
  }

  @Override
  public void setActiveIndex(int x) {
    model.setActiveIndex(x);
  }

  @Override
  public void resetClues() {
    model.resetClues();
  }

  @Override
  public void resetBoard() {
    model.resetBoard();
  }

  @Override
  public void setNextVal(int i) {
    model.setNextVal(i);
  }

  @Override
  public void deleteVal() {
    model.deleteVal();
  }

  @Override
  public void resetLine() {
    model.resetLine();
  }

  @Override
  public void submit() {
    model.assignClues();
    model.submit();
  }

  @Override
  public void generateNewPuzzle() {
    model.setActiveCol(0);
    model.setActiveIndex(0);
    model.resetClues();
    model.resetBoard();
    model.newSolution();
  }


}
