package image.io.serializers.netpbm.pbm;

import image.images_in_memory.netpbm.pbm.InMemoryPbm;
import image.io.serializers.netpbm.NetpbmSerializer;

import java.io.BufferedOutputStream;

public abstract class PbmSerializer<T extends InMemoryPbm> extends NetpbmSerializer<T> {
    @Override
    protected void serializeHeader(BufferedOutputStream bos, T image) {
        serializeMagic(bos, image);
        serializeSize(bos, image);
    }
}
