import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MainDatasFormat {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();

		LocalDate d04 = LocalDate.parse("2022-10-01");
		LocalDateTime d05 = LocalDateTime.parse("2022-10-01T23:46:01");
		Instant d06 = Instant.parse("2022-10-01T23:46:01Z");
		Instant d07 = Instant.parse("2022-10-01T23:46:01-03:00");
		
		LocalDate d08 = LocalDate.parse("02/10/2022", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("02/10/2022 00:26", fmt2);
		
		LocalDate d10 = LocalDate.of(2022, 10, 02);
		LocalDateTime d11 = LocalDateTime.of(2022, 10, 02, 00, 30);		
		
		System.out.println("d01 = " + d01.toString());
		System.out.println("d02 = " + d02.toString());
		System.out.println("d03 = " + d03.toString());
		System.out.println("d04 = " + d04.toString());
		System.out.println("d05 = " + d05.toString());
		System.out.println("d06 = " + d06.toString());
		System.out.println("d07 = " + d07.toString());
		System.out.println("d08 = " + d08.toString());
		System.out.println("d09 = " + d09.toString());
		System.out.println("d10 = " + d10.toString());
		System.out.println("d11 = " + d11.toString());
		
		System.out.println("-------------------------");		

		LocalDate d24 = LocalDate.parse("2022-10-01");
		LocalDateTime d25 = LocalDateTime.parse("2022-10-01T01:46:01");
		Instant d26 = Instant.parse("2022-10-01T01:46:01Z");
		
		DateTimeFormatter fmt11 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt12 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt13 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
		DateTimeFormatter fmt14 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmt15 = DateTimeFormatter.ISO_INSTANT;
		
		System.out.println("d24 = " + d24.format(fmt11));
		System.out.println("d24 = " + fmt11.format(d24));
		System.out.println("d25 = " + d25.format(fmt11));
		System.out.println("d25 = " + d25.format(fmt12));
		System.out.println("d26 = " + fmt13.format(d26));
		System.out.println("d25 = " + d25.format(fmt14));
		System.out.println("d26 = " + fmt15.format(d26));
		
	}

}
