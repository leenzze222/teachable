package kr.purred.tea.time1.sv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kr.purred.tea.time1.model.MfriendUser;

public class UserCmModule
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
}
