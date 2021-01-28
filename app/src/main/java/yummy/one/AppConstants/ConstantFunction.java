package yummy.one.AppConstants;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantFunction {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        // TODO Auto-generated method stub
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern
                .compile(EMAIL_PATTERN);
        Matcher matcher = pattern
                .matcher(email);
        return matcher.matches();
    }

    public static boolean isValidMobile(String phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            // if(phone.length() < 6 || phone.length() > 13) {
            if (phone.length() != 10) {
                check = false;
            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }

    public boolean isValidLastName(final String LastName){
        Pattern pattern;
        Matcher matcher;
        final String LAST_NAME_PATTERN = "[a-zA-Z]+\\.?";
        pattern = Pattern.compile(LAST_NAME_PATTERN);
        matcher = pattern.matcher(LastName);
        return matcher.matches();
    }

    // validate first name
    public static boolean firstName( String firstName ) {
        return firstName.matches( "[A-Z][a-z]*" );
    }

    // validate last name
    public static boolean lastName( String lastName ) {
        return lastName.matches( "[A-Z]+([ '-][a-zA-Z]+)*" );
    }
}
