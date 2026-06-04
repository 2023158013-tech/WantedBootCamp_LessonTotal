package com.wanted.b_collection.a_list.compare;

import com.wanted.b_collection.a_list.dto.BookDTO;

import java.util.Comparator;

public class AscendingTitle implements Comparator<BookDTO> {

    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        int result = 0;

        //o1이 정렬 먼저 되고 o2가 o1 다음으로 정렬된다면,
        // 오름차순에서 o1이 o2보다 크면 o1이 뒤로 가야함(result = 1(자리 바꿔))
        //1: 자리 바꿔, -1: 순서 맞으니까 가만히 있어, 0: 똑같으니까 아무나 들어와도 돼
        if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
            result = 1;
        } else if (o2.getTitle().compareTo(o1.getTitle()) > 0) {
            result = -1;
        } else {
            result = 0;
        }
        return result;
    }
}

