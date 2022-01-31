package ir.data.repository;

import ir.data.model.user.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    List<Admin> findManagerByEmail(String email);

}
