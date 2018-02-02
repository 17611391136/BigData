package top.lookingsky;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.lookingsky.entity.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 李明 on 2018/1/30.
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoSpringTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test1(){
        Log log1 = new Log();
        log1.setId(UUID.randomUUID().toString());
        log1.setName("ceshi");
        log1.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        log1.setOperation("查询");
        List<Log> list =new ArrayList<Log>();
        list.add(log1);
        mongoTemplate.insertAll(list);
    }

    @Test
    public void test2(){
        List<Log> all = mongoTemplate.findAll(Log.class);
        System.out.println(all);
    }
}
