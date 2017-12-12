import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

public class HowToPlayScene extends QuickPlayScene{

    Label labelHeadline, labelHowToPlay;
    Button buttonDrinking, frontpageButton4;
    VBox layout;

    public HowToPlayScene(){
        Label labelHeadline = new Label(Constants.gameName);
        // Gets the css class "label-headline" instead of the normal layout
        buttonDrinking = new Button (Constants.rulesTitle1);

        // Gets the normal layout from the css stylesheet
        labelHowToPlay = new Label(Constants.rulesText2);
        buttonDrinking.getStyleClass().add("button-menu");


        labelHowToPlay.setVisible(false);

            buttonDrinking.setOnAction(e -> {
            if(labelHowToPlay.isVisible()) {
                labelHowToPlay.setVisible(false);
            } else {
                labelHowToPlay.setVisible(true);
            }

        });

        frontpageButton4 = new Button(Constants.goToQuickPlayText);
        frontpageButton4.getStyleClass().add("button-continue");
        frontpageButton4.setOnAction(e -> {
            System.out.println("This is how many teams are selected: " + numOfTeams);
            System.out.println("This is how many questions are selected: " + numOfQuestions);

            if      (numOfTeams == Constants.teamChoice1Num)
                choiceBox.setValue(Constants.teamChoice1);
            else if (numOfTeams == Constants.teamChoice2Num)
                choiceBox.setValue(Constants.teamChoice2);
            else if (numOfTeams == Constants.teamChoice3Num)
                choiceBox.setValue(Constants.teamChoice3);
            else if (numOfTeams == Constants.teamChoice4Num)
                choiceBox.setValue(Constants.teamChoice4);
            else if (numOfTeams == Constants.teamChoice5Num)
                choiceBox.setValue(Constants.teamChoice5);
            else {
                choiceBox.setValue(Constants.teamChoice0);
            }
            if      (numOfQuestions == Constants.questionChoice1Num)
                choiceBox2.setValue(Constants.questionChoice1);
            else if (numOfQuestions == Constants.questionChoice2Num)
                choiceBox2.setValue(Constants.questionChoice2);
            else if (numOfQuestions == Constants.questionChoice3Num)
                choiceBox2.setValue(Constants.questionChoice3);
            else {
                choiceBox2.setValue(Constants.questionChoice0);
            }
            window.setScene(quickPlayScene);
        });

        layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(labelHeadline, buttonDrinking, labelHowToPlay, frontpageButton4);
        Scene gameRulesScene = new Scene(layout, 400, 700);
        gameRulesScene.getStylesheets().add("Theme.css");

        window.setScene(gameRulesScene);
    }
}
