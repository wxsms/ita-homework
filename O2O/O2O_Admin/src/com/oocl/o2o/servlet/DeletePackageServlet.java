package com.oocl.o2o.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.o2o.dao.impl.FoodPackageDao;
import com.oocl.o2o.dao.impl.PackageDao;
import com.oocl.o2o.pojo.Package;

/**
 * Servlet implementation class DeletePackageServlet
 */
public class DeletePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		PackageDao dao = new PackageDao();
		FoodPackageDao dao2 = new FoodPackageDao();
		Package pkg = new Package();
		pkg.setPackageId(id);
		dao.delete(pkg);
		dao2.deleteByPackageId(id);
		response.sendRedirect("/O2O_Admin/main/package.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
