package org.smelly.View;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.smelly.Controller.Controller;

public class RightActiveView implements FXComponent {

  private final Controller controller;

  public RightActiveView(Controller controller) {
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
      Rectangle rectangle = new Rectangle(20, 40);
      if (i == controller.getActiveCol()) {
        rectangle.setFill(Color.LIGHTGREEN);
      } else {
        rectangle.setFill(Color.INDIANRED);
      }
      layout.add(rectangle, 0, i);
    }
    return layout;
  }
}
