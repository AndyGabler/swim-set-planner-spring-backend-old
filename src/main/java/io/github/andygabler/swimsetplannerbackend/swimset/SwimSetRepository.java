package io.github.andygabler.swimsetplannerbackend.swimset;

import io.github.andygabler.swimsetplannerbackend.model.SwimSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimSetRepository extends JpaRepository<SwimSet, Long> {

    SwimSet getByName(String name);
}
