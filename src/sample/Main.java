package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
//          Main scene
            VBox root = new VBox();
            root.setPadding(new Insets(0, 30, 0, 30));
            root.getStyleClass().add("root");
//          First Section
            TilePane firstSection = new TilePane();
            firstSection.setPadding(new Insets(20, 0, 30, 0));
            Label text = new Label("MotorBee must be installed \nusing this button before any \ncontrols below are used");
            text.setFont(Font.font("TimesRoman", FontPosture.REGULAR, 12));
            Button but = new Button("Initialise");
            but.getStyleClass().add("first-button");
            firstSection.setAlignment(Pos.BASELINE_CENTER);
            firstSection.getChildren().add(text);
            firstSection.getChildren().add(but);
            root.getChildren().add(firstSection);

            StackPane smalltitlePane = new StackPane();
            Text smalltitle = new Text("GroupBox");
            smalltitlePane.getStyleClass().add("small-title");
            smalltitlePane.setAlignment(Pos.BASELINE_LEFT);
            smalltitlePane.setPadding(new Insets(0,0,0,0));
            smalltitlePane.getChildren().add(smalltitle);

            Translate trans = new Translate();
            trans.setX(-150);
            trans.setY(-10);
            trans.setZ(100);
            smalltitlePane.getTransforms().addAll(trans);

//          Second Section
            StackPane secondSec = new StackPane();
            secondSec.setPadding(new Insets(0, 10, 10, 30));
//            secondSec.setSpacing(10);
            secondSec.getStyleClass().add("second-section");
            HBox secondSection1 = new HBox();
            secondSection1.setPadding(new Insets(10, 0, 0, 0));
            Text sp1 = new Text("Speed 1");
            TextField tf1 = new TextField("25");
            tf1.setMaxWidth(50);
            CheckBox on1 = new CheckBox("On1");
            on1.setSelected(true);
            CheckBox op1 = new CheckBox("Dig OP1");
            secondSection1.setSpacing(30);
            secondSection1.getChildren().addAll(sp1, tf1, on1, op1);

            HBox secondSection2 = new HBox();
            secondSection2.setPadding(new Insets(45, 0, 0, 0));
            Text sp2 = new Text("Speed 2");
            TextField tf2 = new TextField("150");
            tf2.setMaxWidth(50);
            CheckBox on2 = new CheckBox("On2");
            on2.setSelected(true);
            CheckBox op2 = new CheckBox("Dig OP2");
            op2.setSelected(true);
            secondSection2.setSpacing(30);
            secondSection2.getChildren().addAll(sp2, tf2, on2, op2);

            HBox secondSection3 = new HBox();
            secondSection3.setPadding(new Insets(80, 0, 0, 0));
            Text sp3 = new Text("Speed 3");
            TextField tf3 = new TextField("80");
            tf3.setMaxWidth(50);
            CheckBox on3 = new CheckBox("On3");
            on3.setSelected(true);
            CheckBox op3 = new CheckBox("Dig OP3");
            secondSection3.setSpacing(30);
            secondSection3.getChildren().addAll(sp3, tf3, on3, op3);

            HBox secondSection4 = new HBox();
            secondSection4.setPadding(new Insets(115, 0, 0, 0));
            Text sp4 = new Text("Speed 4");
            TextField tf4 = new TextField("210");
            tf4.setMaxWidth(50);
            CheckBox on4 = new CheckBox("On4");
            CheckBox op4 = new CheckBox("Dig OP4");
            on4.setSelected(true);
            op4.setSelected(true);
            secondSection4.setSpacing(30);
            secondSection4.getChildren().addAll(sp4, tf4, on4, op4);

            HBox secondSection5 = new HBox();
            secondSection5.setPadding(new Insets(150, 0, 0, 0));
            Text sp5 = new Text("Servo");
            TextField tf5 = new TextField("128");
            tf5.setMaxWidth(50);
            secondSection5.setSpacing(42);
            secondSection5.getChildren().addAll(sp5, tf5);
            secondSec.getChildren().addAll(smalltitlePane,secondSection1, secondSection2, secondSection3, secondSection4, secondSection5);


            GridPane sendB = new GridPane();
            sendB.setPadding(new Insets(20, 0, 10, 0));
            Button send = new Button("Send Settings");
            send.getStyleClass().add("second-but");
            sendB.setAlignment(Pos.BASELINE_CENTER);
            sendB.getChildren().add(send);

            root.getChildren().add(secondSec);
            root.getChildren().add(sendB);

//          Third section
            TilePane smalltitlePane1 = new TilePane();
            Text smalltitle1 = new Text("Inputs");
            smalltitle1.setTextAlignment(TextAlignment.CENTER);
            smalltitlePane1.getChildren().add(smalltitle1);

            Translate trans1 = new Translate();
            trans1.setX(10);
            trans1.setY(-10);
            trans1.setZ(100);
            smalltitlePane1.getTransforms().addAll(trans1);
            smalltitlePane1.getStyleClass().add("small-title1");

            VBox thirdSection = new VBox();
            thirdSection.getStyleClass().add("third-section");

            HBox thirdH1 = new HBox();
            thirdH1.setPadding(new Insets(0, 50, 10, 50));
            thirdH1.setSpacing(50);
            thirdH1.setAlignment(Pos.BASELINE_CENTER);
            CheckBox ip1 = new CheckBox("Dig IP1");
            CheckBox ip4 = new CheckBox("Dig IP4");
            ip4.setSelected(true);
            thirdH1.getChildren().addAll(ip1, ip4);

            HBox thirdH2 = new HBox();
            thirdH2.setPadding(new Insets(0, 50, 10, 50));
            thirdH2.setSpacing(50);
            thirdH2.setAlignment(Pos.BASELINE_CENTER);
            CheckBox ip2 = new CheckBox("Dig IP2");
            ip2.setSelected(true);
            CheckBox ip5 = new CheckBox("Dig IP5");
            thirdH2.getChildren().addAll(ip2, ip5);

            HBox thirdH3 = new HBox();
            thirdH3.setPadding(new Insets(0, 50, 10, 50));
            thirdH3.setSpacing(50);
            thirdH3.setAlignment(Pos.BASELINE_CENTER);
            CheckBox ip3 = new CheckBox("Dig IP3");
            ip3.setSelected(true);
            CheckBox ip6 = new CheckBox("Dig IP6");
            thirdH3.getChildren().addAll(ip3, ip6);

            thirdSection.getChildren().addAll(smalltitlePane1,thirdH1, thirdH2, thirdH3);

            root.getChildren().add(thirdSection);
            primaryStage.setTitle("Form1");
            Scene scene = new Scene(root, 420, 520);
            scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
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