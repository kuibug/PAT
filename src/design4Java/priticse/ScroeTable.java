package design4Java.priticse;

import java.util.HashMap;

public class ScroeTable {
	// 设计一个hashMap 以科目为key 同学成绩为value （同学成绩也是一个hashMap 姓名为key）
	static HashMap<String, HashMap<String, Integer>> lessons = new HashMap<String, HashMap<String, Integer>>();

	public static void main(String[] args) {
		// 规定录入格式 姓名,科目,成绩
		put("张三", "高数", 98);
		put("李四", "高数", 88);
		put("张三", "数据结构", 98);

		// 预览一下存储结果
		System.out.println(lessons);

		// 按姓名查询
		System.out.println("==========按姓名查询==========");

		HashMap<String, Integer> result1 = findOfName("张三");
		System.out.println("张三：" + result1);

		HashMap<String, Integer> result2 = findOfName("李四");
		System.out.println("李四：" + result2);

		// 按照科目查询
		System.out.println("==========按照科目查询==========");

		HashMap<String, Integer> math = findOfLesson("高数");
		System.out.println("高数：" + math);

		HashMap<String, Integer> dataStruct = findOfLesson("数据结构");
		System.out.println("数据结构：" + dataStruct);
	}

	// 按照科目查询
	private static HashMap<String, Integer> findOfLesson(String lesson) {
		return lessons.get(lesson);
	}

	// 按姓名查询
	private static HashMap<String, Integer> findOfName(String name) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();// 存储查询结果
		// 遍历kessons的Map，按照name Key查找
		for (String les : lessons.keySet()) {
			Integer score = lessons.get(les).get(name);
			// 这里判断一下如果没有参加该门课程就不添加了
			if (score != null) {
				map.put(les, score);
			}
		}
		return map;
	}

	// 成绩录入
	private static void put(String name, String lesson, int score) {
		// 先检查该科目是否存在 不存在就想创建一下
		if (lessons.get(lesson) == null) {
			lessons.put(lesson, new HashMap<String, Integer>());
		}
		// 添加同学成绩进去
		lessons.get(lesson).put(name, score);

	}
}
