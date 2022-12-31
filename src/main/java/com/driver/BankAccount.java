package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
      this.name = name;
      this.balance = balance;
      this.minBalance = minBalance;
    }

    public BankAccount() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        String res="";
        if(findNDigitNums(digits,sum)==""){
            throw new Exception("Account Number can not be generated");
        }else{
            res = findNDigitNums(digits,sum);
        }
        return res;
    }

    public boolean True = false;

    public String findNDigitNumsUtil(int n, int sum, char out[],
                                     int index)
    {  String res = "";

        if (index > n || sum < 0)
            return res;


        if (index == n)
        {

            if(sum == 0)
            {  if(!True){
                out[index] = '\0'   ;
                res = new String(out);
                True = true;
                System.out.print(res);

            }
            }

        }


        for (int i = 0; i <= 9; i++)
        {

            out[index] = (char)(i + '0');

            res = findNDigitNumsUtil(n, sum - i, out, index + 1);
        }
        return res;
    }

    public String findNDigitNums(int n, int sum)
    {    String result = "";

        char[] out = new char[n + 1];

        for (int i = 1; i <= 9; i++)
        {
            out[0] = (char)(i + '0');
            result = findNDigitNumsUtil(n, sum - i, out, 1);
        }
        return result;
    }
    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        this.balance-=amount;
        if(this.balance<this.minBalance){
            throw new Exception("Insufficient Balance");
        }
    }

}