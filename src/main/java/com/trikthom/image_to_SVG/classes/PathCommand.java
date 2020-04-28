package com.trikthom.image_to_SVG.classes;

public class PathCommand {

    private Type type;
    private Point point;
    private boolean relative = false;

    public PathCommand(Type type) {
        if (type.equals(Type.CLOSE_PATH)) this.type = type;
    }

    public PathCommand(Type type, Point point) {
        this(type, point, false);
    }

    public PathCommand(Type type, Point point, boolean relative) {
        this.type = type;
        this.point = point;
        this.relative = relative;
    }

    public enum Type {
        MOVE_TO("M"),
        LINE_TO("L"),
        HORIZONTAL_LINE_TO("H"),
        VERTICAL_LINE_TO("V"),
        CURVE_TO("C"),
        SMOOTH_CURVE_TO("S"),
        QUADRATIC_BEZIER_CURVE_TO("Q"),
        SMOOTH_QUADRATIC_BEZIER_CURVE_TO("T"),
        ELLIPTICAL_ARC("A"),
        CLOSE_PATH("Z");

        private final String value;

        Type(String value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return (relative ? type.value.toLowerCase() : type.value.toUpperCase()) + (point != null ? point.toString().replace(",", " ") : "");
    }
}
