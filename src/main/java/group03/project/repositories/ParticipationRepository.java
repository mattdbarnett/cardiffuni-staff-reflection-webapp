package group03.project.repositories;

import group03.project.domain.Activity;
import group03.project.domain.Participation;
import group03.project.domain.Tag;

import java.util.List;
import java.util.Optional;

public interface ParticipationRepository {

    List<Participation> findAll();

    Participation save(Participation theParticipation);

    public Optional<Participation> findById(Integer id);
}
