package io.github.andygabler.swimsetplannerbackend.swimset;

import io.github.andygabler.swimsetplannerbackend.model.SwimSet;

import java.util.List;

public interface SwimSetService {

    List<SwimSet> getSwimSet(String name, Long id);
}
