package com.app.iplayadvanced.models;

import com.app.iplayadvanced.R;

public class Match {
    private String name;
    private String location;
    public int img;

    // Initializing match !
    public Match () {
        this.name = "Unknown";
        this.location = "Unknown";
        this.img = R.drawable.card_round_corners;
    }


    public Match(String name, String location, int img) {
        this.name = name;
        this.location = location;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

