package io.github.zodh.reflection;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import org.springframework.util.ReflectionUtils;

public class AttributeHandler<T> {

  public T getNestedAttributeValue(Object object, String nestedFieldPath) {
    Object currentObject = object;

    String[] fieldNames = nestedFieldPath.split("\\.");

    for (String fieldName : fieldNames) {
      Field field = ReflectionUtils.findField(currentObject.getClass(), fieldName);
      if (field != null) {
        field.setAccessible(true);
        try {
          currentObject = field.get(currentObject);
        } catch (IllegalAccessException e) {
          throw new IllegalArgumentException(e.getMessage() + " - Error trying to get target field value.");
        }
      } else {
        return null;
      }
    }
    return (T) currentObject;
  }

  public static class AttributeHandlerToString extends AttributeHandler<String> {
  }

  public static class AttributeHandlerToBigDecimal extends AttributeHandler<BigDecimal> {

  }

  public static class AttributeHandlerToInteger extends AttributeHandler<Integer> {

  }

  public static class AttributeHandlerToBoolean extends AttributeHandler<Boolean> {

  }

  public static class AttributeHandlerToDouble extends AttributeHandler<Double> {

  }

  public static class AttributeHandlerToFloat extends AttributeHandler<Float> {

  }

  public static class AttributeHandlerToShort extends AttributeHandler<Short> {

  }

  public static class AttributeHandlerToByte extends AttributeHandler<Byte> {

  }

  public static class AttributeHandlerToLong extends AttributeHandler<Long> {

  }

  public static class AttributeHandlerToChar extends AttributeHandler<Character> {

  }

}
