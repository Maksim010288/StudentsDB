package simple.com.service;

public class CheckingAFieldForEmptiness {

    public boolean Emptines(Object empty){
        if (empty.equals("")){
            return true;
        }
        return false;
    }
}
