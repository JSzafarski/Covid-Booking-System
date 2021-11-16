import java.util.Date;
public class Booking {
    private int BookingID = 0;
    private static int Static = 10;
    private BookableRoom BookableRoom = new BookableRoom();
    private AssistantOnShift Assistantonshift = new AssistantOnShift();
    private String StudentEmail;
    private Date TimeSlot;
    private String Status;

//To create a booking in a time-slot, the system must certify the availability of resources. That is, must have a
//bookable room not FULL and an assistant on shift which is FREE

 public void createBooking(Date timeslot, String studentemail, BookableRoom roomX, AssistantOnShift assistantX){
     this.Assistantonshift = assistantX;
     this.BookableRoom = roomX;
     this.StudentEmail = studentemail;//enforce “*@uok.ac.uk"
     this.TimeSlot = timeslot;
     BookingID =Static++;//makes the id id unique to each booking made
 }

 public void updateStatus(boolean completed){
     if (completed){
         this.Status ="COMPLETED";
     }else{
         this.Status ="SCHEDULED";
     }
 }


 public int getID(){return BookingID;}

 public String getStatus(){return Status;}

 //A booking not COMPLETED can be cancelled, i.e., deleted from the system. After cancellation, the resources
 //(room and assistant) should be released for booking again, i.e., their statuses must be updated.

 // A booking SCHEDULED can become COMPLETED. Once completed, the booking cannot be deleted due to
 //audit processes.


 public void printTemplate(){
    System.out.println("| ID: "+BookingID + " | " + TimeSlot + " | " + Status + " | " + Assistantonshift.getEmail() + " | " + BookableRoom.getCode() + " | " + StudentEmail);
 }












}
