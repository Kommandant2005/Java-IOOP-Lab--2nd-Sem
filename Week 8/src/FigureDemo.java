abstract class Figure{
	int x,y;
	Figure(int x,int y){
		this.x = x;
		this.y = y;
	}
	abstract double area();
}
class Rectangle extends Figure{

	Rectangle(int width, int height) {
		super(width,height);
	}

	@Override
	double area() {
		return x*y;
	}
	
}
class Triangle extends Figure{

	Triangle(int base, int height) {
		super(base, height);
	}

	@Override
	double area() {
		return 0.5*x*y;
	}
	
}
class Square extends Figure{

	Square(int side) {
		super(side,side);
	}

	@Override
	double area() {
		return x*x;
	}
}
public class FigureDemo {

	public static void main(String[] args) {
		Figure shape1 = new Rectangle(10,5);
		Figure shape2 = new Triangle(3,2);
		Figure shape3 = new Square(5);
	    System.out.println("Rectangle Area: " + shape1.area());
	    System.out.println("Triangle Area: " + shape2.area());
	    System.out.println("Square Area: " + shape3.area());
	}
}
