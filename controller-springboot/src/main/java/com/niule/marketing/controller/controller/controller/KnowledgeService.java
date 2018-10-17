package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.dal.mapper.KnowRepoMapper;
import com.niule.marketing.controller.controller.dal.model.KnowRepo;
import com.niule.marketing.controller.controller.dal.model.KnowRepoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 15:36
 */
@Service
public class KnowledgeService {

    @Autowired
    private KnowRepoMapper knowRepoMapper;

    public List<KnowRepo> getKnowledgeInfo (){
        KnowRepoExample knowRepoExample = new KnowRepoExample();
        knowRepoExample.createCriteria();
        List<KnowRepo> knowRepos = knowRepoMapper.selectByExample(knowRepoExample);
        if (!Objects.isNull(knowRepos) && knowRepos.size() != 0){
            return knowRepos;
        }
        return null;
    }

    public String addKnowledgeInfo (KnowRepo knowRepo){
        int i = knowRepoMapper.insert(knowRepo);
        if (1 == i){
            return "success";
        }
        return "fail";
    }
}
