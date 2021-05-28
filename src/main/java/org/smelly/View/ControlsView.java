package org.smelly.View;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

    VBox layout = new VBox(3);
    layout.getChildren().add(new Label("Controls"));

    HBox colors = new HBox(6);
    Circle color1 = new Circle(7.5, Color.BLUE);
    color1.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(1);
        }
    );
    colors.getChildren().add(color1);

    Circle color2 = new Circle(7.5, Color.GREEN);
    color2.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(2);
        }
    );
    colors.getChildren().add(color2);

    Circle color3 = new Circle(7.5, Color.ORANGE);
    color3.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(3);
        }
    );
    colors.getChildren().add(color3);

    Circle color4 = new Circle(7.5, Color.PURPLE);
    color4.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(4);
        }
    );
    colors.getChildren().add(color4);

    Circle color5 = new Circle(7.5, Color.RED);
    color5.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(5);
        }
    );
    colors.getChildren().add(color5);

    Circle color6 = new Circle(7.5, Color.YELLOW);
    color6.setOnMouseClicked(
        (event) -> {
          controller.setNextVal(6);
        }
    );
    colors.getChildren().add(color6);

    layout.getChildren().add(colors);

    HBox buttons = new HBox(3);
    Button reset = new Button("New Game");
    reset.setOnAction(
        (ActionEvent event) -> {
          controller.generateNewPuzzle();
        }
    );
    buttons.getChildren().add(reset);
    Button back = new Button("Delete");
    back.setOnAction(
        (ActionEvent event) -> {
          controller.deleteVal();
        }
    );
    buttons.getChildren().add(back);
    Button submit = new Button("Submit");
    submit.setOnAction(
        (ActionEvent event) -> {
          controller.submit();
        });
    buttons.getChildren().add(submit);

    layout.getChildren().add(buttons);


    return layout;
  }
}
