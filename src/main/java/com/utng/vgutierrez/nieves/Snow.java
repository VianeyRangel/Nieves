package com.utng.vgutierrez.nieves;

/**
 * Created by Vianey Gutiérrez on 21/02/2018.
 */

public class Snow {
    private int imageId;
    private String name;
    private String start;
    private String type;

    public Snow(int imageId,
                String name,
                String start,
                String type){
        this.imageId = imageId;
        this.name = name;
        this.start = start;
        this.type = type;

    }
    public Snow(){
        this(R.mipmap.ic_launcher,
                "unamed", "started",
                "untyped");
    }
    public int getImageId(){
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getStart() {

        return start;
    }

    public String getType() {

        return type;
    }
}
