package kr.purred.tea.time1.sv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kr.purred.tea.time1.model.MfriendUser;
import kr.purred.tea.time1.model.MyUser;
import kr.purred.tea.time1.sv.common.ModuleHttpSv;

import java.util.Arrays;
import java.util.List;

public class MyFriendSv implements UserSv {

    private ModuleHttpSv moduleHttpSv = new ModuleHttpSv();

    private static String URL = "http://localhost:8089/api/user/";

    ObjectMapper om = new ObjectMapper ();

    @Override
    public List<MfriendUser> getList() throws JsonProcessingException {
        HttpResponse<String> response = moduleHttpSv.get(URL);

        // LocalDate
        om.registerModule (new JavaTimeModule());
        om.disable (SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        MfriendUser[] users = om.readValue (response.getBody (), MfriendUser[].class);
        List<MfriendUser> list = Arrays.asList(users);

        return list;
    }

    @Override
    public long getNo(Object data) {
        MfriendUser user = (MfriendUser) data;
        return user.getIdx();
    }

    @Override
    public MfriendUser get(long no) throws JsonProcessingException {
        HttpResponse<String> response2 = moduleHttpSv.get(URL + no);
        MfriendUser user = om.readValue (response2.getBody (), MfriendUser.class);

        return user;
    }
}
