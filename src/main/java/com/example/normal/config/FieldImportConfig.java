package com.example.normal.config;


import com.example.normal.annotaion.FieldImport;
import com.example.normal.entity.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ReflectPermission;

@Component
public class FieldImportConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public void loadFieldsImportIntoRedis(){
        Class<Doctors> doctorsClass = Doctors.class;
        Field[] declaredFields = doctorsClass.getDeclaredFields();
        String[] arr = new String[declaredFields.length];
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(FieldImport.class)){

                FieldImport annotation = field.getAnnotation(FieldImport.class);
                arr[annotation.orderValue() - 1] = annotation.clownName();

            }
        }

        redisTemplate.opsForValue().set("Doctors",arr);
    }



}
