package kr.purred.tea.time1.sv.common;

import kr.purred.tea.time1.model.MyUser;

import java.util.List;

public class ModulePrintSv<T> {
    public void printUsers(List<T> users) {

        for (T user : users)
        {
            printUser(user);
        }
    }

    public void printUser(T user) {

        System.out.println (user);
    }
}
