package com.reveture.controller;

import com.revature.DAO.RequestDAOImp;
import com.reveture.service.EmployeeService;

import io.javalin.Javalin;

public class RequestMapping {
	public static void settingUpEndpoints(Javalin app) {
		RequestDAOImp re= new RequestDAOImp();
		
		
		  EmployeeService es = new EmployeeService(re);
		EmployeeController e= new EmployeeController(re,es);
		app.get("/api/employee/{position}", ctx -> ctx.json(e.seeEmployee(ctx)) );
		app.get("/api/employee", ctx -> ctx.json(e.seeAll()));
		
		
	}

}
