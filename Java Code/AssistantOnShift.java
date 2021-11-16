import java.util.Date;
public class AssistantOnShift{
    //every assistant on shift has 3 copies of that assistant (7am -10am so he/she can be available 3 times)(60 minute duration per covid test)
    private Assistant AssistantX = new Assistant();
    private Date TimeSlot;//change to a different data type so it can be compared to current time and other times.
    private String Status;
    private boolean allocated;//updates if assistant on shit is allocated for the time slot
    private static int Static = 10;
    private int ID = 0;

    public void createAssistantOnShift(Date timeSlot,String name,String email){
        this.TimeSlot = timeSlot;
        this.AssistantX.createAssistant(name,email);
        this.Status = "FREE";
        ID = Static++;
    }

    public void setStatus(boolean allocated){//not sure why when assistant on shit ever be free? after booking expires?
        if (allocated){
            this.Status = "BUSY";
        }else{
            this.Status = "FREE";
        }
    }

    public String getStatus(){
        return this.Status;
    }

    public Date getTimeSlot(){return this.TimeSlot;}

    public String getEmail(){
        return AssistantX.getEmail();
    }

    public String getName(){
        return AssistantX.getName();
    }

    public int getID(){
        return ID;
    }

    public void printTemplate(){
        System.out.println("| ID: "+ID+"| " +TimeSlot+" | "+Status + " | "+AssistantX.getEmail()+" | ");
    }
}
