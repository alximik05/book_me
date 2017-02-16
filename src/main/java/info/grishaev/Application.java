package info.grishaev;

import info.grishaev.dao.EventRepository;
import info.grishaev.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stas on 16/02/17.
 */
@Controller
@EnableAutoConfiguration
public class Application {

    @Autowired
    private EventRepository eventRepository;



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return eventRepository.findAll().toString();
    }

    @RequestMapping("/put")
    @ResponseBody
    String put() {
        eventRepository.save(new Event());
        return "ok";
    }
}
