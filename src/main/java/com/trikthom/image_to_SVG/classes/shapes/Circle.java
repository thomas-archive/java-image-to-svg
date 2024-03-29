package com.trikthom.image_to_SVG.classes.shapes;

import com.trikthom.image_to_SVG.annotations.Attribute;
import com.trikthom.image_to_SVG.classes.Shape;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle extends Shape {

    private @Attribute int cx;
    private @Attribute int cy;
    private @Attribute int r;
    private @Attribute String stroke;
    private @Attribute("stroke-width") int strokeWidth;
    private @Attribute String fill;

    public Circle() {
        this(50, 50, 10, "black", 1, "white");
    }

    public Circle(Integer cx, Integer cy, Integer r, String stroke, Integer strokeWidth, String fill) {
        super("circle");
        this.cx = cx;
        this.cy = cy;
        this.r = r;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

}
