package com.trikthom.image_to_SVG.exceptions;

class Exception extends RuntimeException {

    Exception(String message) {
        super(message);
        System.err.print(this.getMessage());
        System.err.println(" [" + this.getStackTrace()[0] + "]");
    }

}
