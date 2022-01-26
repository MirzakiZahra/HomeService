import dto.AddressDto;
import model.user.Expert;
import org.junit.jupiter.api.BeforeEach;
import service.ExpertService;

public class ExpertServiceTest {
    ExpertService expertService = new ExpertService();

    @BeforeEach
    void init() {
        expertService.createExpert("Ali", "Alavi", "ali@gmail.com");
    }
    
}

