package io.github.andygabler.swimsetplannerbackend.calendar;

import io.github.andygabler.swimsetplannerbackend.model.ScheduledSet;

import java.util.List;

public interface ScheduledSetService {

    List<ScheduledSet> getScheduledSets(
        String swimSetName,
        Long swimSetId,
        String scheduledDate
    );
}
