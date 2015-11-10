package wan.wanmarcos.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import wan.wanmarcos.R;
import wan.wanmarcos.activities.HomeActivity;
import wan.wanmarcos.models.Error;
import wan.wanmarcos.utils.Builder;
import wan.wanmarcos.utils.Constants;
import wan.wanmarcos.utils.RestClient;


public class LoginFragment extends Fragment {
    private RestClient restClient;

    private Button btnLogIn;
    private Button btnRegister;
    private Button btnForgotPassword;
    private EditText txtEmail;
    private EditText txtPassword;
    private TextView lblError;

    private String email;
    private String password;
    private Builder builder;
    private String device_token = "xxxxxxxxxxx";

    private SharedPreferences preferences;
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    public LoginFragment() {
        restClient =  new RestClient();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = setUpElements(inflater, container);
        addListeners();
        return view;
    }

    private View setUpElements(LayoutInflater inflater, ViewGroup container){
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        builder = new Builder();
        btnLogIn =  (Button)view.findViewById(R.id.logIn);
        btnRegister =(Button)view.findViewById(R.id.signUp);
        btnForgotPassword = (Button)view.findViewById(R.id.forgotPassword);
        txtEmail = (EditText)view.findViewById(R.id.email);
        txtPassword = (EditText)view.findViewById(R.id.password);
        lblError = (TextView)view.findViewById(R.id.error);

        return view;
    }

    private void addListeners(){
        addLogInListener();
        addRegisterListener();
        addForgotPasswordListener();
    }

    private void addLogInListener(){

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getFields();
                postLogIn();
            }
        });
    }

    private void addRegisterListener(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment registerFragment = new RegisterFragment();
                try {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, registerFragment);
                    transaction.addToBackStack("loginFragment");

                    transaction.commit();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void addForgotPasswordListener(){
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getFields(){
        email = txtEmail.getText().toString();
        password = txtPassword.getText().toString();
    }

    private void postLogIn(){

        Call<JsonElement> logInUser= restClient.getConsumerService().login(email, password,device_token, Constants.PLATFORM);
        String token;
        logInUser.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Response<JsonElement> response) {
                try {
                    if (response.isSuccess()) {
                        JsonObject responseBody = response.body().getAsJsonObject();
                        if (responseBody.has("token")) {
                            String token = responseBody.get("token").getAsString();
                            setPreferences(token);
                            changeToHome();
                        } else {

                        }
                    } else {
                        JSONObject responseBody = new JSONObject(response.errorBody().string());
                        String message = responseBody.getJSONObject("error").getString("message");
                        lblError.setText(message);
                    }
                }catch(Throwable e){
                    lblError.setText(e.toString());
                }
            }
            @Override
            public void onFailure(Throwable t) {
                lblError.setText(t.toString());
            }
        });
    }

    private void setPreferences(String token){
        preferences = this.getActivity().getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token",token);
        editor.commit();
    }
    private void changeToHome(){
        Intent home_activity = new Intent(getActivity(), HomeActivity.class);
        getActivity().finish();
        startActivity(home_activity);
    }
}
