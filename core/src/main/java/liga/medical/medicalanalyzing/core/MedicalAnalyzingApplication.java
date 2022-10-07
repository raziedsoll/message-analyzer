package liga.medical.medicalanalyzing.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"liga.medical.medicalanalyzing", "liga.medical.common.service"})
public class MedicalAnalyzingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalAnalyzingApplication.class, args);
    }

}