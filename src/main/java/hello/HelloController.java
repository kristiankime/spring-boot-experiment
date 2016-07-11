package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        LOGGER.debug("debug Greetings from STAMPS");
        LOGGER.info("info Greetings from STAMPS");
        LOGGER.warn("warn Greetings from STAMPS");
        LOGGER.error("error Greetings from STAMPS");
        System.out.println("out Greetings from STAMPS");
        System.err.println("err Greetings from STAMPS");
        return "Greetings from STAMPS";
    }

}