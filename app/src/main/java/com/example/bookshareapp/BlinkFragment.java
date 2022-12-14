package com.example.bookshareapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookshareapp.databinding.FragmentBlinkBinding;

public class BlinkFragment extends Fragment {
    private FragmentBlinkBinding binding;

    public BlinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentBlinkBinding.inflate(inflater,container,false);


        binding.addBookAction.setOnClickListener(view ->                                                  //navigate
                Navigation.findNavController(container).navigate(R.id.blink_to_addBook_action)
        );


        return binding.getRoot();
    }
}