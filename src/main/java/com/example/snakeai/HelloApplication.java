package com.example.snakeai;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;
import java.util.List;

public class HelloApplication extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = WIDTH;
    private static final int ROWS = 20;
    private static final int COLUMNS = ROWS;
    private static final int SQUARE_SIZE = WIDTH / ROWS;
    private static final String [] APPLE_IMAGE = new String[]{"/img/ic_apple.png"};

    private static final int WEST = 0;
    private static final int EAST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private GraphicsContext gc;
    private List<Point> snakeBody = new ArrayList();
    private Point snakeHead;
    private Image appleImage;
    private int appleX;
    private int appleY;
    private boolean gameOver;
    private int currentDirection;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Snake");
        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        gc = canvas.getGraphicsContext2D();
        run();
    }

    private void run(){
        drawBackground(gc);
    }

    private void drawBackground(GraphicsContext gc){
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                if((i+j) % 2 == 0) {
                    gc.setFill(Color.web("0077B6"));
                }else {
                    gc.setFill(Color.web("00B4D8"));
                }
                gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}