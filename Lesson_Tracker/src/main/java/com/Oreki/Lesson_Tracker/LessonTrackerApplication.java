package com.Oreki.Lesson_Tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.Oreki.Lesson_Tracker")
@EnableAutoConfiguration
public class LessonTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonTrackerApplication.class, args);
		System.out.println("Started");
	}

}
