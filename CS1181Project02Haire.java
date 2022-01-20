/*
Brandon Haire
CS1181-Project02
Michelle Cheatham
 */
package cs1181.project02.haire;

import java.util.Random;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This program pops up a window that has the user play the computer in tic tac toe
 * @author bucke
 */
public class CS1181Project02Haire extends Application {
//initliaze variables
    ArrayList<Button> whatsLeft = new ArrayList<Button>();
    Random rand = new Random();
    int randomPick;
    int turn = 2;
    //the computers way of seeing the board and checking if anyone has won yet
    int[][] arrayBoard = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//    boolean readyToWait = false;

    @Override
    public void start(Stage primaryStage) {
        //initialize all empty pictures, x's, and o's 
        //need nine of each because you can only use them once
        ImageView emptyL1 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyL2 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyL3 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyM1 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyM2 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyM3 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyR1 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyR2 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView emptyR3 = new ImageView(new Image("file:src/cs1181/project02/haire/empty.png", 150, 150, false, false, false));
        ImageView xL1 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xL2 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xL3 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xM1 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xM2 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xM3 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xR1 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xR2 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView xR3 = new ImageView(new Image("file:src/cs1181/project02/haire/x.png", 150, 150, false, false, false));
        ImageView oL1 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oL2 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oL3 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oM1 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oM2 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oM3 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oR1 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oR2 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));
        ImageView oR3 = new ImageView(new Image("file:src/cs1181/project02/haire/o.png", 150, 150, false, false, false));

        //make all buttons on board
        Button L1 = new Button("", emptyL1);
        Button L2 = new Button("", emptyL2);
        Button L3 = new Button("", emptyL3);
        Button M1 = new Button("", emptyM1);
        Button M2 = new Button("", emptyM2);
        Button M3 = new Button("", emptyM3);
        Button R1 = new Button("", emptyR1);
        Button R2 = new Button("", emptyR2);
        Button R3 = new Button("", emptyR3);

        //add buttons to arraylist
        whatsLeft.add(L1);
        whatsLeft.add(L2);
        whatsLeft.add(L3);
        whatsLeft.add(M1);
        whatsLeft.add(M2);
        whatsLeft.add(M3);
        whatsLeft.add(R1);
        whatsLeft.add(R2);
        whatsLeft.add(R3);

        //place buttons in vertical boxes, and put it in a horizontal box
        VBox left = new VBox();
        VBox middle = new VBox();
        VBox right = new VBox();

        HBox board = new HBox();

        left.getChildren().addAll(L1, L2, L3);
        middle.getChildren().addAll(M1, M2, M3);
        right.getChildren().addAll(R1, R2, R3);

        board.getChildren().addAll(left, middle, right);

        Alert instructions = new Alert(AlertType.INFORMATION);
        instructions.setTitle("Instructions");
        instructions.setHeaderText("Tic Tac Toe");
        instructions.setContentText("Click on any of the 9 available squares.\n"
                + "You are playing as X's and the \ncomputer is playing as O's\n"
                + "If you get three X's in a row you win but\n"
                + "if the computer gets three O's in a row it wins.");
        //actions for all nine buttons
        L1.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                L1.setGraphic(xL1);
                L1.setDisable(true);
                arrayBoard[0][0] = 1;
                whatsLeft.remove(L1);
                if (arrayBoard[0][1] == 1 && arrayBoard[0][2] == 1) {
                    playerWins();
                }
                if (arrayBoard[1][1] == 1 && arrayBoard[2][2] == 1) {
                    playerWins();
                }
                if (arrayBoard[1][0] == 1 && arrayBoard[2][0] == 1) {
                    playerWins();
                }
                //random number picks how the computer plays next turn
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                L1.setGraphic(oL1);
                L1.setDisable(true);
                arrayBoard[0][0] = -1;
                whatsLeft.remove(L1);
                if (arrayBoard[0][1] == -1 && arrayBoard[0][2] == -1) {
                    computerWins();
                }
                if (arrayBoard[1][1] == -1 && arrayBoard[2][2] == -1) {
                    computerWins();
                }
                if (arrayBoard[1][0] == -1 && arrayBoard[2][0] == -1) {
                    computerWins();
                }
            }
        });
        L2.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                L2.setGraphic(xL2);
                L2.setDisable(true);
                arrayBoard[0][1] = 1;
                whatsLeft.remove(L2);
                if (arrayBoard[1][1] == 1 && arrayBoard[2][1] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                L2.setGraphic(oL2);
                L2.setDisable(true);
                arrayBoard[0][1] = -1;
                whatsLeft.remove(L2);
                if (arrayBoard[1][1] == -1 && arrayBoard[2][1] == -1) {
                    computerWins();
                }
            }
        });
        L3.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                L3.setGraphic(xL3);
                L3.setDisable(true);
                arrayBoard[0][2] = 1;
                whatsLeft.remove(L3);
                if (arrayBoard[1][1] == 1 && arrayBoard[2][0] == 1) {
                    playerWins();
                }
                if (arrayBoard[0][0] == 1 && arrayBoard[0][1] == 1) {
                    playerWins();
                }
                if (arrayBoard[1][2] == 1 && arrayBoard[2][2] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                L3.setGraphic(oL3);
                L3.setDisable(true);
                arrayBoard[0][2] = -1;
                whatsLeft.remove(L3);
                if (arrayBoard[1][1] == -1 && arrayBoard[2][0] == -1) {
                    computerWins();
                }
                if (arrayBoard[0][0] == -1 && arrayBoard[0][1] == -1) {
                    computerWins();
                }
                if (arrayBoard[1][2] == -1 && arrayBoard[2][2] == -1) {
                    computerWins();
                }
            }
        });
