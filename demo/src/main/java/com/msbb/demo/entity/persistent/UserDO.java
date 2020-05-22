package com.msbb.demo.entity.persistent;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.msbb.demo.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vate
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class UserDO {
    @TableId(value = "uuid",type = IdType.ASSIGN_UUID)
    String uuid;
    String userName;
    String password;
    Status status;
}
