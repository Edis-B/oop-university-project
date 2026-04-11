package image.signatures;

import exceptions.ApplicationException;

import java.util.Objects;

public enum FormatType {
    ASCII_PBM("P1", ".pbm"),
    ASCII_PGM("P2", ".pgm"),
    ASCII_PPM("P3", ".ppm"),
    BINARY_PBM("P4", ".pbm"),
    BINARY_PGM("P5", ".pgm"),
    BINARY_PPM("P6", ".ppm");

    public final String magic;
    public final String extension;

    FormatType(String magic, String extension) {
        this.magic = magic;
        this.extension = extension;
    }

    public static FormatType getType(String magic) {
        for (var format : FormatType.values())
            if (Objects.equals(magic, format.magic))
                return format;

        throw new IllegalArgumentException("Unknown magic number: " + magic);
    }
}
