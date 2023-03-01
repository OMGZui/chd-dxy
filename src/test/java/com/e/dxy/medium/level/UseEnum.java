package com.e.dxy.medium.level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 9/1/22 11:37 AM
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UseEnum {

    MAN(1, "男"),
    WOMEN(2, "女");

    private Integer code;

    private String desc;


    private static Map<Integer, UseEnum> useEnumMap = Arrays.stream(values()).collect(Collectors.toMap(UseEnum::getCode, o -> o));


    public static UseEnum getByCode(Integer code){
        for (UseEnum useEnum : UseEnum.values()){
            if (useEnum.code.equals(code)){
                return useEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(UseEnum.getByCode(2));
        System.out.println(useEnumMap.get(3));
        BigDecimal a = BigDecimal.valueOf(35634535255456719.22345634534124578902);
        System.out.println(a.toString());
    }
}
