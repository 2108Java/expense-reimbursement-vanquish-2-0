package com.reveture.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.DAO.UserDAO;
import com.revature.Models.SignUp;
import com.reveture.service.AutenticateService;
import com.reveture.service.EmployeeService;
import com.reveture.service.SignupService;

import io.javalin.Javalin;

public class RequestMapping {
	public static void settingUpEndpoints(Javalin app) {
		RequestDAOImp re= new RequestDAOImp();
		EmployeeService es = new EmployeeService(re);
		SignupService ss= new SignupService();
		SignupDAOImp sd = new SignupDAOImp();
		UserDAO dao=new UserDAO();
		EmployeeController e= new EmployeeController(re,es);
		AutenticateService authService = new AutenticateService(dao);
		SignupDAOImp signupdao = new SignupDAOImp();
		
		Authenticate authenticateController = new Authenticate( authService);
		re.select();
		
		
		//SignupService ss= new SignupService(sd);
		SignupController sc=new SignupController(sd);
		
		app.get("/api/employee/{position}", ctx -> ctx.json(e.selectById(ctx)) );
		
		app.get("/api/employee/{status}", ctx -> ctx.json(e.selectByStatus(ctx)) );
		
		
		
		app.get("/api/employee", ctx -> ctx.json(e.seeAll()));
		
		
		
		
		//app.get("/api/employees", ctx -> ctx.json(e.select(ctx)));
		
		app.post("/register", ctx -> {e.register(ctx);});

	
			
			
		app.post("/login", 
				ctx -> ctx.redirect(authenticateController.authenticate(ctx)));
		
		app.post("/login1", 
				ctx -> ctx.redirect(authenticateController.managerAuthen(ctx)));
	

app.post("/insert", ctx -> {e.insert(ctx);});

app.post("/update", ctx -> {e.update(ctx);});


//app.get("/list.html", ctx -> ctx.redirect("/register"));	

		
		
		
		//app.get("/" , ctx -> ctx.redirect("login.html"));
		
		
	}

}
