package controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import services.CategoryService;
import services.ICategoryService;
import services.IVideoService;
import services.VideoService;

/**
 * Servlet implementation class VideoController
 */
@MultipartConfig()
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/insert", "/admin/video/delete",
		"/admin/video/edit", "/admin/video/update", "/admin/video/status" })
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 2L;
	public IVideoService videoService = new VideoService();
	public ICategoryService categoryService = new CategoryService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoController() {
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
		if (urlString.contains("/admin/videos")) {
			List<Video> list = videoService.findAll();
			request.setAttribute("listvideo", list);
			request.getRequestDispatcher("/views/admin/video-list.jsp").forward(request, response);
		} else if (urlString.contains("/admin/video/add")) {
			request.getRequestDispatcher("/views/admin/video-add.jsp").forward(request, response);
		} else if (urlString.contains("/admin/video/delete")) {
			String videoid = request.getParameter("videoid");
			try {
				videoService.delete(videoid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/admin/videos");
		} else if (urlString.contains("/admin/video/edit")) {
			String videoid = request.getParameter("videoid");
			Video video = videoService.findById(videoid);
			request.setAttribute("video", video);
			request.getRequestDispatcher("/views/admin/video-edit.jsp").forward(request, response);
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
		if (urlString.contains("/admin/video/insert")) {
			String videoid = request.getParameter("videoid");
			int active = Integer.parseInt(request.getParameter("active"));
			String description = request.getParameter("description");
			String poster = request.getParameter("poster");
			String title = request.getParameter("title");
			int views = Integer.parseInt(request.getParameter("views"));
			int categoryid = Integer.parseInt(request.getParameter("categoryid"));
			Video video = new Video();
			video.setCategory(categoryService.findById(categoryid));
			video.setActive(active);
			video.setDescription(description);
			video.setTitle(title);
			video.setViews(views);

			// xu li upload file
			String fname1 = "";
			String fname2 = "";
			String uploadPath = "C:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			try {
				Part part = request.getPart("poster1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname1 = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname1);
					video.setPoster(fname1);
				} else if (poster != null) {
					video.setPoster(poster);
				} else {
					video.setPoster("avatar.png");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Part part = request.getPart("videoid1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname2 = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname2);
					video.setVideoid(fname2);
				} else if (videoid != null) {
					video.setVideoid(videoid);
				} else {
					video.setVideoid("thumbnail.mp4");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			videoService.insert(video);
			response.sendRedirect(request.getContextPath() + "/admin/videos");
		} else if (urlString.contains("/admin/video/update")) {
			String videoid = request.getParameter("videoid");
			int active = Integer.parseInt(request.getParameter("active"));
			String description = request.getParameter("description");
			String poster = request.getParameter("poster");
			String title = request.getParameter("title");
			int views = Integer.parseInt(request.getParameter("views"));
			int categoryid = Integer.parseInt(request.getParameter("categoryid"));
			Video video = new Video();
			video.setCategory(categoryService.findById(categoryid));
			video.setActive(active);
			video.setDescription(description);
			video.setTitle(title);
			video.setViews(views);

			// xu li upload file
			String fname1 = "";
			String fname2 = "";
			String uploadPath = "C:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			try {
				Part part = request.getPart("poster1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname1 = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname1);
					video.setPoster(fname1);
				} else if (poster != null) {
					video.setPoster(poster);
				} else {
					video.setPoster("avatar.png");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Part part = request.getPart("videoid1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname2 = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname2);
					video.setVideoid(fname2);
				} else if (videoid != null) {
					video.setVideoid(videoid);
				} else {
					video.setVideoid("thumbnail.mp4");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			videoService.update(video);
			response.sendRedirect(request.getContextPath() + "/admin/videos");
		}
	}

}
