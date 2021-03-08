package com.cg.BusApp.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BusApp.entities.Bus;
import com.cg.BusApp.entities.BusOperator;

public interface IBusOperatorRepository extends JpaRepository<BusOperator, Integer>{
	
	//Repository methods to be used for fetching data
	
	//public void addBus(Bus b);
	
	//public int getRevenueByBusRoute(String routeName);
	
	//public int getRevenueByBusRouteAndDate(String routeName, LocalDate date);
	
	//public int getMonthlyRevenueByBusRoute(String routeName, String month);
	
	//public int getYearlyRevenueByBusRoute(String routeName, String year);
	
	//public void addBusOperator(BusOperator busOp);
	
	//public void updatePassword(String oldPassword, String newPassword);
	
	BusOperator findByBusOperatorUsername(String busOperatorUsername);

	BusOperator findByPassword(String oldPassword);

}
