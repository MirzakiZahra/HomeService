package data.repository;

import data.model.services.MainService;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Update;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public interface ServiceRepository extends CrudRepository<MainService, Integer>{
    List<MainService> findMainServiceByName(String name);

    public void deleteMainService(MainService mainService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(mainService);
        transaction.commit();
        session.close();
    }

    public List<MainService> showServiceForSpeceficExpert(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from person where name =name";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(MainService.class);
        List<MainService> homeServices = query.list();
        return homeServices;
    }
    public void addMainService(MainService mainService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(mainService);
        transaction.commit();
        session.close();
    }

}
