package ru.vsu.fkn.isit.cg.math.LinearAlgebra;

public class Vector2D extends Vector<Vector2D>{
    public Vector2D(float [] data){
        if (data.length != 2){
            throw new IllegalArgumentException("Вы пытаетесь создать вектор 2-ой размерности, но передаете массив неправильной длины!");
        }
        super(data, 2);
    }


    public Vector2D(float x, float y){
        float[] data = {x, y};
        super(data, 2);
    }


    @Override
    protected Vector2D createNew(float[] data) {
        return new Vector2D(data);
    }
}
