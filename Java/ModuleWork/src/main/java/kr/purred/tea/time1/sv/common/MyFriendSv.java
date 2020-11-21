package kr.purred.tea.time1.sv.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.model.MyUser;

import java.util.Arrays;
import java.util.List;

public class MyFriendSv {

    private ModuleHttpSv moduleHttpSv = new ModuleHttpSv();

    private static String URL = "http://localhost:8089/api/user/";

    ObjectMapper om = new ObjectMapper ();

    public List<MfriendUser> getList() throws JsonProcessingException {
        HttpResponse<String> response = moduleHttpSv.get(URL);

        System.out.println (response.getBody ());

        // LocalDate
        om.registerModule (new JavaTimeModule());
        om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        MfriendUser[] users = om.readValue (response.getBody (), MfriendUser[].class);
        List<MfriendUser> list = Arrays.asList(users);

        return list;
    }

    public MfriendUser get(long no) throws JsonProcessingException {
        HttpResponse<String> response2 = moduleHttpSv.get(URL + no);
        MfriendUser user = om.readValue (response2.getBody (), MfriendUser.class);

        return user;
    }
}
