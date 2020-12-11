package group03.project.services.implementation;

import group03.project.domain.Reflection;
import group03.project.services.offered.ReflectionService;
import group03.project.services.required.ReflectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReflectionServiceImpl implements ReflectionService {

    @Autowired
    private ReflectionRepository reflectionRepository;

    public List<Reflection> findall() {
        return reflectionRepository.findall();
    }

    //Adds a reflection
    public void save(Reflection reflection) {
        reflectionRepository.save(reflection);
    }

}
