package com.example.hayspain.animation;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public abstract class GameLoopTimer extends AnimationTimer {

    long pauseStart;
    long animationStart;
    DoubleProperty animationDuration = new SimpleDoubleProperty(0L);

    long lastFrameTimeNanos;

    boolean isPaused;


    @Override
    public void handle(long now) {


        if (!isPaused) {
            long animDuration = now - animationStart;
            animationDuration.set(animDuration / 1e9);

            float secondsSinceLastFrame = (float) ((now - lastFrameTimeNanos) / 1e9);
            lastFrameTimeNanos = now;
            tick(secondsSinceLastFrame);
        }
    }

    public abstract void tick(float secondsSinceLastFrame);
}
