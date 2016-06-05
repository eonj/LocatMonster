package net.aurynj.rne.locatmonster.data;

import net.aurynj.rne.locatmonster.model.*;

public class Region_ID_5 extends RegionClass {
    private static final double rect_lat_lower, rect_lat_upper, rect_lng_lower, rect_lng_upper;

    static {
        rect_lat_lower = 37.584;
        rect_lat_upper = 37.586;
        rect_lng_lower = 127.028;
        rect_lng_upper = 127.030;
    }

    @Override
    public String getName() {
        return "참살이길";
    }

    @Override
    public LatLngImpl[] polygon() {
        LatLngImpl polygon[] = {
                new LatLngImpl(rect_lat_lower, rect_lng_lower),
                new LatLngImpl(rect_lat_lower, rect_lng_upper),
                new LatLngImpl(rect_lat_upper, rect_lng_upper),
                new LatLngImpl(rect_lat_upper, rect_lng_lower),
        };
        return polygon;
    }

    @Override
    public boolean includes(LatLngImpl ll) {
        return (rect_lat_lower <= ll.latitude && ll.latitude < rect_lat_upper &&
                rect_lng_upper <= ll.longitude && ll.longitude < rect_lng_upper);
    }

    @Override
    public CharacterClass roulette() {
        final double rand = Math.random();
        final double prob = 0.5;
        return rand < prob ? new Character_ID_2() : null;
    }
}
