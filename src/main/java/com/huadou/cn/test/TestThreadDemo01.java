package com.huadou.cn.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by jinliang on 17/3/14.
 *
 *  测试含有优先级的队列
 */
public class TestThreadDemo01 {

    public static void main(String[] args) {

        Comparator<TestRun> OrderIsdn =  new Comparator<TestRun>(){
            public int compare(TestRun o1, TestRun o2) {
                // TODO Auto-generated method stub
                int numbera = o1.getPopulation();
                int numberb = o2.getPopulation();
                if(numberb > numbera)
                {
                    return 1;
                }
                else if(numberb<numbera)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }

            }



        };
        Queue<TestRun> priorityQueue =  new PriorityQueue<TestRun>( 11,OrderIsdn);

        try {

            priorityQueue.add(new TestRun("test03",3));

            priorityQueue.add(new TestRun("test01",1));

            priorityQueue.add(new TestRun("test02",2));

            while (!priorityQueue.isEmpty()){
               TestRun testRun =  priorityQueue.poll();
               testRun.run();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static class TestRun implements Runnable{
        private String name ;

        private int population;
        public TestRun(String name ,int  population ) {
            this.name = name ;
            this.population = population;

        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public void run() {

            System.out.println("Thread Run: "+ this.name + ", populcation:"+ this.population);

        }
    }
}
