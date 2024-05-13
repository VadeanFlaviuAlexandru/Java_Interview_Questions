package CodingProblems.DesignPatterns.BehavioralPatterns;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MediatorPattern {

    public interface Component {

        void setMediator(Mediator mediator);

        String getName();

    }

    public interface Mediator {

        void login();

        void forgotPass();

    } // a way of saying the middle-man

    public class Dialog implements Mediator {

        private final JTextField userTextBox = new JTextField();
        private final JTextField passTextBox = new JTextField();
        private final LoginButton loginButton = new LoginButton();
        private final ForgotPasswordButton passwordButton = new ForgotPasswordButton();

        public Dialog() {
            loginButton.setMediator(this);
            passwordButton.setMediator(this);
        }

        @Override
        public void login() {
            System.out.println("Logging in...");
            String username = userTextBox.getText();
            String password = passTextBox.getText();
            // validate username and password
            // logs in the user or pops error message
        }

        @Override
        public void forgotPass() {
            System.out.println("Generating new Password...");
            String username = userTextBox.getText();
            // generate new pass for the user
            // send mail to this username with new pass
        }

        public void enterUsername(String username) {
            userTextBox.setText(username);
        }

        public void enterPassword(String password) {
            passTextBox.setText(password);
        }

        public void simulateLoginClicked() {
            loginButton.fireActionPerformed(new ActionEvent(this, 0, "login"));
        }

        public void simulateForgotPassClicked() {
            passwordButton.fireActionPerformed(new ActionEvent(this, 0, "forgot pass"));
        }

    } // the dialog is the actual mediator
    // when we make the dialog constructor, we also insert the buttons and input fields

    public class ForgotPasswordButton extends JButton implements Component {

        private Mediator mediator;

        public ForgotPasswordButton() {
            super("Forgot Password?");
        }

        @Override
        protected void fireActionPerformed(ActionEvent actionEvent) {
            mediator.forgotPass();
        }

        @Override
        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }

        @Override
        public String getName() {
            return "ForgotPasswordButton";
        }

    }

    public class LoginButton extends JButton implements Component {

        private Mediator mediator;

        public LoginButton() {
            super("Log In");
        }

        @Override
        protected void fireActionPerformed(ActionEvent actionEvent) {
            mediator.login();
        }

        @Override
        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }

        @Override
        public String getName() {
            return "LoginButton";
        }

    }

    public void main(String[] args) {

        Dialog dialog = new Dialog();
        dialog.enterUsername("Geekific");
        dialog.enterPassword("LikeAndSubscribe");

        dialog.simulateLoginClicked();

        dialog.simulateForgotPassClicked();

    }
}
