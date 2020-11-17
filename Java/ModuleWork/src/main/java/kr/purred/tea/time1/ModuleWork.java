package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

import kr.purred.tea.time1.inter.UserCommon;
import kr.purred.tea.time1.inter.UserModel;
import kr.purred.tea.time1.sv.UserCommonFactrory;

public class ModuleWork
{
	final UserCommon userCommon;

	public ModuleWork (UserCommon userCommon)
	{
		this.userCommon = userCommon;
	}

	public static void main (String[] args)
	{
		UserCommon userCommon = UserCommonFactrory.createUserCommon (0);

		new ModuleWork(userCommon).start ();
	}

	public void start ()
	{
		try
		{
			List<UserModel> users = userCommon.getCommonAll ();

			for (UserModel user : users)
			{
				System.out.println (user);
			}

			UserModel oneUser = userCommon.getCommonOne (users.get (1).getPk ());

			System.out.println ("==== One User === ");
			System.out.println (oneUser);

		} catch (JsonProcessingException e)
		{
			e.printStackTrace ();
		}

	}
}
