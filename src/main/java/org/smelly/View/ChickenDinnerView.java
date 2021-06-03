package org.smelly.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import org.smelly.Controller.Controller;

public class ChickenDinnerView implements FXComponent {

  private final Controller controller;

  public ChickenDinnerView(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    } else {
      this.controller = controller;
    }
  }

  @Override
  public Parent render() {

    BorderPane layout = new BorderPane();
    layout.setStyle("-fx-background-color: #9dcfaa");
    Button proceed = new Button("Continue?");
    proceed.setAlignment(Pos.CENTER);

    proceed.setOnMouseClicked(
        (event) -> {
          controller.generateNewPuzzle();
        }
    );

    proceed.setFont(new Font(20));

    layout.setCenter(proceed);

    VBox solutionVBox = new VBox(2);

    GridPane solution = new GridPane();

    for (int i = 0; i < 4; i++) {


      StackPane stack = new StackPane();
      stack.getChildren().add(new Rectangle(30, 30, Color.DARKGRAY));

      if (controller.getSolution()[i] == 0) {
        solution.add(stack, i, 0);
      } else if (controller.getSolution()[i] == 1) {
        Circle circle = new Circle(15, Color.BLUE);
        stack.getChildren().add(circle);
        solution.add(stack, i, 0);
      } else if (controller.getSolution()[i] == 2) {
        Circle circle = new Circle(15, Color.GREEN);
        stack.getChildren().add(circle);
        solution.add(stack, i, 0);
      } else if (controller.getSolution()[i] == 3) {
        Circle circle = new Circle(15, Color.ORANGE);
        stack.getChildren().add(circle);
        solution.add(stack, i, 0);
      } else if (controller.getSolution()[i] == 4) {
        Circle circle = new Circle(15, Color.PURPLE);
        stack.getChildren().add(circle);
        solution.add(stack, i, 0);
      } else if (controller.getSolution()[i] == 5) {
        Circle circle = new Circle(15, Color.RED);
        stack.getChildren().add(circle);
        solution.add(stack, i, 0);
      } else {
        Circle circle = new Circle(15, Color.VIOLET);
        stack.getChildren().add(circle);
        solution.add(stack, i, 0);
      }
    }

    solution.setAlignment(Pos.CENTER);
    solution.setVgap(5);
    solution.setHgap(5);

    Insets insets = new Insets(10);

    Label solutionLabel = new Label("Solution:");
    solutionLabel.setFont(new Font(18.6));
    solutionVBox.getChildren().add(solutionLabel);
    solutionVBox.getChildren().add(solution);
    solutionVBox.setAlignment(Pos.CENTER);

    layout.setBottom(solutionVBox);
    BorderPane.setMargin(solutionVBox, insets);

    Label label = new Label("Congratulations! You've Won!");
    label.setFont(new Font(18.6));

    layout.setTop(label);


    return layout;
  }
}
