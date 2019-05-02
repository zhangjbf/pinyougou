package com.pinyougou.pojo;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @Version: 1.0
 * @Author: jiabin.zhang
 * @Email: jiabin.zhang@rograndec.com
 *
 */
public class TbBrand implements Serializable{


  /**
   * null
   */
  private Integer id;

  /**
   * 品牌名称
   */
  private String name;

  /**
   * 品牌首字母
   */
  private String firstChar;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getFirstChar() {
    return firstChar;
  }

  public void setFirstChar(String firstChar) {
    this.firstChar = firstChar;
  }

}
