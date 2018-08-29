package dal;

import com.niule.marketing.control.dal.mapper.UserInfoMapper;
import com.niule.marketing.control.dal.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author haijun
 * @create 2018 - 08 - 27 - 17:01
 */
public class UserInfoMapperTest extends BaseTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void getUserInfo() {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
        System.out.println("name is :" + userInfo.getRealName());
    }
}
