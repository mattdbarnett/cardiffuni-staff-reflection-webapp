package group03.project.services.required;

import group03.project.domain.Reflection;

import java.util.List;
import java.util.Optional;

public interface ReflectionRepository {

    List<Reflection> findall();

    Reflection save(Reflection theReflection);

    Optional<Reflection> findById(Integer id);

}
