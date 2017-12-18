package bean;

import com.boot.DemobootApplication;
import com.boot.dao.UserinfoMapper;
import com.boot.model.Userinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by wuzm on 2017/12/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemobootApplication.class)
public class mybatisTest1 {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Test
    public void testInsertUser() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("www");
        userinfo.setPassword("123456");
        userinfo.setDescri(UUID.randomUUID().toString());
        userinfoMapper.insert(userinfo);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("www");
        userinfo.setPassword("666666");
        userinfoMapper.updateByPrimaryKey(userinfo);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        String username = "www";
        userinfoMapper.deleteByPrimaryKey(username);
    }
}
