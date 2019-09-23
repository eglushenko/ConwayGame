package com.game.conway.fileOperations;

public enum StatusEnum {
    LIVE("O"),
    DEATH("X");

    private String typeOfStatus;

    StatusEnum(String typeOfStatus) {
        this.typeOfStatus = typeOfStatus;
    }

    public String getTypeOfStatus() {
        return typeOfStatus;
    }
}
