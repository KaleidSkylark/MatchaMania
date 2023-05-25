package com.skylark.matchamania;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

    private final ArrayList<CardModel> data;
    private final ArrayList<EasyFlipView> flipCards;
    private final ArrayList<String> names;
    private final Context context;
    private int totalCards;
    private final Handler handler;
    private final FragmentManager fragmentManager;

    public CardAdapter(ArrayList<CardModel> data, Context context, int totalCards, FragmentManager fragmentManager) {
        this.data = data;
        this.context = context;
        this.totalCards = totalCards;
        this.fragmentManager = fragmentManager;
        flipCards = new ArrayList<>();
        names = new ArrayList<>();
        handler = new Handler();
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        CardModel cardModel = data.get(position);
        holder.getBackImage().setImageResource(cardModel.getBackImage());
        holder.getFrontImage().setImageResource(cardModel.getImage());
        gameLogic(holder.getEasyFlipView(), handler, cardModel);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    // Controls the logic for the card game and handles the flipping of the cards
    private void gameLogic(EasyFlipView flipView, Handler handler, CardModel model) {
        flipView.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                if (easyFlipView.isBackSide()) {
                    flipCards.add(easyFlipView);
                    names.add(model.getName());
                    easyFlipView.setFlipOnTouch(false);
                } else {
                    easyFlipView.setFlipOnTouch(true);
                }

                if (flipCards.size() == 2) {
                    if (names.get(0).equals(names.get(1))) {
                        totalCards--;

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for (EasyFlipView view : flipCards) {
                                    view.setFlipEnabled(false);
                                }
                                flipCards.clear();
                                names.clear();
                            }
                        }, 200);
                    } else {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for (EasyFlipView view : flipCards) {
                                    view.flipTheView();
                                }
                                flipCards.clear();
                                names.clear();
                            }
                        }, 200);
                    }
                }

                if (totalCards == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Congratulations");
                    builder.setMessage("You have successfully matched all the cats!");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}