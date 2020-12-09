package group03.project.repositories;

import group03.project.domain.Participation;
import group03.project.services.required.ParticipationRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepoJPA extends JpaRepository<Participation, Integer>, ParticipationRepository {

}