package io.github.pashazz.walker.dao;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;
import org.springframework.data.repository.CrudRepository;

import javax.management.Query;

public interface PointDao extends CrudRepository<Point, Long>, PointDaoMethods {

}
