package data.repository;

import data.model.services.SubService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@Repository
public interface SubServiceRepository extends CrudRepository<SubService,Integer>, JpaSpecificationExecutor<SubService> {
    @Query(value = "select * from subService", nativeQuery = true)
    List<SubService> findAllSubService();
    SubService findById(int id);
    SubService findByName(String name);
    List<SubService> findAllByName(String name);
}
