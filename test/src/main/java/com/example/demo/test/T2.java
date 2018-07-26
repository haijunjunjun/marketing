package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class T2 {
    public static void main(String[] args) {
        int a[] = {2, 5, 3, 1, 7, 0, 8, 9};
        maoPaoPaiXu(a);
    }

    public static void maoPaoPaiXu(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int temp;
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
//            log.info("info is :" + a[i]);
            System.out.print(a[i]);
        }
    }

    public static void chaRuPaiXu (int a[]){

    }


}
