package com.mgedu.dao.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * 使用条件：
 * 当我们进行开发项目时，我们经常会用到实体映射到数据库表的操作，此时我们经常会发现在我们需要隐射的几个实体类中，有几个共同的属性，例如编号ID，创建者，创建时间，修改者，修改时间，备注等。遇到这种情况，我们可能会想到把这些属性抽象出来当成一个父类，然后再以不同的实体类来继承这个父类。
 * 那么，我们便可以使用@MappedSuperclass注解，通过这个注解，我们可以将该实体类当成基类实体，它不会隐射到数据库表，但继承它的子类实体在隐射时会自动扫描该基类实体的隐射属性，添加到子类实体的对应数据库表中。
 * 使用环境：
 * 1.@MappedSuperclass注解使用在父类上面，是用来标识父类的
 * 2.@MappedSuperclass标识的类表示其不能映射到数据库表，因为其不是一个完整的实体类，但是它所拥有的属性能够隐射在其子类对用的数据库表中
 * 3.@MappedSuperclass标识得嘞不能再有@Entity或@Table注解
 * <p>
 * 每张表都存在的字段
 */
@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntityWithStringId extends com.example.demo.entity.base.BaseEntity<String> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true)
    @ApiModelProperty(value ="id" ,hidden = true)
    protected String id;
    @ApiModelProperty(value = "创建人",hidden = true)
    protected String createUserId;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @ApiModelProperty(value = "创建时间",hidden = true)
    protected Date createDateTime;
    @ApiModelProperty(value = "更新人",hidden = true)
    protected String updateUserId;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @ApiModelProperty(value = "更新时间",hidden = true)
    protected Date updateDateTime;
    @ApiModelProperty(value = "状态时间",hidden = true)
    protected Integer state;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

}
