package com.trikthom.image_to_SVG;

import com.trikthom.image_to_SVG.annotations.Required;
import com.trikthom.image_to_SVG.classes.SVG;
import com.trikthom.image_to_SVG.classes.Settings;
import com.trikthom.image_to_SVG.exceptions.MissingRequiredPropertiesException;
import com.trikthom.image_to_SVG.processing.BlackAndWhite;
import com.trikthom.image_to_SVG.processing.Contrast;
import com.trikthom.image_to_SVG.processing.Noise;
import com.trikthom.image_to_SVG.processing.TransparantToWhite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageToSVG {

    private final @Required String filename;
    private final Settings settings;
    private BufferedImage image;
    private SVG svg;

    public static void main(String[] args) {

        String filename = args.length >= 1 ? args[0] : null;

        ImageToSVG imageToSVG = new ImageToSVG(filename);
        imageToSVG.generate();
        imageToSVG.save();

    }

    public ImageToSVG(String filename) {
        this(filename, null);
    }

    public ImageToSVG(String filename, Settings settings) {
        this.filename = filename;
        this.settings = settings;

        checkAttributes();

        System.out.println("Loaded Image to SVG");

        try {
            File file = new File(filename);
            image = ImageIO.read(file);
            System.out.println("Image " + file.getName() + " successfully loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void generate() {
        processImage();
        svg = new SVG(filename, image.getHeight(), image.getWidth());
        System.out.println("Generating " + svg.getName());
        long start = System.currentTimeMillis();

        long time = System.currentTimeMillis() - start;

        // temporary
        try {
            ImageIO.write(image, "png", new File("./a.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("SVG generated in " + time + "ms.");
    }

    public void processImage() {
        System.out.println("Processing image...");
        long start = System.currentTimeMillis();

        image = BlackAndWhite.generate(Contrast.generate(TransparantToWhite.generate(image), 1.8f));
        image = Noise.generate(image);

        long time = System.currentTimeMillis() - start;

        System.out.println("Image processed in " + time + "ms.");
    }

    public void save() {
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
