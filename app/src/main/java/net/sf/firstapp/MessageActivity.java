package net.sf.firstapp;

import android.os.Bundle;
import android.util.Patterns;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import net.sf.firstapp.databinding.ActivityMessageBinding;

public class MessageActivity extends AppCompatActivity {

    private Toolbar messageToolbar;
    private ActivityMessageBinding actMsgBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        actMsgBind = ActivityMessageBinding.inflate(getLayoutInflater());
        setContentView(actMsgBind.getRoot());

        messageToolbar = actMsgBind.messageToolbar;
        messageToolbar.setTitle("Message Activity");
        setSupportActionBar(messageToolbar);

        emailFokusListener();
        phoneFocusListener();
        passwordPocusListener();

        actMsgBind.iconButton.setEnabled(false);
        actMsgBind.iconButton.setOnClickListener(v->submitForm());
    }

    private void isValidateToSubmit(){
        System.out.println(" panjang data " + vilidateEmail().length());
        if(vilidateEmail().equals("") && validatePhone().equals("") && validatePassword().equals("")) {
            actMsgBind.iconButton.setEnabled(true);
        }
        else {
            actMsgBind.iconButton.setEnabled(false);
        }
    }

    private void submitForm() {
        String message = "Email : " + actMsgBind.emailEditText.getText()
                +"\nPhone: " + actMsgBind.emailEditText.getText()
                + "\nPassword not show ";

        new MaterialAlertDialogBuilder(this)
                .setTitle("Submit form")
        .setMessage(message)
        .setNeutralButton("Ok",null)
        .setIcon(R.drawable.baseline_info_24)
                .setCancelable(false)
                .show();

    }

    private void passwordPocusListener() {
        actMsgBind.passwordEditText.setOnFocusChangeListener((v,f)->{
            if(!f){
                actMsgBind.passwordcontainer.setHelperText(vilidateEmail());
                isValidateToSubmit();
            }
        });
    }

    private void phoneFocusListener() {
        actMsgBind.phoneEditText.setOnFocusChangeListener((v,hasFocus)->{
            actMsgBind.phonecontainer.setHelperText(validatePhone());
            isValidateToSubmit();
        });
    }

    private void emailFokusListener() {
        actMsgBind.emailEditText.setOnFocusChangeListener((v,hasFocus)->{
            actMsgBind.emailcontainer.setHelperText(validatePhone());
            isValidateToSubmit();
        });
    }

    private String vilidateEmail(){
        String emailText = actMsgBind.emailEditText.getText().toString();
        if(emailText.isEmpty()){
            return "Email address cannot be empty";
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Email address is invalid";
        }
        else
            return "";
    }

    private String validatePhone(){
        String phoneText = actMsgBind.phoneEditText.getText().toString();
        if(phoneText.isEmpty()){
            return "Phone number be empty";
        }
        else if(phoneText.length() < 12){
            return "Phone number must be 12 digits";
        }
        else if(!phoneText.matches(".*[0-9].*")) {
            return "Phone number must contain only numbers";
        }
        else {
            return "";
        }
    }

    private String validatePassword(){
        String passwordText =actMsgBind.passwordEditText.getText().toString();
        if(passwordText.isEmpty()){
            return "Password can not empty";
        }
        else if(passwordText.length() < 8) {
            return "Password length minimum 8 characters";
        }
        else if(passwordText.length() > 16){
            return "Password length maximum 16 characters";
        }
        else if(!passwordText.matches(".*[0-9].*")){
            return "Password must contain at least one number";
        }
        else if(!passwordText.matches(".*[A-Z].*")){
            return "Password must contain at least one  uppercase letter";
        }
        else if(!passwordText.matches(".*[a-b].*")){
            return "Password must contain at least one lowercase letter";
        }
        else if(!passwordText.matches(".*[!@#$%^&*()_-].*")){
            return "Password must contain at least one special letter";
        }
        else {
            return "";
        }
    }
}