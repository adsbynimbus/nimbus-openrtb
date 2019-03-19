package com.adsbynimbus.openrtb.impression;

import com.adsbynimbus.openrtb.internal.NimbusRTB;

import java.util.Map;

import static com.adsbynimbus.openrtb.impression.Format.HEIGHT;
import static com.adsbynimbus.openrtb.impression.Format.WIDTH;

public interface Video extends BaseCreative {

    String MIN_DURATION = "minduration"; // int default 0
    String MAX_DURATION = "maxduration"; // int default 60
    String PROTOCOLS = "protocols"; // int[]
    String START_DELAY = "startdelay"; // int default 0
    String SKIP = "skip"; // int (0 = no, 1 = can skip)
    String SKIP_MIN = "skipmin"; //int default 0;
    String SKIP_AFTER = "skipafter"; //int default 0;
    String MIN_BITRATE = "minbitrate"; // int default 0;
    String MAX_BITRATE = "maxbitrate"; // int default 20000

    interface Builder extends NimbusRTB.Builder {

        default Video build() {
            final Map values = getValues();
            return new Video() {
                public final float bidfloor = (float) (values.containsKey(BID_FLOOR) ? values.get(BID_FLOOR) : 3f);
                public final String[] mimes = (String[]) values.get(MIME_TYPES);
                public final int minduration = (int) (values.containsKey(MIN_DURATION) ? values.get(MIN_DURATION) : 0);
                public final int maxduration = (int) (values.containsKey(MAX_DURATION) ? values.get(MAX_DURATION) : 60);
                public final int[] protocols = (int[]) values.get(PROTOCOLS);
                public final int w = (int) values.get(WIDTH);
                public final int h = (int) values.get(HEIGHT);
                public final int startdelay = (int) (values.containsKey(START_DELAY) ? values.get(START_DELAY) : 0);
                public final Integer skip = (Integer) values.get(SKIP);
                public final int skipmin = (int) (values.containsKey(SKIP_MIN) ? values.get(SKIP_MIN) : 0);
                public final int skipafter = (int) (values.containsKey(SKIP_AFTER) ? values.get(SKIP_AFTER) : 0);
                public final int minbitrate = (int) (values.containsKey(MIN_BITRATE) ? values.get(MIN_BITRATE) : 0);
                public final int maxbitrate = (int) (values.containsKey(MAX_BITRATE) ? values.get(MAX_BITRATE) : 0);
                public final Integer pos = (Integer) values.get(POSITION);
                public final int[] api = (int[]) values.get(SUPPORTED_APIS);
            };
        }
    }
}
