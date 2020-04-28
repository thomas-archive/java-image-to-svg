package com.trikthom.image_to_SVG.classes.shapes;

import com.sun.deploy.util.StringUtils;
import com.trikthom.image_to_SVG.annotations.Attribute;
import com.trikthom.image_to_SVG.classes.PathCommand;
import com.trikthom.image_to_SVG.classes.Point;
import com.trikthom.image_to_SVG.classes.Shape;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Path extends Shape {

    private @Attribute("d") PathCommands pathCommands;
    private @Attribute String stroke;
    private @Attribute("stroke-width") int strokeWidth;
    private @Attribute String fill;

    public Path() {
        this(Arrays.asList(
                new PathCommand(PathCommand.Type.MOVE_TO, new Point(10, 35)),
                new PathCommand(PathCommand.Type.QUADRATIC_BEZIER_CURVE_TO, new Point(15, -30, 30, 0), true),
                new PathCommand(PathCommand.Type.CLOSE_PATH)
        ), "black", 1, "none");
    }

    public Path(List<PathCommand> pathCommands, String stroke, Integer strokeWidth, String fill) {
        super("path");
        this.pathCommands = new PathCommands(pathCommands);
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

    private static class PathCommands {
        private final List<PathCommand> pathCommands;

        PathCommands(List<PathCommand> pathCommands) {
            this.pathCommands = pathCommands;
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            for (PathCommand pathCommand : pathCommands) output.append(pathCommand).append(" ");
            return output.toString().trim();
        }
    }
}
