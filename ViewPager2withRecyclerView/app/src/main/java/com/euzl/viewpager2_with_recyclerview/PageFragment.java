package com.euzl.viewpager2_with_recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PageFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<String> arrayList = new ArrayList<>();

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_page, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);

        // linear layout ver.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        // grid layout ver. - spanCount 지정해줘야함 (한 줄에 몇개 들어갈건지)
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
//        recyclerView.setLayoutManager(gridLayoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        setContents(args.getInt(ARG_OBJECT));
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(Integer.toString(args.getInt(ARG_OBJECT)));
        recyclerAdapter = new RecyclerAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    /**
     * for test (temporary contents)
     * @param position
     */
    void setContents(int position) {
        for (int i=0; i<position; i++) {
            arrayList.add("Hello " + i);
        }
    }
}