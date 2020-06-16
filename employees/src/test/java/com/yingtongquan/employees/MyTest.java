package com.yingtongquan.employees;

import org.apache.shiro.authc.Account;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MyTest {
    @Test
    public void Test() {
        List<test1> list = new ArrayList();
        list.add(new test1(1, 10));
        list.add(new test1(1, 20));
        list.add(new test1(2, 10));
        list.add(new test1(2, 20));
        Map<Integer, Integer> map = new HashMap();
        for (test1 test1 : list) {
            map.computeIfAbsent(test1.getId(), k -> 0);
            map.put(test1.getId(), map.get(test1.getId()) + test1.getAmount());
        }
        System.out.println(map);
        Set keySet = map.keySet();
        Iterator it1 = keySet.iterator();
        while (it1.hasNext()) {
            Integer ID = (Integer) it1.next();
            Integer stu = map.get(ID);
            System.out.println(stu);
        }
    }


}

class test1 {
    private Integer id;

    private Integer amount;

    public test1() {
    }

    public test1(Integer id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "test1{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}