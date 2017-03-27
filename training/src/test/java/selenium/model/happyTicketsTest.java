package ru.st.selenium.model;

import static org.testng.Assert.*;

/**
 * Created by lenovo on 28.01.2017.
 */
public class happyTicketsTest {


    public void defineQuantity(String[] args) {
        int countOfTickets = 0;
        for (int i = 000000; i < 999999; i++) {
            int i1 = i / 100000 % 10,
                    i2 = i / 10000 % 10,
                    i3 = i / 1000 % 10,
                    i4 = i / 100 % 10,
                    i5 = i / 10 % 10,
                    i6 = i % 10;
            if ((i1 + i2 + i3) == (i4 + i5 + i6)) {
                countOfTickets++;
            }
        }
        System.out.println(countOfTickets);
    }
}