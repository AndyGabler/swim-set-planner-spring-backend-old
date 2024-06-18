package io.github.andygabler.swimsetplannerbackend.calendar;

import io.github.andygabler.swimsetplannerbackend.model.ScheduledSet;
import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduledSetRepository extends JpaRepository<ScheduledSet, Long> {

    List<ScheduledSet> findByScheduledSetOrderByDateScheduled(SwimSet scheduledSet);

    // TODO make a between date deal
    List<ScheduledSet> findByDateScheduledOrderByOrder(String scheduledDate);

    // TODO make a between date deal
    List<ScheduledSet> findByDateScheduledAndScheduledSetOrderByOrder(
        String scheduledDate,
        SwimSet scheduledSet
    );
}
