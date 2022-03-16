package com.example.pets;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static class PetsDetails{
        String mName;
        String mBreed;
        PetsDetails(String name, String breed){
            mName = name;
            mBreed = breed;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PetsDetails> pets= new ArrayList<>();

        pets.add(new PetsDetails("Tommy", "Pomeranian"));
        pets.add(new PetsDetails("Garfield", "Tabby"));
        pets.add(new PetsDetails("Binx", "Bombay"));
        pets.add(new PetsDetails("Lady", "Cocker Spanial"));
        pets.add(new PetsDetails("Cat", "Tabby"));

        PetsArrayAdapter petsViewAdapter = new PetsArrayAdapter(this, pets);

        ListView displayPetsDetails = findViewById(R.id.listView);
        displayPetsDetails.setAdapter(petsViewAdapter);
    }

    class PetsArrayAdapter extends ArrayAdapter<PetsDetails> {

        public PetsArrayAdapter(@NonNull Context context, ArrayList<PetsDetails> petsDetails) {
            super(context, 0, petsDetails);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View currentItemView = convertView;

            if(currentItemView == null){
                currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);
            }

            PetsDetails currentPetDetail = getItem(position);

            TextView nameTextView = currentItemView.findViewById(R.id.nameTextView);
            nameTextView.setText(currentPetDetail.mName);

            TextView breedNameTextView = currentItemView.findViewById(R.id.breedNameTextView);
            breedNameTextView.setText(currentPetDetail.mBreed);

            return currentItemView;
        }

    }
}