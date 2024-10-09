package controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import services.CategoryService;
import services.ICategoryService;

/**
 * Servlet implementation class CategoryController
 */
@MultipartConfig()
@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/delete", "/admin/category/edit", "/admin/category/update", "/admin/category/status" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ICategoryService categoryService = new CategoryService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String urlString = request.getRequestURI();
		if (urlString.contains("/admin/category/add")) {
			request.getRequestDispatcher("/views/admin/category-add.jsp").forward(request, response);
		} else if (urlString.contains("/admin/categories")) {
			List<Category> list = categoryService.findAll();
			request.setAttribute("listcate", list);
			request.getRequestDispatcher("/views/admin/category-list.jsp").forward(request, response);
		} else if (urlString.contains("/admin/category/delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				categoryService.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/admin/categories");
		} else if (urlString.contains("/admin/category/edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Category Category = categoryService.findById(id);
			request.setAttribute("cate", Category);
			request.getRequestDispatcher("/views/admin/category-edit.jsp").forward(request, response);
		} else if (urlString.contains("/admin/category/status")) {
//			int id = Integer.parseInt(request.getParameter("id"));
//			int status = Integer.parseInt(request.getParameter("status"));
//			categoryService.updateStatus(id, status == 1 ? 0 : 1);
//			response.sendRedirect(request.getContextPath() + "/admin/categories");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String urlString = request.getRequestURI();
		if (urlString.contains("/admin/category/insert")) {
			String categoryname = request.getParameter("categoryname");
			int status = Integer.parseInt(request.getParameter("status"));
			String images = request.getParameter("images");
			Category Category = new Category();
			Category.setCategoryname(categoryname);
			Category.setStatus(status);

			// xu li upload file
			String fname = "";
			String uploadPath = "C:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			try {
				Part part = request.getPart("images1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname);
					Category.setImages(fname);
				} else if (images != null) {
					Category.setImages(images);
				} else {
					Category.setImages("avatar.png");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			categoryService.insert(Category);
			response.sendRedirect(request.getContextPath() + "/admin/categories");
		} else if (urlString.contains("/admin/category/update")) {
			int categoyid = Integer.parseInt(request.getParameter("categoryid"));
			String categoryname = request.getParameter("categoryname");
			int status = Integer.parseInt(request.getParameter("status"));
			String images = request.getParameter("images");
			Category Category = new Category();
			Category.setCategoryid(categoyid);
			Category.setCategoryname(categoryname);
			Category.setStatus(status);

			// xu li upload file
			String fname = "";
			String uploadPath = "C:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			try {
				Part part = request.getPart("images1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname);
					Category.setImages(fname);
				} else if (images != null) {
					Category.setImages(images);
				} else {
					Category.setImages("avatar.png");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			categoryService.update(Category);
			response.sendRedirect(request.getContextPath() + "/admin/categories");
		}
	}

}
