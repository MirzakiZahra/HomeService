package ir.data.repository;

import ir.data.model.user.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findAllByPassword(String password);

    List<Customer> findAllByEmail(String email);

    Customer findByEmailAndPassword(String email, String password);
}
