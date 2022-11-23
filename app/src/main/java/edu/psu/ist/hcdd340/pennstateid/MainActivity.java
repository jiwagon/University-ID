package edu.psu.ist.hcdd340.pennstateid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the event source
        Button next = findViewById(R.id.button_next);  // have to import android.widget.Button
        //Attach a listener with the event source
        next.setOnClickListener(this);  // this refers  to the class MainActivity itself

        Button prev = findViewById(R.id.button_prev);
        prev.setOnClickListener(this);

    }

    // implement the OnClickListener interface - see line 9
    // Override the onClick function
    // the function that will be called each time the event is triggerd

    private static final String TAG = "ACTIVITY_4";

    // function gets called when buttons get clicked
    @Override
    public void onClick(View view) {

        int eventSourceId = view.getId();
        if (eventSourceId == R.id.button_next) {
            Log.d(TAG, "Next button clicked!");
            // handle the next button click
        }
        else if (eventSourceId == R.id.button_prev) {
            Log.d(TAG, "Previous button clicked!");
            // handle the next button click
        }

        //Log.d(TAG, String.format("event source id: %s", view.getId()));

        // What's the current profile now?
        TextView idNumberTextView = findViewById(R.id.id_number);

        // What's the current profile being diplayed now?
        String currentProfileId = idNumberTextView.getText().toString();
        // debug purpose
        Log.d(TAG, "Current profile id: " + currentProfileId);

        // Compare with the ID assigned to president
        // We will have to convert the ID (an int) to the assigned String value
        String presidentID = this.getString(R.string.president_id_number);

        Button prev = findViewById(R.id.button_prev);
        Button next = findViewById(R.id.button_next);

        if (presidentID.equals(currentProfileId)) {

            if (eventSourceId == R.id.button_next) {
                showProfile(R.drawable.ist_dean,
                        this.getString(R.string.ist_dean_first_name),
                        this.getString(R.string.ist_dean_last_name),
                        this.getString(R.string.ist_dean_machine_id),
                        this.getString(R.string.ist_dean_id_number),
                        this.getString(R.string.ist_dean_position_description));

                next.setVisibility(View.GONE);
            }
            else if (eventSourceId == R.id.button_prev) {
                showProfile(R.drawable.ist_stud,
                        this.getString(R.string.ist_stud_first_name),
                        this.getString(R.string.ist_stud_last_name),
                        this.getString(R.string.ist_stud_machine_id),
                        this.getString(R.string.ist_stud_id_number),
                        this.getString(R.string.ist_stud_position_description));

                prev.setVisibility(View.GONE);
            }
        }
        else {
            showProfile(R.drawable.psu_president,
                    this.getString(R.string.president_first_name),
                    this.getString(R.string.president_last_name),
                    this.getString(R.string.president_machine_id),
                    this.getString(R.string.president_id_number),
                    this.getString(R.string.president_position_description));

            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        }
    }

    private void showProfile(int profileImageId, String firstname, String lastname,
                             String machineId, String idNumber, String positionDescription) {

        // Update profile image
        ShapeableImageView idHolderImage = findViewById(R.id.id_holder_image);
        idHolderImage.setImageResource(profileImageId);

        // find Label
        TextView label = findViewById(R.id.first_name);
        label.setText(firstname);

        label = findViewById(R.id.last_name);
        label.setText(lastname);

        label = findViewById(R.id.id_number);
        label.setText(idNumber);

        label = findViewById(R.id.machine_id);
        label.setText(machineId);

        label = findViewById(R.id.position_description);
        label.setText(positionDescription);
    }
}

/*
            // currently the president's profile is being shown
            // we will replace it with the dean's profile
            ImageView idHolderimage = findViewById(R.id.id_holder_image);
            idHolderimage.setImageResource(R.drawable.ist_dean);

            // find Label
            TextView label = findViewById(R.id.first_name);
            label.setText(R.string.ist_dean_first_name);

            TextView lastNameTextView = findViewById(R.id.last_name);
            lastNameTextView.setText(R.string.ist_dean_last_name);

            TextView nextIdNumTextView = findViewById(R.id.id_number);
            nextIdNumTextView.setText(R.string.ist_dean_id_number);

            TextView nextMachineIdTextView = findViewById(R.id.machine_id);
            nextMachineIdTextView.setText(R.string.ist_dean_machine_id);

            TextView nextPosDescriptionTextView = findViewById(R.id.position_description);
            nextPosDescriptionTextView.setText(R.string.ist_dean_position_description);
            */