import java.util.Scanner;

interface Series {
    int getNext();    
    void reset(); 
    void setStart(int x);
}
class ByTwos implements Series {
	int start;
	int current;
	
	ByTwos(){
		start = 0;
		current = 0;
	}
	@Override
	public int getNext() {
		current+=2;
		return current;
	}

	@Override
	public void reset() {
		current=start;
	}

	@Override
	public void setStart(int x) {		
		start = x;
		current = x;
	}
	
}

public class SeriesDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Series series = new ByTwos();  
		while(true) {
	        System.out.println("1. Generate Next");
	        System.out.println("2. Reset Series");
	        System.out.println("3. Set a Starting Point");
	        System.out.println("4. Exit");
	        int choice = sc.nextInt();
	        switch(choice) {
	        	case 1:
	        		System.out.println("Next in Series is " + series.getNext());
	        		break;
	        
        		case 2:
        			series.reset();
        			System.out.println("Series Resetted");
        			break;
        	    case 3:
        	    	System.out.println("Enter Start");
        	    	int start = sc.nextInt();
		        	series.setStart(start);
		        	System.out.println("Series Started from "+start);
		        	break;
       	        case 4:
       	        	System.exit(0);
       	        	sc.close();
		        	break;
		        default:
		        	System.out.println("Input Valid Choice");
	        }
		}
	}
}
