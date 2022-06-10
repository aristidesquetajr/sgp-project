package undefined;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import com.sgp.controllers.LoginController;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RecoverPasswordController extends WindowControllerFx {

    @FXML private AnchorPane rootPane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //makeFadeIn(rootPane);
    }

    @Override
    public String getFXML() {
        return "/com/sgp/views/RecoverPassword.fxml";
    }

    @FXML
    private void backLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(new LoginController().getFXML()));
            Scene scene = rootPane.getScene();
            scene.setFill(Color.TRANSPARENT);

            root.translateXProperty().set(scene.getWidth());
            rootPane.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeline.getKeyFrames().add(kf);

            timeline.setOnFinished(event2 -> {
                rootPane.getChildren().remove(rootPane.getChildren().get(0));
            });
            timeline.play();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
