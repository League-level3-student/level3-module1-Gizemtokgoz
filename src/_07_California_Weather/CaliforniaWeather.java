package _07_California_Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather {

	void start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        
        String cityName = JOptionPane.showInputDialog("Enter a city in San Diego: ");
        WeatherData datum = weatherData.get(cityName);
        HashMap<String, ArrayList<String>> weather = weather.get(cityName);
		HashMap<String, ArrayList<Integer>> temp = person2.getSchedule();
        String wCondition = JOptionPane.showInputDialog("Specify your weather conditions: ");
        for () {
        	if (weatherData.containsValue(wCondition)) {
        		
    		}
		}
        
        // All city keys have the first letter capitalized of each word 
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
    }
}
