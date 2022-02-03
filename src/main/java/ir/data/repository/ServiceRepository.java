package ir.data.repository;

import ir.data.model.services.MainService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<MainService, Integer> {
    List<MainService> findMainServiceByName(String name);
}
