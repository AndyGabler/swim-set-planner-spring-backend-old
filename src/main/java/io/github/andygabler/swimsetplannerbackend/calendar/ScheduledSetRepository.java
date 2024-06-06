package io.github.andygabler.swimsetplannerbackend.calendar;

import io.github.andygabler.swimsetplannerbackend.model.ScheduledSet;
import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ScheduledSetRepository extends JpaRepository<ScheduledSet, Long> {

    List<ScheduledSet> findByScheduledSetOrderByDateScheduled(SwimSet scheduledSet);

    // TODO make a between date deal
    List<ScheduledSet> findByDateScheduledOrderByOrder(Date scheduledDate);

    // TODO make a between date deal
    List<ScheduledSet> findByDateScheduledAndScheduledSetOrderByOrder(
        Date scheduledDate,
        SwimSet scheduledSet
    );
}
