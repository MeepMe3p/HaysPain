package com.example.hayspain.rendering;

import com.example.hayspain.models.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class LevelCreator {
    Canvas canvas;
    GraphicsContext context;

    Image background;

    List<Player> entities = new ArrayList<>();

    public LevelCreator(Canvas canvas) {
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
    }
    public void createLevel(){

    }
}
