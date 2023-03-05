package com.example.normal;

import com.example.normal.entity.Doctors;
import com.example.normal.mapper.DoctorsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class NormalApplicationTests {

    @Resource
    private DoctorsMapper doctorsMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        Doctors doctors = new Doctors();
        doctors.setName("rr");
        doctors.setAge(1);
        doctors.setId(2);
        doctorsMapper.insert(doctors);
    }


}
