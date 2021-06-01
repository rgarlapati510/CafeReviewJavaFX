//I worked on the homework assignment alone, using only course materials.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class CafeReviewPageTrial extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	primaryStage.getIcons().add(new Image("coffeehouse.png"));
        primaryStage.setTitle("Cafe1331 Reviews");
		HBox hbox = new HBox();
        VBox vbox = new VBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(30);
        vbox.setPadding(new Insets(30));
        Text title = new Text("Reviews");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        FileInputStream input = new FileInputStream("background_image.jpg");
        Image background = new Image(input);

        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, 
        								BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background back = new Background(backgroundImage);

        vbox.setBackground(back);

        TilePane r = new TilePane();
        ColorPicker cp = new ColorPicker();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent> () {
        	public void handle(ActionEvent e) {
        		Color c = cp.getValue();
        	}
        };

        Label l = new Label("No Reviews Yet");
        Label n = new Label ("Anonymous");

        cp.setOnAction(event);

        TextField comment = new TextField();
        TextField name = new TextField();
        hbox.getChildren().add(name);
        hbox.getChildren().add(comment);


        Button post = new Button("Post");
        hbox.getChildren().add(post);
        post.setOnAction(new EventHandler<ActionEvent> () {
        	@Override public void handle (ActionEvent e) {
        		l.setText(comment.getText());
        		n.setText(name.getText());
        	}
        });

        BorderPane pane = new BorderPane();
        comment.setOnAction(event);
        name.setOnAction(event);
        vbox.getChildren().add(n);
        vbox.getChildren().add(l);
        pane.setCenter(vbox);
        vbox.setAlignment(Pos.TOP_LEFT);
        pane.setBottom(hbox);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        // vbox.getChildren().addAll(hbox);


        Scene scene = new Scene(pane, 1120, 600);



        primaryStage.setScene(scene);
        primaryStage.show();

	}
}
