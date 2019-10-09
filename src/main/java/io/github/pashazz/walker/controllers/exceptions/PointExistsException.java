package io.github.pashazz.walker.controllers.exceptions;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;

public class PointExistsException extends RuntimeException {
    static String buildString(String state, Walk walk, Point point) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(state);
        stringBuilder.append(" point already exists for walk ");
        stringBuilder.append(walk.getId());
        stringBuilder.append(" (");
        stringBuilder.append(walk.getName());
        stringBuilder.append("). Its coordinates are: latitude: ");
        stringBuilder.append(point.getLat());
        stringBuilder.append("; longtitude: ");
        stringBuilder.append(point.getLon());
        return stringBuilder.toString();
    }
    public PointExistsException(String state, Walk walk, Point point) {
        super(buildString(state, walk,point));
    }
}
