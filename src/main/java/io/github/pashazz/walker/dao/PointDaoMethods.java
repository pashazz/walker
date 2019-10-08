package io.github.pashazz.walker.dao;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;

import java.util.List;

public interface PointDaoMethods {
    public Point getStart(Walk walk);

    public Point getStop(Walk walk);

    public List<Point> getPoints(Walk walk);
}
