package cat.itb.testingAnApp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import cat.itb.testingAnApp.Data.Grade;
import cat.itb.testingAnApp.Data.GradesViewModel;
import cat.itb.testingAnApp.R;
import cat.itb.testingAnApp.RecyclerViewAdapter;

import static cat.itb.testingAnApp.Data.GradesViewModel.gradings;

public class MainListFragment extends Fragment {

    public static RecyclerView recyclerView;
    GradesViewModel gradingsViewModel;

    FloatingActionButton addButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("grade", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Grade grade = (Grade) result.getSerializable("grade");
                int position = result.getInt("position");
                gradings.set(position, grade);
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_list_fragment, container, false);
        gradingsViewModel = new ViewModelProvider(requireActivity()).get(GradesViewModel.class);
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(gradings));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(gradings);

        addButton = v.findViewById(R.id.addButton);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("grade", gradings.get(recyclerView.getChildAdapterPosition(v)));
                b.putInt("position", recyclerView.getChildAdapterPosition(v));
                getParentFragmentManager().setFragmentResult("bundle", b);

                Navigation.findNavController(v).navigate(R.id.action_mainListFragment_to_detailFragment);

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainListFragment_to_detailFragment);
            }
        });

        recyclerView.setAdapter(adapter);

        return v;
    }
}
