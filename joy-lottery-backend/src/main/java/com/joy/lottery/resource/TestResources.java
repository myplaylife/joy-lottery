package com.joy.lottery.resource;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.joy.lottery.model.Test;
import com.joy.lottery.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangjingbo on 14-10-22.
 */
@Path("/test")
@Controller
@Scope("prototype")
public class TestResources {

    @Autowired
    private TestService testService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Test get(@PathParam("id") String id) {
        System.out.println(id);
        System.out.println(testService.test());
        Test test = new Test();
        test.setName("string");
        test.setId(0);
        List<String> list = Lists.newArrayList();
        list.add("shenyang");
        list.add("beijing");
        test.setAddress(list);
        Map<String,String> map = Maps.newHashMap();
        map.put("alipay", "adsfaf");
        map.put("iqiyi", "asdfasf");
        test.setAccount(map);
        return test;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Test test) {
        System.out.println(test.getId());
        System.out.println(test.getName());
        for (String str : test.getAddress()) {
            System.out.println(str);
        }
        for (String key : test.getAccount().keySet()) {
            System.out.println(key + " : " + test.getAccount().get(key));
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(Test test) {
        System.out.println(test.getId());
        System.out.println(test.getName());
        System.out.println(test.getAddress());
        System.out.println(test.getAccount());
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        System.out.println(id);
    }
}
