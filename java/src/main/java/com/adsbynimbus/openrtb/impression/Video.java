package com.adsbynimbus.openrtb.impression;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;

public interface Video extends Creative {

    /* Protocols [See ORTB 2.5 Section 5.8] */
    int VAST_2 = 2;
    int VAST_3 = 3;
    int VAST_2_WRAPPER = 5;
    int VAST_3_WRAPPER = 6;

    /* Playback methods [See ORTB 2.5 Section 5.10] */
    int PAGE_LOAD_SOUND_ON = 1;
    int PAGE_LOAD_SOUND_OFF = 2;
    int CLICK_SOUND_ON = 3;
    int MOUSE_OVER_SOUND_ON = 4;
    int ENTER_VIEWPORT_SOUND_ON = 5;
    int ENTER_VIEWPORT_SOUND_OFF = 6;

    /* Property Names */
    String MIN_DURATION = "minduration"; // int default 0
    String MAX_DURATION = "maxduration"; // int default 60
    String PROTOCOLS = "protocols"; // int[]
    String START_DELAY = "startdelay"; // int default 0
    String SKIP = "skip"; // int (0 = no, 1 = can skip)
    String SKIP_MIN = "skipmin"; //int default 0;
    String SKIP_AFTER = "skipafter"; //int default 0;
    String MIN_BITRATE = "minbitrate"; // int default 0;
    String MAX_BITRATE = "maxbitrate"; // int default 20000
    String PLAYBACK_METHOD  = "playbackmethod"; // int default 2

    interface Builder extends NimbusRTB.Builder {

        default Video build() {
            final Map values = getValues();
            return new Video() {
                public final Float bidfloor = (Float) values.get(BID_FLOOR); // Server default 3
                public final String[] mimes = (String[]) values.get(MIME_TYPES);
                public final Integer minduration = (int) values.get(MIN_DURATION); // Server default 0
                public final Integer maxduration = (int) values.get(MAX_DURATION); // Server default 60
                public final int[] protocols = (int[]) values.get(PROTOCOLS);
                public final int w = (int) values.get(WIDTH);
                public final int h = (int) values.get(HEIGHT);
                public final Integer startdelay = (Integer) values.get(START_DELAY); // Server default 0;
                public final Integer skip = (Integer) values.get(SKIP); // optional
                public final Integer skipmin = (Integer) values.get(SKIP_MIN); // Server default 0
                public final Integer skipafter = (Integer) values.get(SKIP_AFTER); // Server default 0
                public final Integer minbitrate = (Integer) values.get(MIN_BITRATE); // Server default 0
                public final Integer maxbitrate = (Integer) values.get(MAX_BITRATE); // Server default 0
                public final Integer pos = (Integer) values.get(POSITION); // Optional
                public final Integer playbackmethod = (Integer) values.get(PLAYBACK_METHOD); // Server default 2;
            };
        }
    }
}
