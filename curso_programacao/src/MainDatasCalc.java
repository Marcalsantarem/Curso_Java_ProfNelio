import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MainDatasCalc {

	public static void main(String[] args) {

		LocalDate d04 = LocalDate.parse("2022-10-01");
		LocalDateTime d05 = LocalDateTime.parse("2022-10-01T01:46:01");
		Instant d06 = Instant.parse("2022-10-01T01:46:01Z");
		
		LocalDate lastWeekLocalDate = d04.minusDays(7);
		LocalDate nextWeekLocalDate = d04.plusDays(7);
		
		System.out.println("lastWeekLocalDate = " + lastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

		LocalDateTime lastWeekLocalDateTime = d05.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

		System.out.println("lastWeekLocalDateTime = " + lastWeekLocalDateTime);
		System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

		Instant lastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);		

		System.out.println("lastWeekInstant = " + lastWeekInstant);
		System.out.println("nextWeekInstant = " + nextWeekInstant);
		
		Duration t1 = Duration.between(lastWeekLocalDate.atTime(0, 0), d04.atTime(0, 0));
		Duration t11 = Duration.between(lastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
		Duration t2 = Duration.between(lastWeekLocalDateTime, d05);
		Duration t3 = Duration.between(lastWeekInstant, d06);
		Duration t4 = Duration.between(d06, lastWeekInstant);
		
		System.out.println("t1 dias = " + t1.toDays());
		System.out.println("t11 dias = " + t11.toDays());
		System.out.println("t2 dias = " + t2.toDays());
		System.out.println("t3 dias = " + t3.toDays());
		System.out.println("t4 dias = " + t4.toDays());
		
	}

}
