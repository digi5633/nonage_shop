package nonage_shop.dao;

import java.util.ArrayList;

import nonage_shop.dto.Member;

public interface MemberDao {
	
	// 회원 리스트 가져오기
	ArrayList<Member> selectMemberByAll();

	// 아이디로 회원 정보 가져오기
	Member selectMemberByUserId(Member member);
	
	// 회원 추가
	int insertMember(Member member);
	
	// 회원 수정
	int updateMember(Member member);
	
	// 회원 삭제
	int deleteMember(Member member);
	
	//
	int getId(Member member);

}
