package com.example.hayspain.models;

import com.example.hayspain.controls.ObjectId;
import javafx.scene.image.Image;

public class Player extends Entity{
    private float gravity = 10;
    ObjectId id;
    public Player(Image entityImage, ObjectId id) {
        super(entityImage);
        this.id = id;
    }
}
