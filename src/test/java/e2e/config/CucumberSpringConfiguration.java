package e2e.config;

import com.ua.hotel.RobotSpringDemoApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RobotSpringDemoApplication.class)
public class CucumberSpringConfiguration {
}
