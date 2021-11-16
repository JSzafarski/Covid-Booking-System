import java.util.Date;
public class BookingSystem {//might inherit university resources
    public BookableRoom[] BookableroomX = new BookableRoom[100];
    public AssistantOnShift[] AssistantOnShiftX = new AssistantOnShift[100];
    public Booking[] Booking = new Booking[100];

    public int BookableRoompointer;
    public int AssistantOnShiftpointer;
    public int Bookingpointer;


    //each timeslot is assumed to expire after 1h of the start time
    public boolean addBookableRoom(Date timeslot,String code,int capacity){//occupancy not needed (set to 0),also make it return true if added successfully
        //validate that its (7-10am)
        int x = 0;
        boolean add = true;
        int emptyspace = -1;
        //also check if it's in the future
        while(x != BookableRoompointer){
            if(BookableroomX[x]!= null){
                if(BookableroomX[x].getCode().equals(code)){
                    final int constant = (1000 * 3600);
                    if (Math.abs(((BookableroomX[x].getTimeSlot()).getTime() - timeslot.getTime()) /constant % 24) < 1){
                        //time difference has to be at least 1h
                        //System.out.println("Unable to add a bookable since room with that timeslot already exists or it's overlapping time slots");
                        add = false;
                        break;
                    }
                }
            }else{
                emptyspace = x;
            }
            x++;
        }
        if(add) {//also make it add before pointer of last array if it does find a null array space beforehand
            if(emptyspace == -1){
                BookableroomX[BookableRoompointer] = new BookableRoom();
                BookableroomX[BookableRoompointer].createBookableRoom(timeslot, code, capacity);
                BookableRoompointer++;//next available space
            }else{
                BookableroomX[emptyspace] = new BookableRoom();
                BookableroomX[emptyspace].createBookableRoom(timeslot, code, capacity);
            }
            return true;//successfully added
        }else{
            return false;//unsuccessfully added
        }
    }

    public boolean addAssistantOnShift(Date timeslot, String name, String email){
        //validate that it's (7-10am)
        int x = 0;
        boolean add = true;
        int emptyspace = -1;
        while(x != AssistantOnShiftpointer){
            if(AssistantOnShiftX[x]!=null) {
                if (AssistantOnShiftX[x].getEmail().equals(email)){
                    final int constant = (1000 * 3600);//check if maths works
                    if (Math.abs(((AssistantOnShiftX[x].getTimeSlot()).getTime() - timeslot.getTime())/constant % 24) < 1){
                        //time difference has to be at least 1h
                        //System.out.println("Unable to assign an assistant as assistant is already assigned to a overlapping timeslot");
                        add = false;
                        break;
                    }
                }
            }else{
                emptyspace = x;//determines an empty space in the array
            }
            x++;
        }
        if(add){
            if(emptyspace == -1) {
                AssistantOnShiftX[AssistantOnShiftpointer] = new AssistantOnShift();
                AssistantOnShiftX[AssistantOnShiftpointer].createAssistantOnShift(timeslot, name, email);
                AssistantOnShiftpointer++;
            }else{//gives a position of an empty field in the array that probably was created by deleting data
                AssistantOnShiftX[emptyspace] = new AssistantOnShift();
                AssistantOnShiftX[emptyspace].createAssistantOnShift(timeslot, name, email);
            }
            return true;//successfully added
        }else{
            return false;//unsuccessfully added
        }

    }

    public void addBooking(String StudentEmail, Date timeslot){//timeslot is
        int RoomPos = 0;
        while(RoomPos != Bookingpointer){
            if(BookableroomX[RoomPos] !=null) {
                if ((BookableroomX[RoomPos].getTimeSlot() == timeslot)) {//time difference has to be at least 1h
                    break;
                }
            }
            RoomPos++;
        }
        int AssistantPos = 0;
        while(AssistantPos != AssistantOnShiftpointer){
            if(AssistantOnShiftX[AssistantPos] != null) {
                if (AssistantOnShiftX[AssistantPos].getTimeSlot() == timeslot) {//time difference has to be at least 1h
                    break;
                }
            }
            AssistantPos++;
        }

        BookableroomX[RoomPos].addPerson();//adds another person to the room
        AssistantOnShiftX[AssistantPos].setStatus(true);//makes the assistant not free on that time
        int x = 0;
        while (Booking[x] != null){
            x++;
        }
        BookableroomX[RoomPos].addPerson();
        AssistantOnShiftX[AssistantPos].setStatus(true);
        if (x < Bookingpointer) {//if there are empty spaces from previously deleted bookings
            Booking[x] = new Booking();
            Booking[x].createBooking(timeslot, StudentEmail, BookableroomX[RoomPos], AssistantOnShiftX[AssistantPos]);
            Booking[x].printTemplate();//print booking
        }else{
            Booking[Bookingpointer] = new Booking();
            Booking[Bookingpointer].createBooking(timeslot, StudentEmail, BookableroomX[RoomPos], AssistantOnShiftX[AssistantPos]);
            Booking[Bookingpointer].printTemplate();//print booking
            Bookingpointer++;
        }

    }

