package ir.data.repository;

import ir.data.model.user.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminRepository extends CrudRepository<Manager, Integer> {

    List<Manager> findManagerByEmail(String email);

}
