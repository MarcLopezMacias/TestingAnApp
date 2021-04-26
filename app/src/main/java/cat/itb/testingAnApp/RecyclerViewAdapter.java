package cat.itb.testingAnApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.testingAnApp.Data.Grade;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.GradesViewHolder> implements View.OnClickListener {
    List<Grade> gradings;
    private View.OnClickListener listener;


    public RecyclerViewAdapter(List<Grade> gradings) {
        this.gradings = gradings;
    }

    @NonNull
    @Override
    public GradesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

        v.setOnClickListener(this);

        return new GradesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GradesViewHolder holder, int position) {
        holder.bindData(gradings.get(position));
    }

    @Override
    public int getItemCount() {
        return gradings.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public static class GradesViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView module;
        TextView grading;

        public GradesViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name_item);
            module = itemView.findViewById(R.id.module_item);
            grading = itemView.findViewById(R.id.grade_item);
        }

        public void bindData(Grade grade) {
            studentName.setText(grade.getStudentName());
            module.setText(grade.getModule());
            grading.setText(Double.toString(grade.getGrade()));
        }
    }
}
