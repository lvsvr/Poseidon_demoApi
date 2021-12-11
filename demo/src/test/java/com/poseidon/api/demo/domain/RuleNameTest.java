package com.poseidon.api.demo.domain;

import com.poseidon.api.demo.repositories.RuleNameRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RuleNameTest {

    private RuleName rule0 = new RuleName();

    @Autowired
    private RuleNameRepository ruleRepo;

    @Test
    void shouldGetRuleName() {
//        WHEN
        rule0.setId(1);
        rule0.setDescription("d0");
        rule0.setJson("test");
        rule0.setSqlStr("test");
        rule0.setSqlPart("test");
//        THEN
        Assert.assertNotNull(rule0.getId());
        assertEquals("d0", rule0.getDescription());
        assertEquals("test", rule0.getJson());
        assertEquals("test", rule0.getSqlStr());
        assertEquals("test", rule0.getSqlPart());
        Assert.assertNotNull(rule0.toString());
    }

}