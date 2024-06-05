package io.github.andygabler.swimsetplannerbackend.swimset;

import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SwimSetController {

    @Autowired
    SwimSetRepository repository;

    @GetMapping("/swimsets")
    public List<SwimSet> getSwimSets() {
        List<SwimSet> sets = repository.findAll();
        sets.forEach(set -> set.setLabels(set.getLabelText().split(",")));
        return sets;
    }
}
