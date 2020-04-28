package com.trikthom.image_to_SVG.classes.shapes;

import com.trikthom.image_to_SVG.annotations.Attribute;
import com.trikthom.image_to_SVG.classes.Shape;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Line extends Shape {

    private @Attribute int x1;
    private @Attribute int y1;
    private @Attribute int x2;
    private @Attribute int y2;
    private @Attribute String stroke;
    private @Attribute("stroke-width") int strokeWidth;

    public Line() {
        this(0, 0, 25, 50, "black", 1);
    }

    public Line(Integer x1, Integer y1, Integer x2, Integer y2, String stroke, Integer strokeWidth) {
        super("line");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }

}
