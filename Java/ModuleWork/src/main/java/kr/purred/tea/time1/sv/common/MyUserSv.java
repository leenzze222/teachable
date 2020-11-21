package kr.purred.tea.time1.sv.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kr.purred.tea.time1.model.MyUser;

import java.util.Arrays;
import java.util.List;

public class MyUserSv {

    private ModuleHttpSv moduleHttpSv = new ModuleHttpSv();

    private static String URL = "http://localhost:8089/api/myuser/";

    ObjectMapper om = new ObjectMapper ();

    public List<MyUser> getList() throws JsonProcessingException {
        HttpResponse<String> response = moduleHttpSv.get(URL);

        System.out.println (response.getBody ());

        // LocalDate
        om.registerModule (new JavaTimeModule());
        om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        MyUser[] users = om.readValue (response.getBody (), MyUser[].class);
        List<MyUser> list = Arrays.asList(users);

        return list;
    }

    public MyUser get(long no) throws JsonProcessingException {
        HttpResponse<String> response2 = moduleHttpSv.get(URL + no);
        MyUser user = om.readValue (response2.getBody (), MyUser.class);

        return user;
    }
}
