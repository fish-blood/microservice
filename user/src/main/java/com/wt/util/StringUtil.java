package com.wt.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;

/**
 * String工具类
 *
 * @author pangu
 */
public class StringUtil extends StringUtils {

	public static boolean isBlank(String string) {
		return StringUtils.isEmpty(string) || string.equals("null");
	}

	public static boolean isNotBlank(String string) {
		return !isBlank(string);
	}

	/**
	 * 判断字符串是否含有汉子
	 * @param oneChar
	 * @return
	 */
	public static boolean checkChar(String oneChar) {
		if(oneChar==null){
			return false;
		}
		for(int i=0;i<oneChar.length();i++)
		{
			String test=oneChar.substring(i,i+1);
			if(test.matches("[\\u4E00-\\u9FA5]+"))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 替换指定字符串的指定区间内字符为"*"
	 *
	 * @param str          字符串
	 * @param startInclude 开始位置（包含）
	 * @param endExclude   结束位置（不包含）
	 * @return 替换后的字符串
	 * @since 1.3.8
	 */
	public static String hide(CharSequence str, int startInclude, int endExclude) {
		return replace(str, startInclude, endExclude, '*');
	}

	/**
	 * 替换指定字符串的指定区间内字符为固定字符
	 *
	 * @param str          字符串
	 * @param startInclude 开始位置（包含）
	 * @param endExclude   结束位置（不包含）
	 * @param replacedChar 被替换的字符
	 * @return 替换后的字符串
	 * @since 1.3.8
	 */
	public static String replace(CharSequence str, int startInclude, int endExclude, char replacedChar) {
		if (isEmpty(str)) {
			return str(str);
		}
		final int strLength = str.length();
		if (startInclude > strLength) {
			return str(str);
		}
		if (endExclude > strLength) {
			endExclude = strLength;
		}
		if (startInclude > endExclude) {
			// 如果起始位置大于结束位置，不替换
			return str(str);
		}

		final char[] chars = new char[strLength];
		for (int i = 0; i < strLength; i++) {
			if (i >= startInclude && i < endExclude) {
				chars[i] = replacedChar;
			} else {
				chars[i] = str.charAt(i);
			}
		}
		return new String(chars);
	}

	/**
	 * {@link CharSequence} 转为字符串，null安全
	 *
	 * @param cs {@link CharSequence}
	 * @return 字符串
	 */
	public static String str(CharSequence cs) {
		return null == cs ? null : cs.toString();
	}

	/**
	 * Convert a {@code Collection} into a delimited {@code String} (e.g., CSV).
	 * <p>Useful for {@code toString()} implementations.
	 *
	 * @param coll the {@code Collection} to convert
	 * @return the delimited {@code String}
	 */
	public static String join(Collection<?> coll) {
		return StringUtil.collectionToCommaDelimitedString(coll);
	}

	/**
	 * Convert a {@code Collection} into a delimited {@code String} (e.g. CSV).
	 * <p>Useful for {@code toString()} implementations.
	 *
	 * @param coll  the {@code Collection} to convert
	 * @param delim the delimiter to use (typically a ",")
	 * @return the delimited {@code String}
	 */
	public static String join(Collection<?> coll, String delim) {
		return StringUtil.collectionToDelimitedString(coll, delim);
	}

	/**
	 * Convert a {@code String} array into a comma delimited {@code String}
	 * (i.e., CSV).
	 * <p>Useful for {@code toString()} implementations.
	 *
	 * @param arr the array to display
	 * @return the delimited {@code String}
	 */
	public static String join(Object[] arr) {
		return StringUtil.arrayToCommaDelimitedString(arr);
	}

	/**
	 * Convert a {@code String} array into a delimited {@code String} (e.g. CSV).
	 * <p>Useful for {@code toString()} implementations.
	 *
	 * @param arr   the array to display
	 * @param delim the delimiter to use (typically a ",")
	 * @return the delimited {@code String}
	 */
	public static String join(Object[] arr, String delim) {
		return StringUtil.arrayToDelimitedString(arr, delim);
	}

	/**
	 * 使用字符串填充对应位置的“{}”
	 *
	 * @param pendingString 包含“{}”的待处理字符串
	 * @param strings       填充的字符串
	 * @return 填充后的字符串
	 */
	public static String fillString(String pendingString, String... strings) {
		for (String str : strings) {
			pendingString = fillString(pendingString.replaceFirst("\\{}", str));
		}
		return pendingString;
	}

	public static void main(String[] args) {
		int[] nums1=new int[]{4,3,2,0,0,0};
		int[] nums2=new int[]{6,5,3};
		int m=3;
		int n=3;
		for (int i = 0; i != n; ++i) {
			nums1[m + i] = nums2[i];
		}
		for(int i=0,j=i;i<nums1.length-1;j=++i){
			int a=nums1[i+1];
			System.out.println("i="+i);
			System.out.println("j="+j);
			while(a<nums1[j]){
				System.out.println("循环内开始j="+j);
				System.out.println("循环内--j="+j);
				nums1[j + 1] = nums1[j];
				if(j--==0){
					System.out.println("循环内--j="+j);
					break;
				}

			}
			nums1[j+1]=a;
			System.out.println(Arrays.toString(nums1));
		}
		System.out.println(Arrays.toString(nums1));
	}

}
