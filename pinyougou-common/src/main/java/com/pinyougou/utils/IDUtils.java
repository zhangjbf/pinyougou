package com.pinyougou.utils;

import java.util.Random;

/**
 * id生成策略
 *
 * <p>
 * 名称: com.taotao.utils.IDUtils
 * </p>
 * <p>
 * by：javaboy
 * <p>
 * e-mail:javaboyok@163.com
 * 
 * @author 张佳宾
 * @date 2017年4月15日
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	/**
	 * 所有id生成
	 * <p>
	 * Title: genId
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	public static String genId() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(999);
		// 如果不足两位前面补0
		String str = "1001" + millis + String.format("%03d", end2);
		return str;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			System.out.println(genId());
	}
}
