package com.busanit501.springex.sample;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@RequiredArgsConstructor
@Service
public class SampleService {

    @Autowired
    @Qualifier("event")
    private SampleDAO sampleDAO;

    //@RequiredArgsConstructor 와 같이 설정되어야 한다.
//    private final SampleDAO sampleDAO;



}
