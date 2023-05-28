package e2e.config;

import com.ua.hotel.HotelApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HotelApplication.class)
public class CucumberSpringConfiguration {
}
