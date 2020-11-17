package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.model.MyUser;

public class ModuleWorkUser2
{
	public static void main (String[] args)
	{
		HttpResponse<String> response = Unirest.get ("http://192.168.4.1:8089/api/myuser")
				.header ("accept", "application/json").asString ();

		System.out.println (response.getBody ());

		ObjectMapper om = new ObjectMapper ();

		// LocalDate 처리를 위한 로직
		om.registerModule (new JavaTimeModule ());
		om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		try
		{
			MyUser[] users = om.readValue (response.getBody (), MyUser[].class);

			long no = 0;

			for (MyUser user : users)
			{
				if (no == 0)
					no = user.getNo ();

				System.out.println (user);
			}

			HttpResponse<String> response2 = Unirest.get ("http://192.168.4.1:8089/api/myuser/" + no)
					.header ("accept", "application/json").asString ();

			MyUser user = om.readValue (response2.getBody (), MyUser.class);

			System.out.println (user);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
