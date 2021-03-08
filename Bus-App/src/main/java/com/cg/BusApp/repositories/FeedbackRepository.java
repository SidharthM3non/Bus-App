package com.cg.BusApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BusApp.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

	Feedback findByUserBookingBookingId(long bookingId);

	List<Feedback> findByBusRouteRouteName(String routeName);

	Optional<Feedback> findByUsername(String username);

}
