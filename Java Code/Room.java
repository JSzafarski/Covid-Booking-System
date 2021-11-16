public class Room {

    private  String Code ;//unique
    private int Capacity;//gotta be unique
    private static int Static = 10;
    private int ID=0;


    public void addRoom(String code,int capacity){//constructor
        this.Code = code;//make sure that this has a unique name
        if (capacity >0) {
            this.Capacity = capacity;//most be greater than 0.
            ID = Static++;
        }else{
            System.out.println("Invalid capacity amount");
            //inform user that capacity if wrong and retry
        }

    }

    //getters
    public String getCode(){
        return this.Code;
    }

    public int getID(){return ID;}

    public int getCapacity(){
        return this.Capacity;
    }

    public void printTemplate(){
        System.out.println("| ID: "+ ID +"| " +Code + " | Capacity:"+ String.valueOf(Capacity)+" |");
    }

}
