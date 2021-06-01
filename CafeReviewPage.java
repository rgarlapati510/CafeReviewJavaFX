//I worked on the homework assignment alone, using only course materials.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;


/**
 * Creates a Javafx program that allows
 * user to post reviews.
 * @author Ruthvika Garlapati
 * @version 1.0
 */
public class CafeReviewPage extends Application {
    /** Main method that launches Javafx program.
    * @param args arguments
    */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("coffeehouse.png"));
        primaryStage.setTitle("Cafe1331 Reviews");
        VBox center = new VBox();
        VBox right = new VBox();
        center.setPadding(new Insets(20));
        center.setSpacing(2);
        right.setPadding(new Insets(20));
        right.setSpacing(20);
        BorderPane pane = new BorderPane();
        pane.setCenter(center);
        pane.setRight(right);
        center.setAlignment(Pos.TOP_LEFT);
        right.setAlignment(Pos.TOP_CENTER);
        center.setMinWidth(450);
        center.setMinHeight(450);

        //Setting background for text display box
        FileInputStream input = new FileInputStream("background_image.jpg");
        Image background = new Image(input);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
                                        BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background back = new Background(backgroundImage);
        center.setBackground(back);

        //Setting background fill for text input controls
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background complimentary = new Background(backgroundFill);
        right.setBackground(complimentary);

        //Adding Title for Center Pane
        Text reviewsTitle = new Text("Reviews");
        reviewsTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        center.getChildren().add(reviewsTitle);

        //Creating TextFields, labels, and buttons
        TextField name = new TextField();
        TextField comment = new TextField();
        TextField color = new TextField();
        TextField rate = new TextField();
        rate.setMaxWidth(30);
        Label rating = new Label("Rate the Cafe from 1-5: ");
        name.setPromptText("Name");
        comment.setPromptText("Feedback");
        color.setPromptText("Color");
        Label visitAgain = new Label("Would you visit the cafe again?");
        RadioButton yes = new RadioButton();
        RadioButton no = new RadioButton();
        no.setText("No");
        yes.setText("Yes");
        right.getChildren().addAll(name, comment, color, rating, rate, visitAgain, yes, no);

        //Action on button
        Button post = new Button("Post");
        right.getChildren().add(post);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String nameEntered = name.getText();
                String commentEntered = comment.getText();
                String colorEntered = color.getText().toLowerCase();
                String rateEntered = rate.getText();
                if (!commentEntered.equals("")) {
                    center.getChildren().add(new Text(""));
                    if (nameEntered.equals("")) {
                        Text a = new Text("Anonymous: ");
                        a.setStyle("-fx-fill: " + colorEntered + ";" + "-fx-font-size: 14px;");
                        center.getChildren().add(a);
                    } else {
                        Text a = new Text(nameEntered + ":");
                        a.setStyle("-fx-fill: " + colorEntered + ";" + " -fx-font-size: 14px;");
                        center.getChildren().add(a);
                    }
                    if (rateEntered.equals("")) {
                        Text a = new Text("0.0/5");
                        a.setStyle("-fx-fill: " + colorEntered + ";" + "-fx-font-size: 14px;");
                        center.getChildren().add(a);
                    } else {
                        Text a = new Text(rateEntered + "/5");
                        a.setStyle("-fx-fill: " + colorEntered + ";" + " -fx-font-size: 14px;");
                        center.getChildren().add(a);
                    }
                    if (yes.isSelected()) {
                        Text a = new Text("I would visit again!");
                        a.setStyle("-fx-fill: " + colorEntered + ";" + " -fx-font-size: 14px;");
                        center.getChildren().add(a);
                    } else if (no.isSelected()) {
                        Text a = new Text("This cafe is not for me");
                        a.setStyle("-fx-fill: " + colorEntered + ";" + " -fx-font-size: 14px;");
                        center.getChildren().add(a);
                    }
                    Text a = new Text(commentEntered);
                    a.setStyle("-fx-fill: " + colorEntered + ";" + "-fx-font-size: 14px;");
                    center.getChildren().add(a);
                }
                name.clear();
                comment.clear();
                color.clear();
                rate.clear();
                yes.setSelected(false);
                no.setSelected(false);

            }
        };
        post.setOnAction(event);
        name.setOnAction(event);
        comment.setOnAction(event);
        color.setOnAction(event);



        //Adding layout to scene and picking size of default window
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}