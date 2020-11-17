package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.sv.UserCmModule;

public class ModuleWorkUser1
{
	public static void main (String[] args)
	{
		new ModuleWorkUser1 ().start ();
	}

	public void start ()
	{
		UserCmModule userCm = new UserCmModule ();

		try
		{
			MfriendUser[] mfriendUser = userCm.getUsers ();

			long no = 0;

			for (MfriendUser user : mfriendUser)
			{
				if (no == 0)
					no = user.getIdx ();

				System.out.println (user);
			}

			MfriendUser oneUser = userCm.getUser (no);

			System.out.println ("==== One User === ");
			System.out.println (oneUser);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}
	}
}
