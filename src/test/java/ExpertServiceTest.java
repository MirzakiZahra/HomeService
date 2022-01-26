import dto.AddressDto;
import dto.ExpertDto;
import model.user.Expert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ExpertService;

public class ExpertServiceTest {
    ExpertService expertService = new ExpertService();

    @BeforeEach
    void init() {
        expertService.createExpert("Ali", "Alavi", "ali@gmail.com");
    }
    @Test
    void giveExpertEmail_findExpertByEmail_trueExpertName(){
        ExpertDto expertDto = expertService.findExpertByEmail("ali@gmail.com");
        Assertions.assertEquals("Ali",expertDto.getFirstName());
    }
}

