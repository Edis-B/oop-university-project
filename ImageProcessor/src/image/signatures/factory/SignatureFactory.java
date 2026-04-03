package image.signatures.factory;

import exceptions.ApplicationException;
import image.signatures.netpbm.AsciiPbmSignature;
import image.signatures.FormatSignature;
import util.ClassHelper;

import java.util.ArrayList;
import java.util.List;

public class SignatureFactory {
    private SignatureFactory() {
    }

    public static SignatureFactory instance;

    public static SignatureFactory getInstance() {
        if (instance == null)
            instance = new SignatureFactory();

        return instance;
    }

    public List<FormatSignature> getSignatures() {
        AsciiPbmSignature asciiPbmSignature = new AsciiPbmSignature();
        List<Class<?>> classes = ClassHelper.getClassesOfPackage(asciiPbmSignature.getClass().getPackageName());

        List<FormatSignature> signatures = new ArrayList<>();
        for (var clazz : classes) {
            if (ClassHelper.isConcrete(clazz) &&
                    FormatSignature.class.isAssignableFrom(clazz)) {
                try {
                    var formatSignatureObj = clazz
                            .asSubclass(FormatSignature.class).getConstructor().newInstance();
                    signatures.add(formatSignatureObj);
                } catch (Exception e) {
                    throw new ApplicationException("Error creating FormatSignature!", e);
                }
            }
        }

        return signatures;
    }
}
