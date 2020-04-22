package com.trikthom.image_to_SVG.classes.shapes;

import lombok.Setter;

import java.awt.*;

@Setter
public class Circle {

    private int cx;
    private int cy;
    private int r;
    private String stroke;
    private int strokeWidth;
    private String fill;

    public Circle() {
        this.cx = 50;
        this.cy = 50;
        this.r = 10;
        this.stroke = "black";
        this.strokeWidth = 3;
        this.fill = "blue";
    }

    @Override
    public String toString() {
        return "<circle " +
                "cx=\"" + cx +
                "\" cy=\"" + cy +
                "\" r=\"" + r +
                "\" stroke=\"" + stroke +
                "\" stroke-width=\"" + strokeWidth +
                "\" fill=\"" + fill +
                "\" />";
    }
}
