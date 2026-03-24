package image.signatures;

import exceptions.ApplicationException;

import java.util.Objects;

public enum FormatType {

    ASCII_PBM("P1"),
    ASCII_PGM("P2"),
    ASCII_PPM("P3"),
    BINARY_PBM("P4"),
    BINARY_PGM("P5"),
    BINARY_PPM("P6");

    public final String magic;

    FormatType(String magic) {
        this.magic = magic;
    }

    public static FormatType getType(String magic) {
        for (var format : FormatType.values())
            if (Objects.equals(magic, format.magic))
                return format;

        throw new IllegalArgumentException("Unknown magic number: " + magic);
    }
}
