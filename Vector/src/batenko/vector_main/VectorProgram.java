package batenko.vector_main;

import batenko.vector.Vector;

public class VectorProgram {
    public static void main(String[] args) {
        double[] array1 = new double[]{0.5, 4.2, 12.4, -8.3};
        double[] array2 = new double[]{2.3, 17.4, -0.4, -1.3, 6.7};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(6, array2);

        System.out.println("Размерность вектора №1 равна: " + vector1.getSize() + ".");
        System.out.println("Размерность вектора №2 равна: " + vector2.getSize() + ".\n");

        System.out.println("Вектор №1: " + vector1);
        System.out.println("Вектор №2: " + vector2 + "\n");

        vector1.addVector(vector2);
        System.out.println("Вектор №1 + Вектор №2 = " + vector1 + "\n");

        vector1.subtractVector(vector2);
        System.out.println("Вектор №1 - Вектор №2 = " + vector1 + "\n");

        double scalar = 2;

        vector1.multiplyByScalar(scalar);
        System.out.println("Вектор №1 * " + scalar + " = " + vector1 + "\n");

        vector1.turnVectorBackwards();
        System.out.println("Развернутый Вектор №1 = " + vector1 + "\n");

        System.out.println("Длина Вектора №1 = " + vector1.getLength() + "\n");

        int index = 3;
        System.out.println("Компонент №" + index + " Вектора №1 = " + vector1.getComponentValueByIndex(index));

        index = 2;
        double value = 22.7;

        vector1.setComponentValueByIndex(index, value);
        System.out.println("Длина Вектора №1 = " + vector1.getComponentValueByIndex(index) + "\n");

        if (vector1.equals(vector2)) {
            System.out.println("Ветор №1 и Вектор №2 равны.");
        } else {
            System.out.println("Ветор №1 и Вектор №2 не равны.");
        }

        System.out.println("Хэшкод Вектора №1 = " + vector1.hashCode());
        System.out.println("Хэшкод Вектора №2 = " + vector2.hashCode() + "\n");

        Vector vector3 = Vector.addVectors(vector1, vector2);
        System.out.println("Вектор №3: " + vector3 + "\n");

        Vector vector4 = Vector.subtractVectors(vector1, vector2);
        System.out.println("Вектор №4: " + vector4 + "\n");

        double scalarProduct = Vector.getVectorsScalarProduct(vector3, vector4);
        System.out.println("Скалярное произведение Вектора №3 и Вектора №4: " + scalarProduct + "\n");
    }
}