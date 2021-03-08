package com.cg.BusApp.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BusApp.entities.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Integer> {
	
	//Repository methods to be used for fetching data
	
	List<Booking> findByBusRouteRouteName(String routeName);
	
	List<Booking> findByBusRouteRouteNameAndDate(String routeName, LocalDate date);

	Booking findByUsername(String username);

	Optional<Booking> findByBookingId(long bookingId);

	List<Booking> findByDate(LocalDate date);

}
