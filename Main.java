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
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {


    public static Stage window;
    public static Scene frontPageScene, frontPageSceneLoggedIn, quickPlayScene, customGameScene, logInPageScene, signUpScene, playGameScene, gameRulesScene;
    public static String enteredUsername, enteredPass;
    public static String loggedUser, loggedUsersPass;
    public static boolean loggedIn = false;
    public static int numOfQuestions = 2;
    public static int numOfTeams = 1;
    public static List<Question> questions, rQuestions;
    public static List<RadioButton> answers;
    public static int n;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StartUpSavingFolders.startUpSavingFolders();
      window = primaryStage;
      new FrontPageScene();
      window.setTitle("Soundalicous");
      window.show();

      questions = new ArrayList<>();
      rQuestions = new ArrayList<>();
      answers = new ArrayList<>();
      n = 0;


     Questions.readQuestionsFromFile(questions, rQuestions);
     Questions.getRandomQuestions(questions, rQuestions);
  }
}
