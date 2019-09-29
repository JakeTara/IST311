/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergencyApp;

import java.util.Scanner;

/**
 *
 * @author WarSpite
 */
public class Model {
    private Scanner sc = new Scanner(System.in);
    private UserDao user;
    private Volunteer volunteer;
    private AdminUser adminUser;
    private Guest guest;
    private static UserList list = new UserList();
    private boolean start = true;
    private int pageNumber = 0;
    private String check;
    private void addUserAccount(UserDao user){
        list.add(user);
    }
    
    private void loginAsUser(){
        System.out.println("");
        System.out.println("Login");
        System.out.print("User Name: ");
        String name = sc.nextLine();
        appExit(name);
        System.out.print("Password: ");
        String passWord = sc.nextLine();
        appExit(passWord);
        if(this.list.isEmpty() || !this.list.checkUser(name, passWord)){
            System.out.println("sorry failure, can't find user");
        }else{
            System.out.println("success");
            pageNumber = 8;
        }

    }
    
    private void loginAsAdmin(){
        System.out.println("");
        System.out.println("Admin Login");
        System.out.println("Current Admin: "+list.get(0).getName()+":"+list.get(0).getPassWord()+":"+list.get(0).getAdminCode());
        System.out.print("User Name: ");
        String name = sc.nextLine();
        appExit(name);
        System.out.print("Password: ");
        String passWord = sc.nextLine();
        appExit(passWord);
        System.out.print("Admin Code: ");
        int code = sc.nextInt();
        appExit(Integer.toString(code));
        if(this.list.isEmpty() || !this.list.checkUser(name, passWord, code)){
            System.out.println("sorry failure, can't find this Admin User");
        }else{
            System.out.println("success");
            pageNumber = 8;
        }
    }
    
    private void loginAsGuest() {
        System.out.println("");
        System.out.println("Guest Login");
        guest = new Guest();
        System.out.println("success");
        pageNumber = 8;
    }
    
    private void mainPlatform(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private void createAccountAsUser(){
        user = new User();
        System.out.println("");
        System.out.println("Create Account");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        appExit(name);
        System.out.print("Enter your email address: ");
        String emailAddress = sc.nextLine();
        appExit(emailAddress);
        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.nextLine();
        appExit(phoneNumber);
        boolean flag = true;
        String passWord = "";
        while(flag){
            System.out.print("Enter your password: ");
            passWord = sc.nextLine();
            appExit(passWord);
            System.out.print("Enter your password again: ");
            String passWordCheck = sc.nextLine();
            appExit(passWordCheck);
            if(!passWord.equals(passWordCheck)){
                System.out.println("sorry, the password is incorrect");
                System.out.println("please, re-enter your password");
            }
            flag = false;
        }
        
        user.setName(name);
        user.setEmailAddress(emailAddress);
        user.setPhoneNumber(phoneNumber);
        user.setPassWord(passWord);
        
        addUserAccount(user);
        System.out.println("Create account success");
        pageNumber = 0;
    }

    private void createAccountAsVolunteer(){
        user = new Volunteer();
        volunteer = (Volunteer)user;
        volunteer.examineQuestion();
        if(volunteer.examineQuestionCredit(volunteer.getCredit())){
            System.out.println("Congratulation, you have premission to register as volunteer");
            System.out.println("Create Account");
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            appExit(name);
            System.out.print("Enter your email address: ");
            String emailAddress = sc.nextLine();
            appExit(emailAddress);
            System.out.print("Enter your phone number: ");
            String phoneNumber = sc.nextLine();
            appExit(phoneNumber);
            System.out.print("Enter your hight: ");
            double hight = sc.nextDouble();
            appExit(Double.toString(hight));
            System.out.print("Enter your weight: ");
            double weight = sc.nextDouble();
            appExit(Double.toString(weight));
            boolean flag = true;
            String passWord = "";
            while(flag){
                System.out.print("Enter your password: ");
                passWord = sc.nextLine();
                appExit(passWord);
                System.out.print("Enter your password again: ");
                String passWordCheck = sc.nextLine();
                appExit(passWordCheck);
                if(!passWord.equals(passWordCheck)){
                    System.out.println("sorry, the password is incorrect");
                    System.out.println("please, re-enter your password");
                }
                flag = false;
            }

            volunteer.setName(name);
            volunteer.setEmailAddress(emailAddress);
            volunteer.setPhoneNumber(phoneNumber);
            volunteer.setPassWord(passWord);
            volunteer.setHight(hight);
            volunteer.setWeight(weight);

            addUserAccount(volunteer);
            System.out.println("Create account success");
            pageNumber = 0;
        }else{
            System.out.println("Sorry, you can't register as volunteer");
            pageNumber = 0;
        }
        
    }
    
    private void decision1(String check){
        if(check.equals("a")){
            pageNumber = 1;
        }else if(check.equals("b")){
            pageNumber = 4;
        }else{
            System.exit(0);
        }
    }
    
    private void decision2(String check){
        if(check.equals("a")){
            pageNumber = 2;
        }else if(check.equals("b")){
            pageNumber = 3;
        }else{
            System.exit(0);
        }
    }
    
    private void decision3(String check){
        if(check.equals("a")){
            pageNumber = 5;
        }else if(check.equals("b")){
            pageNumber = 6;
        }else if(check.equals("c")){
            pageNumber = 7;
        }else{
            System.exit(0);
        }
    }
    private void accountChioce(){
        System.out.println("");
        System.out.println("Create Account Choice");
        System.out.println("Normal User: press(a)");
        System.out.println("Volunter: press(b)");
        System.out.println("__________________________");
        System.out.print("Your choice: ");
        check = sc.nextLine();
        appExit(check);
        decision2(check);
    }
    
    private void loginChioce(){
        System.out.println("");
        System.out.println("Login Choice");
        System.out.println("User: press(a)");
        System.out.println("Admin User: press(b)");
        System.out.println("Guest: press(b)");
        System.out.println("__________________________");
        System.out.print("Your choice: ");
        check = sc.nextLine();
        appExit(check);
        decision3(check);
    }
    private void appExit(String check){
        if(check.toLowerCase().equals("exit")){
            System.out.println("Thank you for using this application");
            System.exit(0);
        }
    }
    
    private void initialPlatform(){
        System.out.println("Initial platform");
        System.out.println("Press \"exit\" to end program");
        System.out.println("");
        System.out.println("Sign up: press (a)");
        System.out.println("Sign in: press (b)");
        System.out.println("__________________________");
        System.out.print("Your choice: ");
        check = sc.nextLine();
        appExit(check);
        decision1(check);
    }
    
    public Model() {
        while(start){
            //Initial platform
            while(pageNumber == 0){
                initialPlatform();
            }
            

            while(pageNumber == 1){
                accountChioce();
            }
            

            while(pageNumber == 2){
                createAccountAsUser();
            }
            
            while(pageNumber == 3){
                createAccountAsVolunteer();
            }
            
            while(pageNumber == 4){
                loginChioce();
            }
            
            while(pageNumber == 5){
                loginAsUser();
            }
            
            while(pageNumber == 6){
                loginAsAdmin();
            }
            
            while(pageNumber == 7){
                loginAsGuest();
            }
            
            while(pageNumber == 8){
                mainPlatform();
            }
        }
    }

    
    
}
