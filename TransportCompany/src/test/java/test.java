import dao.CompanyDAO;
import entity.Company;
import entity.Driver;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class test {
    @Test
    void testCompany(){
        Company c1 = new Company();
        c1.setName("Delta");
        Company c2 = new Company();
        c2.setName("Michigan");


    }

    @Test
    void testDriver(){
        Driver driver = new Driver();
        if(driver.equals(null)){
        fail("Not yet implemented");
        }else{
            System.out.println("There is information");
        }

    }




}
