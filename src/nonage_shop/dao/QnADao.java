package nonage_shop.dao;

import java.util.ArrayList;

import nonage_shop.dto.QnA;

public interface QnADao {
	
	// Qna 리스트
	ArrayList<QnA> listQnA(String id);
	
	
	QnA getQnA(int qseq);
	
	// Qna 작성
	int insertQnA(QnA qna, String id);

}
