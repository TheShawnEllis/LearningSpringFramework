package learning.springframework.spring5webapp.controllers;

import learning.springframework.spring5webapp.services.GreetingService;

public class SetterInjectedController {

    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return  greetingService.sayGreeting();
    }
}
