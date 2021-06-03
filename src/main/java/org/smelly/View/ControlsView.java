package org.smelly.View;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import org.smelly.Controller.Controller;

public class ControlsView implements FXComponent {

  private final Controller controller;

  public ControlsView(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    } else {
      this.controller = controller;
    }
  }

  @Override
  public Parent render() {

    VBox colors = new VBox(6);
    colors.setAlignment(Pos.CENTER);
    Circle color1 = new Circle(15, Color.BLUE);
    color1.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(1);
        }
    );
    colors.getChildren().add(color1);

    Circle color2 = new Circle(15, Color.GREEN);
    color2.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(2);
        }
    );
    colors.getChildren().add(color2);

    Circle color3 = new Circle(15, Color.ORANGE);
    color3.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(3);
        }
    );
    colors.getChildren().add(color3);

    Circle color4 = new Circle(15, Color.PURPLE);
    color4.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(4);
        }
    );
    colors.getChildren().add(color4);

    Circle color5 = new Circle(15, Color.RED);
    color5.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(5);
        }
    );
    colors.getChildren().add(color5);

    Circle color6 = new Circle(15, Color.VIOLET);
    color6.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(6);
        }
    );
    colors.getChildren().add(color6);

    return colors;
  }
}
