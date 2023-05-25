package com.skylark.matchamania;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainGameFragment extends Fragment {

    private RecyclerView recyclerView;
    private ImageView backBtn, resetBtn;

    public MainGameFragment(){}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views from the layout
        recyclerView = view.findViewById(R.id.cats_card);
        resetBtn = view.findViewById(R.id.reset_btn);
        backBtn = view.findViewById(R.id.back_btn);

        // Set a GridLayoutManager and set the adapter for the RecyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        PopulateCard populateCard = new PopulateCard();
        CardAdapter cardAdapter = new CardAdapter(populateCard.populateCard(), getContext(), populateCard.getTotalCats(), getFragmentManager());
        recyclerView.setAdapter(cardAdapter);

        // Set a click listener for the back button to finish the main game activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        // Set a click listener for the reset button to reset the game
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    // Reset the game by setting a new adapter for the RecyclerView
    private void resetGame() {
        PopulateCard populateCard = new PopulateCard();
        CardAdapter cardAdapter = new CardAdapter(populateCard.populateCard(), getContext(), populateCard.getTotalCats(), getFragmentManager());
        recyclerView.setAdapter(cardAdapter);
    }
}