package io.github.pashazz.walker.controllers;

import io.github.pashazz.walker.controllers.exceptions.WalkNotFoundException;
import io.github.pashazz.walker.entities.Walk;
import io.github.pashazz.walker.services.WalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* This is REST controller implementation without an intermediate service */

@RestController
public class WalkController {

    @Autowired
    private final WalkService walkService;

    public WalkController(WalkService walkService) {
        this.walkService = walkService;
    }

    @GetMapping("/walks")
    Iterable<Walk> all() {
        return walkService.all();
    }
    @PostMapping("/walks")
    Walk addWalk(@RequestBody Walk walk) {
        return walkService.addWalk(walk);
    }

    @GetMapping("/walks/{id}")
    Walk getWalk(@PathVariable Long id) {
        return walkService.getWalk(id);
    }

    @PutMapping("/walks/{id}")
    Walk replaceWalk(@PathVariable Long id, @RequestBody Walk replacement) {
        return walkService.replaceWalk(id, replacement);
    }

    @DeleteMapping("/walks/{id}")
    void deleteWalk(@PathVariable Long id) {
        walkService.deleteWalk(id);
    }


}
