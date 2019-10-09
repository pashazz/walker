package io.github.pashazz.walker.services.impl;

import io.github.pashazz.walker.controllers.exceptions.WalkNotFoundException;
import io.github.pashazz.walker.dao.WalkDao;
import io.github.pashazz.walker.entities.Walk;
import io.github.pashazz.walker.services.WalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalkServiceImpl implements WalkService {
    @Autowired
    private WalkDao walkDao;



    @Override
    public Iterable<Walk> all() {
        return walkDao.findAll();
    }

    @Override
    public Walk addWalk(Walk walk) {
        return walkDao.save(walk);
    }


    @Override
    public Walk getWalk(Long id) {
        return walkDao.findById(id).orElseThrow(() -> new WalkNotFoundException(id));
    }

    @Override
    public Walk replaceWalk(Long id, Walk replacement) {
        return walkDao.findById(id).map(walk -> {
            walk.setName(replacement.getName());
            return walkDao.save(walk);
        }).orElseGet(() -> {
            replacement.setId(id);
            return walkDao.save(replacement);
        });
    }

    @Override
    public void deleteWalk(Long id) {
        walkDao.deleteById(id);
    }

}
