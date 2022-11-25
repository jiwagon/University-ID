package edu.psu.ist.hcdd340.pennstateid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "LOG_IN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.button_login);
        button.setOnClickListener(this);
    }

    /**
     * Retrieve user input from EditText
     * Email address
     * password
     */
    @Override
    public void onClick(View view) {
        // Select the UI Element and getText() for email input
        EditText emailEditText = findViewById(R.id.editText_email);
        String email = emailEditText.getText().toString();
        // Log the text
        Log.d(TAG, "Email entered: " + email);

        EditText emailEditText = findViewById(R.id.editText_email);
        String email = emailEditText.getText().toString();
    }
}
