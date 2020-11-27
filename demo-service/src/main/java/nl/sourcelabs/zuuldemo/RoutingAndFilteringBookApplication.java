package nl.sourcelabs.zuuldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@SpringBootApplication
public class RoutingAndFilteringBookApplication {

    Logger log = LoggerFactory.getLogger(RoutingAndFilteringBookApplication.class);

    private final Random random = new Random();

    @RequestMapping(value = "/available")
    public String available() {
        log.info("/available");
        return "Spring in Action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        log.info("/checked-out");
        return "Spring Boot in Action";
    }

    @RequestMapping(value = "/simulation/{responseStatus}")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity simulate503(@PathVariable int responseStatus) {
        log.info("/simulation/" + responseStatus);
        return ResponseEntity.status(responseStatus).build();
    }

    @RequestMapping(value = "/random")
    public ResponseEntity random() {
        int randomNumber = random.nextInt(100);
        if (randomNumber % 2 == 0) {
            log.info("random 503");
            return ResponseEntity.status(503).build();
        }
        log.info("random 200");
        return ResponseEntity.ok("All is good!");
    }

    public static void main(String[] args) {
        SpringApplication.run(RoutingAndFilteringBookApplication.class, args);
    }
}