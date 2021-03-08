package com.cg.BusApp.services;

import java.time.LocalDate;

import com.cg.BusApp.entities.Bus;
import com.cg.BusApp.entities.BusOperator;

public interface IBusOperatorService {
	
	//Service methods to be implemented by Service Implementation Class
	
	public void addBus(Bus b);
	
	public int getRevenueByBusRoute(String routeName);
	
	public int getRevenueByBusRouteAndDate(String routeName, LocalDate date);
	
	public int getMonthlyRevenueByBusRoute(String routeName, String month);
	
	public int getYearlyRevenueByBusRoute(String routeName, String year);
	
	public void addBusOperator(BusOperator busOp);
	
	public void updatePassword(String oldPassword, String newPassword);

}
