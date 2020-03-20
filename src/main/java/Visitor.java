import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Formatter;
import java.time.LocalDate;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Visitor {
    private String fullName;
    private int age;
    private LocalDate vDate;
    private LocalTime vTime;
    private String comment;
    private String helperNm;
//    private Formatter x;

    static Logger logger = LogManager.getLogger(Visitor.class);
    public Visitor(String fullName, int age, LocalDate vDate, LocalTime vTime, String comment, String helperNm){
        this.fullName = fullName;
        this.age = age;
        this.vDate = vDate;
        this.vTime = vTime;
        this.comment = comment;
        this.helperNm = helperNm;
    }

    public void save(){
        String message = "";
        try {
            File myObj = new File("visitor_"+fullName.replace(" ","_").toLowerCase()+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

                FileWriter myWriter = new FileWriter("visitor_"+fullName.replace(" ","_").toLowerCase()+".txt");
                message += "\nfull name : " + fullName;
                message += "\nage : " + age;
                message += "\ndate of visit : " + vDate;
                message += "\ntime of visit : " + vTime;
                message += "\ncomments : "+ comment;
                message += "\nname of the person who assisted the visitor : "+ helperNm;

                myWriter.write(message);
                logger.info("File was successfully created and information written");
                myWriter.close();


            } else {
                logger.warn("File already exists.");
            }
        } catch (IOException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }
    }


    public void load(){
        try {
            File myObj = new File("visitor_"+fullName.replace(" ","_").toLowerCase()+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }
    }

}
