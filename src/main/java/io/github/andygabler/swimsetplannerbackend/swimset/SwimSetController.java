package io.github.andygabler.swimsetplannerbackend.swimset;

import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SwimSetController {

    @Autowired
    SwimSetRepository repository;

    @GetMapping("/swimsets")
    public ResponseEntity<List<SwimSet>> getSwimSets(
        @RequestParam(required = false)
        String name,
        @RequestParam(required = false)
        Long id
    ) {
        List<SwimSet> sets = Collections.emptyList();
        SwimSet singletonResult = null;

        if (name != null && id != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (name != null) {
            singletonResult = repository.findByName(name);
        } else if (id != null) {
            singletonResult = repository.findById(id).orElse(null);
        } else {
            sets = repository.findAll();
        }

        if (singletonResult != null) {
            sets = Collections.singletonList(singletonResult);
        }

        if (sets.isEmpty()) {
            return new ResponseEntity<>(sets, HttpStatus.NOT_FOUND);
        }

        sets.forEach(set -> set.setLabels(set.getLabelText().split(",")));
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }
}
