package top.lookingsky;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.mongodb.client.model.Filters.in;

/**
 * Created by liming on 2018/1/29.
 */
public class MongoTest {
    MongoClient mongoClient = null;
    MongoDatabase database=null;
    MongoCollection<Document> coll=null;

    @Before
    public void before() {
        //获取一个连接
        mongoClient = new MongoClient("192.168.2.130", 27017);
        //得到一个数据库
        database= mongoClient.getDatabase("test");
        //获得集合，如果没有则创建
         coll = database.getCollection("coll");
    }

    @Test
    public void testInsert() {

    }
    @Test
    public void testFind(){
        FindIterable<Document> documents = coll.find(in("name", 1, 2, 3));
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    @After
    public void after(){
        mongoClient.close();
    }
}
