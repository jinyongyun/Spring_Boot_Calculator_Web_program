package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {
//operand1=11&operator=*&operand2=55 이걸 쪼개야 함
    @Test
    void createTest() {
        //List<QueryString>
        QueryString queryString = new QueryString("operand1","11");
        assertThat(queryString).isNotNull();
    }
}
