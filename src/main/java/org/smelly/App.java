package org.smelly;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.smelly.Controller.Controller;
import org.smelly.Controller.ControllerImpl;
import org.smelly.Model.Model;
import org.smelly.Model.ModelImpl;
import org.smelly.View.View;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        // Model

        ModelImpl model = new ModelImpl();

        // Controller
        Controller controller = new ControllerImpl(model);

        // View
        View view = new View(controller);

        // Scene
        Scene scene = new Scene(view.render());

        stage.setScene(scene);

        model.addObserver(
            (Model m) -> {
                scene.setRoot(view.render());
                stage.sizeToScene();
            }
        );

        stage.setTitle("Mastermind!");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}