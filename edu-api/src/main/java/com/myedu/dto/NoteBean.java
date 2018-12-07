package com.myedu.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author heyanjing
 * date:2018-12-07 2018/12/7:15:37
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteBean {
    protected String id;
    protected String createUserId;
    protected Date createDateTime;
    protected String updateUserId;
    protected Date updateDateTime;
    protected Integer state;
    private String title;
    private String content;
    private Double money;

}
