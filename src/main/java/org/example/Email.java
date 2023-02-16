package org.example;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "Merrill.com";
    Scanner in = new Scanner(System.in);
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        this.mailboxCapacity = setMailboxCapacity();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() +
                "." + companySuffix.toLowerCase();

    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    private String setDepartment() {
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for accounting\n0 for N/A");
        System.out.print("Enter department code: ");

        int deptChoice = in.nextInt();
        return switch (deptChoice) {
            case 1 -> "Sales";
            case 2 -> "Development";
            case 3 -> "Accounting";
            default -> "";
        };
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    private int setMailboxCapacity() {
        System.out.print("Enter the size in megabytes for the mailbox capacity: ");
        int mgCap = in.nextInt();
        return mgCap;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public String getPassword(){
        return password;
    }
    public void changePassword (String password) {
        this.password = password;
    }

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + " megabytes";
    }

}
