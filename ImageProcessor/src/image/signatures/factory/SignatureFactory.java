package image.signatures.factory;

import exceptions.ApplicationException;
import image.signatures.netpbm.AsciiPbmSignature;
import image.signatures.FormatSignature;
import util.ClassHelper;

import java.lang.classfile.Signature;
import java.util.ArrayList;
import java.util.List;

public class SignatureFactory {
    public List<FormatSignature> getSignatures() {
        List<Class<FormatSignature>> classes = ClassHelper.getClassesImplementationsInPackage(
                FormatSignature.class.getPackageName(),
                FormatSignature.class
        );

        List<FormatSignature> signatures = new ArrayList<>();
        for (var clazz : classes) {
            try {
                FormatSignature formatSignatureObj = (FormatSignature) clazz
                        .getConstructor().newInstance();

                signatures.add(formatSignatureObj);
            } catch (Exception e) {
                throw new ApplicationException("Error creating FormatSignature!", e);
            }
        }

        return signatures;
    }
}
