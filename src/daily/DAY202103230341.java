package daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class DAY202103230341 {

    interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    static class First implements Iterator<Integer> {
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator;
        public First(List<NestedInteger> nestedList) {
            helper(nestedList);
            iterator = list.iterator();
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void helper(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    helper(nestedInteger.getList());
                }
            }
        }
    }


    static class Second implements Iterator<Integer> {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        public Second(List<NestedInteger> nestedList) {
            for(NestedInteger nestedInteger: nestedList){
                helper(nestedInteger);
            }
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return list.get(index++);
            } else {
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty() && index < list.size();
        }

        private void helper(NestedInteger nestedInteger) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                for (NestedInteger ni : nestedInteger.getList()) {
                    helper(ni);
                }
            }
        }
    }
}
