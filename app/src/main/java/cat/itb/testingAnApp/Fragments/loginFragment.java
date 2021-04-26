package cat.itb.testingAnApp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cat.itb.testingAnApp.R;

public class loginFragment extends Fragment {

    TextInputLayout usernameLayout;
    TextInputEditText usernameEditText;

    TextInputLayout passwordLayout;
    TextInputEditText passwordEditText;

    Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment, container, false);
        usernameLayout = v.findViewById(R.id.username_login_layout);
        usernameEditText = v.findViewById(R.id.username_login_edittext);

        passwordLayout = v.findViewById(R.id.password_login_layout);
        passwordEditText = v.findViewById(R.id.password_login_edittext);

        loginButton = v.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password;
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    if (password.length() < 8) {
                        Toast.makeText(getContext(), "Password is too short!", Toast.LENGTH_SHORT).show();
                    } else {
                        Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_mainListFragment);
                    }
                } else {
                    Toast.makeText(getContext(), "Need Username & Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
