package data.repository;

import data.model.services.MainService;
import data.model.user.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminRepository extends CrudRepository<Manager, Integer> {

    List<Manager> findManagerByEmail(String email);

}
