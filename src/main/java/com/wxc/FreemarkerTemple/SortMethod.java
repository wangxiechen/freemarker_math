package com.wxc.FreemarkerTemple;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMethod implements TemplateMethodModelEx {
    @Override
    public Object exec(List list) throws TemplateModelException {
      SimpleSequence ss = (SimpleSequence) list.get(0);
        List<BigDecimal> lists = ss.toList();

        Collections.sort(lists, new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.intValue() - o2.intValue(); // 升序
            }
        });
        return lists;
    }
}
