package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kr.purred.tea.time1.model.MfriendUser;

public class ModuleWorkUser1
{
	public static void main (String[] args)
	{
		new ModuleWorkUser1 ().start ();
	}

	public void start ()
	{
		HttpResponse<String> response = Unirest.get ("http://192.168.4.1:8089/api/user")
			.header ("accept", "application/json").asString ();

		// System.out.println (response.getBody ());

		ObjectMapper om = new ObjectMapper ();

		// LocalDate 처리를 위한 로직
		om.registerModule (new JavaTimeModule ());
		om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		try
		{
			MfriendUser[] mfriendUser = om.readValue (response.getBody (), MfriendUser[].class);

			long no = 0;

			for (MfriendUser user : mfriendUser)
			{
				if (no == 0)
					no = user.getIdx ();

				System.out.println (user);
			}

			HttpResponse<String> response2 = Unirest.get ("http://192.168.4.1:8089/api/user/" + no)
					.header ("accept", "application/json").asString ();

			MfriendUser oneUser = om.readValue (response2.getBody (), MfriendUser.class);

			System.out.println ("==== One User === ");
			System.out.println (oneUser);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
