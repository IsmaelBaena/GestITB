package com.itb.gestitb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itb.gestitb.Adapters.MissedAttendanceAdapter;
import com.itb.gestitb.Models.StudentMissingViewModel;
import com.itb.gestitb.R;
import com.itb.gestitb.Models.StudentMissingModel;

public class MissedAttendanceListFragment extends Fragment {
    RecyclerView recyclerView;
    StudentMissingViewModel studentMissingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentMissingViewModel = new ViewModelProvider(this).get(StudentMissingViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.missed_attendance_list_fragment, container, false);

        MissedAttendanceAdapter adapter = new MissedAttendanceAdapter(studentMissingViewModel.studentMissingModelList, new MissedAttendanceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(StudentMissingModel missingStudent, int position) {
                NavDirections listToDetailDirections = MissedAttendanceListFragmentDirections.actionMissedAttendanceListFragmentToMissedAttendanceFragment(missingStudent);
                Navigation.findNavController(v).navigate(listToDetailDirections);
            }
        });

        recyclerView = v.findViewById(R.id.recycleview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        return v;
    }
}
