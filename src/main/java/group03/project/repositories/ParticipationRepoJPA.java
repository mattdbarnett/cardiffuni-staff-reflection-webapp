package group03.project.repositories;

import group03.project.domain.Activity;
import group03.project.domain.Participation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepoJPA extends JpaRepository<Participation, Integer>, ParticipationRepository {

}