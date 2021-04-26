package cat.itb.testingAnApp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import java.util.Date;

import cat.itb.testingAnApp.Data.Grade;
import cat.itb.testingAnApp.R;

import static cat.itb.testingAnApp.Data.GradesViewModel.gradings;

public class detailFragment extends Fragment {

    TextView titleTextView;
    EditText studentEditText;
    EditText moduleEditText;
    EditText gradeEditText;
    EditText dateEditText;
    CheckBox assistanceCheckBox;
    Button updateButton;
    Button fakeButton;
    Button goBack;
    Button deleteButton;

    Grade grade;
    int position;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("bundle", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                grade = (Grade) result.getSerializable("grade");
                position = result.getInt("position");


                studentEditText.setText(grade.getStudentName());
                moduleEditText.setText(grade.getModule());
                gradeEditText.setText(String.valueOf(grade.getGrade()));
                dateEditText.setText(String.valueOf(grade.getDateOfGrading()));
                if (grade.isAssistance()) {
                    fakeButton.setBackgroundResource(R.drawable.ic_baseline_attended_24);
                } else {
                    fakeButton.setBackgroundResource(R.drawable.ic_baseline_not_attended_24);
                }
            }
        });

    }

    View.OnClickListener updateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Grade g = new Grade();
            Date d = new Date(dateEditText.getText().toString());
            g.setStudentName(studentEditText.getText().toString());
            g.setModule(moduleEditText.getText().toString());
            g.setGrade(Double.parseDouble(gradeEditText.getText().toString()));
            g.setDateOfGrading(d);
            g.setAssistance(assistanceCheckBox.isChecked());
            if (position != 0) {
                Bundle b = new Bundle();
                b.putSerializable("grade", grade);
                b.putInt("position", position);
                getParentFragmentManager().setFragmentResult("grade", b);
                Navigation.findNavController(v).navigate(R.id.action_detailFragment_to_mainListFragment);
            } else {
                gradings.add(g);
                Navigation.findNavController(v).navigate(R.id.action_detailFragment_to_mainListFragment);
            }
        }
    };

    View.OnClickListener goBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.action_detailFragment_to_mainListFragment);
        }
    };

    View.OnClickListener deleteListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gradings.remove(gradings.get(position));
            Navigation.findNavController(v).navigate(R.id.action_detailFragment_to_mainListFragment);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);

        titleTextView = v.findViewById(R.id.titleTextView);
        studentEditText = v.findViewById(R.id.student_name_detail);
        moduleEditText = v.findViewById(R.id.module_name_detail);
        gradeEditText = v.findViewById(R.id.grade_detail);
        dateEditText = v.findViewById(R.id.date_detail);
        assistanceCheckBox = v.findViewById(R.id.assistanceCheckBox);
        updateButton = v.findViewById(R.id.update_button_detail);
        fakeButton = v.findViewById(R.id.fakeButton);
        goBack = v.findViewById(R.id.go_back_button);
        deleteButton = v.findViewById(R.id.delete_button);

        updateButton.setOnClickListener(updateListener);
        goBack.setOnClickListener(goBackListener);
        deleteButton.setOnClickListener(deleteListener);

        return v;
    }
}
