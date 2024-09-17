package core.practise;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Event {
    String name;
    LocalDate date;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + " on " + date;
    }
}

public class DateFiltering {

    public static LocalDate parseDate(String date){

        /**
         * Java provides two classes to format date
         * SimpleDateFormatter -> old formatter from java 1.1
         *  DateTimeFormatter -> is modern comes in java 8 package
         */

//      SimpleDateFormat provide one pattern matcher
//        SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyyy");
//        try {
//         Date formatedDate = format.parse(date);
//            System.out.println("Date :"+formatedDate);
//        }catch (ParseException e){
//         System.out.println("Invalid date format");
//        }

        // we can create one pattern in DateTImePattern
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        /**
         * DateTimeFormatterBuilder allows you to create custom date-time formatters that can handle various date formats
         */
        DateTimeFormatter supremeFormatter= new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("ddMMyyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .toFormatter();

        return LocalDate.parse(date,supremeFormatter);
    }


    public static void main(String[] args) {

        /**
         * Creating Sample Data
         */
        List<Event> events= new ArrayList<>();

        IntStream.range(1,20).forEach(i->{
           Event e= new Event("Evenet-"+i,LocalDate.of(2024,i%12+1,i));
            events.add(e);
        });

        while(true) {

            System.out.println("Date formats :");
            System.out.println("dd-MM-yyyy");
            System.out.println("dd/MM/yyyy");
            System.out.println("ddMMyyyy");
            System.out.println("yyyy-MM-dd");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter start Date in any of the above format");
            String startDate = sc.nextLine();

            System.out.println("Enter end Date in any of the above format");
            String endDate = sc.nextLine();

            try {

                LocalDate sDate = parseDate(startDate);
                LocalDate eDate = parseDate(endDate);

                List<Event> filterEvents= events.stream().filter(event->{
                    LocalDate d= event.getDate();
                    return  ( d.isAfter(sDate) || d.isEqual(sDate) )  && ( d.isBefore(eDate) || d.isEqual(eDate));
                }).toList();

                System.out.println("Events count btn given range :"+filterEvents.size());
                System.out.println("Filter Result :");
                System.out.println(filterEvents);

            }catch (DateTimeParseException e){
                System.out.println("Invalid date format");
            }

            System.out.println("Do you want to terminate? Y|N");
            String input= sc.nextLine();

            if("Y".equalsIgnoreCase(input)){
                break;
            }
        }



    }
}
