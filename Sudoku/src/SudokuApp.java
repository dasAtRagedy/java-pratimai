import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SudokuApp extends Application {
    private IUserInterfaceContract.View uiImpl;


    @Override
    public static void start(Stage primaryStage) throws Exception{
        uiImpl = UserInterfaceImpl(primaryStage);
        try SudokuBuildLogic

    }


    public static void main(String[] args) {
        launch(args);
    }
}
