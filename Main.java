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

import javax.swing.*;
import java.io.IOException;


public class Main extends Application {


    Stage window;
    Scene frontPageScene, frontPageSceneLoggedIn, quickplayScene, customgameScene, loginpageScene, signupScene, playGameScene;
    String enteredUsername, enteredPass;
    boolean loggedIn = false;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;


        //ALL THIS IS FRONT PAGE:

        //Label front page
        Label labelFront = new Label("Soundalicious");

        //Quick play button -> Goes to Quickplay page
        Button quickplayButton = new Button("Quickplay");
        quickplayButton.setOnAction(e -> window.setScene(quickplayScene));

        //Quick play button when logged in -> Goes to Quickplay page
        Button quickplayButton1 = new Button("Quickplay");
        quickplayButton1.setOnAction(e -> window.setScene(quickplayScene));

        //Custom game button -> Goes to login page  page
        Button customgameButton = new Button("Custom Game");
        customgameButton.setOnAction(e -> window.setScene(loginpageScene));

        //Custom game button1 goes to custom game
        Button customgameButton1 = new Button("Custom Game");
        customgameButton1.setOnAction(e -> window.setScene(customgameScene));


        //Logout button
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> window.setScene(frontPageScene));

        //Layout Front Page when logged in
        VBox layoutFrontpage1 = new VBox(20);
        layoutFrontpage1.setAlignment(Pos.CENTER);
        layoutFrontpage1.getChildren().addAll(labelFront, quickplayButton1, customgameButton1, logoutButton);
        frontPageSceneLoggedIn = new Scene(layoutFrontpage1, 400, 600);


        //Login page button -> Goes to login page
        Button loginpageButton = new Button("Log In");
        loginpageButton.setOnAction(e -> window.setScene(loginpageScene));

        //sign up button -> Goes to sign up page
        Button signupButton = new Button("Sign Up");
        signupButton.setOnAction(e -> window.setScene(signupScene));

        //Layout Front Page
        VBox layoutFrontpage = new VBox(20);
        layoutFrontpage.setAlignment(Pos.CENTER);
        layoutFrontpage.getChildren().addAll(labelFront, quickplayButton, customgameButton, loginpageButton, signupButton);
        frontPageScene = new Scene(layoutFrontpage, 400, 600);


        //ALL THIS IS QUICK PLAY PAGE:

        //Label Quick play
        Label labelQuick = new Label("Soundalicious");

        //Amount of teams in a choice box
        Label labelChoiceBox = new Label("Choose amount of teams:");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("1 Team", "2 Teams", "3 Teams", "4 Teams", "5 Teams");
        //Set default value
        choiceBox.setValue("1 Team");

        //Amount of questions in a choice box
        Label labelChoiceBox2 = new Label("Choose amount of questions:");
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
        choiceBox2.getItems().addAll("10 Questions", "20 Questions", "30 Questions");
        //Set default value
        choiceBox2.setValue("10 Questions");

        //Quick Play play button button
        Button quickplayPlay = new Button("Start Game");

        //Open scene for the game
        quickplayPlay.setOnAction(e -> window.setScene(playGameScene));

        //How to play button button
        Button buttonHowToPlay = new Button("How To Play");

        //Button back to front on Quick play page
        Button frontPageButton1 = new Button("Go back to front page");
        frontPageButton1.setOnAction(e -> window.setScene(frontPageScene));

        //Layout quickplay
        VBox quickplayLayout = new VBox(20);
        quickplayLayout.setAlignment(Pos.CENTER);
        quickplayLayout.getChildren().addAll(labelQuick, labelChoiceBox, choiceBox, labelChoiceBox2, choiceBox2, quickplayPlay, buttonHowToPlay, frontPageButton1);
        quickplayScene = new Scene(quickplayLayout, 500, 500);


        //ALL THIS IS CUSTOM GAME PAGE:

        //Label Custom page
        Label labelCustom = new Label("Soundalicious");

        //Label choose cards
        Label labelChooseQuestions = new Label("Choose which questions you want to play with");

        //Checkboxes for choosing cards
        CheckBox box1 = new CheckBox("Musicians");
        CheckBox box2 = new CheckBox("Actors");
        CheckBox box3 = new CheckBox("Athletes");

        //Custom game next button
        Button buttonCustomGameNext = new Button("Next Page");
        buttonCustomGameNext.setOnAction(e -> window.setScene(quickplayScene));

        //Button back to front on custom game page
        Button frontPageButton2 = new Button("Go back to front page");
        frontPageButton2.setOnAction(e -> window.setScene(frontPageScene));

        //Layout custom game
        VBox customgameLayout = new VBox(20);
        customgameLayout.setAlignment(Pos.CENTER);
        customgameLayout.getChildren().addAll(labelCustom, labelChooseQuestions, box1, box2, box3, buttonCustomGameNext, frontPageButton2);
        customgameScene = new Scene(customgameLayout, 400, 600);


        //ALL THIS IS LOGIN PAGE:

        //Label login page
        Label labelLogin = new Label("Soundalicious");

        //Username label
        Label usernameLabel = new Label("Username:");

        //Username input
        TextField usernameInput = new TextField();

        //Password label
        Label passwordLabel = new Label("Password:");

        //Password input
        TextField passwordInput = new PasswordField();

        // Error and message labels
        Label loginError = new Label("Password is not correct. Try again.");
        loginError.setStyle("-fx-text-fill: red");
        loginError.setVisible(false);
        Label loginMessage = new Label("You are logged in");
        loginMessage.setStyle("-fx-text-fill: green");
        loginMessage.setVisible(false);

        Button loginButton = new Button("Log In");
        // The addEventHandler handles more than one event, which makes it so we don't have to click the login button twice.
        loginButton.addEventHandler(ActionEvent.ACTION, event -> {
            enteredUsername = usernameInput.getText();
            enteredUsername = enteredUsername.toLowerCase();
            enteredPass = passwordInput.getText();
            try {
                if (Login.login(enteredUsername, enteredPass)){
                    loggedIn = true;
                    loginMessage.setVisible(true);
                    loginError.setVisible(false);
                    loginButton.setOnAction(e -> window.setScene(frontPageSceneLoggedIn));

                    if (Login.login("admin", "password")){
                        // admin properties so that the admin can delete files and questions if he wants. but only stuff thats uploaded by users.
                        // the login should be assigned to a User with name and stuff. That user should be allowed to upload sound files and make questions.
                        // the User should be allowed to customize own questions and to delete his how shizzle.

                        Label adminMessage = new Label ("You are logged in as administrator");
                        adminMessage.setVisible(true);
                    }
                }
                else {
                    passwordInput.setText("");
                    loginMessage.setVisible(false);
                    loginError.setVisible(true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        //Button back to front on login page
        Button frontPageButton3 = new Button("Go back to front page");
        frontPageButton3.setOnAction(e -> window.setScene(frontPageScene));

        //Layout custom game
        VBox loginpageLayout = new VBox(20);
        loginpageLayout.setAlignment(Pos.CENTER);
        loginpageLayout.getChildren().addAll(labelLogin, usernameLabel, usernameInput, passwordLabel,  passwordInput, loginError, loginMessage, loginButton, frontPageButton3);
        loginpageScene = new Scene(loginpageLayout, 400, 600);


        //Sign up Scene
        //Label login page
        Label labelSignup = new Label("Sign up");

        //Username label
        Label usernameSignupLabel = new Label("New username:");

        //Username input
        TextField usernameSignupInput = new TextField();

        //Password label
        Label passwordSignupLabel = new Label("Your password:");

        //Password input
        TextField passwordSignupInput = new PasswordField();

        //Repeat password label
        Label passwordRepeatSignupLabel = new Label("Repeat password:");

        //Repeat password input
        TextField passwordRepeatSignupInput = new PasswordField();

        //signup error/message
        Label signupError = new Label("Passwords do not match");
        signupError.setVisible(false);

        //Create new user Button
        Button createUserButton = new Button("Create a new user");
        //Action when the button is clicked on
        createUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                signupError.setVisible(false); //do not show message from the previous time
                enteredUsername = usernameSignupInput.getText(); //save text from TextField to String
                enteredUsername = enteredUsername.toLowerCase(); //convert String to lowercase
                enteredPass = passwordSignupInput.getText(); //save password to String
                try{
                    if(enteredUsername.isEmpty() || enteredUsername.isEmpty() || passwordRepeatSignupInput.getText().isEmpty()){ //checks if any line is empty
                        signupError.setText("You left some fields empty");
                        signupError.setStyle("-fx-text-fill: red");
                        signupError.setVisible(true);
                    }
                    else
                    if(Login.containsSpecChar(enteredUsername)){ //checks if username contains spec chars
                        signupError.setText("Username should not contain special characters");
                        signupError.setStyle("-fx-text-fill: red");
                        signupError.setVisible(true);
                    }
                    else if(Login.containsSpecChar(enteredPass)){ //checks if username contains spec chars
                        signupError.setText("Password should not contain special characters");
                        signupError.setStyle("-fx-text-fill: red");
                        signupError.setVisible(true);
                    }
                    else if(passwordSignupInput.getText().equals((passwordRepeatSignupInput.getText()))){ //checking if two TextFields with passwords match
                        if(!SignUp.userExists(enteredUsername)){ //checking if username does not exist
                            signupError.setStyle("-fx-text-fill: green");
                            signupError.setText("New user created");  //changing error message
                            signupError.setVisible(true); //showing error message
                            SignUp.writeToFile(enteredUsername, enteredPass);
                        }
                        else{
                            signupError.setText("Username already exists");
                            signupError.setStyle("-fx-text-fill: red");
                            signupError.setVisible(true);
                            usernameSignupInput.setText("");
                            passwordSignupInput.setText("");
                            passwordRepeatSignupInput.setText("");
                        }
                    }
                    else {
                        signupError.setText("Passwords do not match");
                        signupError.setStyle("-fx-text-fill: red");
                        signupError.setVisible(true);
                        passwordSignupInput.setText("");
                        passwordRepeatSignupInput.setText("");
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        //Button back to front on login page
        Button frontPageButton4 = new Button("Go back to front page");
        frontPageButton4.setOnAction(e -> window.setScene(frontPageScene));

        VBox signUpLayout = new VBox(20);
        signUpLayout.setAlignment(Pos.CENTER);
        signUpLayout.getChildren().addAll(labelSignup, usernameSignupLabel, usernameSignupInput, passwordSignupLabel, passwordSignupInput, passwordRepeatSignupLabel, passwordRepeatSignupInput, signupError, createUserButton, frontPageButton4);
        signupScene = new Scene(signUpLayout, 400, 600);


        //ALL THIS IS PLAYING THE GAME:

        //Label
        Label whoIsThis = new Label("Who is this?");
        //Buttons
        //Play Sound
        Button playSound = new Button ("Play Sound");
        playSound.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Soundfiles.kanyeSound();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button beyonceBut = new Button("Beyonce");
        Button kanyeBut = new Button("Kanye West");
        Button jayzBut = new Button("Jay-Z");
        Button eminemBut = new Button("Eminem");

        //Button back to front on custom game page
        Button frontPageButton5 = new Button("Go back to front page");
        frontPageButton5.setOnAction(e -> window.setScene(frontPageScene));

        //Layout for playing the game
        VBox playGameLayout = new VBox(20);
        playGameLayout.setAlignment(Pos.CENTER);
        playGameLayout.getChildren().addAll(whoIsThis, playSound, beyonceBut, kanyeBut, jayzBut, eminemBut, frontPageButton5);
        playGameScene = new Scene(playGameLayout, 400, 600);



        //THIS MAKES THE WINDOW OPEN:
        window.setScene(frontPageScene);
        window.setTitle("Soundalicous");
        window.show();


    }
}
