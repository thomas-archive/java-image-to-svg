package com.trikthom.image_to_SVG.classes.shapes;

import com.trikthom.image_to_SVG.annotations.Attribute;
import com.trikthom.image_to_SVG.classes.Shape;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ellipse extends Shape {

    private @Attribute int cx;
    private @Attribute int cy;
    private @Attribute int rx;
    private @Attribute int ry;
    private @Attribute String stroke;
    private @Attribute("stroke-width") int strokeWidth;
    private @Attribute String fill;

    public Ellipse() {
        this(50, 85, 40, 20, "black", 1, "white");
    }

    public Ellipse(Integer cx, Integer cy, Integer rx, Integer ry, String stroke, Integer strokeWidth, String fill) {
        super("ellipse");
        this.cx = cx;
        this.cy = cy;
        this.rx = rx;
        this.ry = ry;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

}
