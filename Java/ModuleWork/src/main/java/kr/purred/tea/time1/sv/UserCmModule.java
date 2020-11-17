package kr.purred.tea.time1.sv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kr.purred.tea.time1.inter.UserCommon;
import kr.purred.tea.time1.inter.UserModel;
import kr.purred.tea.time1.model.MfriendUser;

public class UserCmModule implements UserCommon
{
	private ObjectMapper om;

	public UserCmModule ()
	{
		om = new ObjectMapper ();

		om.registerModule (new JavaTimeModule ());
		om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	public MfriendUser[] getUsers () throws JsonProcessingException
	{
		HttpResponse<String> response = Unirest.get ("http://192.168.4.1:8089/api/user")
			.header ("accept", "application/json").asString ();

		return om.readValue (response.getBody (), MfriendUser[].class);
	}

	public MfriendUser getUser(Long no) throws JsonProcessingException
	{
		HttpResponse<String> response2 = Unirest.get ("http://192.168.4.1:8089/api/user/" + no)
			.header ("accept", "application/json").asString ();

		return om.readValue (response2.getBody (), MfriendUser.class);
	}

	@Override
	public List<UserModel> getCommonAll () throws JsonProcessingException
	{
		return Arrays.stream (getUsers ()).map ((d) -> (UserModel) d).collect(Collectors.toList());
	}

	@Override
	public UserModel getCommonOne (Long pk) throws JsonProcessingException
	{
		return getUser (pk);
	}
}
