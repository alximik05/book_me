package info.grishaev.service;

import info.grishaev.dao.EventRepository;
import info.grishaev.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by stas on 20/02/17.
 */
@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "index";
//    }

    @RequestMapping("/events")
    @ResponseBody
    List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @RequestMapping("/event/{id}")
    @ResponseBody
    Event getEventById(@PathVariable Long id) {
        return eventRepository.findOne(id);
    }

//    @RequestMapping("/put")
//    @ResponseBody
//    String put() {
//        eventRepository.save(new Event());
//        return "ok";
//    }

}


