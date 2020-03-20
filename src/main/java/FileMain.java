import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Clock;

public class FileMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide your fullName : ");
        String fullName = scanner.nextLine();
        System.out.println("Provide your age : ");
        int age = scanner.nextInt();

        LocalDate date = LocalDate.now();
        System.out.println("Date of your visit : " + date);

        LocalTime time = LocalTime.now();
        System.out.println("Time of your visit : " + time);

        System.out.println("Provide your comment below : ");
        String comment = scanner.nextLine();

        System.out.println("Enter helper name : ");
        String name = scanner.nextLine();


        Visitor v = new Visitor(fullName, age, date, time, comment, name);
        v.save();
        v.load();
    }
}
