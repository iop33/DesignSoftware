package model;

import controller.SerializableStrokeAdapter;
import view.myTree.view.TabPresentation;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class Slot implements Serializable {
    private Point position;
    private Color color;
    private int height;
    private int width;
    private transient Shape shape;
    private SerializableStrokeAdapter stroke;

    public Slot(Point position, Color color, int height, int width,  SerializableStrokeAdapter stroke) {
        this.position = position;
        this.color = color;
        this.height = height;
        this.width = width;
        this.stroke = stroke;


    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public SerializableStrokeAdapter getStroke() {
        return stroke;
    }

    public void setStroke(SerializableStrokeAdapter stroke) {
        this.stroke = stroke;
    }
}
