package test;

import agency.Agency;
import client.Client;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<Agency> agen;
    static boolean exit = true;
    public static void main(String[] args) {
        agen = new ArrayList<>();
        Scanner input = new Scanner(System.in);

            System.out.println("   B A N K   O F F I C I A L   ");
        do{
            System.out.println("Open Account       [1]");
            System.out.println("Deposit Account    [2]");
            System.out.println("Withdraw Account   [3]");
            System.out.println("Transfer Account   [4]");
            System.out.println("Statement Account  [5]");
            System.out.println("Exit Account       [6]");
            System.out.println("---------------------");
            System.out.print("Operation : ");
            int oper = input.nextInt();
            switch (oper) {
                case 1 -> openAcc();
                case 2 -> deposits();
                case 3 -> withdraws();
                case 4 -> transfers();
                case 5 -> lists();
                case 6 -> exit();
                default -> System.out.println("Value not found ! ");
            }

        }while (exit);
    }

    public static void openAcc(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        System.out.print("Enter your contact : ");
        String contact = sc.nextLine();
        System.out.print("Enter your email : ");
        String email = sc.nextLine();
        System.out.print("Enter your address : ");
        String address = sc.nextLine();
        System.out.print("Enter your salary : ");
        String salary = sc.nextLine();
        Client client = new Client(name,contact,email,address,salary);
        Agency ag = new Agency(client);
        ag.setStatus(true);
        agen.add(ag);
        System.out.println("Account created successfully ! ");
        System.out.println();

    }

    public static Agency findAcc(int numAcc){
        Agency nAgen = null;
        if(agen.size() > 0){
            for(Agency acc : agen){
                if(acc.getNumAcc() == numAcc){
                    nAgen = acc;
                }
            }
        }
        return nAgen;
    }

    public static void deposits(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number : ");
        int numAcc = input.nextInt();
        Agency acc = findAcc(numAcc);
        if(acc != null){
            try{
                System.out.print("Enter your value : ");
                double money = input.nextDouble();          //
                acc.deposit(money);
            }catch (InputMismatchException e ){
            System.out.println(e.getMessage()+" 'Use commingle ','  instead of dot '.' '");
            }

        }else{
            System.out.println("Account not found ! ");
        }
    }

    public static void withdraws(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number : ");
        int nRem = input.nextInt();
        Agency acc = findAcc(nRem);
        if(acc != null){
            try{
                System.out.print("Enter your value R$ : ");
                double money = input.nextDouble();
                acc.withdraw(money);
            }catch (InputMismatchException e){
                System.out.println(e.getMessage()+" 'Use commingle ','  instead of dot '.' '");
            }
        }else{
            System.out.println("Account not found ! ");
        }

    }

    public static void transfers(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number : ");
        int nRem = input.nextInt();
        Agency remet = findAcc(nRem);

        if(remet != null){
            System.out.print("Enter the recipient's number : ");
            int nDest = input.nextInt();
            Agency Dest = findAcc(nDest);

            if(Dest != null){
                System.out.print("Enter the value R$ : ");
                double money = input.nextDouble();
                remet.transfer(Dest, money);

            }else{
                System.out.println("Account number's sender not found ! ");
            }
        }else{
            System.out.println("Account number's recipient's not found ! ");
        }
    }

    public static void lists(){
        if(agen.size() > 0){
            for(Agency list : agen){
                System.out.println(list);
            }
        }
    }

    public static void exit(){
        exit = false;
        System.out.println("See you later ! ");
    }


}
