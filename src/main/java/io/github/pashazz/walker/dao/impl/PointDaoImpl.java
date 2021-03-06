package io.github.pashazz.walker.dao.impl;

import io.github.pashazz.walker.dao.PointDao;
import io.github.pashazz.walker.dao.PointDaoMethods;
import io.github.pashazz.walker.dao.WalkDao;
import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.Walk;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PointDaoImpl implements PointDaoMethods {
    private static final Logger LOG = LogManager.getLogger(PointDaoImpl.class);

    @PersistenceContext //org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor
    private EntityManager em;

    @Override
    public Point getStart(Walk walk) {
        final String qText = "point.start.by.walkId";
        return executeNamedQueryOnWalk(walk, qText);
    }

    @Override
    public Point getStop(Walk walk) {
        final String qText = "point.stop.by.walkId";
        return executeNamedQueryOnWalk(walk, qText);
    }

    @Override
    public List<Point> getPoints(Walk walk) {
        String text = "points.by.walkId";
        LOG.trace("executing Query {} with id {}", text, walk.getId());
        var query = this.em.createNamedQuery(text, Point.class).
                setParameter("walkId", walk.getId());
        var items = query.getResultList();
        LOG.trace("result list: {}", items);
        return items;
    }

    private Point executeNamedQueryOnWalk(Walk walk, String text) {
        LOG.trace("executing Query {} with id {}", text, walk.getId());
        var query = this.em.createNamedQuery(text, Point.class).
                setParameter("walkId", walk.getId());
        var items = query.getResultList();
        LOG.trace("result list: {}", items);
        return items.size() > 0 ? items.get(0) : null;
    }
}
