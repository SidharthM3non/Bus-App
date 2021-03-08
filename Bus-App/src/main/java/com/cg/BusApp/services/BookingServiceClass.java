package com.cg.BusApp.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BusApp.entities.Booking;
import com.cg.BusApp.entities.Feedback;
import com.cg.BusApp.exceptions.BookingNotFoundException;
import com.cg.BusApp.exceptions.UserAlreadyExistsException;
import com.cg.BusApp.repositories.FeedbackRepository;
import com.cg.BusApp.repositories.IBookingRepository;
import com.cg.BusApp.repositories.IBusOperatorRepository;
import com.cg.BusApp.repositories.IUserRepository;

@Service
public class BookingServiceClass implements IBookingService{
	
	@Autowired
	IBookingRepository bookingRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	IBusOperatorRepository busOperatorRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	//private Feedback f = null;
	
	//Feedback feedback;
	
	//addBooking(Booking):long
	@Override
	public long addBooking(Booking booking) {
		Booking b1 = bookingRepository.findByUsername(booking.getUsername());
		if(b1 == null) {
			bookingRepository.save(booking);
		} else {
			throw new UserAlreadyExistsException("User already exist");
		}
		return booking.getBookingId();
	}
	
	//updateBookingDate(long):boolean
//	public boolean updateBookingDate (Booking b) {
//		boolean result = false;
//		Booking b1 =null;
//		Optional<Booking> booking = bookingRepository.findById(b.getId());
//		if(booking.isPresent()) {
//			b1 = booking.get();
//			b1.setDate(b.getDate());
//			result = true;
//		} else {
//			throw new BookingNotFoundException("booking doesn't exist!!!");
//		}
//		return result;
//	}
	
	@Override
	public boolean updateBookingDate(long bookingId) {
		boolean result = false;
		Optional<Booking> b = bookingRepository.findByBookingId(bookingId);
		Booking b1 = null;
		if(b.isPresent()) {
			b1 = b.get();
			b1.setDate(LocalDate.now());
			result = true;
		}
		return result;
	}
	
	//deleteBooking(long):boolean
	@Override
	public boolean deleteBooking (long bookingid) {
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
		Booking b = null;
		boolean result = false;
		if (booking.isPresent()) {
			b=booking.get();
			bookingRepository.delete(b);
			result = true;
		} else {
			throw new BookingNotFoundException("booking doesn't exist!!!");
		}
		return result;
	}
	
	//getBookingDetailsById(long):Booking
	@Override
	public Booking getBookingDetailsById(long bookingid) {
		Booking b = null;
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
		if (booking.isPresent()) {
			b= booking.get();
		}
		return b;
	}
	
	//getAllBookingByDate(LocalDate):List<Booking>
	@Override
	public List<Booking> getAllBookingByDate(LocalDate date){
		List<Booking> booking = bookingRepository.findByDate(date);
		return booking;
	}

	//getAllBookingByBusRoute(String):List<Booking>
	@Override
	public List<Booking> getAllBookingByBusRoute(String routeName){
		List<Booking> booking = bookingRepository.findByBusRouteRouteName(routeName);
		return booking;
	}
	
	//getFeedbackByBusRoute(String):List<Booking>
	@Override
	public List<Feedback> getFeedbackByBusRoute(String routeName){
		List<Feedback> feedback = feedbackRepository.findByBusRouteRouteName(routeName);
		return feedback;
	}
	
	//own method to find all booking
	@Override
	public List<Booking> findAllBookings(){
		List<Booking> booking = bookingRepository.findAll();
		if (booking.isEmpty()) {
			throw new BookingNotFoundException("bookings does not exist!!!");
		}
		return booking;
	}
	
	public void addFeedback(String username, long bookingId, String comment) {
		Booking b = null;
		Feedback f = null;
		Feedback f1 = new Feedback();
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingId);
		if(booking.isPresent()) {
			b = booking.get();
		}
		else {
			throw new BookingNotFoundException("Booking does not exist");
		}
		Optional<Feedback> feedback = feedbackRepository.findByUsername(username);
		if(feedback.isPresent()) {
			f = feedback.get();
		}
		else {
			throw new RuntimeException("Feedback does not exist");
		}
		f1.setComment(comment);
		f1.setRouteName(f.getRouteName());
		f1.setUsername(f.getUsername());
		feedbackRepository.save(f1);
		
	}
//		feedbackRepository.save(f);
////		Feedback feedback = null;
////		feedback.setUsername(username);
////		feedback.setComment(comment);
////		feedbackRepository.save(feedback);
//		
//	}
	
	
	
	
	
	
	
	//addFeedback(User,Long):void
//	public void addFeedback(User user,long bookingId) {
//		Optional<Booking> booking = bookingRepository.findByBookingId(bookingId);
//		Booking b = null;
//		if(booking.isPresent()) {
//			b = booking.get();
//		} else {
//			throw new BookingNotFoundException("Booking not found");
//		}
//		
//		User user1 = userRepository.findByUsername(user.getUsername());
//		User u = null;
//		if(user1 != null) {
//			u = user1;
//		} else {
//			throw new UserNotFoundException("User not found!!!");
//		}
//		
//		newFeedback.setRouteName(b.getBusRoute().getRouteName());
//		newFeedback.setUsername(u.getUsername());
//		newFeedback.setUser(u);
//		feedbackRepository.save(newFeedback);
// 	}
//	
//	//addFeedback(String,long,String):void
//	public void addFeedback(String username, long bookingid, String comment) {
//	Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
//	Feedback feedback = null; 
//	Booking b = null;
//	if(booking.isPresent()) {
//		b = booking.get();
//	}
//	feedback.setComment(comment);
//	feedback.setUsername(username);
//	feedback.setUser(u);
//	feedbackRepository.save(feedback);
//
//	}
	
	
	
//	List<Feedback> f = feedbackRepository.findByUserUsername(username);
//	for (Feedback f1 : f) {
//		if(f1.getComment() == comment) {
//			f1.setRouteName(b.getBusRoute().getRouteName());
//			f1.setComment(comment);
//			f1.setUsername(username);
//			f1.setUser(u);
//			feedbackRepository.save(f1);
//		} else {
//			throw new UserNotFoundException("feedback already exist");
//		}
//	}
	
	//getAllBookingsById(String):List<Booking> 3 methods 
//	//busNumber
//	public List<Booking> getAllBookingByBusNumber(String s) {
//		List<Booking> booking = bookingRepository.findByBusNumber(s);
//		if(booking.isEmpty()) {
//			throw new BookingNotFoundException("bookings not found!!!");
//		}
//		return booking;
//	}
//	
//	//source
//	public List<Booking> getAllBookingBySource(String s){
//		List<Booking> booking = bookingRepository.findBySource(s);
//		if(booking.isEmpty()) {
//			throw new BookingNotFoundException("bookings not found!!!");
//		}
//		return booking;
//	}
//	
//	//destination
//	public List<Booking> getAllBookingByDestination(String s){
//		List<Booking> booking = bookingRepository.findByDestination(s);
//		if(booking.isEmpty()) {
//			throw new BookingNotFoundException("bookings not found!!!");
//		}
//		return booking;
//	}
	
	
}
