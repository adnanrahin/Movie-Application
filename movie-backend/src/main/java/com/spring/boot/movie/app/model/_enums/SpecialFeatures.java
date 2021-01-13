package com.spring.boot.movie.app.model._enums;

public enum SpecialFeatures {

    Trailers, Commentaries, Deleted_Scenes, Behind_the_Scenes;

    public String toString() {
        switch (this) {
            case Trailers:
                return "Trailers";
            case Commentaries:
                return "Commentaries";
            case Deleted_Scenes:
                return "Deleted Scenes";
            case Behind_the_Scenes:
                return "Behind_the_Scenes";
            default: return null;
        }
    }

}
