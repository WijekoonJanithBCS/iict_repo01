package ik.ikman.oop;

import java.util.Scanner;

public class Main {

    static BankAcc [] accDB = new BankAcc[100];
    static int index;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        boolean isRun = true;

        do{
            System.out.println("----------------Main Menu-------------");
            System.out.println();
            System.out.println("01.open a bank account");
            System.out.println("02.deposit money");
            System.out.println("03.withdraw money");
            System.out.println("04.display account details");
            System.out.println();

            System.out.println("Enter your choice (enter 0 to exit) = ");
            int choice=scanner.nextInt();

            switch (choice){
                case 0:
                    isRun = false;
                    break;
                case 1:
                    System.out.println("open new account");

                    System.out.println("Enter account number = ");
                    int accNum= scanner.nextInt();
                    System.out.println("Enter the amount = ");
                    double amount= scanner.nextDouble();
                    System.out.println("Enter account type = ");
                    String accType= scanner.next();

                    toOpenAccount(accNum,amount,accType);
                    break;
                case 2:
                    System.out.println("----------------deposit money------------");
                    System.out.println("Enter account number");
                    int accNumber=scanner.nextInt();
                    System.out.println("Enter the amount");
                    double depositAmount=scanner.nextDouble();

                    toDepsit(accNumber,depositAmount);

                    break;
                case 3:
                    System.out.println("-------------widraw money---------------");
                    System.out.println("Enter the account number = ");
                    int accountNum=scanner.nextInt();
                    System.out.println("Enter withdraw amount = ");
                    double withdrawAmount = scanner.nextDouble();

                    toWithdraw(accountNum,withdrawAmount);
                    break;
                case 4:
                    System.out.println("-------------display account details-----------");
                    System.out.println("Enter account number = ");
                    int accnum = scanner.nextInt();

                    toDisplay(accnum);
                    break;

            }

        }
        while(isRun);


    }

    private static void toDisplay(int accNum) {
        for(BankAcc acc : accDB) {
            if(acc.accNo== accNum) {
                System.out.println("your account number is = "+acc.accNo);
                System.out.println("your account amount (money) is = "+acc.amount);
                System.out.println("your account type is = "+acc.type);

            }
            else{
                System.out.println("No account found with this account number");
            }
        }
    }

    private static void toWithdraw(int accNum,double amount) {
        for(BankAcc acc : accDB){
            if(acc.accNo == accNum && acc.amount > amount) {
                acc.amount-=amount;
                System.out.println("widhrawal success.....");
            }
        }
    }

    private static void toDepsit(int accountNum,double amount) {
        for (BankAcc acc : accDB){
            if(acc.accNo == accountNum) {
                acc.amount+=amount;
                System.out.println("deposit successful.......");
                System.out.println("Your final amount is = "+acc.amount);
                break;
            }
        }
    }

    private static void toOpenAccount(int accnum,double amount, String acctype ) {

        if(index > 99) {
            System.out.println("Failed to create account");
        }

        BankAcc account = new BankAcc(accnum,amount,acctype);

        accDB[index] = account;
        index++;
        System.out.println("Account created successfully.......");

    }
}