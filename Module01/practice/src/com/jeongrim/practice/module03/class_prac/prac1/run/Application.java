package com.jeongrim.practice.module03.class_prac.prac1.run;

import com.jeongrim.practice.module03.class_prac.prac1.dto.ProductDTO;

public class Application {
    public static void main(String[] args) {
        ProductDTO[] product = new ProductDTO[3];

        product[0] = new ProductDTO("ssgnote9", "갤럭시노트9", "경기도 수원", 960000, 10.0);
        product[1] = new ProductDTO("lgxnote5", "LG스마트폰5", "경기도 평택", 780000, 0.7);
        product[2] = new ProductDTO("ktsnote3", "KT스마트폰3", "서울시 강남", 250000, 0.3);

        for (int i = 0; i <product.length; i++) {
            System.out.println(product[i].getInformation());
        }

        System.out.println("=============================================");

        for (int i = 0; i < product.length; i++) {
            product[i].setPrice(1200000);
            product[i].setTax(0.05);
            System.out.println(product[i].getInformation());
        }

        System.out.println("============================================");

        for (int i = 0; i < product.length; i++) {
            System.out.println("상품명 = " + product[i].getProductName());
            System.out.println("부가세 포함 가격 = " + (int) ((product[i].getPrice())+(product[i].getPrice() * product[i].getTax())) + "원");
        }

    }
}
