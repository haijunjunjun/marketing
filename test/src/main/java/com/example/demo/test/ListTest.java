package com.example.demo.test;

import com.example.demo.test.page.ListPageUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 14:48
 */
public class ListTest {

    public static void main(String[] args) throws ParseException {
//        List<String> list = new ArrayList<>();
//        list.add(0, "a");
//        list.add(0, "b");
//        System.out.println("info is :" + list.toString());

//        Map<String, String> map = new HashMap<>();
//        map.put("a", "111");
//        map.put("a", "222");
//        System.out.println("map is :" + map);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        Map<String, Object> map = new HashMap<>();
//        map.put("expire", new Date());
////        System.out.println(System.currentTimeMillis() - sdf.parse(sdf.format(map.get("expire"))).getTime() >0);
//        System.out.println(System.currentTimeMillis() - sdf.parse(map.get("expire").toString()).getTime() >0);
//        System.out.println(new Date().getTime());


//        System.out.println(getUserPageInfo().toString());
        getUserPageInfo();
    }

    public static void getUserPageInfo() {
        int pageNum = 2;
        int pageSize = 2;
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId("1");
        User user1 = new User();
        user1.setId("2");
        User user2 = new User();
        user2.setId("3");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        ListPageUtil<User> listPageUtil = new ListPageUtil<>(userList, 2, 2);
//        List<User> listPageUtil = userListPageUtil.getPagedList();
        System.out.println(listPageUtil.getPagedList() + "," + listPageUtil.getpageNum() + "," + listPageUtil.getPageSize() + "," + listPageUtil.getTotalCount() + "," + listPageUtil.getTotalPage());

    }


}
