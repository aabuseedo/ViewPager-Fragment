package com.example.viewpagerfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpagerfragment.databinding.FragmentSecondPageBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondPageFragment extends Fragment {

    private static final String ARG_TEXT = "text";
    private String text;
    FragmentSecondPageBinding binding;

    public SecondPageFragment() {
        // Required empty public constructor
    }

    public static SecondPageFragment newInstance(String text) {
        SecondPageFragment fragment = new SecondPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
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
        // Use binding to inflate the view
        binding = FragmentSecondPageBinding.inflate(inflater, container, false);
        if (binding != null && binding.tvReceives != null) {
            binding.tvReceives.setText(text);
        } else {
            Log log;
            Log.e("Error", "Binding or tvReceives is null.");
        }
        return binding.getRoot();

    }

    //updateText
    public void updateText(String newText) {
        if (binding != null) {
            binding.tvReceives.setText(newText);
        } else {
            Log.e("SecondPageFragment", "Binding is null, cannot update text.");
        }
    }
}
