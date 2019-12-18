package calculator.bmi.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("calculator.bmi.repository")
public class AppConfiguration {
}
