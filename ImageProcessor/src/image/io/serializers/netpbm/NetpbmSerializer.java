package image.io.serializers.netpbm;

import exceptions.ApplicationException;
import image.images_in_memory.netpbm.InMemoryNetpbm;
import image.io.serializers.ImageSerializer;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class NetpbmSerializer<T extends InMemoryNetpbm> implements ImageSerializer<T> {
    protected void serializeMagic(BufferedOutputStream bos, T image) {
        try {
            byte[] magic = image.getFormat().magic.getBytes(StandardCharsets.UTF_8);
            // Magic
            for (byte bait : magic) bos.write(bait);
            bos.write('\n');
        } catch (IOException e) {
            throw new ApplicationException("Error serializing file magic!", e);
        }
    }

    protected void serializeSize(BufferedOutputStream bos, T image) {
        try {
            byte[] width = String.valueOf(image.getWidth()).getBytes(StandardCharsets.UTF_8), height = String.valueOf(image.getHeight()).getBytes(StandardCharsets.UTF_8);

            for (byte bait : width) bos.write(bait);
            bos.write(' ');

            for (byte bait : height) bos.write(bait);
            bos.write('\n');
        } catch (IOException e) {
            throw new ApplicationException("Error serializing file size!", e);
        }
    }

    protected abstract void serializeHeader(BufferedOutputStream bos, T image);

    protected abstract void serializeBody(BufferedOutputStream bos, T image);

    @Override
    public void serialize(BufferedOutputStream bos, T image) {
        serializeHeader(bos, image);
        serializeBody(bos, image);

        try {
            bos.close();
        } catch (IOException e) {
            throw new ApplicationException("Error closing file!", e);
        }
    }
}
