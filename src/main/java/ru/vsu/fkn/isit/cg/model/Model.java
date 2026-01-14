package ru.vsu.fkn.isit.cg.model;

import ru.vsu.fkn.isit.cg.math.LinearAlgebra.Vector2D;
import ru.vsu.fkn.isit.cg.math.LinearAlgebra.Vector3D;

import java.util.ArrayList;

public class Model {
        public ArrayList<Vector3D> vertices = new ArrayList<>();
        public ArrayList<Vector2D> textureVertices = new ArrayList<>();
        public ArrayList<Vector3D> normals = new ArrayList<>();
        public ArrayList<Polygon> polygons = new ArrayList<>();

    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }

    public ArrayList<Vector2D> getTextureVertices() {
        return textureVertices;
    }

    public ArrayList<Vector3D> getNormals() {
        return normals;
    }

    public ArrayList<Vector3D> getVertices() {
        return vertices;
    }

    public void setNormals(ArrayList<Vector3D> normals) {
        this.normals = normals;
    }

    public void setPolygons(ArrayList<Polygon> polygons) {
        this.polygons = polygons;
    }

    public void setTextureVertices(ArrayList<Vector2D> textureVertices) {
        this.textureVertices = textureVertices;
    }

    public void setVertices(ArrayList<Vector3D> vertices) {
        this.vertices = vertices;
    }
}
