package group03.project.repositories;

import group03.project.domain.Reflection;

import java.util.List;

public interface ReflectRepository {

    List<Reflection> findAll();

    Reflection save(Reflection theReflection);
}
