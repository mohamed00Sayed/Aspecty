package com.sayed.aspects.soundsys;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;


    @Override
    public void playTrack(int trackNum) {
        System.out.println("Playing " + title + " by " + artist +" Track Number:" + trackNum + " Track:" + tracks.get(trackNum));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

}
