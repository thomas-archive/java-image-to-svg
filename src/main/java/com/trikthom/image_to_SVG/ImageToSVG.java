package com.trikthom.image_to_SVG;

import com.trikthom.image_to_SVG.annotations.Required;
import com.trikthom.image_to_SVG.classes.SVG;
import com.trikthom.image_to_SVG.classes.Settings;
import com.trikthom.image_to_SVG.classes.shapes.Circle;
import com.trikthom.image_to_SVG.classes.shapes.Ellipse;
import com.trikthom.image_to_SVG.classes.shapes.Line;
import com.trikthom.image_to_SVG.classes.shapes.Rectangle;
import com.trikthom.image_to_SVG.exceptions.MissingRequiredPropertiesException;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageToSVG {

    private final @Required String filename;
    private final Settings settings;
    private BufferedImage image;

    public static void main(String[] args) {

        String filename = args.length >= 1 ? args[0] : null;

        ImageToSVG imageToSVG = new ImageToSVG(filename);

    }

    public ImageToSVG(String filename) {
        this(filename, null);
    }

    public ImageToSVG(String filename, Settings settings) {
        this.filename = filename;
        this.settings = settings;

        checkAttributes();

        System.out.println("Loaded Image to SVG");
//        System.out.println(filename);
//
//        File file = new File(filename);
//
//        try {
//            image = ImageIO.read(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        Color color = new Color(image.getRGB(0,0));
//
//        System.out.println(color.getRed() + " " + color.getGreen() + " " + color.getBlue());

        createTestSVG();
    }

    private void createTestSVG() {
        SVG svg = new SVG(filename, 100, 100);
        Circle circle = new Circle();
        circle.setFill("#00feaa");
        circle.setCy(0);
        svg.append(circle);
        svg.append(new Circle());
        svg.append(new Circle(10, 10, 20, "black", 2, "#ffffaa"));
        svg.append(new Rectangle());
        svg.append(new Ellipse());
        svg.append(new Line());
        svg.save();
    }

    private void checkAttributes() {

        List<String> errors = new ArrayList<>();

        for (java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {
            if (field.getDeclaredAnnotation(Required.class) != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(this) == null || "".equals(field.get(this))) errors.add(field.getName());
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        if (errors.size() > 0) throw new MissingRequiredPropertiesException(errors);
    }

}
