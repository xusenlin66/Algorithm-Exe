package main.java.com.demo.demo01;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Long id = 123456L;
        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setId(id);
        messageRecord.setOperate("update");
        messageRecord.setTime(new Date());

        PreprocessResult result = preprocess(messageRecord);
        System.out.println("error message: " + messageRecord.getError());
        System.out.println(result);
    }

    private static PreprocessResult preprocess(MessageRecord messageRecord) {
        String errorMessage;
        boolean flag = true;
        if (flag) {
            errorMessage = "根据id查询信息为null, 消费失败";
            messageRecord.setError(errorMessage);
            return null;
        }
        PreprocessResult result = new PreprocessResult();
        result.setDomainId("111");
        return result;
    }
}
