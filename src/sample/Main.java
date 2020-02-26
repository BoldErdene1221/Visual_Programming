package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //root
            VBox root = new VBox();
            root.setPadding(new Insets(
                    20, 20, 0, 30
            ));
            root.getStyleClass().add("root");
            //section1
            HBox section1 = new HBox();
            section1.setPadding(new Insets(0, 50, 10, 0));
            section1.setSpacing(40);

            Label text1 = new Label("Marked Price: ");
            TextField tf1 = new TextField("0");
            tf1.setAlignment(Pos.CENTER_RIGHT);
            tf1.setMaxWidth(100);

            section1.getChildren().add(text1);
            section1.getChildren().add(tf1);
            //section2
            HBox section2 = new HBox();
            section2.setPadding(new Insets(0, 0, 20, 0));
            section2.setSpacing(3);

            HBox sec1 = new HBox();
            sec1.setSpacing(65);
            Label text2 = new Label("Tax Rate: ");
            TextField tf2 = new TextField("0");
            tf2.setAlignment(Pos.CENTER_RIGHT);
            tf2.setMaxWidth(100);

            HBox sec2 = new HBox();
            sec2.setSpacing(10);
            sec2.setAlignment(Pos.BASELINE_CENTER);
            Label symbol = new Label("%");
            Button calc = new Button("Calculate");
            calc.getStyleClass().add("first-button");

            sec1.getChildren().addAll(text2, tf2);
            sec2.getChildren().addAll(symbol, calc);
            section2.getChildren().addAll(sec1, sec2);

            //section3
            HBox section3 = new HBox();
            section3.setPadding(new Insets(20, 50, 10, 0));
            section3.setSpacing(45);
            section3.setAlignment(Pos.BOTTOM_LEFT);
            section3.getStyleClass().add("section3");

            Label text3 = new Label("Tax Amount: ");
            TextField tf3 = new TextField("$0");
            tf3.setAlignment(Pos.CENTER_RIGHT);
            tf3.setDisable(true);
            tf3.setMaxWidth(100);

            section3.getChildren().add(text3);
            section3.getChildren().add(tf3);
            //section4
            HBox section4 = new HBox();
            section4.setPadding(new Insets(0, 0, 0, 0));
            section4.setSpacing(20);
            section4.setAlignment(Pos.BOTTOM_LEFT);

            HBox sec3 = new HBox();
            sec3.setSpacing(65);
            Label text4 = new Label("Net Price:");
            TextField tf4 = new TextField("$0");
            tf4.setAlignment(Pos.CENTER_RIGHT);
            tf4.setDisable(true);
            tf4.setMaxWidth(100);

            HBox sec4 = new HBox();
            sec4.setSpacing(10);
            Button close = new Button("Close");
            close.setMaxWidth(100);
            close.getStyleClass().add("first-button");

            sec3.getChildren().addAll(text4, tf4);
            sec4.getChildren().addAll(close);
            section4.getChildren().addAll(sec3, sec4);

            root.getChildren().addAll(section1, section2, section3, section4);

            calc.setOnAction(event -> {
                double mPrice = Double.parseDouble(tf1.getText());
                double taxRate = Double.parseDouble(tf2.getText());
                double taxAmount, netPrice;
                taxAmount = mPrice / taxRate;
                tf3.setText("$" + new DecimalFormat("##.##").format(taxAmount));
                netPrice = mPrice + taxAmount;
                tf4.setText("$" + new DecimalFormat("##.##").format(netPrice));
            });

            close.setOnAction(event -> {
                primaryStage.close();
            });

            primaryStage.setTitle("Net Price Calculation");
            Scene scene = new Scene(root, 360, 200);
            scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
