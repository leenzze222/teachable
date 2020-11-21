package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.sv.MyFriendSv;
import kr.purred.tea.time1.sv.common.ModulePrintSv;

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
