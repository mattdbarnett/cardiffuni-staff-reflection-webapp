package group03.project.services.offered;

import group03.project.domain.Reflection;

import java.util.List;

public interface ReflectionService {

    public List<Reflection> findAllReflections();

    public void saveReflection(Reflection reflection);
}
