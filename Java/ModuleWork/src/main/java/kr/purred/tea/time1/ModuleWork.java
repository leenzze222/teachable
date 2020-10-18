package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kr.purred.tea.time1.model.MfriendUser;

public class ModuleWork
{
	public static void main (String[] args)
	{
		HttpResponse<String> response = Unirest.get ("http://localhost:8080/api/user")
				.header ("accept", "application/json").asString ();

		System.out.println (response.getBody ());

		ObjectMapper om = new ObjectMapper ();

		// LocalDate 처리를 위한 로직
		om.registerModule (new JavaTimeModule ());
		om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		try
		{
			MfriendUser[] mfriendUser = om.readValue (response.getBody (), MfriendUser[].class);

			for (MfriendUser user : mfriendUser)
			{
				System.out.println (user);
			}
		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
