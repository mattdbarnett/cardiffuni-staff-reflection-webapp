package group03.project.services.implementation;

import group03.project.domain.Participation;
import group03.project.repositories.ParticipationRepository;
import group03.project.services.required.ParticipationRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipationService implements ParticipationRead {

    @Autowired
    private ParticipationRepository participationRepo;

    //Returns a list of all participations in the database
    public List<Participation> getAllParticipations() {
        List<Participation> participations = new ArrayList<>();
        participationRepo.findAll().forEach(participations::add);
        return participations;
    }

    //Adds an activity
    public void save(Participation participation) {
        participationRepo.save(participation);
    }

    //Returns the number of activities in the database
    public int getParticipationListSize() {
        List<Participation> participation = new ArrayList<>();
        participationRepo.findAll().forEach(participation::add);
        return participation.size();
    }

    @Override
    public List<Participation> findall() {
        return participationRepo.findAll();
    }
}
