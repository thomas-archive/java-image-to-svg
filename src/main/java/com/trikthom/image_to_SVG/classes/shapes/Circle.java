package com.trikthom.image_to_SVG.classes.shapes;

import com.trikthom.image_to_SVG.classes.Shape;
import lombok.Setter;

@Setter
public class Circle extends Shape {

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
        this.strokeWidth = 1;
        this.fill = "white";
    }

    public Circle(Integer cx, Integer cy, Integer r, String stroke, Integer strokeWidth, String fill) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
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
