package com.trikthom.image_to_SVG.classes.shapes;

import com.trikthom.image_to_SVG.annotations.Attribute;
import com.trikthom.image_to_SVG.classes.Shape;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle extends Shape {

    private @Attribute int width;
    private @Attribute int height;
    private @Attribute String stroke;
    private @Attribute("stroke-width") int strokeWidth;
    private @Attribute String fill;

    public Rectangle() {
        this(50, 20, "black", 1, "white");
    }

    public Rectangle(Integer width, Integer height, String stroke, Integer strokeWidth, String fill) {
        super("rect");
        this.width = width;
        this.height = height;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

}
