package com.msbb.demo.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author vate
 */
@Getter
@AllArgsConstructor
public enum Status {

    ONLINE(0, "在线"),
    OFFLINE(-1, "离线");

    @EnumValue
    private int code;
    private String description;

    public static Status toEnum(int code) {
        return Arrays.stream(Status.values())
                .filter(status -> status.getCode() == code)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
    }
}
