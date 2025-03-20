package se.salt.precourse.firstJavaApp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class StartDateHandler {
  long daysToCourseStart(String startDateInput) {
    LocalDate startDate = LocalDate.parse(startDateInput);
    return ChronoUnit.DAYS.between(LocalDate.now(), startDate);
  }

  public boolean dateHasOnlyNumbers(String startDateInput) {
    String[] dateParts = startDateInput.split("-");
    for(String datePart : dateParts) {
      if(!StringUtils.isNumeric(datePart)) {
        return false;
      }
    }
    return true;
  }
}
