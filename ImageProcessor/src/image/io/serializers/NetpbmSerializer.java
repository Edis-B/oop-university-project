package image.io.serializers;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.InMemoryNetpbm;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class NetpbmSerializer<T extends InMemoryNetpbm> implements ImageSerializer<T> {
    private void serializeHeader(BufferedOutputStream bos, T image) throws IOException {
        byte[] magic = image.getFormat().magic.getBytes(StandardCharsets.UTF_8);
        // Magic
        for (byte bait : magic) bos.write(bait);
        bos.write('\n');

        byte[] width = String.valueOf(image.getWidth()).getBytes(StandardCharsets.UTF_8),
                height = String.valueOf(image.getHeight()).getBytes(StandardCharsets.UTF_8);

        for (byte bait : width) bos.write(bait);
        bos.write(' ');

        for (byte bait : height) bos.write(bait);
        bos.write('\n');

        bos.close();
    }

    @Override
    public void serialize(BufferedOutputStream bos, T image) {
        try {
            serializeHeader(bos, image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
