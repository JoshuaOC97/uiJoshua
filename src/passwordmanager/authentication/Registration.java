package passwordmanager.authentication;

import javax.swing.*;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {

    private String username, password, email;

    //To be called when the registration button has been pressed
    public Registration() {
        //TODO Get input from UI
        this.username = "Jack";
        this.password = "Temp$1222";
        this.email = "up866263@myport.ac.uk";

        //TODO Live updates and notifications, need the UI for this to remove popups
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return;
        }

        if (!isPasswordSecure(password)) {
            JOptionPane.showMessageDialog(null, "Please enter a secure password");
            return;
        }

        //Entry e = new Entry(var1, var2, var3, etc...);

        try {
            //Execute sql to add entry to the database unless this is done in entry
        } catch (Exception e) { //SQLException*
            e.printStackTrace();
        }

    }

    //Check if the password is secure (letter, number, special char, 8 long, etc)
    private boolean isPasswordSecure(String password) {
        String pattern = "((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
        return Pattern.compile(pattern).matcher(password).matches();
    }

    //Check if the email is valid using regex
    private boolean isValidEmail(String email) {
        String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return Pattern.compile(pattern).matcher(email).matches();
    }

}
