package labs.pm.demos;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


public class Week {
   private int weeknr;
   private int year;
   public Week(int weeknr, int year) {
      this.weeknr = weeknr;
      this.year = year;
   }
   public Iterator getDays() {
      return new DayIterator(this);
   }
   public int getWeeknr() {
      return weeknr;
   }
   public int getYear() {
      return year;
   }
   public static class DayIterator implements Iterator {
      private int index = 0;
      private Calendar cal = null;

      DayIterator (Week aWeek) {
         cal = new GregorianCalendar();
         cal.clear();
         cal.set(Calendar.YEAR, aWeek.getYear());
         cal.set(Calendar.WEEK_OF_YEAR, aWeek.getWeeknr());
      }
      public boolean hasNext() {
         return index < 7;
      }
      public Object next() {
         cal.set(Calendar.DAY_OF_WEEK, index++);
         return cal.getTime();
      }
      public void remove() {
         // not implemented
      }
   }

   public static void main(String[] args) {
   // list the days of the week
   if (args.length < 2) {
      System.err.println("Usage: java Week <weeknr> year>");
      System.exit(1);
   } else {
      try {
        int weeknr = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        Week wk = new Week(weeknr, year);
        for (Iterator i=wk.getDays();i.hasNext();) {
          System.err.println(i.next());
        }
      } catch (NumberFormatException x) {
        System.err.println("Illegal week or year");
      }
   }
   }
}