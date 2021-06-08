package com.app.yummyone.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.yummyone.BuildConfig;
import com.app.yummyone.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;

import org.json.JSONException;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        ResultCallback {

    Context mContext;
    LinearLayout SignInLayout, ExploreLayout;
    CircleImageView imgGoogle, imgTwitter, imgFacebook;
    TextView txtTermPolicy;
    CallbackManager callbackManager;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInOptions gso;
    private static final int RC_SIGN_IN = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Twitter.initialize(mContext);

        FacebookSdk.setApplicationId(getString(R.string.facebook_app_id));
        FacebookSdk.sdkInitialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            FacebookSdk.setIsDebugEnabled(true);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        }

        setContentView(R.layout.activity_main);

        mContext = this;

        getSupportActionBar().hide();

        GoogleSignInOptions();

        ViewInitialization();

        ViewOnClick();
    }

    public void GoogleSignInOptions() {
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("649646092496-bfequa4129rn10qo0il5egbl566895qt.apps.googleusercontent.com")
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .addScope(new Scope(Scopes.PROFILE))
                .build();
    }

    public void ViewInitialization() {
        SignInLayout = findViewById(R.id.SignInLayout);
        ExploreLayout = findViewById(R.id.ExploreLayout);

        imgGoogle = findViewById(R.id.imgGoogle);
        imgTwitter = findViewById(R.id.imgTwitter);
        imgFacebook = findViewById(R.id.imgFacebook);

        txtTermPolicy = findViewById(R.id.txtTermPolicy);

        Spanned string = Html.fromHtml("By continuing, you agree to YummyOne’s<br><b>Terms of Service</b> and <b>Privacy Policy</b>");
        txtTermPolicy.setText(string);
    }

    public void ViewOnClick() {
        SignInLayout.setOnClickListener(this);
        ExploreLayout.setOnClickListener(this);
        imgGoogle.setOnClickListener(this);
        imgTwitter.setOnClickListener(this);
        imgFacebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignInLayout:
                Intent SignIn = new Intent(mContext, SignInActivity.class);
                startActivity(SignIn);
                this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.ExploreLayout:
                Intent Intro = new Intent(mContext, IntroActivity.class);
                startActivity(Intro);
                this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.imgGoogle:
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
                break;
            case R.id.imgTwitter:
//                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
//                TwitterAuthToken authToken = session.getAuthToken();
                // String token = authToken.token;
                // String secret = authToken.secret;

//                loginMethod(session);
                break;
            case R.id.imgFacebook:
                FacebookLogin();
                break;
        }
    }

    public void loginMethod(TwitterSession twitterSession) {
        String userName = twitterSession.getUserName();
        Intent intent = new Intent(mContext, SignInActivity.class);
        intent.putExtra("username", userName);
        startActivity(intent);
    }

    private void FacebookLogin() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager manager = LoginManager.getInstance();
        manager.setLoginBehavior(LoginBehavior.WEB_VIEW_ONLY);
        manager.logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile", "email"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult result) {
                // TODO Auto-generated method stub
                ProgressDialog progressDialog = new ProgressDialog(mContext);
                progressDialog.setMessage("Processing data...");
                progressDialog.show();
                String accessToken = result.getAccessToken().getToken();
                GraphRequest request = GraphRequest.newMeRequest(result.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(org.json.JSONObject object, GraphResponse response) {
                        try {
                            String facebookUserID = object.getString("id");
                            String facebookUsername = object.getString("name");
                            String facebookEmail = object.getString("email");
                            String facebookFirstName = object.getString("first_name");
                            String facebookLastName = object.getString("last_name");

                                /*Log.e("id", "" + facebookUserID);
                                Log.e("name", "" + facebookUsername);
                                Log.e("email", "" + facebookEmail);
                                Log.e("fb_firstName", "" + facebookFirstName);
                                Log.e("fb_lastName", "" + facebookLastName);*/

                            Toast.makeText(mContext, facebookUserID + "\n" + facebookUsername +
                                    "\n" + facebookEmail, Toast.LENGTH_LONG).show();

                                /*Intent PhoneVerify = new Intent(mContext, PhoneVerifyActivity.class);
                                PhoneVerify.putExtra("SocialID", facebookUserID);
                                PhoneVerify.putExtra("Email", facebookEmail);
                                PhoneVerify.putExtra("Type", "Social");
                                PhoneVerify.putExtra("NickName", facebookFirstName);
                                startActivity(PhoneVerify);*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // facebookImage = "http://graph.facebook.com/" + facebookUserID + "/picture?type=large";
                        // String facebookImage = "http://graph.facebook.com/" + Profile.getCurrentProfile().getId() + "/picture?type=large";
                        // Log.e("facebookImage", "" + facebookImage);
                    }
                });

                progressDialog.dismiss();
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,first_name,last_name,gender");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void handleSignInResult(GoogleSignInResult result) {
        // Log.e("google", "" + result.isSuccess());
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            Uri image = acct.getPhotoUrl();

            String GoogleID = acct.getId();
            String GoogleEmail = acct.getEmail();
            String GoogleUsername = acct.getDisplayName();
            String GoogleUserImage = String.valueOf(image);

            Log.e("GoogleID", "" + GoogleID);
            Log.e("GoogleUsername", "" + GoogleUsername);
            Log.e("GoogleEmail", "" + GoogleEmail);
            Log.e("GoogleUserImage", "" + GoogleUserImage);

            Toast.makeText(mContext, GoogleID + "\n" + GoogleUsername +
                    "\n" + GoogleEmail + "\n" + GoogleUserImage, Toast.LENGTH_LONG).show();

            /*Intent PhoneVerify = new Intent(mContext, PhoneVerifyActivity.class);
            PhoneVerify.putExtra("SocialID", GoogleID);
            PhoneVerify.putExtra("Email", GoogleEmail);
            PhoneVerify.putExtra("Type", "Social");
            PhoneVerify.putExtra("NickName", GoogleUsername);
            startActivity(PhoneVerify);*/
        } else {
            Log.e("Not isSuccess", "Not isSuccess");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onResult(@NonNull Result result) {
    }
}