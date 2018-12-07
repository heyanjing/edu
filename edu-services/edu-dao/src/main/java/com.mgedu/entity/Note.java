package com.mgedu.entity;

import com.mgedu.dao.base.BaseEntityWithStringId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.Entity;

@Entity
@Getter
@Setter
//@ApiModel(description = "笔记实体")
public class Note extends BaseEntityWithStringId {
    @NotBlank
    @ApiModelProperty(value = "标题")
    private String title;
    @NotBlank
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "价格")
    private Double money;

    // Getters and Setters ... (Omitted for brevity)
}
