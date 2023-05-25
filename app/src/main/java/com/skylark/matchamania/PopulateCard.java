package com.skylark.matchamania;

import java.util.ArrayList;
import java.util.Collections;

public class PopulateCard {

    // Return an ArrayList of CardModel objects with six different cat images
    public ArrayList<CardModel> catMania() {
        ArrayList<CardModel> catList = new ArrayList<>();
        catList.add(new CardModel("cat_heart", R.drawable.duck, R.drawable.cat1));
        catList.add(new CardModel("cat_hi", R.drawable.duck, R.drawable.cat2));
        catList.add(new CardModel("cat_wow", R.drawable.duck, R.drawable.cat3));
        catList.add(new CardModel("cat_laugh", R.drawable.duck, R.drawable.cat4));
        catList.add(new CardModel("cat_cry", R.drawable.duck, R.drawable.cat5));
        catList.add(new CardModel("cat_angry", R.drawable.duck, R.drawable.cat6));
        return catList;
    }

    // Return an ArrayList of CardModel objects with the cat images shuffled and duplicated
    public ArrayList<CardModel> shuffleDuplicateCats(ArrayList<CardModel> originalList) {
        ArrayList<CardModel> duplicatedList = new ArrayList<>();

        for (CardModel cats : originalList) {
            duplicatedList.add(cats);
            duplicatedList.add(new CardModel(cats.getName(), cats.getBack_img(), cats.getImg()));
        }

        Collections.shuffle(duplicatedList);
        return duplicatedList;
    }

    // Return the total number of unique cat images
    public int getTotalCats() {
        return catMania().size();
    }

    // Return an ArrayList of CardModel objects with the shuffled and duplicated cat images
    public ArrayList<CardModel> populateCard() {
        return shuffleDuplicateCats(catMania());
    }
}