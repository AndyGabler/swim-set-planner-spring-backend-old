package io.github.andygabler.swimsetplannerbackend.calendar;

import io.github.andygabler.swimsetplannerbackend.model.ScheduledSet;

import java.sql.Date;
import java.util.List;

public interface ScheduledSetService {

    List<ScheduledSet> getScheduledSets(
        String swimSetName,
        Long swimSetId,
        Date scheduledDate
    );
}
