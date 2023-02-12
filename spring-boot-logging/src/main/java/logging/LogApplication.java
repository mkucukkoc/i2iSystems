package logging;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LogApplication {
	private static Logger demoLogger= LogManager.getLogger(LogApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
        new LogApplication();

    }
    public LogApplication() {
	    Clock c = new Clock(); 
	    //DosyaSil();
	    MinuteTimer s = new MinuteTimer();
	    HourTimer b = new HourTimer(); 
	    //HourTimerLog slog=new HourTimerLog();
	    c.start(); 
	    s.start();
	    b.start();
	    //slog.start();
	  }
	  private static class MinuteTimer extends Thread {
	    public void run() {
	      while(true) {
	        try {
	        	//1 dakika sonra info verecek.
	          Thread.sleep(60000);
	          demoLogger.info("Info Calisti"); 
	        } catch(InterruptedException e) {
	          e.printStackTrace(); 
	        }
	      }
	    }
	  }
	  private static class HourTimer extends Thread {
		    
		    public void run() {
		      while(true) {
		        try {
		        	//
		          Thread.sleep(600000);
		        //1 saat sonra Error verecek.
		          demoLogger.error("Error Calisti");
		        } catch(InterruptedException e) {
		          e.printStackTrace(); 
		        }
		      }
		    }
		  }
	  private static class Clock extends Thread {
	    private int sn=0, dk=0, saat=0;
	    private void timeIncrement() {
	      sn++;
	      if(sn/60 > 0) {
	        dk += sn/60;
	        sn %=60;
	      }
	      if(dk/60 > 0) {
	        saat += dk/60;
	        dk %= 60; 
	      }
	    }
	    public void run() {
	      while(true) { 
	        try {
	        	//1 Saniye de bir ekranda debug logu fırlatacak.
	          Thread.sleep(1000); 
	          timeIncrement(); 
	          demoLogger.debug("Debug Calisti"); 
	        } catch (InterruptedException e) {
	          e.printStackTrace(); 
	        }
	      }
	    }
	    public String toString() {
	      String a = (saat/10 == 0) ? "0" + saat : ""+saat;
	      a += ":" + ((dk/10 == 0) ? "0" + dk : ""+dk);
	      a += ":" + ((sn/10 == 0) ? "0" + sn : ""+sn);
	      return a;
	    }
    } 
	  private static class HourTimerLog extends Thread {
		  String URL="logs/spring-boot-logging.log";
	    	File f = new File(URL);
		    public void run() {
		      while(true) {
		        try {
		        	//
		          Thread.sleep(60000);
		          f.delete();
		        //1 saat sonra Error verecek.
		          demoLogger.error("Error Calisti");
		        } catch(InterruptedException e) {
		          e.printStackTrace(); 
		        }
		      }
		    }
		  }
	  }
 
