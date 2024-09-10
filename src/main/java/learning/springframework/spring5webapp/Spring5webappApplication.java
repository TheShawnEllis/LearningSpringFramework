package learning.springframework.spring5webapp;

import learning.springframework.spring5webapp.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		// Run method for the DB app
		// SpringApplication.run(Spring5webappApplication.class, args);

		// Run method updated for the dependency injection lesson
		ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class,args);

		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

	}

}
