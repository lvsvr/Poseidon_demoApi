package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.RuleName;
import com.poseidon.api.demo.repositories.RuleNameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service JPA
 * @author w-boar
 * @version 1.0
 */

@Service
public class RuleNameService {
    private final RuleNameRepository ruleNameRepository;
    /**
     * @param ruleNameRepository
     */
    public RuleNameService(RuleNameRepository ruleNameRepository) {
        this.ruleNameRepository = ruleNameRepository;
    }
    /**
     * @return ArrayList<RuleName>
     */
    public ArrayList<RuleName> getAllRuleNames(){
        return (ArrayList<RuleName>) ruleNameRepository.findAll();
    }
    /**
     * @return RuleName
     */
    public RuleName addRuleName(RuleName ruleName){
        return ruleNameRepository.save(ruleName);
    }
    /**
     * @return RuleName
     */
    public RuleName getRuleNameById(Integer id){
        return ruleNameRepository.getById(id);
    }

    public void updateRuleName (RuleName ruleName, RuleName updatedRuleName){
        ruleName.setId(updatedRuleName.getId());
        ruleName.setName(updatedRuleName.getName());
        ruleName.setDescription(updatedRuleName.getDescription());
        ruleName.setJson(updatedRuleName.getJson());
        ruleName.setSqlStr(updatedRuleName.getSqlStr());
        ruleName.setSqlPart(updatedRuleName.getSqlPart());
        ruleNameRepository.save(ruleName);
    }

    public void deleteRuleName(RuleName ruleName){
        ruleNameRepository.delete(ruleName);
    }
}
