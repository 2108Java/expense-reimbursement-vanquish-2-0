package com.reveture.controller;

import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.Models.SignUp;
import com.reveture.service.EmployeeService;
import com.reveture.service.SignupService;

import io.javalin.Javalin;

public class RequestMapping {
	public static void settingUpEndpoints(Javalin app) {
		RequestDAOImp re= new RequestDAOImp();
		EmployeeService es = new EmployeeService();
		EmployeeController e= new EmployeeController(re,es);
		re.select();
		
		SignupDAOImp sd=new SignupDAOImp();
		SignupService ss= new SignupService(sd);
		SignupController sc=new SignupController(sd,ss);
		
		
		
		app.get("/api/employee/{position}", ctx -> ctx.json(e.select(ctx)) );
		//app.get("/api/employee/{position}", ctx -> ctx.json(e.seeEmployee(ctx)) );
		app.get("/api/employee", ctx -> ctx.json(e.seeAll()));
		//app.get("/api/employees", ctx -> ctx.json(e.select(ctx)));
		
		app.get("/api/signup", ctx -> ctx.json(sc.seeAll()));
		//app.post("/insert", ctx -> ctx.request.html());
		
		
	}

}
