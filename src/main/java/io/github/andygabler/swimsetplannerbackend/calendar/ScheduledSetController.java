package io.github.andygabler.swimsetplannerbackend.calendar;

import io.github.andygabler.swimsetplannerbackend.model.ScheduledSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Pattern;

@RestController
public class ScheduledSetController {

    @Autowired
    ScheduledSetService scheduledSetService;

    @GetMapping("/setschedule")
    public ResponseEntity<?> getScheduledSet(
        @RequestParam(required = false)
        String swimSetName,
        @RequestParam(required = false)
        Long swimSetId,
        @RequestParam(required = false)
        String scheduledDate
    ) {
        if (scheduledDate != null && !Pattern.compile("\\d{4}\\-\\d{2}\\-\\d{2}").matcher(scheduledDate).matches()) {
            return new ResponseEntity<>("bad scheduledDate: " + scheduledDate, HttpStatus.BAD_REQUEST);
        }
        List<ScheduledSet> sets;

        try {
            sets = scheduledSetService.getScheduledSets(swimSetName, swimSetId, scheduledDate);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(sets, HttpStatus.OK);
    }
}
