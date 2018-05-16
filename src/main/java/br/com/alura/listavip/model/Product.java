package br.com.alura.listavip.model;

import java.util.List;

public class Product {

  private Long id;
  private String productCode;
  private List<String> versions;

  public Product() {
  }

  public Product(Long id, String productCode, List<String> versions) {
    this.id = id;
    this.versions = versions;
    this.productCode = productCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public List<String> getVersions() {
    return versions;
  }

  public void setVersions(List<String> versions) {
    this.versions = versions;
  }
}