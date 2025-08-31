package batenko.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Amount of vector components must be more than 0.\nAmount of components: " + n + ".\n");
        }

        this.components = new double[n];
        Arrays.fill(this.components, 0, this.components.length, 0);
    }

    public Vector(Vector vector) {
        if (vector.components.length == 0) {
            throw new IllegalArgumentException("Amount of vector components must be more than 0.\nAmount of components: " + vector.components.length + ".\n");
        }

        this.components = new double[vector.components.length];
        System.arraycopy(vector.components, 0, this.components, 0, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Amount of vector components must be more than 0.\nAmount of components: " + array.length + ".\n");
        }

        this.components = array;
    }

    public Vector(int n, double[] array) {
        if (array.length == 0 || n < 0) {
            throw new IllegalArgumentException("Amount of vector components must be more than 0.\n");
        }

        this.components = new double[n];

        System.arraycopy(array, 0, this.components, 0, array.length % (n + 1));

        if (array.length < n) {
            Arrays.fill(this.components, array.length, this.components.length, 0);
        }
    }

    public int getSize() {
        return components.length;
    }

    public void addVector(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = addVectorDifferentSizedComponentsArrays(this.components, vector.components);
        } else {
            for (int i = 0; i < vector.getSize(); i++) {
                this.components[i] += vector.components[i];
            }
        }
    }

    public void subtractVector(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = subtractVectorDifferentSizedComponentsArrays(this.components, vector.components);
        } else {
            for (int i = 0; i < vector.getSize(); i++) {
                this.components[i] -= vector.components[i];
            }
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < this.getSize(); i++) {
            this.components[i] *= scalar;
        }
    }

    public void turnVectorBackwards() {
        for (int i = 0; i < this.getSize(); i++) {
            this.components[i] *= -1;
        }
    }

    public double getLength() {
        double sum = 0;

        for (int i = 0; i < this.getSize(); i++) {
            sum += Math.pow(this.components[i], 2);
        }

        return Math.sqrt(sum);
    }

    public double getComponentValueByIndex(int index) {
        if (index < 0 || index > this.components.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Element index is out of components array bounds. Index: " + index + ".\n");
        }

        return this.components[index];
    }

    public void setComponentValueByIndex(int index, double value) {
        if (index < 0 || index > this.components.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Element index is out of components array bounds. Index: " + index + ".\n");
        }

        this.components[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (this.components.length != vector.components.length) {
            return false;
        }

        for (int i = 0; i < this.getSize(); i++) {
            if (this.components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(components);
    }

    @Override
    public String toString() {
        return "Vector {" +
                Arrays.toString(components) +
                '}';
    }

    public static Vector addVectors(Vector vector1, Vector vector2) {
        if (vector1.components.length < vector2.components.length) {
            return new Vector(addVectorDifferentSizedComponentsArrays(vector1.components, vector2.components));
        }

        if (vector1.components.length > vector2.components.length) {
            return new Vector(addVectorDifferentSizedComponentsArrays(vector2.components, vector1.components));
        }

        double[] temp = new double[vector1.getSize()];

        for (int i = 0; i < vector1.getSize(); i++) {
            temp[i] += vector1.components[i] + vector2.components[i];
        }

        return new Vector(temp);
    }

    public static Vector subtractVectors(Vector vector1, Vector vector2) {
        if (vector1.components.length < vector2.components.length) {
            return new Vector(subtractVectorDifferentSizedComponentsArrays(vector1.components, vector2.components));
        }

        if (vector1.components.length > vector2.components.length) {
            return new Vector(subtractVectorDifferentSizedComponentsArrays(vector2.components, vector1.components));
        }

        double[] temp = new double[vector1.getSize()];

        for (int i = 0; i < vector1.getSize(); i++) {
            temp[i] += vector1.components[i] - vector2.components[i];
        }

        return new Vector(temp);
    }

    private static double[] addVectorDifferentSizedComponentsArrays(double[] components1, double[] components2) {
        double[] components3 = new double[components2.length];
        Arrays.fill(components3, 0, components3.length, 0);

        for (int i = 0; i < components1.length; i++) {
            components3[i] += components1[i] + components2[i];
        }

        for (int i = components1.length; i < components2.length; i++) {
            components3[i] += components2[i];
        }

        return components3;
    }

    private static double[] subtractVectorDifferentSizedComponentsArrays(double[] components1, double[] components2) {
        double[] components3 = new double[components2.length];
        Arrays.fill(components3, 0, components3.length, 0);

        for (int i = 0; i < components1.length; i++) {
            components3[i] += components1[i] - components2[i];
        }

        for (int i = components1.length; i < components2.length; i++) {
            components3[i] -= components2[i];
        }

        return components3;
    }

    public static double getVectorsScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        if (vector1.getSize() >= vector2.getSize()) {
            for (int i = 0; i < vector2.getSize(); i++) {
                scalarProduct += vector1.components[i] * vector2.components[i];
            }
        } else {
            for (int i = 0; i < vector1.getSize(); i++) {
                scalarProduct += vector1.components[i] * vector2.components[i];
            }
        }

        return scalarProduct;
    }
}