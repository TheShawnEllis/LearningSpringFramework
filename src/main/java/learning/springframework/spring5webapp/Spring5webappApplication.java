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

//LEARNING: When working in Spring, changes to source code have need to have the app restarted. To automatically restart the app when the code is updated:
//	Add spring-boot-devtools dependency to the pom.xml file
//	Enable "Build project automatically" checkbox under Settings > Build, Execution Deployment > Compiler
//	Enable "Allow auto-make to start..." checkbox under Settings > Advanced Settings


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
