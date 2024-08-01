package com.zmh.trigger.http.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: QuerySeckillGoodsReq
 * @author: zhou ming hao
 * @date: 2024年07月28日 23:40
 */
@Data
public class QuerySeckillGoodsReqDTO {

    @ApiModelProperty(value = "当前页")
    private Integer pageNum;

    @ApiModelProperty(value = "查询条数")
    private Integer limit;
}
