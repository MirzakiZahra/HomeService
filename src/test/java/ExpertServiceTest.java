import dto.AddressDto;
import dto.ExpertDto;
import exception.InputException;
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
    @Test
    void giveNotExistExpertEmail_findExpertByEmail_throwException(){
        InputException result = Assertions.assertThrows(InputException.class, () ->
                expertService.findExpertByEmail("aliyavari@gmail.com"));
        Assertions.assertEquals("Expert DoesNot Exist",result.getMessage());
    }
    
}

