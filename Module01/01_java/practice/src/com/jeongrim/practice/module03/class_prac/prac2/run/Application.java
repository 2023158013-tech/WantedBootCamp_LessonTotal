package com.jeongrim.practice.module03.class_prac.prac2.run;

import com.jeongrim.practice.module03.class_prac.prac2.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO book = new BookDTO();
        System.out.println(book.getInformation());
        BookDTO bookRe = new BookDTO("자바의 정석", 20000, 0.2, "윤상섭");
        System.out.println(bookRe.getInformation());
        System.out.println("==================================");

        book.setTitle("C언어");
        book.setPrice(30000);
        book.setDiscountRate(0.1);
        book.setAuthor("홍길동");
        System.out.println("수정된 결과 확인");
        System.out.println(book.getInformation());
        System.out.println("==================================");


        System.out.println("도서명 = " + book.getTitle());
        System.out.println("할인된 가격 = " + (int) ((book.getPrice()) - (book.getPrice())*(book.getDiscountRate())) + "원");
        System.out.println("도서명 = " + bookRe.getTitle());
        System.out.println("할인된 가격 = " + (int) ((bookRe.getPrice()) - (bookRe.getPrice())*(bookRe.getDiscountRate())) + "원");


    }
}
