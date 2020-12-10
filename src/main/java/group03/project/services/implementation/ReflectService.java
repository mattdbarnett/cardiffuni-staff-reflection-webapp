package group03.project.services.implementation;

import group03.project.domain.Activity;
import group03.project.domain.Reflection;
import group03.project.repositories.ReflectRepository;
import group03.project.services.required.ReflectionRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.List;

@Service
public class ReflectService implements ReflectionRead {

    @Autowired
    private group03.project.repositories.ReflectRepository reflectRepository;

    @Override
    public List<Reflection> findall() {
        return reflectRepository.findAll();
    }

    //Adds a reflection
    public void save(Reflection reflection) {
        reflectRepository.save(reflection);
    }
}
