import java.util.ArrayList;

public class MobilePhone {
    // write code here
    private String myNumber;
    private ArrayList<Contact>myContacts;
    
    public MobilePhone(String phoneNumber){
        this.myNumber = phoneNumber;
        myContacts = new ArrayList<>();
    }
    public boolean addNewContact(Contact acontact){
        if (findContact(acontact.getName())>=0) return false;
        myContacts.add(acontact);
         return true;
    }
    public boolean updateContact(Contact old, Contact new_){
        
        int pos = findContact(old);
        if(pos < 0){
            return false;
        }
        else{
            myContacts.set(pos,new_);
            return true;
        }
        
    }
    public boolean removeContact(Contact acontact){
        if(findContact(acontact)>-1){
            myContacts.remove(acontact);
            return true;
        }
        return false;
        
    }
    
    private int findContact(Contact acontact){
        if(myContacts.contains(acontact)){
            
            return myContacts.indexOf(acontact);
        }
        else return -1;
        
    }
    private int findContact(String name){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact acontact = myContacts.get(i);
            if (acontact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    
    
    public Contact queryContact(String name){
        for (Contact acontact:myContacts){
            if (acontact.getName() == name){
                return acontact;
            }
        }
        return null;
        
    }
    
    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
    
}
