package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.purred.tea.time1.model.MyUser;
import kr.purred.tea.time1.sv.MyUserSv;
import kr.purred.tea.time1.sv.common.ModulePrintSv;

import java.util.List;

public class ModuleWorkUser2
{

	private MyUserSv myUserSv = new MyUserSv();

	private ModulePrintSv<MyUser> modulePrintSv = new ModulePrintSv<MyUser>();

	public static void main (String[] args)
	{
		new ModuleWorkUser2 ().start ();
	}

	public void start()
	{
		try
		{
			List<MyUser> myUserList = myUserSv.getList();
			modulePrintSv.printUsers(myUserList);

			long no = myUserList.get(0).getNo();
			MyUser user = myUserSv.get(no);
			modulePrintSv.printUser(user);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
