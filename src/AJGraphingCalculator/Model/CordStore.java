package AJGraphingCalculator.Model;

import java.util.ArrayList;

public class CordStore {

    ArrayList<AJGraphingCalculator.Model.Point> Cords = new ArrayList<AJGraphingCalculator.Model.Point>();
    int totalCords;




    private Point Cordinates;

    private int nextY;
    private int previousY;

    private int xCord;
    private int yCord;
    private int width = 1;
    private int height;




    public void setCords(ArrayList<AJGraphingCalculator.Model.Point> Cords) {
        this.Cords = Cords;
    }


    public void setTotalCords(int totalCords) {
        this.totalCords = totalCords;
    }

    public void setCurrentCordinate(int n) {
        this.Cordinates = Cords.get(n);
    }


    public int calculateX() {
        return (int) (250+this.Cordinates.x);
    }

    public int calculateY() {
        return (int) (250+(-1*this.Cordinates.y));
    }


    public int calculateHeight(int n)
    {


        this.Cordinates = Cords.get(n);

        try
        {
            this.nextY = (int) Cords.get(n + 1).y;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.nextY = 0;
        }

        try
        {
            this.previousY = (int) Cords.get(n - 1).y;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.previousY = 0;
        }


        return nextY-previousY;

    }

}

/*
public void setCords(ArrayList<Point> Cords) {
        this.Cords = Cords;
    }

    public void setTotalCords(int totalCords) {
        this.totalCords = totalCords;
    }
 */