package KsiegarniaFX;

/**
 * Created by Adam on 11.01.2017.
 */
public class Users {
    private String name,surname,psswd;
    private double wallet=0;
    public Users(String _name,String _surname,String _psswd){
        this.name=_name;
        this.surname=_surname;
        this.psswd=_psswd;
        this.wallet=0;
    }

    public void upgradeWallet(double hajs){
        this.wallet = hajs;
    }
    public double getHajs(){
        return this.wallet;
    }
}
