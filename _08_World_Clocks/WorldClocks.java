package _08_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone;

    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    JPanel masterPanel;
    
    String city;
    String dateStr;
    String timeStr;
    
    HashMap <String ,TimeZone> togtime = new HashMap <String ,TimeZone>();
    
    public WorldClocks() {
        clockUtil = new ClockUtilities();

        // The format for the city must be: city, country (all caps)
        String usercity = JOptionPane.showInputDialog("Enter a city: ");
        String usercountry = JOptionPane.showInputDialog("Enter the country(2 digit country code): ");
        usercity = usercity + ", " + usercountry;
        timeZone = clockUtil.getTimeZoneFromCityName(usercity);
        togtime.put(usercity, timeZone);
        
        city = "Chicago, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        togtime.put(city, timeZone);
        
        city = "San Diego, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        togtime.put(city, timeZone);
        
        city = "New York, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        togtime.put(city, timeZone);
        
        city = "Florida, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        togtime.put(city, timeZone);
        
        city = "Houston, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        togtime.put(city, timeZone);
        
        Calendar calendar = Calendar.getInstance(timeZone);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        
        System.out.println(dateStr);

        // Sample starter program
        frame = new JFrame();
        masterPanel = new JPanel();
        frame.add(masterPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(100, 100);
        for (String city: togtime.keySet()) {
        	panel = new JPanel();
        	textArea = new JTextArea();
            panel.add(textArea);
			textArea.setText(city + "\n" + togtime.get(city));
			masterPanel.add(panel);
		}
        
        
        // This Timer object is set to call the actionPerformed() method every
        // 1000 milliseconds
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
        System.out.println(timeStr);
        masterPanel.removeAll();
        for (String city: togtime.keySet()) {
        	panel = new JPanel();
        	textArea = new JTextArea();
            panel.add(textArea);
            c = Calendar.getInstance(togtime.get(city));
            String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            String dayOfWeek = c.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
            dateStr = dayOfWeek + " " + month + " " + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR);
            militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
            twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
            timeStr = militaryTime + twelveHourTime;
            textArea.setText(city + "\n" + dateStr + "\n" + timeStr);
            masterPanel.add(panel);
		}
        frame.pack();
    }
}
