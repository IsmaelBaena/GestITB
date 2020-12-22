package com.itb.gestitb.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.itb.gestitb.R;
import com.itb.gestitb.Models.StudentMissingModel;
import java.util.List;


public class MissedAttendanceAdapter extends RecyclerView.Adapter<MissedAttendanceAdapter.MissingStudentHolder> {
        private List<StudentMissingModel> missingStudents;
        private OnItemClickListener itemClickListener;

        public interface  OnItemClickListener {
            void onItemClick(StudentMissingModel missingStudent, int position);
        }

        public MissedAttendanceAdapter(List<StudentMissingModel> missingStudents, OnItemClickListener itemClickListener) {
            this.missingStudents = missingStudents;
            this.itemClickListener = itemClickListener;
        }

        @NonNull
        @Override
        public MissingStudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.missed_attendance_list_item, parent, false);
            return new MissingStudentHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MissingStudentHolder holder, int position) {
            holder.bind(missingStudents.get(position), itemClickListener);
        }

        @Override
        public int getItemCount() {
            return missingStudents.size();
        }



        public static class MissingStudentHolder extends RecyclerView.ViewHolder{
            private TextView nombre, clase, fecha;
            private ImageView justified;

            public void bind(final StudentMissingModel missingStudent, final OnItemClickListener listener) {
                nombre.setText(missingStudent.getName());
                clase.setText(missingStudent.getSubject());
                fecha.setText(missingStudent.getDate().toString());

                if (missingStudent.isJustified()) justified.setImageResource(R.drawable.check_foreground);
                else justified.setImageResource(R.drawable.cross_foreground);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(missingStudent, getAdapterPosition());
                    }
                });
            }

            public MissingStudentHolder(@NonNull View itemView) {
                super(itemView);
                nombre = itemView.findViewById(R.id.textViewName);
                clase = itemView.findViewById(R.id.textViewClass);
                fecha = itemView.findViewById(R.id.textViewDate);
                justified = itemView.findViewById(R.id.imageViewJustified);
            }

        }
    }

