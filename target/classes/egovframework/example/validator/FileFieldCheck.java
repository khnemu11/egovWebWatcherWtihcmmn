package egovframework.example.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.ValidatorAction;
import org.springframework.validation.Errors;
import org.springmodules.validation.commons.FieldChecks;

import egovframework.example.site.service.SiteVO;

public class FileFieldCheck extends FieldChecks {
	private static final Log log = LogFactory.getLog(FileFieldCheck.class);

	public static boolean validateFileName(Object bean, ValidatorAction va, Field field, Errors errors) {
//		String ihidnum = FieldChecks.extractValue(bean, field); //		bean에서 해당 field 값을 추 
		String filename = ((SiteVO) bean).getFile().getName(); 				// 위와 동일한 코드이나 multipartfile 타입은
																			// 객체(collections)타입이라서 property(단순 필드)일때만
																			// extractValue로 객체의 필드값을 추출 불가하여 bean에서 직접
																			// 가져오는 코드

		if (!FileValidator.isValidFileName(filename)) { // 이미 등록된 파일이름이라면
			FieldChecks.rejectValue(errors, field, va); // 에러 처리
			return false;
		} else {
			return true;
		}
	}

	public static boolean validateFile(Object bean, ValidatorAction va, Field field, Errors errors) {
//			String ihidnum = FieldChecks.extractValue(bean, field); //		bean에서 해당 field 값을 추 
		String filename = ((SiteVO) bean).getFile().getOriginalFilename(); // 위와 동일한 코드이나 multipartfile 타입은 객체(collections)타입이라서
																// property(단순 필드)일때만 extractValue로 객체의 필드값을 추출 불가하여
																// bean에서 직접 가져오는 코드
		log.info(filename);
		if (!FileValidator.isValidFileRequired(filename)) { // 파일 이름이 없다면
			FieldChecks.rejectValue(errors, field, va); // 에러 처리
			return false;
		} else {
			if (!FileValidator.isValidFileName(filename)) { // 이미 등록된 파일이름이라면
				FieldChecks.rejectValue(errors, field, va); // 에러 처리
				return false;
			} else {
				return true;
			}
		}
	}
}
