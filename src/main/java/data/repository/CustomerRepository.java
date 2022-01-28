package data.repository;

import data.model.services.MainService;
import data.model.user.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findAllByPassword(String password);
    List<Customer> findAllByEmail(String email);
}
