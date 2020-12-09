package cn.ffyzz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/7
 */
@Controller
public class ThemeController {

    @GetMapping("/fixedTheme")
    public String fixedTheme() {
        return "theme";
    }

}
