package group03.project.services.required;

import group03.project.domain.Participation;

import java.util.List;
import java.util.Optional;

public interface ParticipationRepository {

    List<Participation> findAll();

    Participation save(Participation theParticipation);

    public Optional<Participation> findById(Integer id);
}
