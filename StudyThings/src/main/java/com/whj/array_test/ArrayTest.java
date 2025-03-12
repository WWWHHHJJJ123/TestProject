package com.whj.array_test;

import com.whj.array_test.domain.AppPersonEntity;
import com.whj.array_test.domain.EmployeeInfo;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayTest {

    public static void main(String[] args) {
        System.out.println(square(2));
        List<String> strings=new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        Collections.sort(strings);
    }

    public static int square(int num) {
        assert num > 0 : "Input parameter must be positive";
        return num * num;
    }

//
//    @Test
//    public void test() {
//        List<Item> originalList = new ArrayList<>(Arrays.asList(new Item("A"), new Item("B"), new Item("C")));
//        List<Item> filterList = new ArrayList<>(Arrays.asList(new Item("B"), new Item("C")));
//
//        List<Item> filteredList = originalList.stream()
//                .filter(item -> filterList.stream().noneMatch(f -> f.getName().equals(item.getName())))
//                .collect(Collectors.toList());
//
//        // 输出结果
//        filteredList.forEach(item -> System.out.println(item.getName())); // 输出:
//    }

    @Test
    public void test2() {
        // 创建集合 A 和 B
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        // 向集合 A 和 B 添加元素
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        B.add(3);
        B.add(4);
        B.add(6);
        B.add(7);

        // 计算交集并移除
        Set<Integer> intersection = new HashSet<>(A); // 复制 A
        intersection.retainAll(B); // 计算 A 和 B 的交集

        // 移除交集
        A.removeAll(intersection);

        // 输出结果
        System.out.println("A 去除交集后的结果: " + A);

    }

    @Test
    public void test3() {
        // 生成两个示例数据源
        List<EmployeeInfo> infos = Arrays.asList(
                new EmployeeInfo("1"),
                new EmployeeInfo("2"),
                new EmployeeInfo("3")
        );

        List<AppPersonEntity> allLocal = Arrays.asList(
                new AppPersonEntity("2"),
                new AppPersonEntity("3"),
                new AppPersonEntity("4")
        );

        // A 对 B 的差集：找到 A 中的元素，不在 B 中
        Set<String> allLocalLdapSet = allLocal.stream()
                .map(AppPersonEntity::getEmpLdap) // 提取 empLdap 字段
                .collect(Collectors.toSet());

        List<EmployeeInfo> aMinusB = infos.stream()
                .filter(info -> !allLocalLdapSet.contains(info.getEmpLdap()))  // A 中存在但 B 中没有的元素
                .collect(Collectors.toList());

        // B 对 A 的差集：找到 B 中的元素，不在 A 中
        Set<String> infosLdapSet = infos.stream()
                .map(EmployeeInfo::getEmpLdap)  // 提取 empLdap 字段
                .collect(Collectors.toSet());

        List<AppPersonEntity> bMinusA = allLocal.stream()
                .filter(local -> !infosLdapSet.contains(local.getEmpLdap()))  // B 中存在但 A 中没有的元素
                .collect(Collectors.toList());

        // 打印结果
        System.out.println("A 对 B 的差集：" + aMinusB);  // 只在 infos 中但不在 allLocal 中
        System.out.println("B 对 A 的差集：" + bMinusA);  // 只在 allLocal 中但不在 infos 中

    }

}
