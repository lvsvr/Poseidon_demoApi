package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.RuleName;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RuleNameServiceTest {

    @Autowired
    private RuleNameService underTest;

    private RuleName rule1 = new RuleName();
    private RuleName rule2 = new RuleName();

    @Test
    void shouldCRUDRuleName(){
//        GIVEN
        rule1.setName("test1");
        rule2.setName("test2");
//        WHEN
        underTest.addRuleName(rule1);
        underTest.addRuleName(rule2);
//        THEN
// Create
        Assert.assertNotNull(rule1.getId());
        Assert.assertEquals(rule1.getName(), "test1","test1");
// Read
        Assert.assertNotNull(underTest.getRuleNameById(rule1.getId()));
        Assert.assertNotNull(underTest.getAllRuleNames());
// Update
//        WHEN
        underTest.updateRuleName(rule1, rule2);
//        THEN
        Assert.assertEquals(rule1.getName(),rule2.getName());

// Delete
//        WHEN
        underTest.deleteRuleName(rule2);
//        THEN
        assertFalse(underTest.getAllRuleNames().contains(rule2));
    }

}