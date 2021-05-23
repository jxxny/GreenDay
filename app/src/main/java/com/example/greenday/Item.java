package com.example.greenday;

public class Item {
    String type;
    String name;
    String intro;
    int image;

    public Item(){
    }

    public Item(String type, String name, String intro, int[image) {
        this.type = type;
        this.name = name;
        this.intro = intro;
        this.image = image;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getIntro(){
        return intro;
    }
    public void setIntro(String intro){
        this.intro = intro;
    }

    public int getImage(){
        return image;
    }
    public void setImage(int image){
        this.image = image;
    }
}
