package com.wjn.base.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData {
    // 响应业务状态  1:成功   0：失败
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResultData build(Integer status , String msg , Object data){
        return new ResultData(status , msg , data);
    }

}
