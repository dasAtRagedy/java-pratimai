import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;

public class driverCode {
    final static String DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String[] args){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT);
        // LocalDate localDate = LocalDate.now();

        Scanner scan = new Scanner(System.in);
        String userInputNow = dateInput(scan);
        String userInput = dateInput(scan);
        scan.close();

        LocalDate localDateFinal = LocalDate.parse(userInput, df);
        LocalDate localDate = LocalDate.parse(userInputNow, df);
        //System.out.println("Today is: "+localDate.format(df));

        int currMonth = -1;
        if(localDate.isAfter((localDateFinal)))
            System.out.println("The date provided has already passed.");
        while(!localDate.isAfter(localDateFinal)){
            if(localDate.getMonthValue() != currMonth){
                currMonth = localDate.getMonthValue();
                System.out.printf("\n%d-%02d: %02d", localDate.getYear(),
                        localDate.getMonthValue(), localDate.getDayOfMonth());
            }
            else{
                System.out.printf(", %02d", localDate.getDayOfMonth());
            }
            localDate = localDate.plusDays(7);
        }
    }

    public static String dateInput(Scanner scan){
        System.out.println("Please enter your desired date in this format : "+
                DATE_FORMAT);
        String userInput = scan.nextLine();
        if(!validateDate(userInput)){
            System.out.println("Date format provided is not valid.");
            return dateInput(scan);
        }
        System.out.println("Provided date format is valid.");
        return userInput;
    }

    public static boolean validateDate(String userInput){
        if(userInput.length() != DATE_FORMAT.length())
            return false;
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(userInput);
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }
}