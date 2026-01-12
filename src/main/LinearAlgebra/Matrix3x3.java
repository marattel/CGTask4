package main.LinearAlgebra;

public class Matrix3x3 extends Matrix<Matrix3x3>{
    public Matrix3x3(float [][] data){
        if (data.length != 3 || data[0].length != 3){
            throw new IllegalArgumentException("Вы пытаетесь создать матрицу 3x3, но передаете массив неправильной длины!");
        }
        super(data, 3);
    }


    @Override
    protected Matrix3x3 createNew(float[][] data) {
        return new  Matrix3x3(data);
    }


    public static Matrix3x3 oneMatrix() {
        return new Matrix3x3(new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });
    }


    public static Matrix3x3 zeroMatrix() {
        return new Matrix3x3(new float[3][3]);
    }


    public Vector3D multiplyByVector(Vector4D vector4D){
        if (this.getDimension() == 3) {
            float x = vector4D.getX(),
                    y = vector4D.getY(),
                    z = vector4D.getZ(),
                    w = vector4D.getW();
            if (floatIsZero(w)) {
                w = 1;
            }
            float[] data = {x / w, y / w, z / w};
            return this.multiplyByVector(new Vector3D(data));
        }else {
            throw new IllegalArgumentException("Вы вызывайте не тот метод этот метод для умножения матрицы 3x3 на вектор 4д");
        }
    }
}
