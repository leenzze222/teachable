package kr.purred.tea.time1.sv;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class ModuleHttpSv {

    public HttpResponse<String> getList(String url) {
        HttpResponse<String> response = Unirest.get (url)
                .header ("accept", "application/json").asString ();

        return response;
    }
}
