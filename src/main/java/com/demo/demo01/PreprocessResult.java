package main.java.com.demo.demo01;

import java.util.Map;

public class PreprocessResult {
    private Map<String, String> reqMap;

    private String domainId;

    private String reqNo;

    public Map<String, String> getReqMap() {
        return reqMap;
    }

    public void setReqMap(Map<String, String> reqMap) {
        this.reqMap = reqMap;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }
}
