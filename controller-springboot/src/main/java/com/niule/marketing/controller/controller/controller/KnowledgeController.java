package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.CodeResponse;
import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.dal.model.KnowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 15:36
 */
@RestController
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    @Description("知识库信息查询")
    @RequestMapping(value = "/market/knowledge/info", method = RequestMethod.POST)
    public DataResponse getKnowledgeInfo() {
        return DataResponse.success(knowledgeService.getKnowledgeInfo());
    }

    @Description("知识库信息增加")
    @RequestMapping(value = "/market/knowledge/info/add", method = RequestMethod.POST)
    public DataResponse addKnowledgeInfo(@Valid @NotNull @RequestBody(required = true) KnowRepo knowRepo) {
        String s = knowledgeService.addKnowledgeInfo(knowRepo);
        if ("success".equals(s)) {
            return DataResponse.success(s);
        }
        return DataResponse.error(new CodeResponse(400020, "添加失败"));
    }

    @Description("知识库信息编辑")
    @RequestMapping(value = "/market/knowledge/info/edit",method = RequestMethod.POST)
    public DataResponse editKnowledgeInfo (@Valid @NotNull @RequestBody(required = true) KnowRepo knowRepo){
        return DataResponse.success(null);
    }

    @Description("知识库信息删除")
    @RequestMapping(value = "/market/knowledge/info/delete",method = RequestMethod.POST)
    public DataResponse deleteKnowledgeInfo (@Valid @NotNull @RequestBody(required = true) KnowRepo knowRepo){
        return DataResponse.success(null);
    }
}
