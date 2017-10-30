package com.bluexiii.zen.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by bluexiii on 21/06/2017.
 */
@ApiModel("产品定义")
@Entity
@Table(name = "TD_B_PRODUCT", schema = "UCR_CEN1")
@Getter
@Setter
@ToString
public class TdBProduct {
    @ApiModelProperty(value = "产品编码", example = "99999830")
    @Id
    private Long productId;
    @ApiModelProperty(value = "产品名称", example = "产品名称")
    private String productName;
}
