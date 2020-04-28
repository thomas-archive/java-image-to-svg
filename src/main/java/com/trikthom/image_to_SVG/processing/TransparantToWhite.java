package com.trikthom.image_to_SVG.processing;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TransparantToWhite {

    public static BufferedImage generate(BufferedImage img) {
        BufferedImage b = img.getSubimage(0, 0, img.getWidth(), img.getHeight());

        for (int x = 0; x < b.getWidth(); x++) {
            for (int y = 0; y < b.getHeight(); y++) {
                if (b.getRGB(x, y) == 16777215 || b.getRGB(x, y) == 0) b.setRGB(x, y, new Color(255, 255, 255).getRGB());
            }
        }

        return b;
    }

}
