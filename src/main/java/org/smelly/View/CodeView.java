package org.smelly.View;

import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.smelly.Controller.Controller;

public class CodeView implements FXComponent {

  private final Controller controller;

  public CodeView(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    } else {
      this.controller = controller;
    }
  }

  @Override
  public Parent render() {
    GridPane layout = new GridPane();

    layout.setVgap(5);
    layout.setHgap(5);

    for (int i = 0; i < 10; i++) {

      for (int j = 0; j < 4; j++) {

        StackPane stack = new StackPane();
        stack.getChildren().add(new Rectangle(30, 30, Color.DARKGRAY));

        if (controller.getValue(i, j) == 0) {
          layout.add(stack, j, i);
        } else if (controller.getValue(i, j) == 1) {
          Circle circle = new Circle(15, Color.BLUE);
          stack.getChildren().add(circle);
          layout.add(stack, j, i);
        } else if (controller.getValue(i, j) == 2) {
          Circle circle = new Circle(15, Color.GREEN);
          stack.getChildren().add(circle);
          layout.add(stack, j, i);
        } else if (controller.getValue(i, j) == 3) {
          Circle circle = new Circle(15, Color.ORANGE);
          stack.getChildren().add(circle);
          layout.add(stack, j, i);
        } else if (controller.getValue(i, j) == 4) {
          Circle circle = new Circle(15, Color.PURPLE);
          stack.getChildren().add(circle);
          layout.add(stack, j, i);
        } else if (controller.getValue(i, j) == 5) {
          Circle circle = new Circle(15, Color.RED);
          stack.getChildren().add(circle);
          layout.add(stack, j, i);
        } else {
          Circle circle = new Circle(15, Color.YELLOW);
          stack.getChildren().add(circle);
          layout.add(stack, j, i);
        }

      }

    }


    // Generation of Clues

    for (int i = 0; i < 10; i++) {



      GridPane clueGrid = new GridPane();

      int x = 0;
      int y = 0;
      for (int j = 0; j < 4; j++) {
        StackPane clueBox = new StackPane();

        Region cell = new Region();
        cell.setStyle("-fx-background-color: black, grey; -fx-background-insets: 0, 1; -fx-min-width: 20; -fx-min-height:20; -fx-max-width:20; -fx-max-height: 20;");
        clueBox.getChildren().add(cell);

        if (controller.getClueVal(i,j) == 1) {
          clueBox.getChildren().add(new Circle(7.5, Color.WHITE ));
        } else if (controller.getClueVal(i, j) == 2) {
          clueBox.getChildren().add(new Circle(7.5, Color.BLACK));
        }

        clueGrid.add(clueBox, x, y);


        if (x + 1 == 2) {
          x = 0;
          y = 1;
          continue;
        }
        x++;




      }

      layout.add(clueGrid, 4, i);

    }


    return layout;
  }
}
