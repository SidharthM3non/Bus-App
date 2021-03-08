package com.cg.BusApp.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.BusApp.entities.Booking;
import com.cg.BusApp.entities.Feedback;

public interface IBookingService {
	
	public long addBooking(Booking booking);
	
	public boolean updateBookingDate(long bookingId);
	
	public boolean deleteBooking (long bookingid);
	
	public Booking getBookingDetailsById(long bookingid);
	
	public List<Booking> getAllBookingByDate(LocalDate date);
	
	public List<Booking> getAllBookingByBusRoute(String routeName);
	
	public List<Feedback> getFeedbackByBusRoute(String routeName);
	
	public List<Booking> findAllBookings();
	
	public void addFeedback(String username, long bookingId, String comment);
	
}
