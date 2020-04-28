package com.trikthom.image_to_SVG.classes;

import lombok.Getter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SVG {

    private FileWriter fileWriter;
    private final int width;
    private final int height;
    @Getter
    private final String name;
    private final List<Object> elements = new ArrayList<>();

    public SVG(String filename, Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.name = filename.substring(0, filename.lastIndexOf('.')) + ".svg";
        try {
            fileWriter = new FileWriter(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(Shape shape) {
        elements.add(shape);
    }

    public void append(Group group) {
        elements.add(group);
    }

    public void save() {
        try {
            String pre = "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 " + height + " " + width + "\">\n";
            fileWriter.write(pre);

            for (Object element : elements) fileWriter.append('\t').append(element.toString()).append('\n');

            String post = "</svg>";
            fileWriter.append(post);
            fileWriter.close();
            System.out.println("Successfully saved the svg.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
