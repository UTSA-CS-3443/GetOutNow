package Notification;

import java.io.*;
import java.util.Scanner;
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.shape.*;
import javafx.scene.paint.Color;

/*
Process:
    Retrieve game information from GameScrape

 */
public class BasketBallNotifcation extends Application{

    private static final int NUMBER_OF_TEAMS = 30;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 600;

    //error exit codes
    private static final int FILE_NOT_FOUND = 400;
    private static final int INVALID_TEAM_NAME = 500;

    //array of valid NBA team names
    //will be initialized by the scanTeams method
    private static String[] validTeamNames = new String[NUMBER_OF_TEAMS];

    //full team names
    private static String homeTeamName;
    private static String awayTeamName;

    //shortened team names (Bulls, Heat, Hornets, Spurs)
    private static String homeShortName;
    private static String awayShortName;

    //used to
    private static String homeTeamImagePath;
    private static String awayTeamImagePath;

    private static String gameTime;


    public void start(Stage primaryStage) {

        Group root = new Group();
        scanTeamNames();
        primaryStage = setUpNotification(primaryStage, root);

        primaryStage.show();
    }


    private static void scanTeamNames(){
        Scanner in = null;

        //try to open file
        try{
            in = new Scanner(new File("src/notification/NBA.txt"));
        }catch(FileNotFoundException e){
            exitError("Invalid file name: " , FILE_NOT_FOUND);
        }

        //scan every team name in NBA.txt
        for(int t = 0; in.hasNext(); t++){
            validTeamNames[t] = in.nextLine();
        }

        in.close();
    }


    public static Stage setUpNotification(Stage stage, Group root){
        stage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        stage.setTitle("NBA Game Notification");

        retrieveGameInfo();
        root.getChildren().addAll(returnLRect(), returnRRect());

        return stage;
    }


    public static void retrieveGameInfo(){
        //create sportsscrape variable

        SportsScrape game = new SportsScrape("Miami Heat", "San Antonio Spurs", "19:00");
        //SportsScrape.getData('A')
        //retrieve team names from scrape
        String scrapeHome = game.getHomeTeamName();
        String scrapeAway = game.getAwayTeamName();

        //get home team info
        homeTeamName = validTeamName(scrapeHome);
        homeShortName = homeTeamName.substring(homeTeamName.lastIndexOf(" "));

        //get away team info
        awayTeamName = validTeamName(scrapeAway);
        awayShortName = awayTeamName.substring(awayTeamName.lastIndexOf(" "));

        gameTime = game.getGameTime();
    }


    //make into binary search
    private static String validTeamName(String keyName){

        //for every name in validTeamNames
        for(int t = 0; t < validTeamNames.length; t++){
            if(validTeamNames[t].compareTo(keyName) == 0)
                return validTeamNames[t];
        }

        //not found, exit error
        exitError("Invalid NBA team name: " + keyName, INVALID_TEAM_NAME);
        return null;
    }


    public static Rectangle returnLRect(){
        Rectangle lRect = new Rectangle(0, 0, WINDOW_WIDTH/2, WINDOW_HEIGHT);
        lRect.setFill(Color.BLACK);

        return lRect;
    }


    public static Rectangle returnRRect(){
        Rectangle rRect = new Rectangle(WINDOW_WIDTH/2, 0, WINDOW_WIDTH/2, WINDOW_HEIGHT);
        rRect.setFill(Color.BLUE);

        return rRect;
    }


    private static void exitError(String errorMessage, int errorInt){
        System.err.println(errorMessage);
        System.exit(errorInt);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
