package se.salt.precourse.firstjavaapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Greeter {
  private static String greet(String namePassedIn) {
    return "Welcome to SALT, " + namePassedIn;
  }

  private static String remind(String courseStart){
    String[] s = courseStart.split("-");
    if (s.length != 3 || s[1].length() != 2 || s[2].length() != 2){
      return null;
    } else {
      int year = Integer.parseInt(s[0]);
      int month = Integer.parseInt(s[1]);
      int day = Integer.parseInt(s[2]);
      if (month >= 12){
        return null;
      }
      LocalDate d1 = LocalDate.now();
      LocalDate d2 = LocalDate.of(year, month, day);
      int day_amount = d2.compareTo(d1);

      String days = String.valueOf(day_amount);
      return "Today it is " + days + " days left until the course starts";
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("What is your name? ");
    String name = reader.readLine();
    String greeting = greet(name);

    System.out.print("When does that course start? ");
    String reminder;
    while (true){
      String date = reader.readLine();
      reminder = remind(date);
      if (reminder != null) {
          break;
      }
      System.out.println("Enter valid date format (YY-MM-DD)");
    }

    System.out.println(greeting);
    System.out.println(reminder);
  }
}
