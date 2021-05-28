package org.smelly.View;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import org.smelly.Controller.Controller;

public class View implements FXComponent {

  private final Controller controller;

  public View(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    }
    this.controller = controller;
  }

  @Override
  public Parent render() {
    BorderPane layout = new BorderPane();

    layout.setStyle("-fx-background-color: #FFF1F8");

    if (controller.getIsSolved()) {
      ChickenDinnerView winner = new ChickenDinnerView(controller);
      layout.setCenter(winner.render());
      return layout;
    }

    CodeView codeView = new CodeView(controller);
    layout.setCenter(codeView.render());

    ControlsView controlsView = new ControlsView(controller);
    layout.setLeft(controlsView.render());



    return layout;
  }
}
