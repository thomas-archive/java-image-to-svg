package com.trikthom.image_to_SVG.classes.shapes;

import com.trikthom.image_to_SVG.annotations.Attribute;
import com.trikthom.image_to_SVG.classes.Point;
import com.trikthom.image_to_SVG.classes.Shape;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Polygon extends Shape {

    private @Attribute List<Point> points;
    private @Attribute String stroke;
    private @Attribute("stroke-width") int strokeWidth;
    private @Attribute String fill;

    public Polygon() {
        this(Arrays.asList(
                new Point(10, 10),
                new Point(70, 70),
                new Point(20, 40)
        ), "black", 1, "white");
    }

    public Polygon(List<Point> points, String stroke, Integer strokeWidth, String fill) {
        super("polygon");
        this.points = points;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

}
