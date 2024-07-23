package com.inteswitchmiddleware.digitalmiddleware.Utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class AppUtility {

    public static String sanitize(String data) {
        if (data.contains("_")) {
            data = data.replace("_", " ");
        } else if (data.contains("-")) {
            data = data.replace("-", " ");
        }
        return StringUtils.capitalize(data);
    }
}
