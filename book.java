import java.util.*;
import java.io.*;

class Movie{
    int id;
    String title;
    int duration;
    double rating;
    String genre;

    Movie(int id, String title, int duration, double rating, String genre){
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
    }

    void displayInfo(){
        System.out.printf("|%-3d | %-19s |%-16d | %-10.2f | %-10s |\n",
            id,title,duration,rating,genre);
    }
}

class Show{
    int showID;
    Movie movie;
    String showtime;
    String showdate;
    HashMap<Integer, Boolean> seats = new HashMap<>();

    Show(int showID,String showtime, String showdate){
        this.showID = showID;
        this.showtime = showtime;
        this.showdate = showdate;

        for(int i=1;i<=30;i++){
            seats.put(i,false);
        }
    }
    void displayInfo(){
        System.out.printf("Show ID: %d | Movie: %s | Date: %s | Time: %s\n",
        showID, movie.title, showdate, showtime);
    }
}

class Bookings{
    static int id=100;
    String name;
    String mailID;
    Show show;
    ArrayList<Integer> seatsbooked;

    Bookings(String name,String mailID,ArrayList<Integer> seatsbooked ){
        this.name = name;
        this.mailID = mailID;
        this.seatsbooked = seatsbooked;
        id++;
    }

    String displayInfo(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nBooking ID: ").append(id).append("\n");
        sb.append("Booked by: ").append(name).append("\n");
        sb.append("Mail ID: ").append(mailID).append("\n");
        sb.append("Movie: ").append(show.movie.title).append("\n");
        sb.append("Show Date: ").append(show.showdate).append("\n");
        sb.append("Show Time: ").append(show.showtime).append("\n");
        sb.append("Seats Booked: ");

        for(int s:seatsbooked){
            sb.append(s).append(" ");

        }
        sb.append("\n");
        sb.append("Status: Confirmed ✅\n");


        return sb.toString();
    }

}

public class book {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> users = new HashMap<>();
        Movie[] movies = {
            new Movie(101, "The Revenant", 160, 9.4,"Survival"),
            new Movie(102, "The Social Network", 151, 7.8,"Drama"),
            new Movie(103, "IT: Chapter 1", 169, 8.9,"Horror"),
            new Movie(104, "Avatar:Fire and Ash", 192,8.8, "Sci-Fi"),
            new Movie(105, "The Evil Dead", 180,9.1, "Horror")
        };
        String email, username;
        
        System.out.println("============================================\n");
        System.out.println("        Welcome to Movie Ticket Booking     \n");
        System.out.println("============================================\n");

        while(true){
            System.out.print("Login | Sign Up | Remove Account | Exit\nChoose an option: ");
            String option = sc.nextLine();
            if(option.equalsIgnoreCase("login")){
                System.out.print("E-Mail ID: ");
                email = sc.nextLine();
                
                if(users.containsKey(email)){
                    System.out.print("Username: ");
                    username = sc.nextLine();
                    if(users.get(email).equals(username)){
                        System.out.printf("\nLogin Successful!\nWelcome, %s\n\n",users.get(email));
                        break;
                    }
                    else{
                        System.out.println("Incorrect Username!\n");
                    }
                }
                else{
                    System.out.println("Invalid Mail ID!\n");
                }
            }
            else if(option.equalsIgnoreCase("Sign Up")){
                System.out.print("E-Mail ID: ");
                email = sc.nextLine();
                System.out.print("Username: ");
                username = sc.nextLine();
                if(users.containsKey(email)){
                    System.out.println("Account already exists!\n");
                    continue;
                }

                users.put(email,username);
                System.out.println("\nAccount created Successfully ✅\nNow Login to continue.\n");

            }
            else if(option.equalsIgnoreCase("Remove Account")){
                System.out.print("Email ID: ");
                email = sc.nextLine();
                if(users.containsKey(email)){
                    users.remove(email);
                    System.out.println("Account removed Successfully ✅\n");
                }
                else System.out.println("No account found with this E-Mail ID. ❌\n");
            }
            else if(option.equalsIgnoreCase("Exit")){
                System.out.println("Exiting...👋");
                sc.close();
                return;
            }
            else {
                System.out.println("Invalid Option! ❌\n");
            }
        }



        System.out.println("+-----+---------------------+-----------------+------------+------------+");
        System.out.println("|  ID |        TITLE        |  DURATION(mins) |   RATING   |    GENRE   |");
        System.out.println("+-----+---------------------+-----------------+------------+------------+");

