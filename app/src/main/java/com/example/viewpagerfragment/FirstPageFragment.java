package com.example.viewpagerfragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewpagerfragment.databinding.FragmentFirstPageBinding;

public class FirstPageFragment extends Fragment {
    FragmentFirstPageBinding binding;
    FragmentListener listener;
    private static final String ARG_TEXT = "text";
    private String text;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FragmentListener) context;
    }

    public FirstPageFragment() {
        // Required empty public constructor
    }

    public static FirstPageFragment newInstance(String data) {
        FirstPageFragment fragment = new FirstPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstPageBinding.inflate(inflater, container, false);
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textText = binding.etSend.getText().toString();
                listener.onFragmentView(textText);
            }
        });

        View view = binding.getRoot();
        return view;
    }

}
