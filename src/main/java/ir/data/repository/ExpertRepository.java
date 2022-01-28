package ir.data.repository;

import ir.data.model.user.Expert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpertRepository extends CrudRepository<Expert, Integer> {
    List<Expert> findAllByEmail(String email);
    List<Expert> findAllByPassword(String password);
}
