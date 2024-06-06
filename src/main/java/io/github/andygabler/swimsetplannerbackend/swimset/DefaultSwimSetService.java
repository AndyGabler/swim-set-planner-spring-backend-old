package io.github.andygabler.swimsetplannerbackend.swimset;

import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultSwimSetService implements SwimSetService {

    @Autowired
    SwimSetRepository swimSetRepository;

    @Override
    public List<SwimSet> getSwimSet(String name, Long id) {
        List<SwimSet> sets = Collections.emptyList();
        SwimSet singletonResult = null;

        if (name != null && id != null) {
            throw new IllegalArgumentException("Cannot search by both name and id.");
        } else if (name != null) {
            singletonResult = swimSetRepository.findByName(name);
        } else if (id != null) {
            singletonResult = swimSetRepository.findById(id).orElse(null);
        } else {
            sets = swimSetRepository.findAll();
        }

        if (singletonResult != null) {
            sets = Collections.singletonList(singletonResult);
        }

        sets.forEach(set -> set.setLabels(set.getLabelText().split(",")));
        return sets;
    }
}
