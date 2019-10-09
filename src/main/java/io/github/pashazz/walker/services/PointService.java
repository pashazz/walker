package io.github.pashazz.walker.services;

import io.github.pashazz.walker.controllers.exceptions.PointExistsException;
import io.github.pashazz.walker.controllers.exceptions.WalkNotFoundException;
import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.PointType;
import io.github.pashazz.walker.entities.Walk;

import java.util.List;

public interface PointService {
    Point add(Point point) throws PointExistsException, WalkNotFoundException;

    List<Point> getAll(Long walkId) throws WalkNotFoundException;
}
