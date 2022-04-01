package com.example.tddstudy;

import com.example.tddstudy.bank.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AccountTest {

    private Account account;
    
    private void setUp(int money) {
        account= new Account(money);
    }
    
    @Test
    public void testAccount() throws Exception {
        setUp(10000);
    }

    @Test
    public static void main(String[] args) {
        AccountTest accountTest = new AccountTest();
        try {
            accountTest.testAccount();
            accountTest.testGetBalance();
        } catch (Exception e) {
            System.out.println("실패(x)");
            return;
        }
        System.out.println("success(O)");
    }

    @Test
    public void testGetBalance() throws Exception {
        //10000원으로 계좌 생성 -> 잔고 조회 결과 일치 : 시나리오
        setUp(10000);
        assertEquals(10000, account.getBalance(), "10000원으로 계좌 생성 후 잔고 조회");

        setUp(1000);
        assertEquals(1000, account.getBalance());

        setUp(0);
        assertEquals(0, account.getBalance());

    }

    @Test
    @DisplayName(value = "입금")
    void 입금하기() throws Exception {
        setUp(10000);
        account.deposit(1000);
        assertEquals(11000, account.getBalance(), "계좌 잔액이 맞지 않습니다.");
    }


    @Test
    @DisplayName(value = "출금")
    void 출금하기() throws Exception{
        setUp(10000);
        account.withraw(1000);
        assertEquals(9000, account.getBalance(), "출금하기");
    }

    @Test
    void setUp테스트(){
        setUp(10000);
        assertEquals(account.getBalance(), 10000);
    }




}
