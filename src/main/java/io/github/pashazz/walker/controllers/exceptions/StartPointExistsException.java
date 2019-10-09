package io.github.pashazz.walker.controllers.exceptions;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;

public class StartPointExistsException extends PointExistsException {
    public StartPointExistsException(Walk walk, Point point) {
        super("Stop", walk, point);
    }
}
