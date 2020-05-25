package com.example.easyfood.view.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.ViewModelProvider;

import com.example.easyfood.R;
import com.example.easyfood.view.SettingsActivity;
import com.example.easyfood.viewmodel.CustomerSettingsViewModel;


public class CustomerSettingsActivity extends SettingsActivity {
    private String UID;

    private CustomerSettingsViewModel viewModel;

    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private Button logoutButton;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_settings);

        viewModel = new ViewModelProvider(this).get(CustomerSettingsViewModel.class);
        // UID = viewModel.getUserUID().getValue();
        viewModel.init(UID);

        emailEditText = findViewById(R.id.email_editText);
        phoneNumberEditText = findViewById(R.id.phoneNumber_editText);

        saveButton = findViewById(R.id.save_button);
        logoutButton = findViewById(R.id.logout_button);

        saveButtonListener();
        logoutButtonListener();
    }

    private void logoutButtonListener() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void saveButtonListener() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {
        viewModel.updateUser(UID, phoneNumberEditText.getText().toString());
        startActivity(new Intent(this, EateryActivity.class));
    }
}