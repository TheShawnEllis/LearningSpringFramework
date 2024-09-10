package learning.springframework.spring5webapp;

import learning.springframework.spring5webapp.controllers.ConstructorInjectedController;
import learning.springframework.spring5webapp.controllers.MyController;
import learning.springframework.spring5webapp.controllers.PropertyInjectedController;
import learning.springframework.spring5webapp.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.sql.SQLOutput;

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

		System.out.println("-------------------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------------------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------------------- Contstuctor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

	}

}
