1. Create User
2. Add Show 
3. Booking
   - Implement Isolation in spring boot for BMS
- Feature:
  - Person wants to book a ticket for a show

- TicketController {
  - bookTicket(
    - show_id
    - list<show_seat_id>
    - user_id
  - )
- }

- TicketService { 
  - bookTicket(
    - show_id  
    - list<show_seat_id>
    - user_id
  - )
- }

- How will bookTicket() in TicketService work?

- update show_seats
set status = LOCKED
where show_seat_id in ()
- // City // Theatre // Auditorium // Seat // Show