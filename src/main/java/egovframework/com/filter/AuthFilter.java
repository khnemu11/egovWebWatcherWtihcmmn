package egovframework.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import egovframework.com.filter.service.AuthFilterService;
import egovframework.com.filter.service.AuthVO;
import egovframework.com.uat.uia.service.EgovLoginService;

/**
 *
 * @author 공통서비스 개발팀 서준식
 * @since 2011. 8. 29.
 * @version 1.0
 * @see
 *
 *      <pre>
 * 개정이력(Modification Information)
 *
 *  수정일               수정자        	 수정내용
 *  ----------   --------   ---------------------------
 *  2011.08.29   서준식            최초생성
 *  2011.12.12   유지보수         사용자 로그인 정보 간섭 가능성 문제(멤버 변수 EgovUserDetails userDetails를 로컬변수로 변경)
 *  2014.03.07   유지보수         로그인된 상태에서 다시 로그인 시 미처리 되는 문제 수정 (로그인 처리 URL 파라미터화)
 *  2017.03.03 	  조성원 	       시큐어코딩(ES)-부적절한 예외 처리[CWE-253, CWE-440, CWE-754]
 *  2017.07.10   장동한            실행환경 v3.7(Spring Security 4.0.3 적용)
 *  2017.07.21 	  장동한 		로그인인증제한 작업
 *  2020.06.25 	  신용호 		로그인 메시지 처리 수정
 *
 *      </pre>
 */

public class AuthFilter implements Filter {

	private FilterConfig config;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		LOGGER.info("AuthFilter called...");

		// 로그인 URL
		String loginURL = "/login.do";

		ApplicationContext act = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		AuthFilterService authFilterService = (AuthFilterService) act.getBean("authService");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		AuthVO authVO = new AuthVO();
		authVO.setAuth("ROLE_ANONYMOUS");
		authVO.setSeq("ANONYMOUS");

		String requestURL = ((HttpServletRequest) request).getRequestURI();
		authVO.setUrl(requestURL);

		if (session.getAttribute("loginInfo") != null) {
			egovframework.com.login.service.LoginVO loginVO = (egovframework.com.login.service.LoginVO) session
					.getAttribute("loginInfo");
			authVO.setSeq(String.valueOf(loginVO.getUserSeq()));
		}

		if (session.getAttribute("loginVO") != null) {
			loginURL = "/uat/uia/egovLoginUsr.do";
			authVO.setSeq((String) session.getAttribute("accessUser"));
		}

		long count = 0;

		try {
			if (authVO.getSeq().equals("ANONYMOUS")) {
				count = authFilterService.selectRole(authVO);
			} else {
				String authCode = authFilterService.selectAuth(authVO);

				LOGGER.info("auth code : " + authCode);
				authVO.setAuth(authCode);

				count = authFilterService.selectRole(authVO);
			}
			LOGGER.info("count : " + count);
			if (count == 0) {
				RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginURL);
				dispatcher.forward(httpRequest, httpResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		LOGGER.info("seq : " + authVO.getSeq());
		LOGGER.info(requestURL);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}
}
