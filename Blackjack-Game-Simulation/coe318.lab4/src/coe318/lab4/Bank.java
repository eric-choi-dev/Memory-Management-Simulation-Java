package coe318.lab4;

public class Bank {
    private String name;
    private Account[] accounts;
    private int numAccounts;

    public Bank(String name, int maxNumberAccounts){
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0;
    }

    public String getName(){
        return name;
    }

    public int getNumAccounts(){
        return numAccounts;
    }

    public Account[] getAccounts(){
        return accounts;
    }

    public boolean hasAccountNumber(int accountNumber){
        for (int i = 0; i < numAccounts; i++){
            if (accounts[i].getNumber() == accountNumber){
                return true;
            }
        }
        return false;
    }

    public boolean add(Account account) {
        if (hasAccountNumber(account.getNumber())){
            return false;
        }
        if (numAccounts >= accounts.length){
            return false;
        }
        accounts[numAccounts] = account;
        numAccounts++;
        return true;
    }
    @Override
    public String toString() { // DO NOT MODIFY
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for (Account account : getAccounts()) {
            if (account == null) break;
            s += "\n " + account;
        }
        return s;
    }

}
