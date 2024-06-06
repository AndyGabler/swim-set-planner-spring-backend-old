package io.github.andygabler.swimsetplannerbackend.calendar;

import io.github.andygabler.swimsetplannerbackend.model.ScheduledSet;
import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import io.github.andygabler.swimsetplannerbackend.swimset.SwimSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultScheduledSetService implements ScheduledSetService {

    @Autowired
    SwimSetService swimSetService;

    @Autowired
    ScheduledSetRepository scheduledSetRepository;

    @Override
    public List<ScheduledSet> getScheduledSets(String swimSetName, Long swimSetId, Date scheduledDate) {
        SwimSet swimSet = null;

        if (swimSetName != null || swimSetId != null) {
            swimSet = swimSetService.getSwimSet(swimSetName, swimSetId)
                .stream()
                .findFirst()
                .orElse(null);
            if (swimSet == null) {
                return Collections.emptyList();
            }
        }

        List<ScheduledSet> results;
        if (swimSet != null && scheduledDate != null) {
            results = scheduledSetRepository.findByDateScheduledAndScheduledSetOrderByOrder(
                scheduledDate,
                swimSet
            );
        } else if (scheduledDate != null) {
            results = scheduledSetRepository.findByDateScheduledOrderByOrder(scheduledDate);
        } else if (swimSet != null) {
            results = scheduledSetRepository.findByScheduledSetOrderByDateScheduled(swimSet);
        } else {
            results = scheduledSetRepository.findAll();
        }

        return results;
    }
}
