package org.example;

import java.util.ArrayList;

public class World {

    private int worldX;
    private int worldY;
    private int turn;
    private ArrayList<String> organisms;
    private ArrayList<String> newOrganisms;
    private String separator;


    public void world (int worldX, int worldY){
        this.worldX = worldX;
        this.worldY = worldY;
        this.turn = 0;
        this.organisms = new ArrayList<>();
        this.newOrganisms = new ArrayList<>();
        this.separator = " ";
    }

    public Integer getWorldX(){return worldX;}
    public void setWorldX(int worldX){this.worldX = worldX;}
    public Integer getWorldY(){return worldY;}
    public void setWorldY(int worldY){this.worldY = worldY;}
    public Integer getTurn(){return turn;}
    public void setTurn(int turn){this.turn = turn;}
    public String getSeparator(){return separator;}
    public void setSeparator(String separator){this.separator = separator;}

    public void makeTurn(){

    }

    public void makeMove(){

    }

    public
}
