package com.trikthom.image_to_SVG.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point {

    private Integer[] values;

    public Point(Integer ...value) {
        this.values = value;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("");
        for (Integer value : values) {
            output.append(value).append(" ");
        }
        return output.toString().trim();
    }
}
