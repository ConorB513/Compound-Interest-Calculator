package javaFXLabs;



import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InterestGUI extends Application {

   TextField investedATF;
   TextField rateOfInterestTF;
   TextField investementYearsTF;
   ToggleGroup radgroup;
   RadioButton Yearly;
   RadioButton HalfYearly;
   RadioButton Quarterly;
   TextArea output;
   DecimalFormat dollarFormat = new DecimalFormat("$#.##");

   @Override
   public void start(Stage stage) {

      BorderPane mainlayout = new BorderPane();

      Label mainLabel = new Label("Compound Interest Calculator");
      FlowPane titlepane = new FlowPane(Orientation.HORIZONTAL, 10, 10, mainLabel);
      titlepane.setAlignment(Pos.CENTER);

      GridPane centerLayout = new GridPane();
      centerLayout.setAlignment(Pos.CENTER);
      centerLayout.setVgap(5);

      Label investedAmount = new Label("Invested Amount:");
      investedATF = new TextField();
      centerLayout.add(investedAmount, 0, 0);
      centerLayout.add(investedATF, 1, 0);
      GridPane.setColumnSpan(investedATF, 2);

      Label rateOfInterest = new Label("Interest Rate:");
      rateOfInterestTF = new TextField();
      centerLayout.add(rateOfInterest, 0, 1);
      centerLayout.add(rateOfInterestTF, 1, 1);
      GridPane.setColumnSpan(rateOfInterest, 2);

      Label investementYears = new Label("Years Invested:");
      investementYearsTF = new TextField();
      centerLayout.add(investementYears, 0, 2);
      centerLayout.add(investementYearsTF, 1, 2);
      GridPane.setColumnSpan(investementYearsTF, 2);

      Label FrequencyOfInterest = new Label("Frequency of Interest:");

      radgroup = new ToggleGroup();

      Yearly = new RadioButton("Yearly");
      Yearly.setUserData(1);

      HalfYearly = new RadioButton("Half-Yearly");
      HalfYearly.setUserData(2);

      Quarterly = new RadioButton("Quarterly");
      Quarterly.setUserData(4);

      Yearly.setToggleGroup(radgroup);
      HalfYearly.setToggleGroup(radgroup);
      Quarterly.setToggleGroup(radgroup);

      HBox radiobuttonlayout = new HBox(20);
      radiobuttonlayout.getChildren().add(Yearly);
      radiobuttonlayout.getChildren().add(HalfYearly);
      radiobuttonlayout.getChildren().add(Quarterly);

      centerLayout.add(FrequencyOfInterest, 0, 3);
      centerLayout.add(radiobuttonlayout, 0, 4);

      Button calculate = new Button("Calculate");
      centerLayout.add(calculate, 0, 5);
      calculate.setOnAction(new calculateClass());

      output = new TextArea();
      output.setPrefSize(50, 100);

      mainlayout.setBottom(output);

      mainlayout.setCenter(centerLayout);
      mainlayout.setTop(titlepane);

      Scene scene = new Scene(mainlayout);

      stage.setScene(scene);
      stage.setTitle("Compound Interest Calculator");
      stage.show();

   }

   class calculateClass implements EventHandler < ActionEvent > {

      @Override
      public void handle(ActionEvent arg0) {

         double p = Double.parseDouble(investedATF.getText());
         double r = Double.parseDouble(rateOfInterestTF.getText());
         int n = (int) radgroup.getSelectedToggle().getUserData();
         int t = Integer.parseInt(investementYearsTF.getText());

         Interest interest = new Interest(p, r, n, t);
         double i = interest.getI();

         String data = "Principal Investement: " + dollarFormat.format(p) + "\n" +
            "Interest Earned: " + dollarFormat.format(i) + "\n" +
            "Final Amount: " + dollarFormat.format(i + p);

         output.setText(data);
      }
   }

   public static void main(String[] args) {
      launch(args);

   }

}