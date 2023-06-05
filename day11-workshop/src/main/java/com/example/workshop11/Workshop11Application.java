package com.example.workshop11;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Workshop11Application {
private static String portNumber = null;
private static String DEFAULT_PORTNUM = "3000";

	public static void main(String[] args) {
		
		
		// jar -jar target/workshop11-0.0.1-SNAPSHOT.jar --port=5055
		// jar -jar target/workshop11-0.0.1-SNAPSHOT.jar --Dport=5055


		for (String argVal: args) {
			System.out.println("argVal = " + argVal);
			if (argVal.contains("--Dport=") || argVal.contains("--port=")){
				System.out.println("contains ");
				portNumber = argVal.substring(argVal.length() - 4, argVal.length());
				System.out.println("Port is started:" + portNumber);
			}
		}

		//mvn clean spring-boot:run -Dspring-boot.run.arguments=--Dport=5055
		//mvn clean spring-boot:run -Dspring-boot.run.arguments=--port=5051
		
		// maven
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		if (appArgs.containsOption("port")){
			System.out.println("contains");
			portNumber = appArgs.getOptionValues("port").get(0);
		}

		// export PORT=xxxx
		// mvn spring-boot:run
		if (portNumber == null) {
			portNumber = System.getenv("PORT");
			System.out.println("env portNumber " + portNumber);
		}

		if (portNumber == null || portNumber.isBlank()) {
			portNumber = DEFAULT_PORTNUM;
		}

		SpringApplication app = new SpringApplication(Workshop11Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		System.out.println("Starting application on port" + portNumber);

		app.run(args);
		
		};
		
	}


