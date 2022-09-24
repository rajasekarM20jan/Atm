import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OperatingClass {
    Scanner getInput= new Scanner(System.in);
    ArrayList<Database> accountHoldersData = new ArrayList<>();
    OperatingClass() throws Exception {
        Object dataList=  new JSONParser().parse(new FileReader("C:\\Users\\Temp-user4\\IdeaProjects\\Atm\\src\\Data.json"));
        JSONArray dataInJson = (JSONArray) dataList;

        for (Object jerry:dataInJson) {
            String name= (String) ((JSONObject) jerry).get("name");
            String pin= (String) ((JSONObject) jerry).get("pin");
            String dateOfBirth= (String) ((JSONObject) jerry).get("dateOfBirth");
            String typeOfAccount= (String) ((JSONObject) jerry).get("typeOfAccount");
            String balance= (String) ((JSONObject) jerry).get("balance");
            accountHoldersData.add(new Database(name,dateOfBirth,typeOfAccount,pin,balance));
        }
    }
    void validation() {
        boolean found=false;
        System.out.println("Enter Your Name as per Account Details:");
        String Username = getInput.nextLine();
        for (int i = 0; i < accountHoldersData.size(); i++) {
            if (Username.equals(accountHoldersData.get(i).getName())) {
                found=true;
                System.out.println("Enter Your Pin:");
                int count=3;
                while(count>0){
                    String pin= getInput.nextLine();
                    if(pin.equals(accountHoldersData.get(i).getPin())) {
                        int countForAccountType = 3;
                        do {
                            System.out.println("Enter Your Account Type: \n1-----> Savings Account \n2-----> Current Account");
                            String typeOfAcc = getInput.nextLine();
                            String account = (typeOfAcc.equals("1")) ? "SavingsAccount" : (typeOfAcc.equals("2")) ? "CurrentAccount" : "";
                            if (account.equals(accountHoldersData.get(i).getTypeOfAccount())) {
                                System.out.println("Please Select the option.. \n1----->Balance Enquiry. \n2----->Withdrawal");
                                String option = getInput.nextLine();
                                switch (option) {
                                    case "1": {
                                        System.out.println("\tYour Balance is: " + accountHoldersData.get(i).getBalance());
                                        System.out.println("\t\tThank You!");
                                        count=0;
                                        countForAccountType=0;
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Select any for Fast Withdrawal or select with Other for other amount:\n1----->500\n2----->1000\n3----->2000\n4----->Other");
                                        String fastCash = getInput.nextLine();
                                        switch (fastCash) {
                                            case "1": {
                                                System.out.println("Please wait while we process Your Transaction..");
                                                System.out.println("Please Collect Your Cash.");
                                                System.out.println("Do You wish to check your Balance?\n1----->Yes \n2----->No");
                                                String afterTransaction = getInput.nextLine();
                                                if (afterTransaction.equals("1")) {
                                                    String amt = accountHoldersData.get(i).getBalance();
                                                    int amount = Integer.parseInt(amt);
                                                    System.out.println("Your Balance is : " + (amount - 500));
                                                    System.out.println("\n\tThank You!");
                                                    count = 0;
                                                    countForAccountType = 0;
                                                    break;
                                                }
                                            }
                                            case "2": {
                                                System.out.println("Please wait while we process Your Transaction..");
                                                System.out.println("Please Collect Your Cash.");
                                                System.out.println("Do You wish to check your Balance?\n1----->Yes \n2----->No");
                                                String afterTransaction = getInput.nextLine();
                                                if (afterTransaction.equals("1")) {
                                                    String amt = accountHoldersData.get(i).getBalance();
                                                    int amount = Integer.parseInt(amt);
                                                    System.out.println("Your Balance is : " + (amount - 1000));
                                                    System.out.println("\n\tThank You!");
                                                    count = 0;
                                                    countForAccountType = 0;
                                                    break;
                                                }
                                            }
                                            case "3": {
                                                System.out.println("Please wait while we process Your Transaction..");
                                                System.out.println("Please Collect Your Cash.");
                                                System.out.println("Do You wish to check your Balance?\n1----->Yes \n2----->No");
                                                String afterTransaction = getInput.nextLine();
                                                if (afterTransaction.equals("1")) {
                                                    String amt = accountHoldersData.get(i).getBalance();
                                                    int amount = Integer.parseInt(amt);
                                                    System.out.println("Your Balance is : " + (amount - 2000));
                                                    System.out.println("\n\tThank You!");
                                                    count = 0;
                                                    countForAccountType = 0;
                                                    break;
                                                }
                                            }
                                            case "4": {
                                                for(int k=3;k>0;k--){
                                                    System.out.println("Please Enter the Amount in Multiples of 100 to withdraw.");
                                                    String cash=getInput.nextLine();
                                                    int amt=Integer.parseInt(cash);
                                                    String balance = accountHoldersData.get(i).getBalance();
                                                    int bal = Integer.parseInt(balance);
                                                    if(amt>100 && (amt%100==0) && (bal-amt>0)) {
                                                        System.out.println("Please wait while we process your transaction..");
                                                        System.out.println("Please Collect Your Cash.");
                                                        System.out.println("Do You wish to check your Balance?\n1----->Yes \n2----->No");
                                                        String afterTransaction = getInput.nextLine();
                                                        if (afterTransaction.equals("1")) {
                                                            System.out.println("Your Balance is : " + (bal - amt));
                                                            System.out.println("\n\tThank You!");
                                                            count = 0;
                                                            countForAccountType = 0;
                                                            break;
                                                        }
                                                    }else{
                                                        System.out.println("Invalid amount Entered."+(k-1)+" attempts left");
                                                        if(k==1){
                                                            System.out.println("Thank You!");
                                                            count = 0;
                                                            countForAccountType = 0;
                                                            break;
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                            default:{
                                                System.out.println("Invalid Input  \n\tThank You!");
                                                count=0;
                                                countForAccountType=0;
                                                break;
                                            }
                                        }
                                        count=0;
                                        countForAccountType=0;
                                        break;
                                    }
                                    default:{
                                        System.out.println("Invalid Input given");
                                        count=0;
                                        countForAccountType=0;
                                        break;
                                    }

                                }
                            } else{
                                System.out.println("Invalid Account Type.. \nPlease enter valid Account Type.. \n"+(countForAccountType-1)+" attempts left..");
                                countForAccountType--;
                                count=0;
                                if(countForAccountType==0){
                                    System.out.println("\t\tThank You!");
                                }
                            }
                        }while(countForAccountType>0);


                    }else{
                        System.out.println("Invalid Pin "+(count-1)+" attempts left!");
                        count--;
                        if(count==0){
                            System.out.println("\tThank You!");
                        }
                    }
                }
            }
        }if(!found){
            System.out.println("Invalid User Name");
        }
    }
}