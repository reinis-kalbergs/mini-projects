package io.codelex.fibonacci_and_testing;

public class FibonacciSequence {

    public int getNumber(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Incorrect index!");
        } else if (index <= 2) {
            return index - 1;
        } else {
            return getNumber(index - 1) + getNumber(index - 2);
        }
    }

}
