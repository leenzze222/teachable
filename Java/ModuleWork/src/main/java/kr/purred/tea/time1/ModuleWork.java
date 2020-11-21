package kr.purred.tea.time1;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.sv.UserFactory;
import kr.purred.tea.time1.sv.UserSv;
import kr.purred.tea.time1.sv.common.ModulePrintSv;
import kr.purred.tea.time1.type.UserType;

public class ModuleWork
{
	UserFactory userFactory = new UserFactory();

	private ModulePrintSv modulePrintSv = new ModulePrintSv();


	public static void main (String[] args)
	{
		new ModuleWork().start (UserType.FRIEND);
	}

	public void start (UserType type)
	{
		UserSv userSv = userFactory.getSv(type);
//		TODO totalList
//		TODO once return
//		TODO : 제네릭을 더 잘 쓰고 싶은데 잘 모르겠네요.. ㅜㅜ

		try {
			modulePrintSv.printUsers(userSv.getList());
			modulePrintSv.printUser(userSv.get(userSv.getNo(userSv.getList().get(0))));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
