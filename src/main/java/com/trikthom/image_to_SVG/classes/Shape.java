package com.trikthom.image_to_SVG.classes;

import com.trikthom.image_to_SVG.annotations.Attribute;

import java.util.*;

public abstract class Shape {

    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        LinkedHashMap<String, String> attributes = new LinkedHashMap<>();

        try {
            for (java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {
                if (field.getDeclaredAnnotation(Attribute.class) != null) {
                    field.setAccessible(true);

                    String attribute = field.getDeclaredAnnotation(Attribute.class).value();
                    if (attribute.isEmpty()) attribute = field.getName();

                    attributes.put(attribute, String.valueOf(field.get(this)));

                    field.setAccessible(false);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        StringBuilder output = new StringBuilder("<" + name + " ");

        for (String attribute : attributes.keySet()) {
            output.append(attribute).append("=\"").append(attributes.get(attribute)).append("\" ");
        }

        output.append(" />");

        return output.toString();
    }
}
