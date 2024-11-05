package com.illuminatechain.techtriviaquiz.common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


/**
 * GenericEnumAttributeConverter 클래스는 데이터베이스 열 값을 Enum 타입으로,
 * Enum 타입을 데이터베이스 열 값으로 변환하기 위한 JPA AttributeConverter를 제공합니다.
 *
 * @param <E> 변환할 Enum 타입. Enum은 IntEnum 인터페이스를 구현해야 합니다.
 */
@Converter
public class GenericEnumAttributeConverter<E extends Enum<E> & IntEnum> implements AttributeConverter<E, Integer> {

    private final Class<E> enumClass;

    public GenericEnumAttributeConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    /**
     * Enum 인스턴스를 데이터베이스 열 값으로 변환합니다.
     *
     * @param attribute 변환할 Enum 인스턴스. null일 수도 있습니다.
     * @return Enum 인스턴스에 대응하는 데이터베이스 열 값. Enum 인스턴스가 null인 경우 null을 반환합니다.
     */
    @Override
    public Integer convertToDatabaseColumn(E attribute) {
        return (attribute != null) ? attribute.getValue() : null;
    }

//
//    @Override
//    public E convertToEntityAttribute(Integer dbData) {
////        return (dbData != null) ? enumClass.getEnum(enumClass, dbData) : null;
//        return (dbData != null) ? getEnum(enumClass, dbData) : null;
//    }
//
//    //todo : Enum 클래스,int 넘겨 받아서 string(enum) 추출
//    private E getEnum(E enumClassTemp, int value) {
//        for (E enumConstant : enumClassTemp.getDeclaringClass().getEnumConstants()) {
//            if (enumConstant.na == value) return enumConstant;
//        }
//        throw new IllegalArgumentException("Invalid value: " + value);
//    }
//

    /**
     * 데이터베이스 열 값을 해당하는 Enum 인스턴스로 변환합니다.
     *
     * @param dbData 데이터베이스에서 읽어온 열 값. null일 수도 있습니다.
     * @return 데이터베이스 열 값에 대응하는 Enum 인스턴스. dbData가 null인 경우 null을 반환합니다.
     * @throws IllegalArgumentException 유효하지 않은 값이 전달된 경우
     */
    @Override
    public E convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        for (E enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getValue() == dbData) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("Invalid value for enum: " + dbData);
    }


}

