package com.wjn.base.web;

import com.wjn.base.dto.BaseDto;
import com.wjn.base.service.BaseService;
import com.wjn.base.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<TDto extends BaseDto , TService extends BaseService> {
    @Autowired
    protected TService service;

    /**
     * 添加方法
     * @author wujianong
     */
    @PostMapping
    public ResultData create(TDto dto){
        try {
            TDto tDto = (TDto)service.create(dto);
            return ResultData.build(1,"添加成功",tDto);
        }catch (Exception e){
            e.printStackTrace();
            String msg = StringUtils.isEmpty(e.getMessage()) ? "添加失败" :e.getMessage();
            return ResultData.build(0,msg,e.getMessage());
        }
    }

    /**
     * 查询所有方法
     * @return
     */
    @GetMapping
    public ResultData findAll(){
        return ResultData.build(1,"查询成功",service.findAll());
    }

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    @GetMapping("findOneById")
    public ResultData findOneById(@RequestParam("id") String id){
        try {
            TDto tDto = (TDto)service.findOneById(id);
            return ResultData.build(1,"查询详情成功",tDto);
        }catch (Exception e){
            e.printStackTrace();
            String msg = StringUtils.isEmpty(e.getMessage()) ? "查询详情失败" :e.getMessage();
            return ResultData.build(0,msg,e.getMessage());
        }
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @PutMapping("delete")
    public ResultData deleteById(@RequestParam("id") String id){
        try {
            service.delete(id);
            return ResultData.build(1,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            String msg = StringUtils.isEmpty(e.getMessage()) ? "删除失败" :e.getMessage();
            return ResultData.build(0,msg,e.getMessage());
        }
    }

}
