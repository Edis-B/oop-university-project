package image.io.serializers.netpbm;

import image.images_in_memory.netpbm.InMemoryMaxValued;
import image.manipulators.annotation.SupportedFormats;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class MaxValuedSerializer<T extends InMemoryMaxValued> extends NetpbmSerializer<T> {
    @Override
    protected void serializeHeader(BufferedOutputStream bos, T image) {
        serializeMagic(bos, image);
        serializeSize(bos, image);
        serializeMaxValue(bos, image);
    }

    private void serializeMaxValue(BufferedOutputStream bos, T image) {
        try {
            byte[] maxValueString = String.valueOf(image.getMaxValue()).getBytes(StandardCharsets.UTF_8);
            for (var bait : maxValueString)
                bos.write(bait);

            bos.write('\n');
        } catch (IOException e) {
            throw new RuntimeException("Error serializing Max Value!", e);
        }
    }
}
