package week5;
import java.util.*;
class Weather{
	static class ForeCast{
		double temperature;
		double humidity;		
		ForeCast(double temperature,double humidity) {
			this.temperature = temperature;
			this.humidity = humidity;
		}
		void predictWeather() {
			if(temperature>40 & humidity<25) {
				 System.out.println("Dry Weather");	
			}
			else if(temperature>35 & humidity>25) {
				 System.out.println("Cloudy Weather");	
			}
			else if(temperature>30 & humidity>50) {
				 System.out.println("Rainy Weather");	
			}
			else {
				System.out.println("Cold Weather");
			}
		}

	}
}

public class Prediction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Temperature");
		double temperature = sc.nextDouble();
		System.out.println("Enter Humidity");
		double humidity = sc.nextDouble();
		Weather.ForeCast temp_forecast = new Weather.ForeCast(temperature, humidity);
		temp_forecast.predictWeather();
	}
}
