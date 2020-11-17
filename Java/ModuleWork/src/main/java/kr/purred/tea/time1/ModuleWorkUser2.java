package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.purred.tea.time1.model.MyUser;
import kr.purred.tea.time1.sv.MyUserCmModule;

public class ModuleWorkUser2
{
	public static void main (String[] args)
	{
		new ModuleWorkUser2 ().start ();
	}

	public void start()
	{
		MyUserCmModule module = new MyUserCmModule ();

		try
		{
			MyUser[] users = module.getUsers ();

			long no = 0;

			for (MyUser user : users)
			{
				if (no == 0)
					no = user.getNo ();

				System.out.println (user);
			}

			MyUser user = module.getUser (no);

			System.out.println (user);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