        for(Movie movie:movies){
            movie.displayInfo();
        }
        System.out.println("+-----+---------------------+-----------------+------------+------------+");
        
        String[] dates = {"29-10-2025","30-10-2025","31-10-2025","01-11-2025","02-11-2025"};
        String[] times = {"10:00 AM","1:30 PM","5:00 PM","8:30 PM"};
        ArrayList<Integer> bookedSeats = new ArrayList<>();
        Show show=null;
        while(true){
            System.out.print("Book Tickets | Exit\nChoose an Option: ");
            int ch = sc.nextInt();
            sc.nextLine();
            System.out.println("\n======================================\n");
            if(ch==2){
                System.out.println("Exiting...\nThank you 👋");
                break;
            }
            else if(ch==1){
                System.out.print("Enter Movie ID: ");
                int movieID = sc.nextInt();
                sc.nextLine();

                boolean found = false;
                int count=0;
                for(Movie movie:movies){
                    if(movieID==movie.id){
                        found = true;
                        count++;
                        System.out.printf("\nAvailable Shows for %s: |\n",movie.title);
                        for(String date:dates) System.out.printf("%s |",date);
                        System.out.println();
                        for(String time:times) System.out.printf("%s |",time);
                        System.out.println();
                        System.out.println("\n======================================\n");
                        System.out.print("Enter Date (DD-MM-YYYY): ");
                        String d = sc.nextLine().trim();


                        System.out.print("Enter Time (HH:MM AM/PM): ");
                        String t = sc.nextLine().trim().toUpperCase();
                        System.out.println("\n======================================\n");
                        boolean validD = false, validT = false;
                        for(String date:dates){
                            if(d.equals(date)){
                                validD=true;
                                break;
                            }
                        }
                        for(String time:times){
                            if(t.equals(time)){
                                validT= true;
                                break;
                            }
                        }

                        if(validD && validT){
                            show = new Show(count,t,d);
                            show.movie = movie;
                            show.displayInfo();
                            System.out.println();
                        }
                        else{
                            System.out.println("Invalid Date or Time!\n");
                            continue;
                        }

                        System.out.println("======================================\n");
                        String bhead = "BOOKING";
                        System.out.printf("%-12s\n\n",bhead);
                        System.out.println("======================================\n");

                        while(true){
                            System.out.println("How many Seats you want to book?: ");
                            int seatstobook = sc.nextInt();
                            sc.nextLine();
                            if(seatstobook>10) System.out.println("Cannot book more than 10 seats at a time!\n\n");
                            else{
                                System.out.println("Available Seats:");
                                for(int i=1;i<=30;i++){
                                    if(!show.seats.get(i)){
                                        System.out.printf("%d ",i);
                                    }
                                }
                                System.out.println("\n");
                                for(int i=1;i<=seatstobook;i++){
                                    System.out.print("Enter Seat Number: ");
                                    int seatNo = sc.nextInt();
                                    sc.nextLine();
                                    if(seatNo<1 || seatNo>30){
                                        System.out.println("Invalid Seat Number!\n");
                                        i--;
                                    }
                                    else if(show.seats.get(seatNo)){
                                        System.out.println("Seat already booked! Choose another seat.\n");
                                        i--;
                                    }
                                    else{
                                        show.seats.put(seatNo,true);
                                        bookedSeats.add(seatNo);
                                    }
                                    if(bookedSeats.size()==seatstobook){
                                        
                                        Bookings bookings = new Bookings(username,email,bookedSeats);
                                        bookings.show=show;

                                        try(FileWriter writer = new FileWriter("C:\\Users\\Admin\\OneDrive\\Desktop\\ticket-booking.txt")){
                                            writer.write("==============================================\n\n");
                                            writer.write("        Movie Ticket Booking     \n\n");
                                            writer.write("==============================================\n");
                                            writer.write("\n      Booking Confirmed!     \n");
                                            writer.write("==============================================\n");
                                            writer.write(bookings.displayInfo());
                                        }
                                        catch(Exception e){
                                            System.out.println("Error generating ticket PDF: "+e.getMessage());
                                        }
                                        finally{
                                            System.out.println("\nTicket details has been saved to ticket-booking.txt\nThank you for booking with us!\n");
                                        }

                                        bookings.displayInfo();
                                        bookedSeats.clear();
                                        System.out.println("\n==============================\n");
                                    }
                                }
                            }
                            break;
                        }
                    }
                    
                }
                if(!found){
                    System.out.println("Invalid Movie ID!\n");
                    continue;
                }
            }
            
        }
        sc.close();
    }

}

