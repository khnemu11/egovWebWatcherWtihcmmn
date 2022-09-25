package egovframework.example.validator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springmodules.validation.commons.FieldChecks;

public class FileValidator implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(FileValidator.class);

	public static boolean isValidFileName(String value) { //db에서 파일 이름을 검색하여 이미 있는 이름인지 확인하는 메소드
		try {
			log.info("file name validate start");
			if (value.isEmpty()) {
				return false;
			}
			// static 타입은 스프링 컨테이너에서 의존성 주입이 불가하므로 직접 커넥션 풀을 생성하여 디비 접속
			Class.forName("com.mysql.cj.jdbc.Driver"); // db드라이버 설정
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_49e9d9e55a08975?reconnect=true", "bce999f4740880",
					"98c1ec79"); // 디비 설정
			
			
			
			String sql = "SELECT count(*) FROM SCENARIO	WHERE DDATE =0 AND DTIME=0 AND NAME =?"; // 쿼리입력
			PreparedStatement pstmt = con.prepareStatement(sql); // 동적쿼리 부분
			
			
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery(); // 쿼리 실행
			
			while (rs.next()) { // 쿼리 결과 가져오는 부분
				int count = rs.getInt(1);
				if (count > 0) {
					log.info(value + " is duplicate in DB");
					return false; // 실패
				} else {
					log.info(value + "is not duplicate file");
					return true; // 성공
				}
			}
		} catch (Exception e) {
			log.error("failed file name validation");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean isValidFileRequired(String value) { //파일 이름이 비어있는지 확인하는 메소드
		try {
			if (value.isEmpty() || value.equals("file")) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			log.error("failed file required validation");
			e.printStackTrace();
			return false;
		}
	}
}
