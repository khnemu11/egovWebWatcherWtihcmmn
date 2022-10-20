package egovframework.com.site.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.login.service.LoginVO;
import egovframework.com.site.service.DefaultVO;
import egovframework.com.site.service.SiteService;
import egovframework.com.site.service.SiteVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

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
public class SiteController {
	Logger logger = LogManager.getRootLogger();

	@Resource(name = "EgovFileMngService")
	private EgovFileMngService fileMngService;

	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;

	@Resource(name = "siteService")
	private SiteService siteService;

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
	@RequestMapping(value = "/site/SiteList.do")
	public String selectSiteList(@ModelAttribute("searchVO") DefaultVO searchVO, ModelMap model) throws Exception {
		logger.info("start select site list");
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> siteList = siteService.selectSiteList(searchVO);
		logger.info("site size : " + siteList.size());
		model.addAttribute("resultList", siteList);

		int totCnt = siteService.selectSiteListTotCnt(searchVO);
		logger.info("total count : " + totCnt);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		logger.info("end select site list");

		return "egovframework/com/site/SiteList";
	}

	@RequestMapping(value = "/site/SiteList/{userSeq}.do")
	public String selectSiteListBySeq(@PathVariable int userSeq, @ModelAttribute("searchVO") DefaultVO searchVO,
			ModelMap model) throws Exception {
		logger.info("start select site list");
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		SiteVO vo = new SiteVO();
		vo.setUserSeq(userSeq);
		logger.info("user seq : " + userSeq);
		List<?> siteList = siteService.selectSiteListBySeq(vo);
		logger.info("site size : " + siteList.size());

		model.addAttribute("resultList", siteList);
		model.addAttribute("userSeq", userSeq);
		int totCnt = siteService.selectSiteListBySeqTotCnt(vo);

		logger.info("total count : " + totCnt);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		logger.info("end select site list");

		return "egovframework/com/site/SiteList";
	}

	@RequestMapping("/site/addSiteView.do")
	public String addSiteView(@ModelAttribute("searchVO") DefaultVO searchVO, Model model) throws Exception {
		logger.info("addSiteView Start");
		model.addAttribute("siteVO", new SiteVO());
		logger.info("siteVO : " + (new SiteVO()).toString());
		logger.info("addSiteView End");
		return "egovframework/com/site/SiteRegister";
	}

	@RequestMapping("/site/addSite.do")
	public String addSite(HttpServletRequest request, MultipartHttpServletRequest multiRequest,
			@ModelAttribute("siteVO") SiteVO siteVO, SessionStatus status,
			@SessionAttribute("loginInfo") LoginVO loginInfo, BindingResult bindingResult, Model model)
			throws Exception {
		logger.info("addSite Start");
		siteVO.setFileName(
				siteVO.getFile().getOriginalFilename().length() == 0 ? null : siteVO.getFile().getOriginalFilename());
		logger.info(siteVO.toString());

		beanValidator.validate(siteVO, bindingResult);
		logger.info(bindingResult.toString());
		if (bindingResult.hasErrors()) {
			logger.info("field error");
			System.out.println(bindingResult.toString());
			model.addAttribute("searchVO", siteVO);

			return "egovframework/com/site/SiteRegister";
		}
		String path = "./webapp/file";
		String absolutePath = request.getServletContext().getRealPath(path);
		Path paths = Paths.get(absolutePath);
		File directory = new File(absolutePath);

		logger.info(absolutePath);
		logger.info("directory is exist " + Files.exists(paths));

		if (!Files.exists(paths)) {
			directory.mkdir();
			logger.info("make folder");
		}

		siteVO.setUserSeq((int) loginInfo.getUserSeq());
		List<FileVO> _result = null;
		String _atchFileId = "";

		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		if (!files.isEmpty()) {
			_result = fileUtil.parseFileInf(files, "SCENARIO_", 0, "", "");
			_atchFileId = fileMngService.insertFileInfs(_result); // 파일이 생성되고나면 생성된 첨부파일 ID를 리턴한다.
		}
		logger.info("file id : " + _atchFileId);
		siteVO.setFileId(_atchFileId);
		logger.info("insert : " + siteVO.toString());
		siteService.insertSite(siteVO);
//		status.setComplete();

		logger.info("addSite end");
		return "forward:/site/SiteList/" + loginInfo.getUserSeq() + ".do";
	}

	@RequestMapping("/site/updateSiteView.do")
	public String updateSiteView(@RequestParam("seq") int seq, Model model) throws Exception {
		SiteVO siteVO = new SiteVO();
		siteVO.setSeq(seq);

		model.addAttribute("siteVO", siteService.selectSite(siteVO));
		return "egovframework/com/site/SiteRegister";
	}

	@RequestMapping("/site/selectSite.do")
	public @ModelAttribute("siteVO") SiteVO selectSite(SiteVO siteVO, @ModelAttribute("searchVO") DefaultVO searchVO)
			throws Exception {
		return siteService.selectSite(siteVO);
	}

