package beans;

/**
 * Created by nick on 10/1/16.
 */
public class AccountID {

    public String accountID;

    public AccountID(){}

    public AccountID(String accountID){

        this.accountID = accountID;
    }

    public String getAccountID(){
        return this.accountID;
    }

    public void setAccountID(String accountID){
        this.accountID = accountID;
    }
}
