package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.model.MyUser;
import kr.purred.tea.time1.sv.ModuleHttpSv;
import kr.purred.tea.time1.sv.ModulePrintSv;
import lombok.RequiredArgsConstructor;

public class ModuleWorkUser2
{

	private static ModuleHttpSv moduleHttpSv;

	private static ModulePrintSv modulePrintSv;

	public static void main (String[] args)
	{


	public static void main (String[] args)
	{
		new ModuleWorkUser2 ().start ();
	}

	public void start()
	{
		HttpResponse<String> response = moduleHttpSv.getList("http://192.168.4.1:8089/api/myuser");

		System.out.println (response.getBody ());

		ObjectMapper om = new ObjectMapper ();

		// LocalDate 처리를 위한 로직
		om.registerModule (new JavaTimeModule ());
		om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		try
		{

			MyUser[] users = om.readValue (response.getBody (), MyUser[].class);
			modulePrintSv.printUsers(users);

			long no = users[0].getNo();

			HttpResponse<String> response2 = moduleHttpSv.getList("http://192.168.4.1:8089/api/myuser/" + no);

			MyUser user = om.readValue (response2.getBody (), MyUser.class);

			modulePrintSv.printUser(user);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
