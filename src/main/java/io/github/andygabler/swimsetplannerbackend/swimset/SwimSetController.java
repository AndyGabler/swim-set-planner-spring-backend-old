package io.github.andygabler.swimsetplannerbackend.swimset;

import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SwimSetController {

    @Autowired
    SwimSetService swimSetService;

    @GetMapping("/swimsets")
    public ResponseEntity<?> getSwimSets(
        @RequestParam(required = false)
        String name,
        @RequestParam(required = false)
        Long id
    ) {
        List<SwimSet> sets;

        try {
            sets = swimSetService.getSwimSet(name, id);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (sets.isEmpty()) {
            return new ResponseEntity<>(sets, HttpStatus.NOT_FOUND);
        }

        sets.forEach(set -> set.setLabels(set.getLabelText().split(",")));
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }
}
