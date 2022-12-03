import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int input_type;
        int min, hour, day, month, year;
        Scanner scan = new Scanner(System.in);
        

        System.out.println("Vehicle Type\n[1] Motorcycle\n[2] Cars and SUVs's\n[3] Trucks and Buses\n");
        System.out.print("Input: ");
        input_type = scan.nextInt();

        System.out.println("Date Parked: ");
        System.out.print("Min: "); min = scan.nextInt();
        System.out.print("Hour: "); hour = scan.nextInt();
        System.out.print("Day: "); day = scan.nextInt();
        System.out.print("Month: "); month = scan.nextInt();
        System.out.print("Year: "); year = scan.nextInt();
        Date parked_date = new Date();
        parked_date.set(hour, min, day, month, year);

        System.out.println("Date Exited: ");
        System.out.print("Min: "); min = scan.nextInt();
        System.out.print("Hour: "); hour = scan.nextInt();
        System.out.print("Day: "); day = scan.nextInt();
        System.out.print("Month: "); month = scan.nextInt();
        System.out.print("Year: "); year = scan.nextInt();
        Date exited_date = new Date();
        exited_date.set(hour, min, day, month, year);

        double totalHours = parked_date.getDifference(exited_date);
        double amount = 0;

        switch(input_type) {
            case 1:
                amount = totalHours * 15.00;
                break;
            case 2:
                amount = totalHours * 35.00;
                break;
            case 3:
                amount = totalHours * 40.00;
                break;
        }
        
        System.out.println("LCB Parking System");
        System.out.printf("Vehicle Type: %d%n", input_type);
        System.out.printf("Parking Date: %d-%d-%d Time: %d:%d%n", parked_date.current_year, parked_date.current_month, parked_date.current_day, parked_date.current_hour, parked_date.current_min);
        System.out.printf("Exited Date: %d-%d-%d Time: %d:%d%n", exited_date.current_year, exited_date.current_month, exited_date.current_day, exited_date.current_hour, exited_date.current_min);
        System.out.printf("Total Parking Hours: %.2fHours%n", totalHours);
        System.out.printf("Parking Fee: PHP%.2f%n", amount);

    }

    
}

class Date {
    double hour = 0;
    int zday = 0;

    public int current_min;
    public int current_hour;
    public int current_day;
    public int current_month;
    public int current_year;

    public void set(int hour, int min,int day, int month, int year) {
        current_min = min;
        current_hour = hour;
        current_day = day;
        current_month = month;
        current_year = year;

        this.zday += day;

        //month
        for(int i = 1; i < month; i++) {
            
            switch(i) {
                case 2:
                    if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        this.zday += 29;
                    }
                    else {
                        this.zday += 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    this.zday += 30;
                    break;
                default:
                    this.zday += 31;
                    break;
            }
        }

        //year check
        for(int i = 1900; i <= year; i++) {
            if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.zday += 366;
            } else {
                this.zday += 365;
            }
        }

        this.hour += zday * 24;
        this.hour += hour;
        this.hour += min / 60;
    }

    public double getDifference(Date yDate) {

        return yDate.hour - this.hour;
    }
}