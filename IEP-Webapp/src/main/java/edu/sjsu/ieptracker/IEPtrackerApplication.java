package edu.sjsu.ieptracker;


import edu.sjsu.ieptracker.service.SentimentAnalysis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IEPtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IEPtrackerApplication.class, args);
	}

}
