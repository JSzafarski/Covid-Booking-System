import java.util.Date;
public class BookableRoom{
    private int Occupancy;//amount of people attending the room
    private String Status;//EMPTY,AVAILABLE,FULL
    private Date TimeSlot;//might change this into a different data type format(dd/mm/yyyy HH:MM)
    private Room RoomX = new Room();//since its based on a specific room object
    private int ID = 0;
    private static int Static = 10;
    public void createBookableRoom(Date timeslot,String code,int capacity){
        this.TimeSlot = timeslot;
        RoomX.addRoom(code, capacity);//wrong cuz you can't add room here but bookable room
        this.Status = "EMPTY";
        ID= Static++;
    }


    public void addPerson(){
        this.Occupancy = this.Occupancy + 1;
        updateStatus();
    }

    public void removePerson(){
        this.Occupancy = this.Occupancy - 1;
        updateStatus();
    }

    private void updateStatus(){
        if (Occupancy == 0){
            Status = "EMPTY";
        }else if(RoomX.getCapacity() - Occupancy >0 ){
             Status = "AVAILABLE";
        }else if(RoomX.getCapacity()== Occupancy){
            Status = "FULL";
        }
    }

    //getters

    public String getStatus(){
        return this.Status;
    }//used during booking and to determine if a room can be removed from system

    public String getCode(){
        return this.RoomX.getCode();
    }

    public Date getTimeSlot(){
        return this.TimeSlot;
    }

    public int getID(){return ID;};

    public void printTemplate(){
        System.out.println("| ID: " +ID+ " | " +TimeSlot+" | "+Status + " | "+ RoomX.getCode()+" | "+"Occupancy: "+Occupancy);
    }

}
