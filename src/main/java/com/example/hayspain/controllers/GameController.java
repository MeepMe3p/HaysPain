package com.example.hayspain.controllers;

import com.example.hayspain.animation.GameLoopTimer;
import com.example.hayspain.controls.KeyInput;
import com.example.hayspain.controls.ObjectId;
import com.example.hayspain.models.Entity;
import com.example.hayspain.models.Player;
import com.example.hayspain.rendering.Renderer;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable {

    public Canvas gameCanvas;
    public AnchorPane gameAnchor;
    KeyInput keys = KeyInput.getInstance();

    private /*Entity*/ Player player = new Player/*Entity*/(new Image(getClass().getResourceAsStream("/img/hutao_uwu.png")), ObjectId.PLAYER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initialiseCanvas();

        player.setDrawPosition(350, 200);
        player.setScale(0.8f);

        Renderer renderer = new Renderer(this.gameCanvas);
        renderer.addEntity(player);
        renderer.setBackground(new Image(getClass().getResourceAsStream("/img/windrise-background-4k.png")));

        GameLoopTimer timer = new GameLoopTimer() {
            @Override
            public void tick(float secondsSinceLastFrame) {
//                renderer.prepare();

                updatePlayerMovement(secondsSinceLastFrame);

                renderer.render();
            }
        };
        timer.start();
    }

    private void initialiseCanvas() {
        gameCanvas.widthProperty().bind(gameAnchor.widthProperty());
        gameCanvas.heightProperty().bind(gameAnchor.heightProperty());
    }

    private void updatePlayerMovement(float frameDuration) {
        if (keys.isDown(KeyCode.D)) {
            Point2D vector = new Point2D(5,0);
            player.move(vector);
        } else if (keys.isDown(KeyCode.A)) {
            Point2D vector = new Point2D(-5,0);
            player.move(vector);
        } else if(keys.isDown(KeyCode.W)){
            Point2D vector = new Point2D(0,-5);
            player.move(vector);
        } else if(keys.isDown(KeyCode.S)){
            Point2D vector = new Point2D(0,5);
            player.move(vector);
        }

        player.update();
    }
}
