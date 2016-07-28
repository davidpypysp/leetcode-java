package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 7/26/16.
 */
public class ExpressionAddOperators {
    List<String> res;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<String>();
        helper(num, target, "", 0, 0);
        return res;
    }

    void helper(String num, int target, String tmp, long currRes, long prevNum){
        // �������������Ŀ��ֵ�����������������ˣ�������Ч���
        if(currRes == target && num.length() == 0){
            String exp = new String(tmp);
            res.add(exp);
            return;
        }
        // �������п��ܵĲ�����
        for(int i = 1; i <= num.length(); i++){
            String currStr = num.substring(0, i);
            // ����ǰ��Ϊ0���������ų�
            if(currStr.length() > 1 && currStr.charAt(0) == '0'){
                // ������return����continue
                return;
            }
            // �õ���ǰ�س�����
            long currNum = Long.parseLong(currStr);
            // ȥ����ǰ�������õ���һ�������õ��ַ���
            String next = num.substring(i);
            // ������ǵ�һ����ĸʱ�����Լ������������ֻ������
            if(tmp.length() != 0){
                // �˷�
                helper(next, target, tmp+"*"+currNum, (currRes - prevNum) + prevNum * currNum, prevNum * currNum);
                // �ӷ�
                helper(next, target, tmp+"+"+currNum, currRes + currNum, currNum);
                // ����
                helper(next, target, tmp+"-"+currNum, currRes - currNum, -currNum);
            } else {
                // ��һ����
                helper(next, target, currStr, currNum, currNum);
            }

        }
    }
}
