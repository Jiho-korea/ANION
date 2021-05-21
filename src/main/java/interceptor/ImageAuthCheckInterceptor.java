/*
========================================================================
파    일    명 : ImageAuthCheckInterceptor.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.06
작  성  내  용 : 특정 이미지에 접근할 수 있는 지 권한을 체크하는 인터셉터
========================================================================
*/
package interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import petProject.exception.ImageNotExistException;
import petProject.service.ScriptWriter;
import petProject.service.image.ImageSelectService;
import petProject.vo.AuthInfo;
import petProject.vo.dto.Image;

public class ImageAuthCheckInterceptor implements HandlerInterceptor {

	@Resource(name = "imageSelectService")
	ImageSelectService imageSelectService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");
		if (request.getParameter("imageNumber") != null) {
			Image image = null;
			try {
				image = imageSelectService.selectImage(Integer.parseInt(request.getParameter("imageNumber")));
			} catch (ImageNotExistException e) {
				e.printStackTrace();
				return ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			} catch (NumberFormatException e) {
				return ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
			} catch (Exception e) {
				e.printStackTrace();
				return ScriptWriter.write("오류가 발생했습니다.", "home", request, response);
			}
			// 관리자가 다른 사람 이미지에 접근하게 하고 싶으면 이부분 주석 풀면됨
//			if (!"0".equals(authInfo.getMemberlevel().getMemberLevelCode())
//					&& authInfo.getMemberNumber() != image.getMember().getMemberNumber()) {
//				return ScriptWriter.write("권한이 없습니다.", "home", request, response);
//			}
//			if ("0".equals(authInfo.getMemberlevel().getMemberLevelCode())
//					&& authInfo.getMemberNumber() != image.getMember().getMemberNumber()) {
//				request.setAttribute("admin", true);
//			}

			if (authInfo.getMemberNumber() != image.getMember().getMemberNumber()) {
				return ScriptWriter.write("권한이 없습니다.", "home", request, response);
			}

			return true;
		} else {
			return ScriptWriter.write("잘못된 접근입니다.", "home", request, response);
		}

	}

}
