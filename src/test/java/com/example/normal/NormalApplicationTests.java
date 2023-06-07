package com.example.normal;



import com.example.normal.entity.Doctors;
import com.example.normal.mapper.DoctorsMapper;
import com.example.normal.service.HelloSend;
import com.example.normal.service.impl.DoctorsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
class NormalApplicationTests {

    @Resource
    private DoctorsMapper doctorsMapper;
    @Resource
    private HelloSend helloSend;
    @Resource
    private DoctorsServiceImpl doctorsServiceImpl;

    @Test
    public void contextLoads() {

        helloSend.send();
    }

    @Test
    public void test1(){
        Doctors doctors = new Doctors();
        doctors.setName("rr");
        doctors.setAge(1);
        doctors.setId(2);
        doctorsMapper.insert(doctors);
    }

    @Test
    public void test2(){
        doctorsServiceImpl.testing();
    }

    @Test
    public void test3(){

        Set<Integer> phoneList = new HashSet<>();
        phoneList.add(12);
        phoneList.add(13);
        phoneList.add(14);
        phoneList.add(15);

        for (Integer integer : phoneList) {
            System.out.println(integer);
        }
    }

}
