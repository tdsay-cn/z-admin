package com.z.admin.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.z.admin.entity.po.base.BasePo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * <p>
 * 
 * </p>
 *
 * @author system
 * @since 2026-06-08
 */
@Getter
@Setter
@ToString
@TableName("slave_test")
public class SlaveTest{

    /**
     * 主键自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 值
     */
    private String value;
}
