import java.util.Date;
import java.time.LocalTime;
import java.util.Scanner;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
public class BookingApp {
    private static BookingSystem BookingSystem1 = new BookingSystem();
    //uni resources////////////////////////////////////////////////////////////////////////////////////////////////////
    private static Assistant[] AssistantX = new Assistant[100];//might change it to lists
    private static int AssistantCount = 0;

    private static Room[] RoomX = new Room[100];//make those a list
    private static int RoomCount = 0;

    static Scanner mainMenuInput = new Scanner(System.in);


    //decide how to verify codes ect...
    public static void addAssistant(String name, String email){
        int x = 0;
        boolean found = false;
        while (AssistantX[x] !=null){
            if (AssistantX[x].getEmail().equals(email)){//can have same names so emails make them unique
                found = true;
                break;
            }
            x++;
        }
        if(!found) {
            AssistantX[AssistantCount] = new Assistant();
            AssistantX[AssistantCount].createAssistant(name, email);
            AssistantCount++;
        }else{
            System.out.println("Unable to add a assistant since email already exists");
        }
    }

    public static void  addRoom(String code, int capacity){
        int x = 0;
        boolean found = false;
        while (RoomX[x] !=null){
            if (RoomX[x].getCode().equals(code)){//can have same names so emails make them unique
                found = true;
                break;
            }
            x++;
        }
        if(!found){
            RoomX[RoomCount] = new Room();
            RoomX[RoomCount].addRoom(code,capacity);
            RoomCount++;
        }else{
            System.out.println("Unable to add a room since room code already exists");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {//need to populate this
        //initialise
        addRoom("Lib03",4);
        addRoom("MH56",12);
        addRoom("ROO9",7);

        addAssistant("James","James88@uok.ac.uk");
        addAssistant("Amy","amywaters5@uok.ac.uk");
        addAssistant("Jakub","projakub22@uok.ac.uk");
        SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
         try {
             BookingSystem1.addBookableRoom(sdformat.parse("08-05-2021 07:00"),"Lib03",30);
             BookingSystem1.addBookableRoom(sdformat.parse("08-08-2021 07:00"),"Lib03",34);
             BookingSystem1.addBookableRoom(sdformat.parse("08-05-2021 09:00"),"MH56",40);
             BookingSystem1.addBookableRoom(sdformat.parse("12-05-2021 08:00"),"MH56",71);
             BookingSystem1.addBookableRoom(sdformat.parse("17-05-2021 07:55"),"ROO9",10);
             BookingSystem1.addBookableRoom(sdformat.parse("01-06-2021 07:10"),"ROO9",100);
             BookingSystem1.addBookableRoom(sdformat.parse("08-06-2021 07:00"),"ROO9",6);
             BookingSystem1.addBookableRoom(sdformat.parse("11-06-2021 9:30"),"Lib03",77);
             BookingSystem1.addBookableRoom(sdformat.parse("08-07-2021 07:15"),"Lib03",34);

             BookingSystem1.addAssistantOnShift(sdformat.parse("08-06-2021 07:00"),"James","James88@uok.ac.uk");
             BookingSystem1.addAssistantOnShift(sdformat.parse("17-05-2021 09:00"),"James","James88@uok.ac.uk");
             BookingSystem1.addAssistantOnShift(sdformat.parse("22-05-2021 07:40"),"Amy","amywaters5@uok.ac.uk");
             BookingSystem1.addAssistantOnShift(sdformat.parse("08-05-2021 09:50"),"Amy","amywaters5@uok.ac.uk");
             BookingSystem1.addAssistantOnShift(sdformat.parse("08-07-2021 07:00"),"Jakub","projakub22@uok.ac.uk");
             BookingSystem1.addAssistantOnShift(sdformat.parse("08-09-2021 07:00"),"Jakub","projakub22@uok.ac.uk");
         }catch (ParseException e){
             System.out.println("unable to parse data");
         }
         mainMenu();
    }

    public static void clearConsole(){//experimental
        for (int i = 0; i <= 40; i++){
            System.out.println("\n");//adds bunch of new lines to give the illusion of clearing the console
        }
    }

    public static void mainMenu(){
        System.out.println("University of Knowledge - COVID test");
        System.out.println("");
        System.out.println("Manage Bookings");
        System.out.println("");
        System.out.println("Please, enter the number to select your option:");
        System.out.println("");
        System.out.println("To manage Bookable Rooms:");
        System.out.println("1. List");
        System.out.println("2. Add");
        System.out.println("3. Remove");
        System.out.println("To manage Assistants on Shift:");
        System.out.println("4. List");
        System.out.println("5. Add");
        System.out.println("6. Remove");
        System.out.println("To manage Bookings:");
        System.out.println("7. List");
        System.out.println("8. Add");
        System.out.println("9. Remove");
        System.out.println("10. List");
        System.out.println("After selecting one the options above, you will be presented other screens.");
        System.out.println("If you press 0, you will be able to return to this main menu.");
        System.out.println("Press -1 (or ctrl+c) to quit this application.");
        String input = mainMenuInput.nextLine();//fix!
        //if statements
        if (input.equals("1")){
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("list bookable rooms");
            listBookableRooms();
        }else if(input.equals("2")){
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("Adding bookable room");
            System.out.println("");
            addBookableRoom();
        }else if (input.equals("3")){
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("Removing a bookable room");
            removeBookableRoom();
        }else if(input.equals("4")){
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("list of assistant on shift");
            ListAssistantsOnShift();
        }else if(input.equals("5")){
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("add a assistant on shift");
            addAssistantonShift();
        }else if (input.equals("6")){
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("Remove a assistant from shift");
            removeAssistantonShift();
        }else if (input.equals("7")){
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            listBooking();
        }else if(input.equals("8")) {
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("Adding booking (appointment for a COVID test) to the system");
            System.out.println("");
            addBooking();
        }else if(input.equals("9")) {
            clearConsole();
            System.out.println("University of Knowledge - COVID test");
            System.out.println("");
            System.out.println("Removing booking from the system");
            removeBooking();
        }else if(input.equals("10")) {
            System.out.println("University of Knowledge - COVID test\n");
            System.out.println("");
            System.out.println("Conclude booking");
            clearConsole();
            concludeBooking();
        }else if(input.equals("-1")){
            System.exit(0);
        }else{
            clearConsole();
            mainMenu();
        }
    }

    public static void listBookableRooms(){//done
        BookingSystem1.listBookableRooms();
        String input = mainMenuInput.nextLine();
        if(input.equals("0")){
            clearConsole();
            mainMenu();
        }else if(input.equals("-1")){
            //exit app
            System.exit(0);
        }else{
            clearConsole();
            listBookableRooms();
        }

    }
    public static void addBookableRoom(){
        //verify there is no overlap!
        int x = 0;
        while(RoomX[x] != null){
            RoomX[x].printTemplate();
            x++;
        }
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),");
        System.out.println("separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        String input = mainMenuInput.nextLine();
        Date tempdate = null;
        String[] inputSplit = input.split(" " /*<- Regex */);//splits the input into 3 pieces of data
        if(inputSplit[0].equals("0")) {
            clearConsole();
            mainMenu();
        }else if(inputSplit[0].equals("-1")){
            //exit app
            System.exit(0);
        }else{
            x = 0;
            boolean complete = false;
            boolean foundroom = false;
            String error = "";
            while(RoomX[x] != null){
                if(RoomX[x].getID()==Integer.parseInt(inputSplit[0])){
                    String timedate = inputSplit[1]+" "+inputSplit[2];
                    SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    try {
                        Date bookingtime = sdformat.parse(timedate);//also make it so it verify the date is in the future
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
                        LocalTime target = LocalTime.parse(inputSplit[2]+":00",formatter) ;
                        boolean targetInZone = (
                            target.isAfter( LocalTime.parse( "6:59:00",formatter) )
                                    &&
                                    target.isBefore( LocalTime.parse( "9:00:00",formatter) )
                        ) ;
                        if (targetInZone){
                            int y = 0;
                            while(y != BookingSystem1.BookableRoompointer){
                                if(BookingSystem1.BookableroomX[y].getCode().equals(RoomX[x].getCode())){
                                    if(BookingSystem1.BookableroomX[y].getTimeSlot()==bookingtime){
                                        error = "booking already set for that time";
                                        break;
                                    }
                                }
                                y++;
                            }
                            if(BookingSystem1.addBookableRoom(bookingtime,RoomX[x].getCode(),RoomX[x].getCapacity())){//Date timeslot,String code,int capacity
                                tempdate = bookingtime;
                                complete = true;
                            }else{
                                error = " bookable room already exists";
                            }
                        }else{
                            error = "invalid time input";
                        }
                    } catch (ParseException e) {
                        error = "invalid entry";
                        clearConsole();
                        System.out.println("Error!");
                        System.out.println(e);//prints error code
                        System.out.println("");
                        addBookableRoom();
                    }
                    foundroom = true;
                }
                x++;
            }
            if (foundroom) {
                if (complete) {
                    //print assistant on shift
                    int z = 0;
                    while(z!=BookingSystem1.BookableRoompointer){
                        if(BookingSystem1.BookableroomX[z] != null) {
                            if (BookingSystem1.BookableroomX[z].getCode().equals(inputSplit[0])) {
                                if(BookingSystem1.BookableroomX[z].getTimeSlot() == tempdate) {//it is initialized
                                    BookingSystem1.BookableroomX[z].printTemplate();
                                    break;
                                }
                            }
                        }
                        z++;
                    }
                    clearConsole();
                    System.out.println("Bookable Room added successfully:");
                    addBookableRoom();//allows to add more entries
                } else {
                    clearConsole();
                    System.out.println("Error!");
                    System.out.println(error);//prints error code
                    System.out.println("");
                    addBookableRoom();
                }
            }else{
                clearConsole();
                error = "invalid room code";
                System.out.println("Error!");
                System.out.println(error);//prints error code
                System.out.println("");
                addBookableRoom();
            }
        }
    }

    public static void removeBookableRoom(){
        int x = 0;
        while(BookingSystem1.BookableroomX[x] != null){
            if((BookingSystem1.BookableroomX[x].getStatus().equals("EMPTY"))){
                BookingSystem1.BookableroomX[x].printTemplate();//prints empty room
            }
            x++;
        }
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the bookable room to be removed.");
        System.out.println("separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        String input = mainMenuInput.nextLine();
        if(input.equals("0")) {
            clearConsole();
            mainMenu();
        }else if(input.equals("-1")){
            //exit app
            System.exit(0);
        }else{
            int id = 0;
            boolean passed=true;//verify if input is integer
            try {
                id = Integer.parseInt(input);
            } catch(Exception e) {
                passed = false;
            }
            if(passed){
                BookingSystem1.removeBookableRoom(id);
                int y = 0;
                while(y != BookingSystem1.BookableRoompointer){
                    if(BookingSystem1.BookableroomX[y] != null){
                        if(BookingSystem1.BookableroomX[y].getID() == id){
                            //did not remove successfully
                            clearConsole();
                            System.out.println("Error!");
                            System.out.println("unable to remove room with id provided");
                            removeBookableRoom();
                        }
                    }
                    y++;
                }
                clearConsole();
                System.out.println("Bookable Room removed successfully:");
                removeBookableRoom();
            }else{
                clearConsole();
                System.out.println("Error!");
                System.out.println("unable to remove room with id provided");
                removeBookableRoom();
            }
        }
    }

    public static void ListAssistantsOnShift(){
        BookingSystem1.listAssistantsOnShift();
        String input = mainMenuInput.nextLine();
        if(input.equals("0")){
            clearConsole();
            mainMenu();
        }else if(input.equals("-1")){
            //exit app
            System.exit(0);
        }else{
            clearConsole();
            ListAssistantsOnShift();
        }
    }
    public static void addAssistantonShift(){//modify so its for assistant on shift
        int x = 0;
        while(AssistantX[x] != null){
            AssistantX[x].printTemplate();
            x++;
        }
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an assistant and date (dd/mm/yyyy)");
        System.out.println(",separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        String input = mainMenuInput.nextLine();
        Date tempdate = null;
        String[] inputSplit = input.split(" " /*<- Regex */);
        if(inputSplit[0].equals("0")) {
            clearConsole();
            mainMenu();
        }else if(inputSplit[0].equals("-1")){
            //exit app
            System.exit(0);
        }else{
            x = 0;
            boolean complete = false;
            boolean foundroom = false;
            String error = "";
            while(AssistantX[x] != null){
                if(AssistantX[x].getID()==Integer.parseInt(inputSplit[0])){//change to sequential id later
                    String timedate = inputSplit[1]+" "+inputSplit[2];
                    SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    try {
                        Date bookingtime = sdformat.parse(timedate);//also make it so it verify the date is in the future
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
                        LocalTime target = LocalTime.parse(inputSplit[2]+":00",formatter) ;
                        boolean targetInZone = (//since its operating from 7 to 10.
                                target.isAfter( LocalTime.parse( "06:59:00",formatter) )
                                        &&
                                        target.isBefore( LocalTime.parse( "9:00:00",formatter) )
                        ) ;
                        if (targetInZone){
                            int y = 0;
                            while(y != BookingSystem1.AssistantOnShiftpointer){
                                if(BookingSystem1.AssistantOnShiftX[y].getEmail().equals(AssistantX[x].getEmail())){
                                    if(BookingSystem1.AssistantOnShiftX[y].getTimeSlot()==bookingtime){
                                        error = "booking already set for that time";
                                        break;
                                    }
                                }
                                y++;
                            }
                            if(BookingSystem1.addAssistantOnShift(bookingtime,AssistantX[x].getName(),AssistantX[x].getEmail())){//Date timeslot, String name, String email)
                                tempdate = bookingtime;
                                complete = true;
                            }else{
                                error = " Assistant already on that shift";
                            }
                        }else{
                            error = "invalid time input";
                        }

                    } catch (ParseException e) {
                        error = "invalid entry";
                        break;
                    }
                    foundroom = true;
                }
                x++;
            }
            if (foundroom) {
                if (complete) {
                    //print assistant on shift
                    int z = 0;
                    while(z!=BookingSystem1.AssistantOnShiftpointer){
                        if(BookingSystem1.AssistantOnShiftX[z] != null) {
                            if (BookingSystem1.AssistantOnShiftX[z].getEmail().equals(inputSplit[0])) {
                                if(BookingSystem1.AssistantOnShiftX[z].getTimeSlot() == tempdate) {//it is initialized
                                    BookingSystem1.AssistantOnShiftX[z].printTemplate();
                                    break;
                                }
                            }
                        }
                        z++;
                    }
                    clearConsole();
                    System.out.println("assistant on shift added successfully:");
                    addBookableRoom();//allows to add more entries
                } else {
                    clearConsole();
                    System.out.println("Error!");
                    System.out.println(error);//prints error code
                    System.out.println("");
                    addBookableRoom();
                }
            }else{
                clearConsole();
                error = "invalid room code";
                System.out.println("Error!");
                System.out.println(error);//prints error code
                System.out.println("");
                addBookableRoom();
            }
        }
    }
    public static void removeAssistantonShift(){//modify so its for assistant on shift
        int x = 0;
        while(BookingSystem1.AssistantOnShiftX[x] != null){
            if((BookingSystem1.AssistantOnShiftX[x].getStatus().equals("FREE"))){
                BookingSystem1.AssistantOnShiftX[x].printTemplate();//prints empty room
            }
            x++;
        }
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the assistant on shift to be removed.");
        System.out.println("separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        String input = mainMenuInput.nextLine();
        if(input.equals("0")) {
            clearConsole();
            mainMenu();
        }else if(input.equals("-1")){
            //exit app
            System.exit(0);
        }else{
            int id = 0;
            boolean passed=true;//verify if input is integer
            try {
                id = Integer.parseInt(input);
            } catch(Exception e) {
                passed = false;
            }
            if(passed){
                BookingSystem1.removeAssistantOnShift(id);//it is just in the catch block
                //find and remove the room
                int y = 0;
                while(y != BookingSystem1.AssistantOnShiftpointer){
                    if(BookingSystem1.AssistantOnShiftX[y] != null){
                        if(BookingSystem1.AssistantOnShiftX[y].getID() == id){
                            clearConsole();
                            System.out.println("Error!");
                            System.out.println("unable to remove a Assistant with id provided");
                            removeBookableRoom();
                        }
                    }
                    y++;
                }
                clearConsole();
                System.out.println("Assistant removed successfully:");
                removeAssistantonShift();
            }else{
                clearConsole();
                System.out.println("Error!");
                System.out.println("invalid id provided");
                removeBookableRoom();
            }
        }
    }

    public static void listBooking(){
        System.out.println("Select which booking to list:");
        System.out.println("1 : All");
        System.out.println("2 : Only bookings status:SCHEDULED");
        System.out.println("3 : Only bookings status:COMPLETED");
        String input = mainMenuInput.nextLine();
        if(input.equals("1")){
            BookingSystem1.listBookings(1);
        }else if(input.equals("2")){
            BookingSystem1.listBookings(2);
        }else if(input.equals("3")){
            BookingSystem1.listBookings(3);
        }
        else if(input.equals("0")){
            clearConsole();
            mainMenu();
        }else if(input.equals("-1")){
            //exit app
            System.exit(0);
        }else{
            System.out.println("invalid input; we listed all bookings:");
            BookingSystem1.listBookings(1);
        }
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        input = mainMenuInput.nextLine();
        if (input.equals("0") ){
            clearConsole();
            mainMenu();
        }
        else if(input.equals("-1")){
            //exit app
            System.exit(0);
        }else{
            clearConsole();
            listBooking();
        }
    }
    public static void addBooking(){
        int x = 0;
        int g = 0;
        Date[] temp = new Date[100];//array of dates
        Date[] finaloutput = new Date[100];
        while(x != BookingSystem1.BookableRoompointer) {
            if(BookingSystem1.BookableroomX[x] !=null) {
                if (BookingSystem1.BookableroomX[x].getStatus().equals("EMPTY") || BookingSystem1.BookableroomX[x].getStatus().equals("AVAILABLE")) {
                    temp[g] = BookingSystem1.BookableroomX[x].getTimeSlot();
                    g++;
                }
            }
            x++;
        }
        int y = 0;
        boolean swapped = false;
        while(true){//sorts it.
            while(temp[y] !=null ){
                if(temp[y+1] !=null){
                    if(temp[y].after(temp[y+1])) {
                        Date date = temp[y];
                        temp[y] = temp[y + 1];
                        temp[y + 1] = date;
                        swapped = true;
                    }
                }
                y++;
            }
            if (!swapped){
                break;
            }else { swapped = false;}
            y= 0;
        }
        int z = 0;
        int b = 0;
        while(temp[z] != null){
            int a = 0;
            while(a != BookingSystem1.AssistantOnShiftpointer){
                if(BookingSystem1.AssistantOnShiftX[a].getTimeSlot().after(temp[z])){
                    if(BookingSystem1.AssistantOnShiftX[a].getStatus().equals("FREE")){
                        finaloutput[b] = temp[z];//creates the final array of available time
                        b++;
                    }
                }
                a++;
            }
            z++;
        }
        int c = 0;
        while(finaloutput[c] !=null){
            System.out.println(Integer.toString(10+c)+". "+finaloutput[c].toString());//prints available dates
            c++;
        }
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");
        String input = mainMenuInput.nextLine();
        String[] inputSplit = input.split(" " /*<- Regex */);//separates the number from the student email and it knows this by the space the user gave in between
        boolean isint = false;
        boolean done = false;
        try {
            @SuppressWarnings("unused")
            int test = Integer.parseInt(inputSplit[0]);
            isint = true;
        } catch (NumberFormatException ignored) {
        }
        if(isint){
            if(inputSplit[0].equals("0")){
                clearConsole();
                mainMenu();
            }else if(inputSplit[0].equals("-1")){
                System.exit(0);
                //exit app
            }else{
                int d = 0;
                while(finaloutput[d] != null){
                    if (Integer.toString(d+10).equals(inputSplit[0])){
                        BookingSystem1.addBooking(inputSplit[1],finaloutput[d]);
                        done = true;
                        break;
                    }
                    d++;
                }
            }
        }
        //sort the array of dates then check if theres a free assistant on shift for the time and date,then display those filtered results
        //allows the user to enter more than one booking
        if(done) {
            System.out.println("Booking added successfully:");
        }else{
            System.out.println("Error!");
        }
        System.out.println("");
        clearConsole();
        addBooking();//allows the user to enter more than one booking
        //incorporate error messages into booking
    }
    public static void removeBooking(){
        BookingSystem1.listBookings(2);
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");
        String input = mainMenuInput.nextLine();
        String error = "";
        int ID = 0;
        if(input.equals("0")){
            clearConsole();
            mainMenu();
        }else if(input.equals("-1")){
            System.exit(0);
                //exit app
        }else{
            int x =Integer.parseInt(input);
            if(x>=0 && x < BookingSystem1.Bookingpointer){
                if(BookingSystem1.Booking[x] != null){
                    if(BookingSystem1.Booking[x].getStatus().equals("SCHEDULED")) {
                        ID = BookingSystem1.Booking[x].getID();
                        BookingSystem1.Booking[x] = null;
                    }else{
                        error = "wrong unique identifier entered";
                    }
                }else{
                    error = "invalid input of unique identifier";
                }
            }else{
                error = "unique identifier out of range";
            }
        }
        if(error.equals("")){
            clearConsole();
            System.out.println("Booking removed successfully:");
            System.out.println("booking id removed:" + ID);
            removeBooking();//loops back up
        }else{
            clearConsole();
            System.out.println("Error!");
            System.out.println(error);
            removeBooking();
            //print error
        }
    }
    public static void concludeBooking(){
        BookingSystem1.listBookings(2);
        System.out.println("");
        System.out.println("Please, enter one of the following:");
        System.out.println("");
        System.out.println("The sequential ID to select the booking to be removed from the listed bookings above.");
        System.out.println("0. Back to main menu.");
        System.out.println("-1. Quit application.");
        System.out.println("");
        String input = mainMenuInput.nextLine();
        String error = "";
        int ID = 0;
        if(input.equals("0")){
            clearConsole();
            mainMenu();
        }else if(input.equals("-1")){
            System.exit(0);
            //exit app
        }else{
            int x =Integer.parseInt(input);
            if(x>=0 && x < BookingSystem1.Bookingpointer){
                if(BookingSystem1.Booking[x] != null){
                    if(BookingSystem1.Booking[x].getStatus().equals("SCHEDULED")) {
                        ID = BookingSystem1.Booking[x].getID();
                        BookingSystem1.Booking[x].updateStatus(true);
                    }else{
                        error = "wrong unique identifier entered";
                    }
                }else{
                    error = "invalid input of unique identifier";
                }
            }else{
                error = "unique identifier out of range";
            }
        }
        if(error.equals("")){
            clearConsole();
            System.out.println("Booking removed successfully:");
            System.out.println("booking id concluded:" + ID);
            removeBooking();//loops back up
        }else{
            clearConsole();
            System.out.println("Error!");
            System.out.println(error);
            removeBooking();
            //print error
        }
    }
}
