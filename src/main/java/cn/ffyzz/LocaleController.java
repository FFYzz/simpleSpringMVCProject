package cn.ffyzz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Locale;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/7
 */
@Controller
public class LocaleController {

    @ResponseBody
    @GetMapping(value = "/acceptHeaderLocale", produces = "text/html;charset=UTF-8")
    public String acceptHeaderLocale(HttpServletRequest request) {
        return getLocaleFromRequest(request);
    }

    @ResponseBody
    @GetMapping(value = "/fixedLocale", produces = "text/html;charset=UTF-8")
    public String fixedLocale(HttpServletRequest request) {
        return getLocaleFromRequest(request);
    }

    @ResponseBody
    @GetMapping(value = "/sessionLocale", produces = "text/html;charset=UTF-8")
    public String sessionLocale(HttpServletRequest request) {
        return getLocaleFromRequest(request);
    }

    @GetMapping(value = "/cookieLocale", produces = "text/html;charset=UTF-8")
    public String setCookieLocale(HttpServletRequest request, HttpServletResponse response, String locale) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (locale == null) {
            locale = "en-US";
        }
        localeResolver.setLocale(request, response, Locale.forLanguageTag(locale));
        return "redirect:showCookieLocale";
    }

    @ResponseBody
    @GetMapping(value = "/showCookieLocale", produces = "text/html;charset=UTF-8")
    public String cookieLocale(HttpServletRequest request) {
        return getLocaleFromRequest(request);
    }


    private String getLocaleFromRequest(HttpServletRequest request) {
        String clientLocale = "";
        Enumeration<Locale> enus = request.getLocales();
        while (enus.hasMoreElements()) {
            Locale locale = enus.nextElement();
            clientLocale += locale + ",";
        }
        RequestContext requestContext = new RequestContext(request);
        String value = requestContext.getMessage("message.locale");
        return "客户端支持的Locale有: " + clientLocale + " </br>当前使用的 Locale 是: " + requestContext.getLocale() + " </br>资源的内容为: " + value;
    }

}
