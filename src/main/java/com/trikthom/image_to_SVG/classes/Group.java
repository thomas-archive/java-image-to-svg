package com.trikthom.image_to_SVG.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Group {

    private List<Shape> shapes;

    public Group(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("<g>");

        for (Shape shape : shapes) output.append("\n\t\t").append(shape.toString());

        output.append("\n\t</g>");

        return output.toString();
    }
}
