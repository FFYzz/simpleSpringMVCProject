package cn.ffyzz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/6
 */
@RestController
public class StartupController {

    @GetMapping("/startup")
    public void startup() {
        System.out.println("startup...");
    }

}
