package io.zucchiniui.backend.shared.domain;

import java.util.Objects;

public final class Location {

    private String filename;

    private long line;

    /**
     * For frameworks.
     */
    private Location() {
    }

    public Location(final String filename, final long line) {
        this.filename = Objects.requireNonNull(filename);

        if (line < 1) {
            throw new IllegalArgumentException("Line number starts at 1");
        }
        this.line = line;
    }

    public String getFilename() {
        return filename;
    }

    public long getLine() {
        return line;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        final Location other = (Location) obj;
        return filename.equals(other.filename) && line == other.line;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, line);
    }

    @Override
    public String toString() {
        return filename + ":" + line;
    }

}
