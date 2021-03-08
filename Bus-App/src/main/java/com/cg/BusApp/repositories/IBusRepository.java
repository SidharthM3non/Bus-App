package com.cg.BusApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BusApp.entities.Bus;

public interface IBusRepository extends JpaRepository<Bus, Integer>{
	
	//Repository methods to be used for fetching data
	
	Bus findByBusNumber(String busNumber);

}
