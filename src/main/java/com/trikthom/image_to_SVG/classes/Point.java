package com.trikthom.image_to_SVG.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point {

    private int x;
    private int y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
