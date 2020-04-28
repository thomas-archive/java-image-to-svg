package com.trikthom.image_to_SVG.processing;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Noise {

    public static BufferedImage generate(BufferedImage img) {

        BufferedImage proxyimage = img.getSubimage(0, 0, img.getWidth(), img.getHeight());

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int ri = new Color(img.getRGB(x, y)).getRed();
                int gi = new Color(img.getRGB(x, y)).getGreen();
                int bi = new Color(img.getRGB(x, y)).getBlue();

                if (ri == 255 & gi == 255 & bi == 255) {

                    Color c00 = new Color(255, 255, 255);
                    Color c01 = new Color(255, 255, 255);
                    Color c02 = new Color(255, 255, 255);
                    Color c10 = new Color(255, 255, 255);
                    Color c11 = new Color(255, 255, 255);
                    Color c12 = new Color(255, 255, 255);
                    Color c20= new Color(255, 255, 255);
                    Color c21 = new Color(255, 255, 255);
                    Color c22 = new Color(255, 255, 255);

                    try {
                        c00 = new Color(proxyimage.getRGB(x - 1, y - 1));
                        c01 = new Color(proxyimage.getRGB(x - 1, y));
                        c02 = new Color(proxyimage.getRGB(x - 1, y + 1));
                        c10 = new Color(proxyimage.getRGB(x, y - 1));
                        c11 = new Color(proxyimage.getRGB(x, y));
                        c12 = new Color(proxyimage.getRGB(x, y + 1));
                        c20 = new Color(proxyimage.getRGB(x + 1, y - 1));
                        c21 = new Color(proxyimage.getRGB(x + 1, y));
                        c22 = new Color(proxyimage.getRGB(x + 1, y + 1));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        //
                    }

                    int r = c00.getRed() / 9 + c01.getRed() / 9 + c02.getRed()
                            / 9 + c10.getRed() / 9 + c11.getRed() / 9
                            + c12.getRed() / 9 + c20.getRed() / 9
                            + c21.getRed() / 9 + c22.getRed() / 9;

                    int g = c00.getGreen() / 9 + c01.getGreen() / 9
                            + c02.getGreen() / 9 + c10.getGreen() / 9
                            + c11.getGreen() / 9 + c12.getGreen() / 9
                            + c20.getGreen() / 9 + c21.getGreen() / 9
                            + c22.getGreen() / 9;

                    int b = c00.getBlue() / 9 + c01.getBlue() / 9
                            + c02.getBlue() + c10.getBlue() / 9 + c11.getBlue()
                            / 9 + c12.getBlue() / 9 + c20.getBlue() / 9
                            + c21.getBlue() / 9 + c22.getBlue() / 9;

                    r = Math.min(255, Math.max(0, r));
                    g = Math.min(255, Math.max(0, g));
                    b = Math.min(255, Math.max(0, b));

                    Color c = new Color(r, g, b);

                    proxyimage.setRGB(x, y, c.getRGB());
                }
            }
        }

        return proxyimage;
    }

}
