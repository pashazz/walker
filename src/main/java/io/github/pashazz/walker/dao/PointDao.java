package io.github.pashazz.walker.dao;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;
import org.springframework.data.repository.CrudRepository;

public interface PointDao extends CrudRepository<Point, Long> {
    public Point getStart(Walk walk);

    public Point getStop(Walk walk);
}
