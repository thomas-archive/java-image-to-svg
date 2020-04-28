package com.trikthom.image_to_SVG.processing;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BlackAndWhite {

    public static BufferedImage generate(BufferedImage img) {
        BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D g = gray.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();

        return gray;
    }

}
