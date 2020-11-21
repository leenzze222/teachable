package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.model.MyUser;
import kr.purred.tea.time1.sv.common.ModulePrintSv;
import kr.purred.tea.time1.sv.common.MyFriendSv;

import java.util.List;

public class ModuleWorkUser1
{
    
    private MyFriendSv myFriendSv = new MyFriendSv();

    private ModulePrintSv<MfriendUser> modulePrintSv = new ModulePrintSv<MfriendUser>();


	public static void main (String[] args)
	{
		new ModuleWorkUser1 ().start ();
	}

	public void start ()
	{
		try
		{
			List<MfriendUser> myUserList = myFriendSv.getList();
			modulePrintSv.printUsers(myUserList);

			long no = myUserList.get(0).getIdx();
			MfriendUser user = myFriendSv.get(no);
			modulePrintSv.printUser(user);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
