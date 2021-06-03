package org.smelly.View;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import org.smelly.Controller.Controller;

public class ButtonsView implements FXComponent {

  private final Controller controller;

  public ButtonsView(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    } else {
      this.controller = controller;
    }
  }

  @Override
  public Parent render() {
    HBox buttons = new HBox(3);
    buttons.setAlignment(Pos.CENTER);
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
    return buttons;
  }
}
