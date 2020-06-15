package com.koalaIT.common.interceptor;

import com.koalaIT.common.querypage.QueryPage;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.HashMap;
import java.util.Map;


@Component
public class QueryPageArgumentInterceptor implements WebArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        if (!methodParameter.getParameterType().equals(QueryPage.class)) {
            return UNRESOLVED;
        }
        Map<String, String[]> parameters = webRequest.getParameterMap();
        Map<String, Object> map = new HashMap<String, Object>();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            String[] values = entry.getValue();
            if (ArrayUtils.getLength(values) == 1) {
                map.put(entry.getKey(), values[0]);
            } else {
                map.put(entry.getKey(), values);
            }
        }

        QueryPage queryPage = new QueryPage();
        int pageSize = parseInt(map.get("pageSize") == null ? null : map.get("pageSize").toString(), 10);
        int currentPage = parseInt(map.get("pageNumber") == null ? null : map.get("pageNumber").toString(), 1);
        queryPage.setPageSize(pageSize);
        queryPage.setPageNumber(currentPage);
        queryPage.setObj(map);
        return queryPage;
    }

    private int parseInt(String value, int defaultValue) {
        try {
            return Integer.valueOf(value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }
}
