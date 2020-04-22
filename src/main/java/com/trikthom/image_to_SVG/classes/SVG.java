package com.trikthom.image_to_SVG.classes;

import com.trikthom.image_to_SVG.classes.shapes.Circle;

import java.io.FileWriter;
import java.io.IOException;

public class SVG {

    private FileWriter fileWriter;

    public SVG(FileWriter fileWriter) throws IOException {

        this.fileWriter = fileWriter;
        int height = 100;
        int width = 100;
        String pre = "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 " + height + " " + width + "\">";
        fileWriter.append(pre);
        write("<circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"green\" stroke-width=\"4\" fill=\"yellow\" />");
        write(new Circle().toString());

        String post = "</svg>";
        fileWriter.append(post);
        fileWriter.close();
        System.out.println("Successfully wrote to the file.");
    }

    private void write(String string) {
        try {

            fileWriter.append(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