//        });
        M1.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                M1.setGraphic(xM1);
                M1.setDisable(true);
                arrayBoard[1][0] = 1;
                whatsLeft.remove(M1);
                if (arrayBoard[1][1] == 1 && arrayBoard[1][2] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                M1.setGraphic(oM1);
                M1.setDisable(true);
                arrayBoard[1][0] = -1;
                whatsLeft.remove(M1);
                if (arrayBoard[1][1] == -1 && arrayBoard[1][2] == -1) {
                    computerWins();
                }
            }
        });
        M2.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                M2.setGraphic(xM2);
                M2.setDisable(true);
                arrayBoard[1][1] = 1;
                whatsLeft.remove(M2);
                if (arrayBoard[0][0] == 1 && arrayBoard[2][2] == 1) {
                    playerWins();
                }
                if (arrayBoard[2][0] == 1 && arrayBoard[0][2] == 1) {
                    playerWins();
                }
                if (arrayBoard[1][0] == 1 && arrayBoard[1][2] == 1) {
                    playerWins();
                }
                if (arrayBoard[0][1] == 1 && arrayBoard[2][1] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                M2.setGraphic(oM2);
                M2.setDisable(true);
                arrayBoard[1][1] = -1;
                whatsLeft.remove(M2);
                if (arrayBoard[0][0] == -1 && arrayBoard[2][2] == -1) {
                    computerWins();
                }
                if (arrayBoard[2][0] == -1 && arrayBoard[0][2] == -1) {
                    computerWins();
                }
                if (arrayBoard[1][0] == -1 && arrayBoard[1][2] == -1) {
                    computerWins();
                }
                if (arrayBoard[0][1] == -1 && arrayBoard[2][1] == -1) {
                    computerWins();
                }
            }
        });
        M3.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                M3.setGraphic(xM3);
                M3.setDisable(true);
                arrayBoard[1][2] = 1;
                whatsLeft.remove(M3);
                if (arrayBoard[1][1] == 1 && arrayBoard[1][0] == 1) {
                    playerWins();
                }
                if (arrayBoard[0][2] == 1 && arrayBoard[2][2] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                M3.setGraphic(oM3);
                M3.setDisable(true);
                arrayBoard[1][2] = -1;
                whatsLeft.remove(M3);
                if (arrayBoard[1][1] == -1 && arrayBoard[1][0] == -1) {
                    computerWins();
                }
                if (arrayBoard[0][2] == -1 && arrayBoard[2][2] == -1) {
                    computerWins();
                }
            }
        });
        R1.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                R1.setGraphic(xR1);
                R1.setDisable(true);
                arrayBoard[2][0] = 1;
                whatsLeft.remove(R1);
                if (arrayBoard[0][0] == 1 && arrayBoard[1][0] == 1) {
                    playerWins();
                }
                if (arrayBoard[1][1] == 1 && arrayBoard[0][2] == 1) {
                    playerWins();
                }
                if (arrayBoard[2][1] == 1 && arrayBoard[2][2] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                R1.setGraphic(oR1);
                R1.setDisable(true);
                arrayBoard[2][0] = -1;
                whatsLeft.remove(R1);
                if (arrayBoard[1][1] == -1 && arrayBoard[1][0] == -1) {
                    computerWins();
                }
                if (arrayBoard[0][0] == -1 && arrayBoard[1][0] == -1) {
                    computerWins();
                }
                if (arrayBoard[1][1] == -1 && arrayBoard[0][2] == -1) {
                    computerWins();
                }
                if (arrayBoard[2][1] == -1 && arrayBoard[2][2] == -1) {
                    computerWins();
                }
            }
        });
        R2.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                R2.setGraphic(xR2);
                R2.setDisable(true);
                arrayBoard[2][1] = 1;
                whatsLeft.remove(R2);
                if (arrayBoard[1][1] == 1 && arrayBoard[0][1] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                R2.setGraphic(oR2);
                R2.setDisable(true);
                arrayBoard[2][1] = -1;
                whatsLeft.remove(R2);
                if (arrayBoard[1][1] == -1 && arrayBoard[0][1] == -1) {
                    computerWins();
                }
            }
        });
        R3.setOnAction(e -> {
            if (turn % 2 == 0) {//even(players turn)
                turn++;
                R3.setGraphic(xR3);
                R3.setDisable(true);
                arrayBoard[2][2] = 1;
                whatsLeft.remove(R3);
                if (arrayBoard[1][1] == 1 && arrayBoard[0][0] == 1) {
                    playerWins();
                }
                if (arrayBoard[2][1] == 1 && arrayBoard[2][0] == 1) {
                    playerWins();
                }
                if (arrayBoard[0][2] == 1 && arrayBoard[1][2] == 1) {
                    playerWins();
                }
                randomPick = (int) (Math.random() * (whatsLeft.size()));
                whatsLeft.get(randomPick).fire();
            } else {//odd(computers turn)
                turn++;
                R3.setGraphic(oR3);
                R3.setDisable(true);
                arrayBoard[2][2] = -1;
                whatsLeft.remove(R3);
                if (arrayBoard[1][1] == -1 && arrayBoard[0][0] == -1) {
                    computerWins();
                }
                if (arrayBoard[2][0] == -1 && arrayBoard[2][1] == -1) {
                    computerWins();
                }
                if (arrayBoard[0][2] == -1 && arrayBoard[1][2] == -1) {
                    computerWins();
                }
            }
        });
        Scene scene = new Scene(board, 510, 510);
        primaryStage.setTitle("Tic Tac Toe Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        instructions.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
/**
 * This  method creates an alert and tells the user that they lost to the computer when called
 */
    public static void computerWins() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You Lost");
        alert.setTitle("Loser");
        alert.setContentText("You got beat by a computer");
        alert.show();
    }
/**
 * This method creates an alert and tells the user that they beat the computer when called
 */
    public static void playerWins() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You Won");
        alert.setTitle("Winner");
        alert.show();
    }

}
