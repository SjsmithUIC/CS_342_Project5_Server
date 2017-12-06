import java.io.Serializable;
import java.math.BigInteger;

public class EncryptionKey implements Serializable {
    public final BigInteger first;
    public final BigInteger second;

    public EncryptionKey(BigInteger first, BigInteger second) {
        this.first = first;
        this.second = second;
    }
}
