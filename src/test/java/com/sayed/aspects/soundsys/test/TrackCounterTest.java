package com.sayed.aspects.soundsys.test;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sayed.aspects.soundsys.CompactDisc;
import com.sayed.aspects.soundsys.TrackCounter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:track-counter-config.xml")
public class TrackCounterTest {

    @Rule
    public final SystemOutRule log
            = new SystemOutRule();
    
    @Autowired
    private CompactDisc cd;
    
    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(4);
        cd.playTrack(4);
        assertEquals(1, counter.getPlayCount(1));
        assertEquals(1, counter.getPlayCount(2));
        assertEquals(4, counter.getPlayCount(3));
        assertEquals(2, counter.getPlayCount(4));
        assertEquals(0, counter.getPlayCount(5));
        assertEquals(0, counter.getPlayCount(6));
        assertEquals(0, counter.getPlayCount(7));
    }
}
