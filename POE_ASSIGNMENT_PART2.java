/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_assignment_part2;

import com.mycompany.poe_assignment_part2.LoginLOGINS;
import com.mycompany.poe_assignment_part2.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author VUNINI
 */

//PLEASE NOTE THE LOGIN BUTTON DOES NOT "WORK" YOU CAN REGISTER USING 
//YOUR OWN OR THE PREDEFINED USERS TO BE ABLE TO LOGIN TO QUICKCHAT SYSYTEM
public class POE_ASSIGNMENT_PART2 {
    
       

        //ENABLES THES USERS WHO ARE ALREADY REGISTERED TO LOGIN
        private static final String[][] predefinedUsers = {
        {"nu_", "@#Vun3n3", "Vunene", "Hlungwani", "0758046295"},
        {"se_di", "@L3s3di#", "Lesedi", "Motlatlole", "+279278403852"},
        {"_mire", "@Ad1m1r3", "Vunwe", "Admire", "0639854933"},
        {"jos_y", "@Jossy_Solly", "Jsephine", "Chauke", "0713904572"},
        {"k_bo", "#kayr@yb0", "Karabo", "Kaymo", "+27884963275"}
    };
    // WITHOUT DEFINING THE LIST, THE MESSAGELIST WAS HIGHLIGHTED, AND WRITING IT BELOW MAIN METHOD HIGHLIGHTED ALMOST EVERY PART OF THE PROJECT
    private static List<String> messageList = new ArrayList<>();
    private static final ArrayList<String[]> registeredUsers = new ArrayList<>();
    private static boolean isPredefinedUser;
    //MAIN METHOD CONTAINS 3 PARTS REGISTRATION ,LOGIN AND QUICK CHAT APP SYSTEM
    public static void main(String[] args) {
        //PROGRAMMING_PART_ONE
        System.out.println("QUICKQUICKCHAT.....");
        System.out.println("*******************");
        System.out.println("PLEASE NOTE THERE ARE PREDEFINED USERS UNDERNEATH PROJECT NAME(BEFORE MAIN METHOD) TO BE ABLE TO LOG IN AND ACCESS CHATAPP ");
        //INITIALIZING VARIABLES IN REGISTRATION TO BE ABLE TO LOG IN 
        String firstname = "", lastname = "", cellNumber, username = "", password = "";
        int attempts = 0; // AVOID INFINTE LOOPS MOSTLY BECAUSE THE PROGAM JUST STARTED
        while (true) 
        {
        int initialChoice = JOptionPane.showOptionDialog(
            null,
            "Welcome to QuickChat!\nSelect an option:",
            "QuickChat",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]{"Register", "Login", "Exit"},
            "Register"
        );
        
            if (initialChoice == JOptionPane.CLOSED_OPTION) {
        attempts++;
        if (attempts >= 1) {
            break; // EXIT AFTER THE SECOND "X" IS PRESSED
        }
    } else {
        attempts = 0; // RESETS ATTEMPT COUNTER ON VALID 
    }

        //WHEN USER SELECT REGISTER
        if (initialChoice == 0) 
        { 

        // PROMPT USER FOR FIRSTNAME
        while (true)
        {
            firstname = promptUser("Step 1: Enter your first name");
            if (!firstname.isEmpty() && firstname.matches("[a-zA-Z]+")) break;
            JOptionPane.showMessageDialog(null, "Invalid first name. Ensure it only contains letters.");
        }

       // PROMPT USER FOR LASTNAME
        while (true) 
        {
            lastname = promptUser("Step 2: Enter your last name");
            if (!lastname.isEmpty() && lastname.matches("[a-zA-Z]+")) break;
            JOptionPane.showMessageDialog(null, "Invalid last name. Ensure it only contains letters.");
        }

        // PROMPT USER FOR CELL NUMBER
        while (true)
        {
            cellNumber = promptUser("Enter South African cell number (Format: +27987654321 or 0987654321)");
            if (!cellNumber.isEmpty() && (cellNumber.matches("^\\+27\\d{9}$") || cellNumber.matches("^0\\d{9}$"))) break;
            JOptionPane.showMessageDialog(null, "Invalid cell phone format! Use +27987654321 or 0987654321.");
        }

        // PROMPT USER FOR USERNAME
        while (true) 
        {
            username = promptUser("Enter username (must contain an underscore (_) and not be more than 5 characters long)");
            if (!username.isEmpty() && username.contains("_") && username.length() <= 5) break;
            JOptionPane.showMessageDialog(null, "Invalid username format! Must contain an underscore(_)and not be more than 5 characters long.");
        }

        // PROMPT USER FOR PASSWORD
        while (true)
        {
            password = promptUser("Enter password (Atleast be : 8 characters in length,consist of 1 uppercase,1 number and 1 special character)");
            if (password.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Password is required.", "Invalid", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Registration failed.");
                continue; 
            }
            // REGISTRATION STATUS
            if (!password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@!$#^%*&()+_{}\\-=\\[\\]|:;'\",.<>/?]).{8,}$")) 
            {
                JOptionPane.showMessageDialog(null, "Invalid password format!\nEnsure:\n- 8 characters long\n- At least 1 uppercase letter\n- At least 1 number\n- At least 1 special character.");
                JOptionPane.showMessageDialog(null, "Registration failed.");
                continue; 
            }

            JOptionPane.showMessageDialog(null, "Password successfully captured.");
            break;
        }
           
        registeredUsers.add(new String[]{username,password,firstname,lastname});
        JOptionPane.showMessageDialog(null, "Registration successful!"); 
  
        
        }
        
         
        //WHEN USER SELECTS EXIT
        if (initialChoice == 2)
        { 
            JOptionPane.showMessageDialog(null, "You have exited the program.");
            System.exit(0);
        }
        
        //WHEN USER SELECTS LOGINS
        if(initialChoice == 1)
           if (initialChoice == 1) {
           boolean validLogin = false;

           while (!validLogin) { //LOOPS VALIDATES USERS INPUT 
           String enteredUsername = JOptionPane.showInputDialog("Login using your username:");
           String enteredPassword = JOptionPane.showInputDialog("Login using your password:");

        //INCASE USERS INCORRECTLY SELECTECTED LOGIN AND WANTS TO EXIT 
        if (enteredUsername == null || enteredPassword == null) 
        {
            JOptionPane.showMessageDialog(null, "Login cancelled.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return; 
        }

        for (String[] user : predefinedUsers) 
        {
            if (user[0].equals(enteredUsername) && user[1].equals(enteredPassword)) 
            {
                validLogin = true;
                JOptionPane.showMessageDialog(null, "Login successful!\nWelcome, " + user[2] + " " + user[3] + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                //WELCOME MESSAGE FOR SUCCESSFULLY LOGGED IN USERS
                JOptionPane.showMessageDialog(null, "Welcome to QuickChat");

                //HANDLE MESSAGES BY CREATING INSTANCES (INTANTIATE)
                Message message = new Message("0987765432");
                message.printFullDetails(0);

                break;
            }
        }
        
          for (String[] user : registeredUsers) 
        {
            if (user[0].equals(enteredUsername) && user[1].equals(enteredPassword)) 
            {
                validLogin = true;
                JOptionPane.showMessageDialog(null, "Login successful!\nWelcome, " + user[2]+ " " + user[3]+"!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                //WELCOME MESSAGE FOR SUCCESSFULLY LOGGED IN USERS
                JOptionPane.showMessageDialog(null, "Welcome to QuickChat");

                //HANDLE MESSAGES BY CREATING INSTANCES (INTANTIATE)
                Message message = new Message("0987765432");
                message.printFullDetails(0);

                break;
            }
        }
             
        if (!validLogin) {
            JOptionPane.showMessageDialog(null, "Login failed! Invalid username or password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
       //ACCESS TO CHATAPP IF USER HAS SUCCESSFULLY LOGGED IN
      int choice = 0;
      while (choice!=3)
        {
        String input = JOptionPane.showInputDialog("QuickChat menu:\n"
                        +"1-Send Messages\n"
                        +"2-Show recently sent messages\n"
                        +"3-Quit\n"
                        +"Enter your choice:");
        if (input == null)
        {
        int confirmExit = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit Confirmation",JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION)
            {
            JOptionPane.showMessageDialog(null, "You have exited the program.");
            System.exit(0);
            }
        else 
        {
            continue;
        }
        
        }
        //RECIPIENT
        if (input!= null && input.matches("\\d+")) {
          choice = Integer.parseInt(input);
            
          switch (choice) {
                case 1:     
                        String recipient;
                       while(true){
                        recipient= JOptionPane.showInputDialog(null, "Enter recipient number (+27 or 0 followed by 9 digits)");
                          System.out.println("Entered Recipient: " + recipient);
                        if (recipient == null)// ASSIGNING (=) AND COMPARING (==) ARE TWO DIFFERENT THINGS. WHEN I USED A SINGLE = SIGN, IT SAID "INT CANNOT BE CONVERTED TO BOOLEAN."
                            {
                                JOptionPane.showMessageDialog(null, "Recipient number cannot be empty");
                            }
                        Message messageCheck = new Message(recipient);
                        if (messageCheck.checkRecipientCell()==1)
                        {
                            break;
                        }
                            JOptionPane.showMessageDialog(null, "Cellphone number is incorrectly formatted or does not contain an international code please correct the number and try again");
                        }
                        Message.resetTotalMessages();//RESETS TO COUNT TOTAL MESSAGES THAT WILL BE DISPLAYED IN PRINTFULLDETAILS
                        int totalMessagesCount = 0;
                        int msgCount = 0;//MSGCOUNT IS WHAT USERS ENTERS "ABCD"
                        do{//IF USER ENTERS 4 THEN COUNTINPUTMSG IS 4 AND THE LOOP WILL ITERATE 4 TIMES AS PER USER REQUEST
                        String countInputMsg = JOptionPane.showInputDialog(null, "How many messages would you like to send?"); 
                        if (countInputMsg != null && countInputMsg.matches("\\d+")) 
                            {
                                msgCount = Integer.parseInt(countInputMsg);
                                       if (msgCount <= 0)//ENSURES THAT USER DOESNT CONTINUE UNNESSESSARILY IF THEY ENTER THEY WANT TO SEND -2 MESSAGES AT THE END IT WILL BE 0 
                                    {
                                        JOptionPane.showMessageDialog(null, "Please enter a number greater than zero.");
                                    }
                            } 
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Please enter a valid positive number.");//ALSO ACCOUNT FOR STRING INPUTS WHEN ASKED HOW MANY MESSAGES THEY WANT TO SEND 
                            }
                            } while (msgCount <= 0);



                                for (int countMessages = 0; countMessages < msgCount; countMessages++) 
                              
                            {
                                String messageText = JOptionPane.showInputDialog(null, "Enter message text for message " + (countMessages+1) + ":");//INCREMENATES MESSAGE NUMBERS "ENTER MESSAGE 1" WHEN USER INPUTS A MESSAGE
                                while (messageText == null || messageText.trim().isEmpty()) 
                                {
                                   JOptionPane.showMessageDialog(null, "Message cannot be empty. Please enter a valid message.");
                                    messageText = JOptionPane.showInputDialog(null, "Enter message text for message " + (countMessages+1) + ":");
                                }
                                Message message = new Message("0987765432");
                                String result =  message.sendMessage();

                                while (result == null)
                                {
                                 result = message.sendMessage();
                                }
 
 
                switch (result) {
   
                    case "Message sent successfully":
                    JOptionPane.showMessageDialog(null, result);
                    messageList.add(messageText);
                    Message.incrementTotalMessages();
                    break;

                    case "Message stored to send later":
                    try 
                    {
                        message.storeMessage("message.json");
                        JOptionPane.showMessageDialog(null, "Message stored successfully in JSON file");
                    } 
                    catch (IOException e) 
                    {
                        JOptionPane.showMessageDialog(null, "Error storing message: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                    default: 
                    JOptionPane.showMessageDialog(null, result);//WHEN USER SELECTS DISCARD MESSAGE
                    break;
                }//WHEN THE USER HAS SELECTED WHAT TO DO WITH THE MESSAGE 
                    message.setMessageText(messageText);
                    Message msg = new Message("+27098765432"); 
                    JOptionPane.showMessageDialog(null, message.printFullDetails(countMessages));//COUNTS ONLY SENT MESSAGE
                            } //THE PROGRAM STOPS COUNTS THE TOTAL NUMBER OF MESSAGE HERE
                    JOptionPane.showMessageDialog(null, "You have sent all the messages");
                    JOptionPane.showMessageDialog(null, "Total number of messages sent: " + Message.returnTotalMessages());//RESETS TOTAL NUMBER TO AVOID MISCALCULATIONS
                    List<String> sentMessages = Message.printMessages();//TO PRINT ONLY SENT MESSAGES TO THE LIST
                    JList<String> listComponent = new JList<>(messageList.toArray(new String[0]));//WHEN THE LIST IS LONG THE SCROOL IS ACTIVATED
                    JOptionPane.showMessageDialog(null, new JScrollPane(listComponent), "A list of messages you sent", JOptionPane.PLAIN_MESSAGE);
                    break;
                    case 2:    
                    JOptionPane.showMessageDialog(null, "Coming Soon!!!!!.");
                    break;
                    case 3:
                    JOptionPane.showMessageDialog(null, "You selected quit.\nquitting....");//CASES WHERE USER REALLY WANT TO QUIT BUT CONFIRMS FIRST
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.Select either 1 , 2 or 3.");//WHEN USER ENTERES "VALID" NUMBER BUT IT EXCEEDS THE NUMBER OF CHOICES 
                    break;
          }
           }
        else 
             {
               JOptionPane.showMessageDialog(null, "Please enter a valid number.");//WHEN USER DOES NOT ENTER ANYTHING IN "ENTER CHOICE" 
             } 
        }
           }
        }
        
       }//CLOSE MAIN METHOD 
        
        //PARTONE 
        private static int closeCounter = 0; // WHEN USER PRESSES "X" IN LOGIN AND REGISTER SYSYEM

        private static String promptUser(String message) {
            while (true) 
            {
                String input = JOptionPane.showInputDialog(message);
            if (input == null) { // 
            closeCounter++; // COUNTS HOW MANY TIMES USER SELECTED "X"

            if (closeCounter == 1) { // WARNS USER FIRST BEFORE CLOSING DIALOG
                JOptionPane.showMessageDialog(null, 
                    "⚠ Closing the dialog 2 consecutive time will exit the program!", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
                continue; // RETURNS FROM WHERE USER LEFTOFF
            }

            if (closeCounter >= 2) { // EXIT LOGIN PROGRAM 
                JOptionPane.showMessageDialog(null, 
                    "You have closed the dialog twice. Exiting program.", 
                    "Exit Confirmation", 
                    JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }

        closeCounter = 0; // RESET COUNTER IF USER RETUENS ACTUAL INPUT
        return input.trim();
        }
    }
}



     
        
        
        











   

    


    










        
    







    

