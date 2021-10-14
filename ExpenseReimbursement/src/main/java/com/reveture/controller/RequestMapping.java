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
		EmployeeService es = new EmployeeService();
		SignupService ss= new SignupService();
		SignupDAOImp sd = new SignupDAOImp();
		UserDAO dao=new UserDAO();
		EmployeeController e= new EmployeeController(re,es);
		AutenticateService authService = new AutenticateService(dao);
		
		Authenticate authenticateController = new Authenticate( authService);
		re.select();
		
		
		//SignupService ss= new SignupService(sd);
		SignupController sc=new SignupController(sd);
		
		
		
		app.get("/api/employee/{position}", ctx -> ctx.json(e.select(ctx)) );
		//app.get("/api/employee/{position}", ctx -> ctx.json(e.seeEmployee(ctx)) );
		app.get("/api/employee", ctx -> ctx.json(e.seeAll()));
		//app.get("/api/employees", ctx -> ctx.json(e.select(ctx)));
		
		app.get("/api/signup", ctx -> ctx.json(sc.seeAll()));
	//app.post("/insert", ctx -> ctx.request.html());
		
		//app.post("/login" , ctx -> ctx.redirect(authenticateController.authenticate(ctx)));
		/*app.get("/", ctx -> {
			HttpServletRequest request = ctx.req;
			HttpServletResponse response = ctx.res;
			
			//This creates an internal endpoint we want to forward to. 
//			RequestDispatcher reqDispatcher = ctx.req.getRequestDispatcher("Login.html");
			RequestDispatcher reqDispatcher = ctx.req.getRequestDispatcher("/login");
			
			//Also forward them the resust and response objects!
			reqDispatcher.forward(request, response);
		}
			);*/
app.post("/authenticate", ctx -> {
			
			authenticateController.authenticate(ctx);
			
		});

app.post("/insert", ctx -> {e.insert(ctx);});
		
		
		
		//app.get("/" , ctx -> ctx.redirect("login.html"));
		
		
	}

}
