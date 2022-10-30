package egovframework.com.email.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.email.service.EmailService;
import egovframework.com.email.service.EmailVO;
import egovframework.com.utl.fcc.service.EgovNumberUtil;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : SiteController.java
 * @Description : Site Controller class
 * @Modification Information
 *
 * @author 김수현
 * @since 2022-09-24
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes({ "emailAuth" })
public class EmailController {
	Logger logger = LogManager.getRootLogger();

	@Resource(name = "emailService")
	private EmailService emailService;

	@Value("${email.title.en}")
	String title;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	// bean vaildator

	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * site 목록을 조회한다. (pageing)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 SiteDefaultVO
	 * @return "/site/SiteList"
	 * @exception Exception
	 */
	@RequestMapping("/email/userRegisterView.do")
	public String userRegisterView(Model model, HttpServletRequest request) throws Exception {
		logger.info("userRegisterView Start");

		model.addAttribute("emailVO", new EmailVO());
		String lang = RequestContextUtils.getLocale(request).getLanguage();

		logger.info(uniToKor(propertiesService.getString("email.title.ko")));
		logger.info(propertiesService.getString("email.title.en"));
		logger.info("userRegisterView End");

		return "egovframework/com/email/EmailRegister";
	}

	@RequestMapping("/email/emailCheck.do")
	public String userEmailCheck(@ModelAttribute("emailVO") EmailVO emailVO, Model model, HttpServletRequest request,
			BindingResult bindingResult) throws Exception {
		logger.info("userEmailCheck Start");
		logger.info(emailVO.getEmail());
		beanValidator.validate(emailVO, bindingResult);
		int count = emailService.selectEmailTotCnt(emailVO);
		if (bindingResult.hasErrors() || count > 0) {
			logger.info("count : " + count);
			logger.info("field error");
			System.out.println(bindingResult.toString());
			model.addAttribute("emailVO", emailVO);
			model.addAttribute("errormsge", emailVO);
			return "egovframework/com/email/EmailRegister";
		}

		logger.info("userEmailCheck End");

		try {
			HtmlEmail emailContext = new HtmlEmail();
			emailContext.setCharset("euc-kr");
			emailContext.setHostName("smtp.gmail.com");
			emailContext.setSmtpPort(587);

			emailContext.setAuthentication(EgovProperties.getProperty("google.id"),
					EgovProperties.getProperty("google.password"));

			emailContext.setStartTLSEnabled(true);

			emailContext.addTo(emailVO.getEmail(), ""); // 수신자를 추가

			emailContext.setFrom(EgovProperties.getProperty("google.id"), "Web Watcher"); // 보내는 사람 지정

			String lang = RequestContextUtils.getLocale(request).getLanguage();
			logger.info("locale " + lang);

			String title = uniToCountry(propertiesService.getString("email.title." + lang), lang);

			if (title == null || title.isEmpty()) {
				lang = "en";
				title = propertiesService.getString("email.title.en");
			}

			logger.info("title " + title);
			emailContext.setSubject(title); // 메일 제목

			logger.info("set context");

			StringBuilder sb = new StringBuilder();

			int emailAuth = EgovNumberUtil.getRandomNum(10000000, Integer.MAX_VALUE - 1);
			logger.info(emailAuth);
			logger.info(request.getContextPath());

			model.addAttribute("emailAuth", emailAuth);
			String link = EgovProperties.getProperty("url.start") + request.getContextPath() + "/signup/" + emailAuth
					+ ".do";

			String context1 = uniToCountry(propertiesService.getString("email.context1." + lang), lang);
			String context2 = uniToCountry(propertiesService.getString("email.context2." + lang), lang);
			String context3 = uniToCountry(propertiesService.getString("email.context3." + lang), lang);

			sb.append("<h4>" + context1 + "</h4><br>");
			sb.append("<p>" + context2 + "</p><br>");
			sb.append("<a href=\"" + link + "\">" + link + "</a><br><br>");
			sb.append("<p>" + context3 + "</p>");

			logger.info("context : " + sb.toString());
			emailContext.setHtmlMsg(sb.toString());
			emailContext.send();

		} catch (Exception e) {
			logger.info("email fail");
			e.printStackTrace();
			return "egovframework/com/error/Emailfail";
		}

		return "egovframework/com/email/EmailSuccess";
	}

	public String uniToCountry(String uni, String lang) {
		if (lang.equals("ko")) {
			return uniToKor(uni);
		} else {
			return uni;
		}
	}

	public String uniToKor(String uni) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < uni.length(); i++) {
			if (uni.charAt(i) == '\\' && uni.charAt(i + 1) == 'u') {
				Character c = (char) Integer.parseInt(uni.substring(i + 2, i + 6), 16);
				result.append(c);
				i += 5;
			} else {
				result.append(uni.charAt(i));
			}
		}
		return result.toString();
	}
}
