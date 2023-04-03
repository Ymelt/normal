package com.example.normal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.normal.common.Result;
import com.example.normal.entity.Doctors;
import com.example.normal.mapper.DoctorsMapper;
import com.example.normal.service.DoctorsService;
import com.example.normal.util.Base64;
import com.example.normal.util.JsonUtils;
import com.google.code.kaptcha.Producer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FastByteArrayOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@Service
public class DoctorsServiceImpl extends ServiceImpl<DoctorsMapper, Doctors> implements DoctorsService{

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public int batchInsert(List<Doctors> list) {
        return baseMapper.batchInsert(list);
    }

    @Async("taskExecutor")
    @Override
    public void machThread() {
        LambdaQueryWrapper<Doctors> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Doctors::getId,1);
        Doctors doctors = baseMapper.selectById(1);
        doctors.setAge(doctors.getAge() + 1);
        baseMapper.update(doctors,wrapper);
//        try {
//            Thread.sleep(5000);
//            System.out.println("done");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }




    }

    @Override
    public Result getInToTomorrow() {
        List<Doctors> list = this.list(null);
        machThread();
        return JsonUtils.success(list);
    }

    @Override
    public Result insertGoing() {
        List<Doctors> list = new ArrayList<>();
        for (int i = 0; i < 10000;i++){
            Doctors doctors = new Doctors();
            doctors.setName("heh");
            doctors.setAge(i);
            list.add(doctors);
        }
//        this.saveBatch(list);
        baseMapper.batchInsert(list);
        return JsonUtils.success(null);
    }

    public void testing(){
        // 保存验证码信息
        String uuid = UUID.randomUUID().toString();
        String verifyKey = "CacheConstants" + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码

        String capText = "12+24=@36";
        capStr = capText.substring(0, capText.lastIndexOf("@"));
        code = capText.substring(capText.lastIndexOf("@") + 1);
        image = captchaProducerMath.createImage(capStr);


//        redisCache.setCacheObject(verifyKey, code, 2, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            System.out.println("exception:" + e.getMessage());;
        }

        stringRedisTemplate.opsForValue().set(verifyKey, code, 2, TimeUnit.MINUTES);

        System.out.println(Base64.encode(os.toByteArray()));
    }




}
