import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BirthdayCalculator {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Whats your birthday? ex: 01-01-1992");
        String bday = sc.nextLine();

        String[] arr = bday.split("-");

        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,day);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.YEAR,year);

        String stringDay = String.valueOf(LocalDate.of(year,month,day).getDayOfWeek());
        System.out.println("That means you were born on a " + stringDay);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        //System.out.println(currentYear);
        calendar.set(Calendar.YEAR,currentYear);
        stringDay = String.valueOf(LocalDate.of(currentYear,month,day).getDayOfWeek());
        System.out.println("This year (" + currentYear +") falls on a " + stringDay);
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate curDate = currentTime.toLocalDate();
        System.out.println("and since today is " + curDate);



        //formatted birthday
        LocalDate birthday = LocalDate.of(currentYear,month,day);
        //current date
        LocalDate today = LocalDate.now();

        LocalDate birth = LocalDate.of(year,month,day);
        long age = ChronoUnit.YEARS.between(birth,today);
        System.out.println("You are currently " + age + " years old");

        long daysUntilBday = ChronoUnit.DAYS.between(today,birthday);

        if(daysUntilBday < 0 ){
            System.out.print("Theres only " + (365 - Math.abs(daysUntilBday) + " more days until you turn "+ (age + 1)));
        }else {
            System.out.print("Theres only " + daysUntilBday + " more days until your turn " + (age + 1));
        }




    }

}

