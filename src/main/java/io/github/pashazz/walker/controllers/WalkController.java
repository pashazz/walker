package io.github.pashazz.walker.controllers;

import io.github.pashazz.walker.controllers.exceptions.WalkNotFoundException;
import io.github.pashazz.walker.dao.WalkDao;
import io.github.pashazz.walker.entities.Walk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* This is REST controller implementation without an intermediate service */

@RestController
public class WalkController {

    private final WalkDao walkDao;

    WalkController(WalkDao walkDao) {
        this.walkDao = walkDao;
    }

    @GetMapping("/walks")
    Iterable<Walk> all() {
        return walkDao.findAll();
    }
    @PostMapping("/walks")
    Walk addWalk(@RequestBody Walk walk) {
        return walkDao.save(walk);
    }

    @GetMapping("/walks/{id}")
    Walk getWalk(@PathVariable Long id) {
        return walkDao.findById(id).orElseThrow(() -> new WalkNotFoundException(id));
    }

    @PutMapping("/walks/{id}")
    Walk replaceWalk(@PathVariable Long id, @RequestBody Walk replacement) {
        return walkDao.findById(id).map(walk -> {
            walk.setName(replacement.getName());
            return walkDao.save(walk);
        }).orElseGet(() -> {
            replacement.setId(id);
            return walkDao.save(replacement);
        });
    }

    @DeleteMapping("/walks/{id}")
    void deleteWalk(@PathVariable Long id) {
        walkDao.deleteById(id);
    }


}
