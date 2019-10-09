package io.github.pashazz.walker.controllers;

import io.github.pashazz.walker.entities.Point;
import io.github.pashazz.walker.services.PointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PointController {
    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;

    }


    @GetMapping("/walks/{id}/points")
    List<Point> getPointsForWalk(@PathVariable Long id) {
        return pointService.getAll(id);
    }

    @PostMapping("/points")
    Point addPoint(@RequestBody Point point) {
        return pointService.add(point);
    }

}
