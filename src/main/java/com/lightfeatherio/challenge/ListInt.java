public class ListInt {
    protected int bufferSize = 32;
    protected int size = 0;
    protected int [] buffer = null;

    ListInt() {
        buffer = new int[bufferSize];
    }
    
    ListInt(int initialBufferSize) {
        if (initialBufferSize > 0) {
            bufferSize = initialBufferSize;
            buffer = new int[bufferSize];
        }
    }

    public void add(int element) {
        if (size > 0.75 * bufferSize) {
            // we need to resize the array, dupiclate buffer
            int[] newBuffer = new int [bufferSize * 2];
            // now we copy the elements 
            System.arraycopy(buffer, 0, newBuffer, 0, bufferSize);
            // now we set the new buffer
            buffer = newBuffer;
            // buffer is bigger
            bufferSize *= 2;
        } 
        // we have space
        buffer[size++] = element;
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) return; // TODO: an exception could be thrown here for more extensive checking
        buffer[index] = value;
    }

    public int get(int index) {
        //if (index < 0 || index >= size) {}; // TODO: an exception could be thrown here for more extensive checking
        return buffer[index];
    }

    public int size() {
        return size;
    }
}