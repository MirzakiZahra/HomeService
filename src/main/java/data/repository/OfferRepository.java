package data.repository;

import data.model.Offer;
import data.model.services.MainService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public interface OfferRepository extends CrudRepository<Offer, Integer> {
   Offer findOfferById(int id);
}