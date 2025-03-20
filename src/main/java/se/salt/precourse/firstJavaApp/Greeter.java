package se.salt.precourse.firstJavaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class Greeter implements CommandLineRunner {
  @Autowired
  StartDateHandler startDateHandler;

  private static String greet(String namePassedIn) {
    return "Welcome to SALT, " + namePassedIn;
  }

  public static void main(String[] args) throws IOException {
    SpringApplication.run(Greeter.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.print("What is your name? : ");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String name = reader.readLine();
    String greeting = greet(name);
    System.out.println(greeting);

    System.out.print("When does your course start (yyyy-mm-dd) ? : ");
    String startDateInput = reader.readLine();

    if(startDateHandler.dateHasOnlyNumbers(startDateInput) ){
      System.out.print("You start in " + startDateHandler.daysToCourseStart(startDateInput) + " days. Better get cracking on that Pre-course!!");
    } else {
      System.out.print("Please provide a valid date");
    }
  }
}
