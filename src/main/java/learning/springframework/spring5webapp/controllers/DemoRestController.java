package learning.springframework.spring5webapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World from DemoRestController";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "You ran a hard 5K!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today you are better than yesterday!";
    }
}
