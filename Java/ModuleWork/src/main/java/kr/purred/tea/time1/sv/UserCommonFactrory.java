package kr.purred.tea.time1.sv;

import kr.purred.tea.time1.inter.UserCommon;

public class UserCommonFactrory
{
	public static UserCommon createUserCommon (int type)
	{
		if (type == 0)
			return new UserCmModule ();
		else if (type == 1)
			return new MyUserCmModule ();

		// TODO EXECPTION
		return null;
	}
}
