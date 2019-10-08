package io.github.pashazz.walker.dao;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;

public interface PointDaoMethods {
    public Point getStart(Walk walk);

    public Point getStop(Walk walk);
}