    public void removeBookableRoom(int id){//searches it based one the sequential ID.
        int x = 0;
        boolean found = false;
        while(x !=BookableRoompointer){
            if(BookableroomX[x]!=null){
                if(BookableroomX[x].getID() == id){
                    found = true;
                    break;
                }
            }
            x++;
        }
        if(found) {
            if (BookableroomX[x].getStatus().equals("EMPTY")) {
                BookableroomX[x] = null;//makes it empty as th user wanted to remove it
            } else {
                //cannot be done cuz not empty
            }
        }else{
            //id not found
        }
        //only can be removed if EMPTY
    }

    public void removeAssistantOnShift(int id){
        //only free can be removed from system
        int x = 0;
        boolean found = false;
        while(x != AssistantOnShiftpointer){
            if(AssistantOnShiftX[x]!=null){
                if(AssistantOnShiftX[x].getID()==id){
                    found = true;
                    break;
                }
            }
            x++;
        }
        if(found) {
        if(AssistantOnShiftX[x].getStatus().equals("FREE")){
            AssistantOnShiftX[x] = null;//makes it empty as th user wanted to remove it
        }else{
            //cannot be done
        }
        }
        //only can be removed if EMPTY
    }

    public void removeBooking(int id){
        //only not COMPLETED i.e. SCHEDULED booking can be removed from the system
        int x = 0;
        while(x != Bookingpointer){
            if(Booking[x]!=null){
                if(Booking[x].getID()!=id){
                    break;
                }
            }
            x++;
        }
        if(Booking[x].getStatus().equals("SCHEDULED")){
            AssistantOnShiftX[x] = null;//makes it empty as th user wanted to remove it
        }else{
            //cannot be done
        }
        //only can be removed if EMPTY
    }

    public void listBookableRooms(){
        System.out.println("");
        int x = 0;
        while(x!=BookableRoompointer){
            if(BookableroomX[x] != null) {
                BookableroomX[x].printTemplate();
            }
            x++;
        }
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
    }

    public void listAssistantsOnShift(){
        System.out.println("");
        int x = 0;
        while(x!=AssistantOnShiftpointer){
            if(AssistantOnShiftX[x] != null) {
                AssistantOnShiftX[x].printTemplate();
            }
            x++;
        }
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
    }

    public void listBookings(int option){
        //1. All
        //2. Only bookings status:SCHEDULED
        //3. Only bookings status:COMPLETED
        System.out.println("");
        int x = 0;
        boolean found = false;
        while(x!=Bookingpointer){
            if(Booking[x] != null) {
                if(option == 1){
                        Booking[x].printTemplate();//both
                        found = true;
                }else if(option == 2){
                    if(Booking[x].getStatus().equals("SCHEDULED")){
                        Booking[x].printTemplate();
                        found = true;
                    }
                }else if(option == 3){
                    if(Booking[x].getStatus().equals("COMPLETED")){
                        Booking[x].printTemplate();
                        found = true;
                    }
                }
            }
            x++;
        }
        if(!found){
            System.out.println("no Bookings in system");
        }
    }
    //There is a time-slot concept that will guide the booking system. For instance, rooms will be available, and
    //assistants will work at a specific time-slot, i.e., date, time and duration. Hence, tests should be booked at
    //available slots.

    //    Every time-slot has a fixed duration – a positive number representing the duration of a test, in minutes. This
    //    quantity includes the time spent doing the test and the time to sanitize the room. The current policy establishes
    //    this duration to be 60 minutes.
}
