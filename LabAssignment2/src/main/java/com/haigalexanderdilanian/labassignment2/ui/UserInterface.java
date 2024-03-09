package com.haigalexanderdilanian.labassignment2.ui;
import com.haigalexanderdilanian.labassignment2.business.ChequingAccount;
import com.haigalexanderdilanian.labassignment2.business.SavingsAccount;
import com.haigalexanderdilanian.labassignment2.data.Account;
import java.math.BigDecimal;
import java.util.Scanner;
/**
 *
 * @author Haig-Alexander Dilanian
 */
public class UserInterface { //Initializing everything that's needed.
    private final Scanner sc;
    private final Account savingsBean;
    private final Account chequingBean; 
    private final ChequingAccount chequingAccount;
    private final SavingsAccount savingsAccount;
    
    public UserInterface() { // Constructor method.
        sc = new Scanner(System.in);
        savingsBean = new Account();
        chequingBean = new Account();
        chequingAccount = new ChequingAccount(new BigDecimal("1000"), new BigDecimal("0.05"),chequingBean);
        savingsAccount = new SavingsAccount(new BigDecimal("1000"), new BigDecimal("0.05"), savingsBean);
    }
    
    public void perform() { // Starts and performs the entire menu/UI interface.
        char choice;
        do {
            displayBankMenu();
            choice = sc.next().charAt(0);
            switch (Character.toUpperCase(choice)) {
                case 'A' -> savingsMenu(); // Runs the savings menu and all of its functionalities.
                case 'B' -> chequingMenu(); // Runs the chequing menu and all of its functionalities.
                case 'C' -> System.out.println("Exiting program...");
                default -> System.out.println("Error. Please input a valid letter.");
            }
        } while (Character.toUpperCase(choice) != 'C');
    }
    
    private void displayBankMenu() { // Displays the main bank menu and give you options to either go to the savings/chequing menus or to exit the program.
        System.out.println("Bank Menu");
        System.out.println("A: Savings");
        System.out.println("B: Chequing");
        System.out.println("C: Exit");
        System.out.print("Enter your choice: ");
    }
    
    private void displaySavingsMenu() { // Displays the savings menu and give you options to deposit, withdraw and do a report on the account.
        System.out.println("Savings Menu");
        System.out.println("A: Deposit");
        System.out.println("B: Withdrawal");
        System.out.println("C: Report");
        System.out.println("D: Return to Bank Menu");
        System.out.print("Enter your choice: ");
    }
    
    private void displayChequingMenu() { // Displays the chequing menu and give you options to deposit, withdraw and do a report on the account.
        System.out.println("Chequing Menu");
        System.out.println("A: Deposit");
        System.out.println("B: Withdrawal");
        System.out.println("C: Report");
        System.out.println("D: Return to Bank Menu");
        System.out.print("Enter your choice: ");
    }
    
    private void savingsMenu() { // Runs the savings menu and let's you deposit, withdraw and do a report on the account.
        char choice;
        do {
            displaySavingsMenu();
            choice = sc.next().charAt(0);
            switch (Character.toUpperCase(choice)) {
                case 'A' -> {
                    System.out.print("Enter deposit amount: ");
                    BigDecimal depositAmount = sc.nextBigDecimal();
                    savingsAccount.makeDeposit(depositAmount);
                    System.out.print("Deposit successful. \n");
                }
                case 'B' -> {
                    System.out.print("Enter withdrawal amount: ");
                    BigDecimal withdrawalAmount = sc.nextBigDecimal();
                    boolean withdrawalResult = savingsAccount.makeWithdraw(withdrawalAmount);
                    if (withdrawalResult) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds. Withdrawal failed.");
                    }
                }
                case 'C' -> {
                    System.out.println("Savings Account Report:");
                    System.out.println(savingsAccount.doMonthlyReport());
                }
                case 'D' -> System.out.println("Returning to Bank Menu...");
                default -> System.out.println("Error. Please input a valid letter.");
            }
        } while (Character.toUpperCase(choice) != 'D');
    }
     
    private void chequingMenu() { // Runs the chequing menu and let's you deposit, withdraw and do a report on the account.
        char choice;
        do {
            displayChequingMenu();
            choice = sc.next().charAt(0);
            switch (Character.toUpperCase(choice)) {
                case 'A' -> {
                    System.out.print("Enter deposit amount: ");
                    BigDecimal depositAmount = sc.nextBigDecimal();
                    chequingAccount.makeDeposit(depositAmount);
                }
                case 'B' -> {
                    System.out.print("Enter withdrawal amount: ");
                    BigDecimal withdrawalAmount = sc.nextBigDecimal();
                    boolean withdrawalResult = chequingAccount.makeWithdraw(withdrawalAmount);
                    if (withdrawalResult) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds. Withdrawal failed.");
                    }
                }
                case 'C' -> {
                    System.out.println("Chequing Account Report:");
                    System.out.println(chequingAccount.doMonthlyReport());
                }
                case 'D' -> System.out.println("Returning to Bank Menu...");
                default -> System.out.println("Error. Please input a valid letter.");
            }
        } while (Character.toUpperCase(choice) != 'D');
    }
}