	@RequestMapping("/site/updateSite.do")
	public String updateSite(@ModelAttribute("siteVO") SiteVO siteVO, Model model, SessionStatus status, BindingResult bindingResult,
			MultipartHttpServletRequest multiRequest) throws Exception {
		logger.info("updateSite Start");
		logger.info(siteVO.toString());
		siteVO.setFileName(
				siteVO.getFile().getOriginalFilename().length() == 0 ? null : siteVO.getFile().getOriginalFilename());
		logger.info(siteVO.toString());
		
		beanValidator.validate(siteVO, bindingResult);
		
		
		logger.info(bindingResult.toString());

		if (bindingResult.hasErrors()) {
			if (bindingResult.getErrorCount() == 1 && siteVO.getFileName() == null) {
			} else {
				logger.info("field error");
				System.out.println(bindingResult.toString());
				SiteVO originalVO = siteService.selectSite(siteVO);

				siteVO.setUrl(originalVO.getUrl());
				siteVO.setFileName(originalVO.getFileName());
				model.addAttribute("siteVO", siteVO);

				logger.info("site update input fail");

				return "egovframework/com/site/SiteRegister";
			}
		}

		String _atchFileId = siteVO.getFileId();// 해당 업무기능에 따라서 수정되는 기능의 파일 ID를 불러온다.
		logger.info("file id : " + _atchFileId);
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		logger.info("input file: " + files.toString());
		logger.info("input file name : " + files.get("file").getOriginalFilename());
		try {
			SiteVO originalVO = siteService.selectSite(siteVO);
			logger.info("original site vo : " + originalVO.toString());

			if (files.get("file").getOriginalFilename().isEmpty()
					|| files.get("file").getOriginalFilename().equals("")) {
				logger.info("no change file");
				siteVO.setFileName(originalVO.getFileName());
				siteVO.setFileId(originalVO.getFileId());
			} else {
				logger.info("insert file");
				FileVO fileVO = new FileVO();
				fileVO.setAtchFileId(originalVO.getFileId());
				fileVO.setFileSn("0");
				fileMngService.deleteFileInf(fileVO);

				List<FileVO> _result = fileUtil.parseFileInf(files, "SCENARIO_", 0, "", "");
				_atchFileId = fileMngService.insertFileInfs(_result); // 기존에 첨부파일 ID가 없다.
				siteVO.setFileId(_atchFileId); // 관련 비즈니스 규칙에 따라서 생성된 첨부파일 ID 정보를 세팅한다.
				siteVO.setFileName(files.get("file").getOriginalFilename());
			}
		} catch (Exception e) {
			logger.info("file update fail");
			e.getStackTrace();
		}
		logger.info(siteVO.toString());
		try {
			siteService.updateSite(siteVO);
		} catch (Exception e) {
			logger.info("site update fail");
			e.getStackTrace();
		}

//		status.setComplete();
		logger.info("site update end");
		return "forward:/site/SiteList/" + siteVO.getUserSeq() + ".do";
	}

	@RequestMapping("/site/deleteSite/{siteSeq}.do")
	public String deleteSite(@PathVariable int siteSeq, @ModelAttribute("searchVO") DefaultVO searchVO,
			SessionStatus status) throws Exception {
		logger.info("site delete start");
		SiteVO search = new SiteVO();
		search.setSeq(siteSeq);

		SiteVO siteVO = siteService.selectSite(search);

		siteService.deleteSite(siteVO);

		logger.info("delete : " + siteVO.getFileId());
		FileVO fileVO = new FileVO();
		fileVO.setAtchFileId(siteVO.getFileId());
		fileVO.setFileSn("0");
		logger.info("delete : " + fileVO.getAtchFileId());
		fileMngService.deleteFileInf(fileVO);
//		status.setComplete();
		return "forward:/site/SiteList/" + siteVO.getUserSeq() + ".do";
	}

	@RequestMapping(value = "/site/downloadFile.do")
	public void downloadFile(@RequestParam(value = "requestedFile") String requestedFile, HttpServletResponse response)
			throws Exception {

		String uploadPath = EgovProperties.getProperty("Globals.fileStorePath");

		File uFile = new File(uploadPath, requestedFile);
		int fSize = (int) uFile.length();

		if (fSize > 0) {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(uFile));
			// String mimetype = servletContext.getMimeType(requestedFile);
			String mimetype = "text/html";

			response.setBufferSize(fSize);
			response.setContentType(mimetype);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + requestedFile + "\"");
			response.setContentLength(fSize);

			FileCopyUtils.copy(in, response.getOutputStream());
			in.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} else {
			// setContentType을 프로젝트 환경에 맞추어 변경
			response.setContentType("application/x-msdownload");
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<br><br><br><h2>Could not get file name:<br>" + requestedFile + "</h2>");
			printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("<br><br><br>&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	}

	public void setInsert(SiteVO sample) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HHmmss");

		sample.setCdate(Integer.valueOf(now.format(dateformat)));
		sample.setCtime(Integer.valueOf(now.format(timeformat)));
	}

	public void setUpdate(SiteVO sample) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HHmmss");

		sample.setUdate(Integer.valueOf(now.format(dateformat)));
		sample.setUtime(Integer.valueOf(now.format(timeformat)));
	}

	public void setDelete(SiteVO sample) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HHmmss");

		sample.setDdate(Integer.valueOf(now.format(dateformat)));
		sample.setDtime(Integer.valueOf(now.format(timeformat)));
	}
}
