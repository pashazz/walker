package io.github.pashazz.walker.controllers.exceptions;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;

public class StopPointExistsException extends PointExistsException {
    public StopPointExistsException(Walk walk, Point point) {
        super("Stop", walk, point);
    }
}
