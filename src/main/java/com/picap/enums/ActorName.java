package com.picap.enums;

public enum ActorName {

    MIGUEL(2);

    private final int id;

    ActorName(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
