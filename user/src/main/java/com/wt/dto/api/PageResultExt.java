package com.wt.dto.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wt.enums.CodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class PageResultExt<T,V> extends Result<T> {

    private static final long serialVersionUID = -349725813707749431L;

    private long total = 0;
    private long pageNum = 0;
    private long pageSize = 0;

    @ApiModelProperty(value = "额外数据")
    private V ext;

    //由于无法重载 传null即可
    public static <T,V> PageResultExt<T,V> success(Integer nul) {
        return restResult(null,null, CodeEnum.SUCCESS.getCode(), null);
    }

    public static <T,V> PageResultExt<T,V> data(final T data,final V ext) {
        return restResult(data,ext, CodeEnum.SUCCESS.getCode(), null);
    }

    public static <T,V> PageResultExt<T,V> data(final T data,final V ext, final String msg, final long total, final long pageSize, final long pageNum) {
        final PageResultExt<T,V> pageRetDTO = restResult(data,ext, CodeEnum.SUCCESS.getCode(), msg);
        pageRetDTO.setTotal(total);
        pageRetDTO.setPageSize(pageSize);
        pageRetDTO.setPageNum(pageNum);
        return pageRetDTO;
    }

    public static <T,V> PageResultExt<T,V> data(final T data,final V ext, final long total, final long pageSize, final long pageNum) {
        final PageResultExt<T,V> pageRetDTO = restResult(data,ext, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
        pageRetDTO.setTotal(total);
        pageRetDTO.setPageSize(pageSize);
        pageRetDTO.setPageNum(pageNum);
        return pageRetDTO;
    }

    private static <T,V> PageResultExt<T,V> restResult(final T data,final V ext, final int code, final String msg) {
        final PageResultExt<T,V> apiResult = new PageResultExt<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setExt(ext);
        apiResult.setMsg(msg);
        return apiResult;
    }
    public static <T,V> PageResultExt<List<T>,V> data(IPage<T> iPage,V ext) {
        PageResultExt<List<T>,V> data = PageResultExt.data(iPage.getRecords(),ext, iPage.getTotal(), iPage.getSize(), iPage.getCurrent());

        return data;
    }


}
