package com.yingtongquan.system;

import com.yingtongquan.system.user.pojo.LuckyDraw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyTest {

    public static void main(String[] args) {

//        System.out.println(JSON.toJSONString(lotteryTurntable()));

        Random random = new Random();
        String v = String.valueOf(random.nextDouble()).substring(0, 4);
        System.out.println(duageAward(v, LUCKY_DRAWS));


    }

    private final static List<LuckyDraw> LUCKY_DRAWS = new ArrayList<LuckyDraw>() {{
        add(new LuckyDraw(1, 1, 0.10,null));
        add(new LuckyDraw(2, 2, 0.20,null));
        add(new LuckyDraw(3, 3, 0.30,null));
        add(new LuckyDraw(4, 4, 0.40,null));
        add(new LuckyDraw(5, 5, 0.50,null));
        add(new LuckyDraw(6, 6, 1d,null));
    }};

    public static LuckyDraw duageAward(String randomNumber, List<LuckyDraw> awardList) {
        for (LuckyDraw award : awardList) {
            if (Double.valueOf(randomNumber) <= award.getChance()) {
                System.out.println(randomNumber + "         " + award.getChance());
                return award;
            }
        }
        return null;
    }


//    public static LuckyDraw lotteryTurntable() {
//        List<LuckyDraw> luckyDraws = LUCKY_DRAWS;
//
//        Long result = randomnum(1, 1000);
//
//        int line = 0;
//        int temp = 0;
//        LuckyDraw returnobj = null;
//        int index = 0;
//        System.out.println(luckyDraws.size());
//        for (int i = 0; i <= luckyDraws.size(); i++) {
//            LuckyDraw luckyDraw = luckyDraws.get(i);
//            Integer chance = luckyDraw.getChance();
//            System.out.println(chance);
//            temp = temp + chance;
//            line = 100 - temp;
//            if (chance != 0) {
//                if (result > line && result <= (line + chance)) {
//                    returnobj = luckyDraw;
//                    break;
//                }
//            }
//        }
//        return returnobj;
//    }
//
//
//    /**
//     * @Date 2020/6/3 11:26
//     * @Author 胖
//     * 获取传入的两个值之间的随机数
//     **/
//    private static Long randomnum(int smin, int smax) {
//        int range = smax - smin;
//        double rand = Math.random();
//        return (smin + Math.round(rand * range));
//    }
//
//    @Test
//    private void test1(){
//        Random random = new Random();
//        double v = random.nextDouble();
//        System.out.println(v);
//    }

}
