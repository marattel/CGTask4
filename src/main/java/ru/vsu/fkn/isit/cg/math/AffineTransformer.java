package ru.vsu.fkn.isit.cg.math;

import ru.vsu.fkn.isit.cg.math.LinearAlgebra.Matrix3x3;
import ru.vsu.fkn.isit.cg.math.LinearAlgebra.Matrix4x4;
import ru.vsu.fkn.isit.cg.math.LinearAlgebra.Vector3D;
import ru.vsu.fkn.isit.cg.math.LinearAlgebra.Vector4D;
import ru.vsu.fkn.isit.cg.model.Model;

import java.util.ArrayList;

public class AffineTransformer {
    public static Matrix4x4 createScalingMatrix(float sx, float sy, float sz) {
        return new Matrix4x4(new float[][]{
                {sx, 0, 0, 0},
                {0, sy, 0, 0},
                {0, 0, sz, 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix4x4 createRotateXMatrix(float angelRotateX) {
        return new Matrix4x4(new float[][]{
                {1, 0, 0, 0},
                {0, (float) Math.cos(angelRotateX), (float) Math.sin(angelRotateX), 0},
                {0, (float) -Math.sin(angelRotateX), (float) Math.cos(angelRotateX), 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix4x4 createRotateYMatrix(float angelRotateY) {
        return new Matrix4x4(new float[][]{
                {(float) Math.cos(angelRotateY), 0, (float) Math.sin(angelRotateY), 0},
                {0, 1, 0, 0},
                {(float) - Math.sin(angelRotateY), 0, (float) Math.cos(angelRotateY), 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix4x4 createRotateZMatrix(float angelRotateZ) {
        return new Matrix4x4(new float[][]{
                {(float) Math.cos(angelRotateZ), (float) Math.sin(angelRotateZ), 0, 0},
                {(float) -Math.sin(angelRotateZ), (float) Math.cos(angelRotateZ), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
    }

    public static Matrix4x4 createTranslationMatrix(float tx, float ty, float tz) {
        return new Matrix4x4(new float[][]{
                {1, 0, 0, tx},
                {0, 1, 0, ty},
                {0, 0, 1, tz},
                {0, 0, 0, 1}
        });
    }

    public static Matrix4x4 createRotateMatrix(float angelRotateX, float angelRotateY, float angelRotateZ) {
        return createRotateZMatrix(angelRotateZ).
                multiply(createRotateYMatrix(angelRotateY)).
                multiply(createRotateXMatrix(angelRotateX));
    }

    public static Matrix4x4 createFinalTransformationMatrix(
            float sx,
            float sy,
            float sz,
            float angelRotateX,
            float angelRotateY,
            float angelRotateZ,
            float tx,
            float ty,
            float tz) {
        return createTranslationMatrix(tx, ty, tz).
                multiply(createRotateMatrix(angelRotateX, angelRotateY, angelRotateZ)).
                multiply(createScalingMatrix(sx, sy, sz));
    }

    public void FinalTransformation(Model model, Matrix4x4 finalTransformationMatrix) {
        ArrayList<Vector3D> vertices = model.getVertices();
        for (int i = 0; i < vertices.size(); i++) {
            Vector3D vertex = vertices.get(i);
            Vector3D preResult = finalTransformationMatrix.multiplyByVector(vertex);
            vertices.set(i, preResult);
        }
        model.setVertices(vertices);
    }

    public void normalTransformation(Model model, Matrix4x4 finalTransformationMatrix){
        ArrayList<Vector3D> normals = model.getNormals();
        for (int i = 0; i < normals.size(); i++){
            Vector3D normal = normals.get(i);
            Vector3D preResult = Matrix4x4ToMatrix3x3(finalTransformationMatrix)
                    .inverse().transpose().multiplyByVector(normal);
            normals.set(i, preResult);
        }
        model.setNormals(normals);
    }

    public Matrix3x3 Matrix4x4ToMatrix3x3(Matrix4x4 a){
        float[][] data = a.getData();
        return new Matrix3x3(new float[][]{
                {data[0][0], data[0][1], data[0][2]},
        {data[1][0], data[1][1], data[1][2]},
        {data[2][0], data[2][1], data[2][2]}
        });
    }
}