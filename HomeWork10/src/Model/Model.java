package Model;

import Controller.EmptyArrayException;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;

public class Model {

    public static int[] generateIntArray(int size) {
        return new Random().ints(size, -11, 11).toArray();
    }

    public static double meanValue(int[] array) throws EmptyArrayException {
        OptionalDouble res = Arrays.stream(array).average();
        if (res.isPresent()) {
            return res.getAsDouble();
        } else {
            throw new EmptyArrayException();
        }
    }

    public static int minValue(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }

    public static long equalsToZero(int[] array) {
        return Arrays.stream(array).filter(x-> x==0).count();
    }

    public static long biggerThanZero(int[] array) {
        return Arrays.stream(array).filter(x-> x>0).count();
    }

    public static int[] multiplyInNumber(int[] array, double number) {
        return Arrays.stream(array).map(x-> x *= number).toArray();
    }
}
