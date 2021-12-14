
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

   // a  window to show the score board.
   // the code is copied from my javaFX project with some minor modifications.	
public class AlertBox {
	public static void display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(10);
		window.setTitle(title);
		
		Text l = new Text(message);
		Text t = new Text("A new a file (Hall of Fame.txt) with the next data \n has been created in your source folder.");
		
		
		Button b = new Button("OK");
		b.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.TOP_CENTER);
		layout.getChildren().addAll(t,l,b);
		
		
		Scene s = new Scene (layout, 300, 300);
		window.setScene(s);
		window.showAndWait();
	}
}
