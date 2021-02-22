package MapsAndMultimaps;

public class Entry {
    public final String key;
    public final Integer value;

    public Entry(String s, Integer v) {
        key = s;
        value = v;
    }

    public boolean equals(String s) {
        return s == null && key == null || key.equals(s);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && this.equals(((MapsAndMultimaps.Entry) o).key) && this.value == ((MapsAndMultimaps.Entry) o).getValue();
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
