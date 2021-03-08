package com.cg.BusApp.testcases;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.BusApp.entities.Bus;
import com.cg.BusApp.services.BusOperatorServiceClass;

@SpringBootTest
class TestBusOperator {
		
	@Autowired 
	BusOperatorServiceClass busOperatorServiceClass;
	
	@Test
	void addBus() {
		Bus b = new Bus("1111", 21, 10);
		busOperatorServiceClass.addBus(b);
	}
	
	@Test
	void getRevenueByBusRoute() {
		String routeName = "AtoB";
		busOperatorServiceClass.getRevenueByBusRoute(routeName);
	}
	
	@Test
	void getRevenueByBusRouteAndDate() {
		String routeName = "AtoB";
		LocalDate date = LocalDate.now();
		busOperatorServiceClass.getRevenueByBusRouteAndDate(routeName, date);
	}
	
	@Test
	void updatePassword() {
		String oldPassword = "pass123";
		String newPassword = "pass";
		busOperatorServiceClass.updatePassword(oldPassword, newPassword);
	}
	
	
	
	
}
