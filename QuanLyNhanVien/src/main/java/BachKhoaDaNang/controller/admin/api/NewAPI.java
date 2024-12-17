package BachKhoaDaNang.controller.admin.api;

import java.io.IOException;
import java.util.Base64;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import BachKhoaDaNang.bean.Account;
import BachKhoaDaNang.bean.News;
import BachKhoaDaNang.constant.SystemConstant;
import BachKhoaDaNang.utils.HttpUtil;
import BachKhoaDaNang.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewAPI extends HttpServlet {
	
	@Inject
	private BachKhoaDaNang.service.INewService newService;

	private static final long serialVersionUID = -915988021506484384L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// Đọc toàn bộ body của request
	    StringBuilder jsonStr = new StringBuilder();
	    String line;
	    while ((line = request.getReader().readLine()) != null) {
	        jsonStr.append(line);
	    }

	    // Kiểm tra nếu body rỗng
	    if (jsonStr.length() == 0) {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write("{\"error\": \"Request body is empty\"}");
	        return;
	    }

	    // Chuyển chuỗi JSON thành đối tượng News
	    News newModel = mapper.readValue(jsonStr.toString(), News.class);

	    // Set thông tin người sửa
	    newModel.setCreatedBy(((Account) SessionUtil.getInstance().getValue(request, SystemConstant.USERACCOUNT)).getUserName());

	    // Xử lý thumbnail nếu có
	    JsonNode jsonNode = mapper.readTree(jsonStr.toString());
	    if (jsonNode.has("thumbnail") && !jsonNode.get("thumbnail").isNull()) {
	        String thumbnailBase64 = jsonNode.get("thumbnail").asText();
	        if (thumbnailBase64 != null && !thumbnailBase64.isEmpty()) {
	            byte[] thumbnailBytes = Base64.getDecoder().decode(thumbnailBase64);
	            newModel.setThumbnail(thumbnailBytes);
	        }
	    }
	    
		newModel = newService.save(newModel);
		mapper.writeValue(response.getOutputStream(), newModel);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json");

	    // Đọc toàn bộ body của request
	    StringBuilder jsonStr = new StringBuilder();
	    String line;
	    while ((line = request.getReader().readLine()) != null) {
	        jsonStr.append(line);
	    }

	    // Kiểm tra nếu body rỗng
	    if (jsonStr.length() == 0) {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write("{\"error\": \"Request body is empty\"}");
	        return;
	    }

	    // Chuyển chuỗi JSON thành đối tượng News
	    News updateNew = mapper.readValue(jsonStr.toString(), News.class);

	    // Set thông tin người sửa
	    updateNew.setModifiedBy(((Account) SessionUtil.getInstance().getValue(request, SystemConstant.USERACCOUNT)).getUserName());

	    // Xử lý thumbnail nếu có
	    JsonNode jsonNode = mapper.readTree(jsonStr.toString());
	    if (jsonNode.has("thumbnail") && !jsonNode.get("thumbnail").isNull()) {
	        String thumbnailBase64 = jsonNode.get("thumbnail").asText();
	        if (thumbnailBase64 != null && !thumbnailBase64.isEmpty()) {
	            byte[] thumbnailBytes = Base64.getDecoder().decode(thumbnailBase64);
	            updateNew.setThumbnail(thumbnailBytes);
	        }
	    }

	    // Cập nhật dữ liệu
	    updateNew = newService.update(updateNew);

	    // Trả về kết quả dưới dạng JSON
	    mapper.writeValue(response.getOutputStream(), updateNew);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		News newModel =  HttpUtil.of(request.getReader()).toModel(News.class);
		newService.delete(newModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
