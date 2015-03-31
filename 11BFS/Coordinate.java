public class Coordinate{
    int x,y,current;

    public Coordinate(int xcoor, int ycoor, int curr){
	x = xcoor;
	y = ycoor;
	current = curr;
    }

    public int getCurrent(){
	return current;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setCurrent(int curr){
	current = curr;
    }

    public void setX(int xcoor){
	x = xcoor;
    }

    public void setY(int ycoor){
	y = ycoor;
    }

}
