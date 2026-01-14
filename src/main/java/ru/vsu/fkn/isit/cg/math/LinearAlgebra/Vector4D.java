package ru.vsu.fkn.isit.cg.math.LinearAlgebra;

public class Vector4D extends Vector<Vector4D>{
    public Vector4D(float [] data){
        if (data.length != 4){
            throw new IllegalArgumentException("Вы пытаетесь создать вектор 2-ой размерности, но передаете массив неправильной длины!");
        }
        super(data, 4);
    }


    public Vector4D(float x, float y, float z, float w){
        float[] data = {x, y, z, w};
        super(data, 4);
    }


    @Override
    protected Vector4D createNew(float[] data) {
        return new Vector4D(data);
    }


    public float getZ(){
        return getDataByIndex(2);
    }


    public float getW(){
        return getDataByIndex(3);
    }
}
