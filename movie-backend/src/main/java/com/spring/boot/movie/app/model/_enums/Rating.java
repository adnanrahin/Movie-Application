package com.spring.boot.movie.app.model._enums;

public enum Rating {

    G, PG, PG_13, R, NC_17;

    public String toString() {
        switch (this) {
            case NC_17:
                return "NC-17";
            case R:
                return "R";
            case PG:
                return "PG";
            case PG_13:
                return "PG-13";
            default:
                return "G";
        }
    }
}
