package main.LinearAlgebra;

public class Matrix4x4 extends Matrix<Matrix4x4>{
    public Matrix4x4(float [][] data){
        if (data.length != 4 || data[0].length != 4){
            throw new IllegalArgumentException("Вы пытаетесь создать матрицу 4x4, но передаете массив неправильной длины!");
        }
        super(data, 4);
    }


    @Override
    protected Matrix4x4 createNew(float[][] data) {
        return new  Matrix4x4(data);
    }


    public static Matrix4x4 oneMatrix() {
        return new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
    }


    public static Matrix4x4 zeroMatrix() {
        return new Matrix4x4(new float[4][4]);
    }


    public Vector3D multiplyByVector(Vector3D vector3D){
        if (this.getDimension() == 4) {
            Vector4D preResultVector = this.multiplyByVector(new Vector4D(
                    new float[]{
                            vector3D.getX(),
                            vector3D.getY(),
                            vector3D.getZ(),
                            (float) 1
                    }
            ));
            float x = preResultVector.getX(),
                    y = preResultVector.getY(),
                    z = preResultVector.getZ(),
                    w = preResultVector.getW();
            if (floatIsZero(w)) {
                w = 1;
            }
            return new Vector3D(new float[]{x / w, y / w, z / w});
        }else {
            throw new IllegalArgumentException("Вы вызывайте не тот метод этот метод для умножения матрицы 4x4 на вектор 3д");
        }
    }
}
