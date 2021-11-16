public class Assistant {

    private String Name;
    private String Email;//make unique
    private int ID=0;
    private static int Static = 10;

    public void createAssistant(String name,String email){
        if (email !=null && !email.isEmpty()){
            if (email.substring(email.length() - 10).equals("@uok.ac.uk")) {
                //checks if email is the correct format
                this.Email = email;// make ending in : *@uok.ac.uk
            }
            if(name !=null && !name.isEmpty()){
                this.Name = name;
                ID = Static++;
            }else{
                System.out.println("Invalid name");
                //inform user and retry or abort
            }
        }else{
            System.out.println("Invalid email");
            //inform user and retry or abort
        }
    }

    //getters
    public String getEmail(){
        return this.Email;
    }

    public int getID(){return ID;}

    public String getName(){
        return this.Name;
    }

    public void printTemplate(){
        System.out.println("| ID: "+ ID + " | " + Name + " | "+Email+" |");
    }

}
