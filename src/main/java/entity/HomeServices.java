package entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HomeServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    List<Expert>experts=new ArrayList<>();

}
