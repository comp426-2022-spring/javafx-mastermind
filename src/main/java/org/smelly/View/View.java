package org.smelly.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
    Insets insets = new Insets(10);

    if (controller.getIsSolved()) {
      ChickenDinnerView winner = new ChickenDinnerView(controller);
      layout.setCenter(winner.render());
      return layout;
    }

    CodeView codeView = new CodeView(controller);
    Node codeViewNode = codeView.render();
    layout.setCenter(codeViewNode);

    ControlsView controlsView = new ControlsView(controller);
    Node controlViewNode = controlsView.render();
    layout.setLeft(controlViewNode);
    BorderPane.setMargin(controlViewNode, insets);


    ButtonsView buttonsView = new ButtonsView(controller);
    Node buttonsViewNode = buttonsView.render();
    layout.setTop(buttonsViewNode);
    BorderPane.setMargin(buttonsViewNode, insets);


    RightActiveView rightActiveView = new RightActiveView(controller);
    Node rightActiveViewNode = rightActiveView.render();
    layout.setRight(rightActiveViewNode);


    return layout;
  }
}
