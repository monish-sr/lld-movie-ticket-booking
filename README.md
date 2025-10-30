# Movie Ticket Booking System in Java
A console-based LLD (Low Level Design) where users can Sign Up, Login, View Movies, and Book Seats for available shows. Features include account management, seat availability tracking using HashMap, and booking confirmation with details. Simple, interactive, and real-world inspired!

## Project Overview
The Movie Ticket Booking System is a Java console-based application designed to simulate the real-world process of booking movie tickets. It allows users to sign up, log in, view available movies, select a show (date & time), and book seats with real-time seat availability management. This project showcases Object-Oriented Programming (OOP) concepts such as classes, objects, composition, static members, encapsulation, and data handling using HashMaps and ArrayLists.

## Execution Plan
### 1. Modules / Components

**(a) Movie Class** – Holds movie details like ID, title, duration, rating, and genre.

**(b)Show Class** – Represents individual movie shows with specific date and time. Manages seat availability using a HashMap<Integer, Boolean>.

**(c)Bookings Class** – Stores booking information including user details, booked seats, and show data. Uses a static booking ID counter.

**(d)Main Class (book) – Handles:**

  • User registration (Sign Up)

  • Login validation

  • Displaying movie listings

  • Booking tickets

  • Removing accounts

### 2. Workflow
**(a) User Authentication:**

  • User can Sign Up, Login, or Remove Account.

  • HashMap<String, String> stores email–username pairs.

**(b) Movie Selection:**

  • Once logged in, users see a formatted movie list (with ID, rating, genre, etc.).

**(c) Show Selection:**

  • User selects a movie ID, then chooses a date and showtime from available options.

**(d) Seat Booking:**

  • The system displays all available seats (1–30).

  • User selects how many seats to book (max 10 per transaction).

  • Seats are updated in a HashMap to prevent double booking.

**(e) Booking Confirmation:**
  • Generates a unique Booking ID.

  • Displays all details (movie name, show date/time, seats, and status ✅).

## Result
**After execution, the program successfully allows:**

  • Secure user login and management.

  • Viewing multiple movies in a tabular format.

  • Dynamic show and seat booking.

  • Real-time seat update (booked vs. available).

  • Display of confirmed booking details with a unique booking ID.
