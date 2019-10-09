package io.github.pashazz.walker.db;

import io.github.pashazz.walker.dao.PointDao;
import io.github.pashazz.walker.dao.WalkDao;
import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.PointType;
import io.github.pashazz.walker.entities.Walk;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;


@Service
public class DataFillerService {

    private static final Logger LOG = LogManager.getLogger(DataFillerService.class);

    @Autowired
    private final PointDao pointDao;

    @Autowired
    private final WalkDao walkDao;

    public DataFillerService(PointDao pointDao, WalkDao walkDao) {
        this.pointDao = pointDao;
        this.walkDao = walkDao;
    }

    @PostConstruct
    @Transactional
    public void fillData() {
        final var  walkName = "Moscow CenterWalk";
        if (walkDao.count() > 0) {
            LOG.debug("DB already populated");
            return;
        }


        LOG.debug("PostConstruct: Filling new data {}", walkName);
        Walk testWalk = new Walk(false, "Moscow Center Walk");
        walkDao.save(testWalk);
        Point one = new Point(testWalk, 55.759567, 37.628462, PointType.START);
        pointDao.save(one);

        Point two = new Point(testWalk, 55.672265, 37.282350, PointType.STOP);
        pointDao.save(two);

        LOG.debug("Finished filling new data");
    }
}
