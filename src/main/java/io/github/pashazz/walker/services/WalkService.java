package io.github.pashazz.walker.services;

import io.github.pashazz.walker.entities.Walk;

public interface WalkService {
    Iterable<Walk> all();

    Walk addWalk(Walk walk);

    Walk getWalk(Long id);

    Walk replaceWalk(Long id, Walk replacement);

    void deleteWalk(Long id);
}
