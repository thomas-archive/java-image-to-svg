package com.trikthom.image_to_SVG.exceptions;

import java.util.List;

public class MissingRequiredPropertiesException extends Exception {

    public MissingRequiredPropertiesException(List<String> strings) {
        super("Missing required properties: " + strings.toString());
    }
}
