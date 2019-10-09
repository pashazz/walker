package io.github.pashazz.walker.controllers.exceptions;

public class WalkNotFoundException extends RuntimeException {
    public WalkNotFoundException(Long id) {
        super("Walk not found: " + id);
    }
}
