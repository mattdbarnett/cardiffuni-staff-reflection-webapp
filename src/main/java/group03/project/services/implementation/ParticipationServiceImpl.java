package group03.project.services.implementation;

import group03.project.domain.Participation;
import group03.project.services.required.ParticipationRepository;
import group03.project.services.offered.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipationServiceImpl implements ParticipationService {

    @Autowired
    private ParticipationRepository participationRepo;

    @Override
    public List<Participation> findAllParticipations() { return participationRepo.findAll(); }

    //Returns a list of all participations in the database
    public List<Participation> getAllParticipations() {
        List<Participation> participations = new ArrayList<>();
        participationRepo.findAll().forEach(participations::add);
        return participations;
    }
    //Adds a participation
    @Override
    public void createParticipation(Participation participation) { participationRepo.save(participation); }

    //Returns the number of activities in the database
    @Override
    public Integer getParticipationListSize() {
        List<Participation> participation = new ArrayList<>();
        participationRepo.findAll().forEach(participation::add);
        return participation.size();
    }
}
