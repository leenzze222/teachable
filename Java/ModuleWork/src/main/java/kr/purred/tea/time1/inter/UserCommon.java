package kr.purred.tea.time1.inter;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface UserCommon
{
	List<UserModel> getCommonAll() throws JsonProcessingException;

	UserModel getCommonOne(Long pk) throws JsonProcessingException;
}
