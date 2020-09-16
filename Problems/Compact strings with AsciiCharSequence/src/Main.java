import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence /* extends/implements */ {

    private byte[] arr;

    public AsciiCharSequence(byte[] arr) {
        this.arr = arr.clone();
    }


    @Override
    public int length() {
        return arr.length;
    }

    @Override
    public char charAt(int i) {
        return (char) arr[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] arr = Arrays.copyOfRange(this.arr, i, i1);
        return new AsciiCharSequence(arr);
    }

    @Override
    public String toString() {
        return new String(arr, StandardCharsets.UTF_8);
    }
}