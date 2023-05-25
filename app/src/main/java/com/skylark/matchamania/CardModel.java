package com.skylark.matchamania;

public class CardModel {

    private String name;
    private int backImage;
    private int image;

    public CardModel(String name, int backImage, int image) {
        this.name = name;
        this.backImage = backImage;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBackImage() {
        return backImage;
    }

    public void setBackImage(int backImage) {
        this.backImage = backImage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getBack_img() {
        return backImage;
    }

    public int getImg() {
        return image;
    }
}