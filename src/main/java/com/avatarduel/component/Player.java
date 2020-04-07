package com.avatarduel.component;

public class Player {
    private String name;
    private int health;

    public Player()
    {
        this.name = "Fauzan";
        this.health = 70000;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
