
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

	// code copied from my JavaFx project
// class to display a confirm box when user ask to leave the game.
public class ConfirmBox {
	static boolean ans;
	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(250);
		window.setTitle(title);
		
		Label l = new Label(message);
		Button b1 = new Button("Yes");
		Button b2 = new Button("No");
		b1.setOnAction(e -> {
		ans = true;
		window.close();
		});
		b2.setOnAction(e -> {
			ans = false;
			window.close();
			});
		VBox mainLayout = new VBox(20);
		HBox layout = new HBox(20);
		layout.getChildren().addAll(b1,b2);
		mainLayout.getChildren().addAll(l,layout);
		mainLayout.setAlignment(Pos.BASELINE_CENTER);
		layout.setAlignment(Pos.BASELINE_CENTER);
		
		Scene s = new Scene (mainLayout, 300, 100);
		window.setScene(s);
		window.showAndWait();
		return ans;
	}
}
