package io.github.pashazz.walker.dao;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;
import org.springframework.data.repository.CrudRepository;

public interface WalkDao extends CrudRepository<Walk, Long> {

}

