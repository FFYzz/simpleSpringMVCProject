package cn.ffyzz;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

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

    @GetMapping("/sessionTheme")
    public String sessionTheme() {
        return "theme";
    }

    @GetMapping(value = "/cookieTheme", produces = "text/html;charset=UTF-8")
    public String setCookieTheme(HttpServletRequest request, HttpServletResponse response, String theme) {
        ThemeResolver themeResolver = RequestContextUtils.getThemeResolver(request);
        if (StringUtils.isEmpty(theme)) {
            theme = "default";
        }
        themeResolver.setThemeName(request, response, theme);
        return "redirect:showCookieTheme";
    }

    @GetMapping("/showCookieTheme")
    public String cookieTheme() {
        return "theme";
    }

}
