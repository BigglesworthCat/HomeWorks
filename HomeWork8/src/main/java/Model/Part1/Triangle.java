package Model.Part1;

import Controller.TriangleException;

public class Triangle extends Shape{
    private Point verticeA;
    private Point verticeB;
    private Point verticeC;

    public Triangle(Point verticeA, Point verticeB, Point verticeC) throws TriangleException {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.verticeC = verticeC;

        if(!exists())
        {
            throw new TriangleException();
        }
    }

    //Return true is triangle exists (by triangle condition)
    private boolean exists() {
        return (getAB() < getBC() + getAC()) && (getBC() < getAB() + getAC()) && (getAC() < getAB() + getBC());
    }

    public Point getVerticeA() {
        return verticeA;
    }

    public Point getVerticeB() {
        return verticeB;
    }

    public Point getVerticeC() {
        return verticeC;
    }

    public double getAB() {
        return Math.sqrt(Math.pow(verticeA.getX() - verticeB.getX(), 2) + Math.pow(verticeA.getY() - verticeB.getY(), 2));
    }

    public double getBC() {
        return Math.sqrt(Math.pow(verticeB.getX() - verticeC.getX(), 2) + Math.pow(verticeB.getY() - verticeC.getY(), 2));
    }

    public double getAC() {
        return Math.sqrt(Math.pow(verticeA.getX() - verticeC.getX(), 2) + Math.pow(verticeA.getY() - verticeC.getY(), 2));
    }

    public void setVerticeA(Point verticeA) throws TriangleException {
        this.verticeA = verticeA;

        if(!exists())
        {
            throw new TriangleException();
        }

    }

    public void setVerticeB(Point verticeB) throws TriangleException {
        this.verticeB = verticeB;

        if(!exists())
        {
            throw new TriangleException();
        }
    }

    public void setVerticeC(Point verticeC) throws TriangleException {
        this.verticeC = verticeC;

        if(!exists())
        {
            throw new TriangleException();
        }
    }

    @Override
    public double square() {
        double p = perimeter() /2; //Half of the perimeter
        return Math.sqrt(p * (p - getAB()) * (p - getBC()) * (p - getAC())); //Using Gero's formula
    }

    @Override
    public double perimeter() {
        return getAB() + getBC() + getAC();
    }

    @Override
    public void move(double dx, double dy) {
        verticeA.setX( verticeA.getX() + dx);
        verticeA.setY( verticeA.getY() + dy);

        verticeB.setX( verticeB.getX() + dx);
        verticeB.setY( verticeB.getY() + dy);

        verticeC.setX( verticeC.getX() + dx);
        verticeC.setY( verticeC.getY() + dy);
    }

    @Override
    public String toString() {
        return "Triangle {" + "vertice A=" + verticeA + ", vertice B=" + verticeB + ", vertice C=" + verticeC + super.toString() + '}';
    }
}
