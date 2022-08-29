package com.iqama.headfirst;

import java.util.ArrayList;

public class expert {
    public ArrayList<String> getBrands(String color){
        ArrayList<String> brands = new ArrayList<>();
        if (color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }
        else {
            brands.add("Jail Ale Pale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}
