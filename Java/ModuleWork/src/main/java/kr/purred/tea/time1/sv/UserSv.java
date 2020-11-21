package kr.purred.tea.time1.sv;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface UserSv<T> {

    List<T> getList() throws JsonProcessingException;

    long getNo(T data);

    T get(long no) throws JsonProcessingException;
}
