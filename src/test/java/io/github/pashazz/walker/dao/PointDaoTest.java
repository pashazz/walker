package io.github.pashazz.walker.dao;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.entities.PointType;
import io.github.pashazz.walker.entities.Walk;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PointDaoTest {

    @Autowired
    private PointDao pointDao;

    @Autowired
    private WalkDao walkDao;
/* If we want to use some kind of filler use this
    @TestConfiguration
    static class PointDaoTestConfiguration {
        @Autowired
        private PointDao pointDao;

        @Autowired
        private WalkDao walkDao;

        @Bean
        DataFillerService dataFillerService() {
            return new DataFillerService(pointDao, walkDao);
        }
    }
*/
    private Point one;
    private Point two;
    private  Walk walk;

    @Before
    public void setUp () {
        walk = new Walk(false, "Moscow Walk");
        walkDao.save(walk);

        one = new Point(walk, 55.759567, 37.628462, PointType.START);
        pointDao.save(one);

        two = new Point(walk, 55.672265, 37.282350, PointType.STOP);
        pointDao.save(two);


    }

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void walkIsFound() {
        var walks = walkDao.findAll();
        Walk walk = null;
        for (Walk item: walks) {
            walk = item;
        }
        assertNotNull("Walk should be found", walk);

        assertEquals(walk.getId(), this.walk.getId());
    }

    @Test
    public void getStartPointForWalk() {

        Point start = pointDao.getStart(walk);
        assertEquals(start, one);
    }

    @Test
    public void getStopPointForWalk() {
        Point stop = pointDao.getStop(walk);
        assertEquals(stop, two);
    }

    @Test
    public void getPointsForWalk() {
        List<Point> points = pointDao.getPoints(walk);
        assertThat(points, CoreMatchers.hasItems(one, two));
        assertEquals(2, points.size());
    }
}