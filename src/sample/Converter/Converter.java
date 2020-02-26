package sample.Converter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Converter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane root = new GridPane();
            root.setPadding(new Insets(10, 10, 10, 10));
            root.setHgap(8);
            root.setVgap(8);

            Label title = new Label("Celsius to Fahrenheit");
            title.setStyle("-fx-text-fill: green;-fx-font-size: 40;-fx-font-weight: 800;");
            root.getChildren().add(title);

            HBox buttons = new HBox();
            buttons.setSpacing(112);
            GridPane.setConstraints(buttons, 0, 6);

            Button btn = new Button("Calculate");

            Button btn1 = new Button("Refresh");

            Button btn2 = new Button("Close");


            buttons.getChildren().addAll(btn,btn1,btn2);

            Label input = new Label("Input:");
            GridPane.setConstraints(input,0,3);

            Label output = new Label("Output:");
            GridPane.setConstraints(output,0,1);

            TextField resultInput = new TextField("0");
            GridPane.setConstraints(resultInput, 0, 4);

            TextField resultOutput = new TextField("0");
            resultOutput.setDisable(true);
            GridPane.setConstraints(resultOutput, 0, 2);

            ToggleGroup radioButtons = new ToggleGroup();

            HBox options = new HBox();
            options.setAlignment(Pos.BASELINE_CENTER);
            options.setSpacing(30);
            GridPane.setConstraints(options,0,5);

            RadioButton celsius = new RadioButton("Celsius");
            celsius.setSelected(true);
            celsius.setToggleGroup(radioButtons);

            RadioButton fahrenheit = new RadioButton("Fahrenheit");
            fahrenheit.setToggleGroup(radioButtons);

            options.getChildren().addAll(celsius,fahrenheit);

            btn.setOnAction(event -> {
                double toNum = Double.parseDouble(resultInput.getText());
                if (celsius.isSelected()) {
                    double celsiusResult = (toNum - 32) * 5 / 9;
                    resultOutput.setText(new DecimalFormat("##.##").format(celsiusResult) + " C");
                } else {
                    double fahrenheitResult = toNum * 1.8 + 32;
                    resultOutput.setText(new DecimalFormat("##.##").format(fahrenheitResult) + " F");
                }
            });

            btn1.setOnAction(event -> {
                    resultOutput.setText("0");
                    resultInput.setText("0");
            });
            btn2.setOnAction(event -> {
                    primaryStage.close();
            });
            root.getChildren().addAll(options, resultOutput, resultInput, input,output,buttons);

            primaryStage.setTitle("Converter");
            Scene scene = new Scene(root, 415, 250);
            scene.getStylesheets().add(getClass().getResource("converter.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
