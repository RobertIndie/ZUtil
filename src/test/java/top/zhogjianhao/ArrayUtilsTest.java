package top.zhogjianhao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import top.zhogjianhao.charset.StandardCharsets;

@DisplayName("数组工具类测试")
public class ArrayUtilsTest {

  private void println(Object source) {
    System.out.println(source);
  }

  @DisplayName("toBytes：转字节数组")
  @Test
  void toBytes() {
    char[] chars = new char[]{'中', '国', 'a'};
    // 不同字符集的字符数组转字节数组
    for (byte b : ArrayUtils.toBytes(chars, StandardCharsets.ISO_8859_1)) {
      println(b);
    }
    println("——————————————————");
    for (byte b : ArrayUtils.toBytes(chars, StandardCharsets.GB2312)) {
      println(b);
    }
    println("——————————————————");
    // UTF-8 字符集的字符数组转字节数组
    for (byte b : ArrayUtils.toBytes(chars)) {
      println(b);
    }
  }

  @DisplayName("toChars：转字符数组")
  @Test
  void toChars() {
    char[] chars = new char[]{'中', '国', 'a'};
    // 不同字符集的字符数组转字节数组
    for (char c : ArrayUtils.toChars(ArrayUtils.toBytes(chars, StandardCharsets.ISO_8859_1), StandardCharsets.ISO_8859_1)) {
      println(c);
    }
    println("——————————————————");
    for (char c : ArrayUtils.toChars(ArrayUtils.toBytes(chars, StandardCharsets.GB2312), StandardCharsets.GB2312)) {
      println(c);
    }
    println("——————————————————");
    // UTF-8 字符集的字符数组转字节数组
    for (char c : ArrayUtils.toChars(ArrayUtils.toBytes(chars))) {
      println(c);
    }
  }

  @DisplayName("remove：删除元素")
  @Test
  void remove() {
    int[] ints = {1, 2, 3, 4, 5};
    ints = ArrayUtils.remove(ints, 3, 9);
    println("删除下标为 3 的元素后下标为 3 的元素：" + ints[3]);
    println("删除下标为 3 的元素后，最后一个元素（给默认值）：" + ints[ints.length - 1] + "，数组长度：" + ints.length);
    ints = new int[]{1, 2, 3, 4, 5};
    ints = ArrayUtils.remove(ints, 3);
    println("删除下标为 3 的元素后，最后一个元素（无默认值）：" + ints[ints.length - 1] + "，数组长度：" + ints.length);
    println("——————————————————");
    Integer[] ints1 = {1, 2, 3, 4, 5};
    ints1 = ArrayUtils.remove(ints1, 3, 9);
    println("删除下标为 3 的元素后下标为 3 的元素：" + ints1[3]);
    println("删除下标为 3 的元素后，最后一个元素（给默认值）：" + ints1[ints1.length - 1] + "，数组长度：" + ints1.length);
    ints1 = new Integer[]{1, 2, 3, 4, 5};
    ints1 = ArrayUtils.remove(ints1, 3);
    println("删除下标为 3 的元素后，最后一个元素（无默认值）：" + ints1[ints1.length - 1] + "，数组长度：" + ints1.length);
  }

  @DisplayName("fill：填充元素")
  @Test
  void fill() {
    int[] ints = {1, 2, 3, 4, 5};
    ints = ArrayUtils.fill(ints, 3, ints.length, 1);
    println("填充元素且超出原数组下标，最后一个元素：：" + ints[ints.length - 1] + "，数组长度：" + ints.length);
    Integer[] ints1 = {1, 2, 3, 4, 5};
    ints1 = ArrayUtils.fill(ints1, 3, ints1.length, 1);
    println("填充元素且超出原数组下标，最后一个元素：：" + ints1[ints1.length - 1] + "，数组长度：" + ints1.length);
  }

  @DisplayName("removeAllElements：删除所有匹配元素")
  @Test
  void removeAllElements() {
    int[] ints = {1, 2, 0, 0, 0};
    ints = ArrayUtils.removeAllElements(ints, 0);
    println("删除数组中的 0，数组长度：" + ints.length);
    Integer[] ints1 = {1, 2, 0, 0, 0};
    ints1 = ArrayUtils.removeAllElements(ints1, 0);
    println("删除数组中的 0，数组长度：" + ints1.length);
  }

  @DisplayName("indexOf：查找数组中指定的字符串")
  @Test
  void indexOf() {
    char[] chars = "{aaa{}".toCharArray();
    println(ArrayUtils.indexOf(chars, "a{}", 2));
    println(ArrayUtils.indexOf(chars, "{}"));
  }

  @DisplayName("allLength：所有元素的长度总和")
  @Test
  void allLength() {
    println(ArrayUtils.allLength("12", "123"));
  }
}
