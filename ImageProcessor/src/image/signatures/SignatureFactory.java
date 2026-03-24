package image.signatures;

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
        List<FormatSignature> signatures = new ArrayList<>();
        AsciiPbmSignature asciiPbmSignature = new AsciiPbmSignature();

        List<Class<?>> classes = ClassHelper.getClassesOfPackage(asciiPbmSignature.getClass().getPackageName());

        for (var clazz : classes) {
            if (!ClassHelper.isConcrete(clazz) || clazz.isEnum()) {
                continue;
            }

            try {
                Object unknownObject = clazz.getDeclaredConstructor().newInstance();

                if (unknownObject instanceof FormatSignature) {
                    FormatSignature sig = (FormatSignature) unknownObject;
                    signatures.add(sig);
                }

            } catch (Exception e) {
                System.out.println("Could not create: " + clazz.getSimpleName());
            }
        }

        return signatures;
    }
}
