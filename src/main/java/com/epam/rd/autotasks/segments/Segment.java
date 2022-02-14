package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private final double endX;
    private final double startX;
    private final double endY;
    private final double startY;

    public Segment(Point start, Point end) {
        this.startX = start.getX();
        this.endX = end.getX();
        this.startY = start.getY();
        this.endY = end.getY();
        if (startX == endX && startY == endY) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        double length = Math.sqrt(Math.pow((endX - startX), 2) + Math.pow((endY - startY), 2));
        if (length != 0) {
            return length;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

     Point middle() {
         return new Point((startX + endX)/2, (startY + endY)/2);
    }

    Point intersection(Segment another) {
        double d = ((this.startX-this.endX) * (another.startY-another.endY) - (this.startY-this.endY) * (another.startX-another.endX));
        double v = another.startX * another.endY - another.startY * another.endX;
        double w = this.startX*this.endY-this.startY*this.endX;
        double intersX = (w * (another.startX-another.endX) - (this.startX-this.endX) * v) / d;
        double intersY = (w * (another.startY-another.endY) - (this.startY-this.endY) * v) / d;
        if((Math.min(this.startX, this.endX)) <= intersX && intersX <= (Math.max(this.startX, this.endX))
                && (Math.min(another.startX,another.endX)) <= intersX && intersX<= (Math.max(another.startX,another.endX))) {
            return new Point(intersX, intersY);
        }
        else{ return null;}
    }

}
