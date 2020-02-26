package sample.SalesReport;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class SalesRep extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //root
        VBox root = new VBox();
        root.setPadding(new Insets(
                20, 20, 10, 0
        ));
        root.setSpacing(0);
        root.getStyleClass().add("root");
        //section1
        HBox section1 = new HBox();
        section1.setSpacing(10);
        section1.setPadding(new Insets(0, 0, 0, 20));
        StackPane curYear = new StackPane();
        curYear.setPadding(new Insets(10, 0, 10, 20));
        curYear.getStyleClass().add("first-stack");

        Label Q1 = new Label("1st Qtr");
        Label Q2 = new Label("2st Qtr");
        Label Q3 = new Label("3st Qtr");
        Label Q4 = new Label("4st Qtr");

        TextField txtCurrentQtr1 = new TextField("12000");
        txtCurrentQtr1.setMaxWidth(50);
        txtCurrentQtr1.setAlignment(Pos.BASELINE_RIGHT);
        TextField txtCurrentQtr2 = new TextField("14500");
        txtCurrentQtr2.setMaxWidth(50);
        txtCurrentQtr1.setAlignment(Pos.BASELINE_RIGHT);
        TextField txtCurrentQtr3 = new TextField("8500");
        txtCurrentQtr3.setMaxWidth(50);
        txtCurrentQtr3.setAlignment(Pos.BASELINE_RIGHT);
        TextField txtCurrentQtr4 = new TextField("16800");
        txtCurrentQtr4.setMaxWidth(50);
        txtCurrentQtr4.setAlignment(Pos.BASELINE_RIGHT);

        VBox qtr1 = new VBox();
        qtr1.setAlignment(Pos.TOP_RIGHT);
        VBox qtr2 = new VBox();
        qtr2.setAlignment(Pos.TOP_RIGHT);
        VBox qtr3 = new VBox();
        qtr3.setAlignment(Pos.TOP_RIGHT);
        VBox qtr4 = new VBox();
        qtr4.setAlignment(Pos.TOP_RIGHT);

        qtr1.getChildren().addAll(Q1, txtCurrentQtr1);
        qtr2.getChildren().addAll(Q2, txtCurrentQtr2);
        qtr3.getChildren().addAll(Q3, txtCurrentQtr3);
        qtr4.getChildren().addAll(Q4, txtCurrentQtr4);

        HBox qtrs = new HBox();
        qtrs.setSpacing(20);
        qtrs.getChildren().addAll(qtr1, qtr2, qtr3, qtr4);

        Label title1 = new Label("Current Year's Sales");
        Translate trans = new Translate();
        trans.setX(-100);
        trans.setY(-35);
        trans.setZ(20);
        title1.getTransforms().addAll(trans);
        title1.setAlignment(Pos.BASELINE_LEFT);
        title1.getStyleClass().add("title1");
        curYear.getChildren().addAll(title1, qtrs);

        Button but1 = new Button("Close");
        but1.getStyleClass().add("close-but");


        section1.getChildren().addAll(curYear, but1);

        //section2
        HBox section2 = new HBox();
        section2.setSpacing(10);
        section2.setPadding(new Insets(15, 0, 0, 20));
        StackPane preYear = new StackPane();
        preYear.setPadding(new Insets(10, 0, 10, 20));
        preYear.getStyleClass().add("sec-stack");

        Label Q1s = new Label("1st Qtr");
        Label Q2s = new Label("2st Qtr");
        Label Q3s = new Label("3st Qtr");
        Label Q4s = new Label("4st Qtr");

        TextField txtPreviousQtr1 = new TextField("10000");
        txtPreviousQtr1.setMaxWidth(50);
        txtPreviousQtr1.setAlignment(Pos.BASELINE_RIGHT);
        TextField txtPreviousQtr2 = new TextField("11000");
        txtPreviousQtr2.setMaxWidth(50);
        txtPreviousQtr2.setAlignment(Pos.BASELINE_RIGHT);
        TextField txtPreviousQtr3 = new TextField("12500");
        txtPreviousQtr3.setMaxWidth(50);
        txtPreviousQtr3.setAlignment(Pos.BASELINE_RIGHT);
        TextField txtPreviousQtr4 = new TextField("15800");
        txtPreviousQtr4.setMaxWidth(50);
        txtPreviousQtr4.setAlignment(Pos.BASELINE_RIGHT);

        VBox qtr1s = new VBox();
        qtr1s.setAlignment(Pos.TOP_RIGHT);
        VBox qtr2s = new VBox();
        qtr2s.setAlignment(Pos.TOP_RIGHT);
        VBox qtr3s = new VBox();
        qtr3s.setAlignment(Pos.TOP_RIGHT);
        VBox qtr4s = new VBox();
        qtr4s.setAlignment(Pos.TOP_RIGHT);

        qtr1s.getChildren().addAll(Q1s, txtPreviousQtr1);
        qtr2s.getChildren().addAll(Q2s, txtPreviousQtr2);
        qtr3s.getChildren().addAll(Q3s, txtPreviousQtr3);
        qtr4s.getChildren().addAll(Q4s, txtPreviousQtr4);

        HBox qtrs2 = new HBox();
        qtrs2.setSpacing(20);
        qtrs2.getChildren().addAll(qtr1s, qtr2s, qtr3s, qtr4s);

        Label title2 = new Label("Previous Year's Sales");
        title2.getTransforms().addAll(trans);
        title2.setAlignment(Pos.BASELINE_LEFT);
        title2.getStyleClass().add("title1");
        preYear.getChildren().addAll(title2, qtrs2);

        Button but2 = new Button("Generate");
        but2.getStyleClass().add("close-but");

        section2.getChildren().addAll(preYear, but2);
        //chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("");
        xAxis.setTickLabelsVisible(false);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("");
        yAxis.setTickLabelsVisible(false);
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.getStyleClass().add("chart");
        barChart.setVerticalGridLinesVisible(false);
        barChart.setHorizontalGridLinesVisible(false);

        XYChart.Series<String, Number> data1 = new XYChart.Series<>();
        data1.setName("");

        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        data2.setName("");

        but2.setOnAction(actionEvent -> {
            data2.getData().add(new XYChart.Data<>("1", Integer.parseInt(txtCurrentQtr1.getText())));
            data2.getData().add(new XYChart.Data<>("2", Integer.parseInt(txtCurrentQtr2.getText())));
            data2.getData().add(new XYChart.Data<>("3", Integer.parseInt(txtCurrentQtr3.getText())));
            data2.getData().add(new XYChart.Data<>("4", Integer.parseInt(txtCurrentQtr4.getText())));

            data1.getData().add(new XYChart.Data<>("1", Integer.parseInt(txtPreviousQtr1.getText())));
            data1.getData().add(new XYChart.Data<>("2", Integer.parseInt(txtPreviousQtr2.getText())));
            data1.getData().add(new XYChart.Data<>("3", Integer.parseInt(txtPreviousQtr3.getText())));
            data1.getData().add(new XYChart.Data<>("4", Integer.parseInt(txtPreviousQtr4.getText())));

            barChart.getData().add(data2);
            barChart.getData().add(data1);
        });
        barChart.setLegendVisible(false);
        HBox chart = new HBox();
        chart.getChildren().add(barChart);
        VBox leg = new VBox();
        leg.setSpacing(0);
        leg.setPadding(new Insets(30, 0, 0, 0));
        leg.setAlignment(Pos.BASELINE_CENTER);
        Label legend = new Label("Legend");
        legend.setStyle("-fx-translate-y: -18px;-fx-background-color: #d3cfc9;");
        Separator lege = new Separator();
        lege.getStyleClass().add("sepa");
        Label thisY = new Label("  This Year's Sales");
        Label lastY = new Label("  Last Year's Sales");
        lastY.setPadding(new Insets(15, 0, 0, 0));
        Rectangle red = new Rectangle(0, 0, 20, 20);
        red.getStyleClass().add("red-rec");
        Rectangle blue = new Rectangle(0, 0, 20, 20);
        blue.getStyleClass().add("blue-rec");
        leg.getChildren().addAll(lege, legend, thisY, lastY, red, blue);
        chart.getChildren().add(leg);

        root.getChildren().addAll(section1, section2, chart);

        but1.setOnAction(actionEvent -> {
            primaryStage.close();
        });

        primaryStage.setTitle("Company Sales Annual Report");
        Scene scene = new Scene(root, 520, 420);
        scene.getStylesheets().add(getClass().getResource("sales.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
