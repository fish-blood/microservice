package com.wt.dto.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wt.enums.CodeEnum;
import com.wt.exception.UserException;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页实体类
 *
 * @author unicorn
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "统一响应分页消息报文")
public class PageResult<T> extends Result<T> {

    private static final long serialVersionUID = -349725813707749431L;

    private long total = 0;
    private long pageNum = 0;
    private long pageSize = 0;

    public static <T> PageResult<T> success() {
        return restResult(null, CodeEnum.SUCCESS.getCode(), null);
    }

    public static <T> PageResult<T> data(final T data) {
        return restResult(data, CodeEnum.SUCCESS.getCode(), null);
    }

    public static <T> PageResult<T> data(final T data, final String msg, final long total, final long pageSize, final long pageNum) {
        final PageResult<T> pageRetDTO = restResult(data, CodeEnum.SUCCESS.getCode(), msg);
        pageRetDTO.setTotal(total);
        pageRetDTO.setPageSize(pageSize);
        pageRetDTO.setPageNum(pageNum);
        return pageRetDTO;
    }

    public static <T> PageResult<T> data(final T data, final long total, final long pageSize, final long pageNum) {
        final PageResult<T> pageRetDTO = restResult(data, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
        pageRetDTO.setTotal(total);
        pageRetDTO.setPageSize(pageSize);
        pageRetDTO.setPageNum(pageNum);
        return pageRetDTO;
    }

    private static <T> PageResult<T> restResult(final T data, final int code, final String msg) {
        final PageResult<T> apiResult = new PageResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
    public static <T> PageResult<List<T>> data(IPage<T> iPage) {
        PageResult<List<T>> data = PageResult.data(iPage.getRecords(), iPage.getTotal(), iPage.getSize(), iPage.getCurrent());

        return data;
    }

    /** 检查并抛出异常 慎用,如果想捕获异常请勿使用 **/
    public Result<T> check() {
        if(ResultCode.SUCCESS.code != super.getCode()){
            throw new UserException(super.getCode(),super.getMsg(),super.getStack());
        }else{
            if(super.getData() == null){
                this.setData(super.getInstanceOfT());
            }
        }
        return this;
    }

    /** 检查并忽略异常(data设置为一个属性都为null的对象) 慎用,如果想捕获异常请勿使用 **/
    public Result<T> checkIgnore() {
        if(ResultCode.SUCCESS.code != super.getCode()){
            this.setCode(ResultCode.SUCCESS.code);
            this.setData(super.getInstanceOfT());
        }
        return this;
    }

}
