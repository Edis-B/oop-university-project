package image.io.serializers.pbm;

import image.images_in_memory.netpbm.pbm.InMemoryPbmBinary;
import image.io.serializers.NetpbmSerializer;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.BINARY_PBM})
public class BinaryPbmSerializer extends NetpbmSerializer<InMemoryPbmBinary> {

}
