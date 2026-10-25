package ATMproject;

import java.util.Scanner;

public class ATMproject {
    static Scanner Sc = new Scanner(System.in);
    static double balance = 1000.00;
    static int pin=1234;
    static double count_depo=0;
    static double total_depo=0;
    static double count_withdraw=0;
    static double total_withdraw=0;

    static boolean accsess;

    public static void main(String[] args) {
        boolean accsess = login();
        do { 
            menu();
            System.out.print("Choose your Servuce number:");
            int choice =Sc.nextInt();
            switch(choice){
                case 1: checkBalance();break;
                case 2: deposit();break;
                case 3: withdraw();break;
                case 4: accountTier();break;
                case 5: savingsProjection();break;
                case 6: receiptSummary();break;
                case 7: changePin();break;
                case 0: System.out.println("GoodBye:)");accsess=false;break;
                default:System.out.println("ENTER A VALID INPUT");
            }
        } while (accsess==true);
    }
    //Login
    public static boolean  login(){   
        for (int i = 2 ; i>=0; i--){
            System.out.print("Enter your password: ");
            int pass = Sc.nextInt();
            if(pass==pin){
                accsess = true;
                System.out.println("\nWelcom To your ATM simulation System ");
                break;
            }else{
                System.out.println("You have "+ i +" attempts left");
                if (i==0){
                    System.out.println("Card blocked");
                }
            }
        }  
        return accsess;
    }

    //Main Menu
    public static void menu(){
        System.out.println("\nMenu");
        System.out.println("1.Chech Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Account tier");
        System.out.println("5. Savings");
        System.out.println("6. Recoeipt projection");
        System.out.println("7. Change PIN");
        System.out.println("0. Exit");
    }
    public static void checkBalance(){
        System.out.println("Your current balance is : "+ balance );
    }

    public static double deposit(){
        System.out.print("Enter the amount you want to deposit: ");
        double DepositAmount = Sc.nextDouble();
        if (DepositAmount>0 && DepositAmount<=5000){
            balance = balance + DepositAmount;
            System.out.println("Updated Balance: "+ balance);
        }else{
            System.out.println("Error!\n Please Enter a vaild number");
        }
        count_depo++;
        total_depo+= DepositAmount;
        return balance;
    }

    public static double withdraw(){
        System.out.print("\nEnter the amount you want to withdraw: ");
        double WithdrawAmount = Sc.nextDouble();
        if (WithdrawAmount>0 
            && WithdrawAmount%10==0 
            && WithdrawAmount<balance 
            && WithdrawAmount<1000){
                if(WithdrawAmount<=500){WithdrawAmount= WithdrawAmount+2.00;}
                if (WithdrawAmount>500){WithdrawAmount= WithdrawAmount+5.00;}
                balance = balance- WithdrawAmount;
                System.out.println("Updated Balance: "+balance);
        }else{
            System.out.println("Enter a valid amount ");
        }
        count_withdraw++;
        total_withdraw+=WithdrawAmount;
        return balance;
    }

    public static void accountTier(){
        if(balance<1000){System.out.println("Tier: Bronze \nYearly interest= 1% ");}
        else if(balance >=1000 && balance <5000){System.out.println("Tier: Silver \nYearly interest= 2% ");}
        else if(balance>=5000 && balance<20000){System.out.println("Tier: Gold \nYearly interest= 3% ");}
        else{System.out.println("Tier: Platinum \nYearly interest= 4% ");}
    }

    static double getInterestRate() {
        if (balance < 1000) {
            return 0.01;
        } else if (balance < 5000) {
            return 0.02;
        } else if (balance < 20000) {
            return 0.03;
        } else {
            return 0.04;
        }
    }

    static void savingsProjection() {
    System.out.print("Enter number of years (1-10): ");
    int years = Sc.nextInt();

    if (years >= 1 && years <= 10) {
        for (int i = 1; i <= years; i++) {
            double interestRate = getInterestRate();
            balance = balance + (balance * interestRate);
            System.out.println("Year " + i + " balance: " + balance);
        }
    } else {
        System.out.println("Invalid number of years");
    }
}
static void receiptSummary() {
    System.out.println("Number of deposits: " + count_depo);
    System.out.println("Total deposits: " + total_depo);

    System.out.println("Number of withdrawals: " + count_withdraw);
    System.out.println("Total withdrawals: " + total_withdraw);

    System.out.println("Current balance: " + balance);
}

static void changePin() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter old PIN: ");
    int oldPin = sc.nextInt();
    if (oldPin == pin) {
        System.out.print("Enter new PIN: ");
        int newPin = sc.nextInt();
        if (newPin >= 1000 && newPin <= 9999) {
            System.out.print("Confirm new PIN: ");
            int confirmPin = sc.nextInt();
            if (newPin == confirmPin) {
                pin = newPin;
                System.out.println("PIN changed successfully");
            } else {
                System.out.println("PINs do not match");
            }
        } else {
            System.out.println("PIN must be 4 digits");
        }
    } else {
        System.out.println("Incorrect old PIN");
    }
}
   
   
}