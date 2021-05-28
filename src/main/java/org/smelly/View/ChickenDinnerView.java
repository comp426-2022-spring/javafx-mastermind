package org.smelly.View;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    Button proceed = new Button("Continue?");

    proceed.setOnMouseClicked(
        (event) -> {
          controller.generateNewPuzzle();
        }
    );

    StackPane stack = new StackPane();
    Rectangle outer = new Rectangle(300, 300, Color.INDIANRED);
    Rectangle mid = new Rectangle(200, 200, Color.LIGHTCORAL);
    Rectangle inner = new Rectangle(100, 100, Color.LIGHTSALMON);
    Label label = new Label("Congratulations!\nYou've Won!");
    label.setFont(new Font(20.00));
    stack.getChildren().add(outer);
    stack.getChildren().add(mid);
    stack.getChildren().add(inner);
    stack.getChildren().add(label);

    layout.setTop(proceed);
    layout.setCenter(stack);

    return layout;
  }
}
