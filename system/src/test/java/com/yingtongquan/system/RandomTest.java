package com.yingtongquan.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {
    /**
     * 大转盘抽奖
     *
     * @author wangbo
     * @date 2019-05-22 14:54:47
     */

    public static void main(String[] args) {

        List<Award> awardList = new ArrayList<Award>();
        Award award1 = new Award();
        award1.setAwardName("手机");//10%
        award1.setProbability(0.1);
        awardList.add(award1);

        Award award2 = new Award();
        award2.setAwardName("水杯");//20%
        award2.setProbability(0.2 + 0.1);//概率加上上一个奖品的概率（累加）
        awardList.add(award2);

        Award award4 = new Award();
        award4.setAwardName("鼠标");//10%
        award4.setProbability(0.1 + 0.2 + 0.1);
        awardList.add(award4);

        Award award5 = new Award();
        award5.setAwardName("谢谢惠顾");//60%
        award5.setProbability(1d);//最后一个肯定是1
        awardList.add(award5);

        Random random = new Random();
        int a = 0, b = 0, c = 0, d = 0;
//        for (int i = 0; i < 10000; i++) {

            Double userSelect = random.nextDouble();//0.0-1.0的double随机数（不包括1.0）
            String awardName = duageAward(userSelect, awardList);
            //信息统计
            if ("手机".equals(awardName)) {
                a++;
            } else if ("水杯".equals(awardName)) {
                b++;
            } else if ("鼠标".equals(awardName)) {
                c++;
            } else if ("谢谢惠顾".equals(awardName)) {
                d++;
            }
//        }
        System.out.println("手机 " + a + " 次");
        System.out.println("水杯 " + b + " 次");
        System.out.println("鼠标 " + c + " 次");
        System.out.println("谢谢惠顾 " + d + " 次");
    }

    /**
     * 选奖品
     *
     * @param userSelect
     * @param awardList
     * @return
     */
    public static String duageAward(Double userSelect, List<Award> awardList) {
        for (Award award : awardList) {
            if (userSelect < award.getProbability()) {
                return award.getAwardName();
            }
        }
        return null;
    }

}


class Award {
    private String awardName;
    private Double probability;

    public String getAwardName() {
        return awardName;
    }

    public Double getProbability() {
        return probability;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

}

