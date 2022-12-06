package com.example.bookshareapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bookshareapp.databinding.FragmentAddBookBinding;
import com.example.bookshareapp.models.BookDataClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;


public class AddBookFragment extends Fragment {

private DatabaseReference mDatabase;
    private FragmentAddBookBinding binding;

    public AddBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBookBinding.inflate(inflater);


        mDatabase =FirebaseDatabase.getInstance().getReference("BookLists");

        binding.saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePost();
                Navigation.findNavController(container).navigate(R.id.add_to_home_fragment);
            }

        });


        return binding.getRoot();
    }

    private void savePost() {

        String title = binding.titleET.getText().toString();
        String description = binding.descriptionET.getText().toString();
        String location = binding.locationET.getText().toString();

        String key = mDatabase.push().getKey();

        BookDataClass bookDataClass = new BookDataClass(title,description,location);

        mDatabase.child(key).setValue(bookDataClass);

        Toast.makeText(getActivity(), "Book LIst has been uploaded ....", Toast.LENGTH_LONG).show();

        binding.titleET.setText("");
        binding.descriptionET.setText("");
        binding.locationET.setText("");


    }
}