package com.example.normal.entity;


import java.util.List;

public class TheApple extends Tree{

    public void belongsToAppleOnly(){
        super.growUp();
    }

    private Integer size;

    protected static class MiddleNode extends Human{
        private List<TheApple>  list;
    }

}
