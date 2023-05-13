package io.github.zodh.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class AttributeHandlerTest {

  @Test
  void givenObjectWithNestedObjectsWhenAttributeHandlerFindNestedObjectValueThenGetValue() {
    AttributeHandler<BigDecimal> attributeHandler = new AttributeHandler<>();
    ProductDetailsTestObj productDetailsTestObj = new ProductDetailsTestObj(new BigDecimal("9.99"), 1);
    ProductTestObj productTestObj = new ProductTestObj("Knife", productDetailsTestObj);
    BigDecimal result = attributeHandler.getNestedAttributeValue(productTestObj, "productDetailsTestObj.value");
    assertThat(result).isNotNull().isEqualTo("9.99");
  }

  public static class ProductTestObj {

    private String name;
    private ProductDetailsTestObj productDetailsTestObj;

    public ProductTestObj(String name, ProductDetailsTestObj productDetailsTestObj) {
      this.name = name;
      this.productDetailsTestObj = productDetailsTestObj;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public ProductDetailsTestObj getProductDetails() {
      return productDetailsTestObj;
    }

    public void setProductDetails(
        ProductDetailsTestObj productDetailsTestObj) {
      this.productDetailsTestObj = productDetailsTestObj;
    }
  }

  public static class ProductDetailsTestObj {

    private BigDecimal value;
    private Integer id;

    public ProductDetailsTestObj(BigDecimal value, Integer id) {
      this.value = value;
      this.id = id;
    }

    public BigDecimal getValue() {
      return value;
    }

    public void setValue(BigDecimal value) {
      this.value = value;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }
  }

}
