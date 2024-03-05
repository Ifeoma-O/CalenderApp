import java.util.Scanner;

public class CalenderApp {

        /** Main method */
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            // Prompt the user to enter year
            System.out.print("Enter full year (e.g., 2012): ");
            int year = input.nextInt();
            // Prompt the user to enter month
            System.out.print("Enter month as a number between 1 and 12: ");
            int month = input.nextInt();
            // Print calendar for the month of the year
            printMonth(year, month);
        }
        public static void printMonth(int year, int month){
            printMonthTitle(year, month);

            printMonthBody(year, month);
        }
        public static void printMonthTitle(int year, int month){
            System.out.println("        " + getMonthName(month) + " " + year);
            System.out.println("---------------------------");
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        }

        public static String getMonthName(int month) {

            String monthName = switch (month) {
                case 1 -> "January";
                case 2 -> "February";
                case 3 -> "March";
                case 4 -> "April";
                case 5 -> "May";
                case 6 -> "June";
                case 7 -> "July";
                case 8 -> "August";
                case 9 -> "September";
                case 10 -> "October";
                case 11 -> "November";
                case 12 -> "December";
                default -> "";
            };
            return monthName;
        }

        public static void printMonthBody(int year, int month){
            int startDay = getStartDay(year,month);
            int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

            int i = 0;
            for (i = 0; i < startDay; i++){
                System.out.print("    ");
            }

            for (i = 1; i <= numberOfDaysInMonth; i++){
                System.out.printf("%4d", i);
                if ((i + startDay) % 7 == 0){
                    System.out.println();
                }
            }
            System.out.println();
        }

        public static int getStartDay(int year, int month) {

            final int START_DAY_FOR_JAN_1_1800 =3;
            int totalNumberOfDays = getTotalNumberOfDays(year,month);

            return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
        }
        public static int getTotalNumberOfDays(int year, int month) {
            final int BASE_YEAR = 1800;
            final int DAYS_IN_YEAR = 365;
            final int DAYS_IN_LEAP_YEAR = 366;

            //NUMBER OF DATS BETWEEN 1800 AND THE GIVEN YEAR
            int totalDays = 0;
            for (int i = BASE_YEAR; i < year; i++){
                if (isLeapYear(i)){
                    totalDays += DAYS_IN_LEAP_YEAR;
                }
                else {
                    totalDays += DAYS_IN_YEAR;
                }
            }

            for (int i = 1; i < month; i++){
                totalDays += getNumberOfDaysInMonth(year, i);
            }
            return totalDays;
        }
        public static int getNumberOfDaysInMonth(int year, int month) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                return 31;

            if (month == 4 || month == 6 || month == 9 || month == 11)
                return 30;

            if (month == 2) return isLeapYear(year) ?  29 : 28;

            return 0;
        }
        public static Boolean isLeapYear(int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }
}

