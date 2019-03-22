package passwordmanager.authentication;

import javax.swing.*;

public class Login {

    private String username, password, email;

    public Login(String username, String password, String email) {

        if (!usernameExists(username) || !emailExists(email)) {
            JOptionPane.showMessageDialog(null, "Username or email is incorrect");
            return;
        }

        if (!passwordMatches(password)) {
            JOptionPane.showMessageDialog(null, "Password incorrect for username/email");
            return;
        }

        this.username = username;
        this.password = password;
        this.email = email;
        
        //Start a new login session here
    }

    private boolean passwordMatches(String password) {
        return true; //TODO check if password matches the account linked to email/username
    }

    private boolean usernameExists(String username) {
        return true; //TODO check if the user exists in the database
    }

    private boolean emailExists(String email) {
        return true; //TODO check if the email exists in the database

    }





}