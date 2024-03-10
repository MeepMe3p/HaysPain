package com.example.hayspain.rendering;

import com.example.hayspain.models.Entity;
import com.example.hayspain.models.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Renderer {

    Canvas canvas;
    GraphicsContext context;

    Image background;

    List<Player> entities = new ArrayList<>();

    public Renderer(Canvas canvas) {
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
    }

    public void addEntity(Player entity) {
        entities.add(entity);
    }


    public void setBackground(Image background) {
        this.background = background;
    }

    public void render() {
        context.save();

        if(background!=null){
            context.drawImage(background, 0, 0);
        }

        for (Entity entity : entities) {
            Point2D pos = entity.getDrawPosition();
            context.drawImage(
                    entity.getImage(),
                    pos.getX(),
                    pos.getY(),
                    entity.getWidth(),
                    entity.getHeight()
            );
        }

        context.restore();
    }

    public void prepare(){
//        context.setFill( new Color(0.68, 0.68, 0.68, 1.0) );
//        context.fillRect(0,0, canvas.getWidth(),canvas.getHeight());
    }



}
