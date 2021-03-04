import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Main instance;

    private Stage activeStage;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML/MainMenu.fxml"));
        primaryStage.setTitle("Rock Paper Scissor");
        primaryStage.setScene(new Scene(root));

        this.primaryStage = primaryStage;
        activeStage = primaryStage;
        primaryStage.show();
    }

    /**
     * Get the current active stage.
     *
     * @return
     */
    public Stage getActiveStage() {
        return activeStage;
    }

    /**
     * Change the current stage to the specified fxml.
     *
     * @param fxml The fxml name of the replacement stage.
     * @return Returns the stage's controller.
     * @throws Exception Any exceptions.
     */
    public <T> T changeStage(String fxml, String title) throws Exception {
        var loader = new FXMLLoader(getClass().getResource(fxml));
        Parent page = loader.load();
        if (getActiveStage() != null) {
            Scene scene = getActiveStage().getScene();
            if (scene == null) {
                scene = new Scene(page);
                getActiveStage().setScene(scene);
            } else {
                getActiveStage().getScene().setRoot(page);
            }

            getActiveStage().setScene(scene);
            getActiveStage().setTitle(title);
            getActiveStage().centerOnScreen();
            //System.out.println(String.format("Changing stage to: %s", getActiveStage()));
        }
        return loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Main getInstance() {
        return instance;
    }
}
