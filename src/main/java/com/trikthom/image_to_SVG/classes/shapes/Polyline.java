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
public class Polyline extends Shape {

    private @Attribute List<Point> points;
    private @Attribute String stroke;
    private @Attribute("stroke-width") int strokeWidth;
    private final @Attribute String fill = "none";

    public Polyline() {
        this(Arrays.asList(
                new Point(20, 10),
                new Point(40, 70),
                new Point(10, 40)
        ), "black", 1);
    }

    public Polyline(List<Point> points, String stroke, Integer strokeWidth) {
        super("polyline");
        this.points = points;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }

}
