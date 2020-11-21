package kr.purred.tea.time1.sv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.purred.tea.time1.model.MyUser;

public class ModulePrintSv {
    public void printUsers(MyUser[] users) throws JsonProcessingException {

        for (MyUser user : users)
        {
            printUser(user);
        }
    }

    public void printUser(MyUser user) throws JsonProcessingException {

        System.out.println (user);
    }
}
