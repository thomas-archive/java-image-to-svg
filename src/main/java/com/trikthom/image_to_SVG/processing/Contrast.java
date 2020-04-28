package com.trikthom.image_to_SVG.processing;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class Contrast {

    public static BufferedImage generate(BufferedImage img, Float scaleFactor) {
        BufferedImage b = img.getSubimage(0, 0, img.getWidth(), img.getHeight());

        RescaleOp op = new RescaleOp(scaleFactor, 0, null);
        b = op.filter(b, b);

        return b;
    }

}
