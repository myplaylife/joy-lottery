package com.joy.lottery.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangjingbo on 14-10-22.
 */
@XmlRootElement
public class Test implements Serializable {

    private Integer id;
    private String name;
    private List<String> address = Lists.newArrayList();
    private Map<String, String> account = Maps.newHashMap();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Map<String, String> getAccount() {
        return account;
    }

    public void setAccount(Map<String, String> account) {
        this.account = account;
    }
}
