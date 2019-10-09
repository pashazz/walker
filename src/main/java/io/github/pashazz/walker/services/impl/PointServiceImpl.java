package io.github.pashazz.walker.services.impl;

import io.github.pashazz.walker.controllers.exceptions.PointExistsException;
import io.github.pashazz.walker.controllers.exceptions.StartPointExistsException;
import io.github.pashazz.walker.controllers.exceptions.StopPointExistsException;
import io.github.pashazz.walker.controllers.exceptions.WalkNotFoundException;
import io.github.pashazz.walker.dao.PointDao;
import io.github.pashazz.walker.dao.WalkDao;
import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.PointType;
import io.github.pashazz.walker.entities.Walk;
import io.github.pashazz.walker.services.PointService;
import io.github.pashazz.walker.services.WalkService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PointServiceImpl implements PointService {

    private final PointDao pointDao;

    private final WalkService walkService;



    public PointServiceImpl(PointDao pointDao, WalkService walkService){
        this.pointDao = pointDao;
        this.walkService = walkService;
    }


    private Walk getWalkById(Long walkId) throws WalkNotFoundException {
        return walkService.getWalk(walkId);
    }

    @Override
    public Point add(Point point) throws PointExistsException {
        Walk walk = point.getWalk();
        PointType type = point.getType();
        switch (type) {
            case START:
                Point startPoint = pointDao.getStart(walk);
                if (startPoint != null) {
                    throw new StartPointExistsException(walk, startPoint);
                }
                break;
            case STOP:
                Point stopPoint = pointDao.getStop(walk);
                if (stopPoint != null) {
                    throw new StopPointExistsException(walk, stopPoint);
                }
                break;
        }

        return pointDao.save(point);
    }

    @Override
    public List<Point> getAll(Long id) {
        return pointDao.getPoints(getWalkById(id));
    }
}
