package com.enzo.demo.common.code.generator.config;/**
 * Created by LENOVO on 2018/6/21.
 */

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangyx
 * @desccription freemarker配置
 * @date 2018-06-2018/6/21-9:12
 */
@Service
public class FreemarkerConfiguration {

    private static Configuration cfg;

    private String tempFolder = "/data";

    private static Logger log = LoggerFactory.getLogger(FreemarkerConfiguration.class);

    static {
        // Create your Configuration instance, and specify if up to what FreeMarker
        // version (here 2.3.27) do you want to apply the fixes that are not 100%
        // backward-compatible. See the Configuration JavaDoc for details.
        cfg = new Configuration(Configuration.VERSION_2_3_23);

        // Specify the source where the template files come from. Here I set a
        // plain directory for it, but non-file-system sources are possible too:
        try {
            String path = FreemarkerConfiguration.class.getResource("/templates/freemarker").getPath();
            log.info("类资源路径:" + path);
            cfg.setDirectoryForTemplateLoading(new File(path));
        } catch (IOException e) {
            log.error("freemark 配置初始化失败，加载template 目录失败");
            e.printStackTrace();

        }

        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);

        // Wrap unchecked exceptions thrown during template processing into TemplateException-s.
//        cfg.setWrapUncheckedExceptions(true);
    }

    public Configuration getCfg() {
        return cfg;
    }

    public String getTempFolder() {
        return tempFolder;
    }

    public void setTempFolder(String tempFolder) {
        this.tempFolder = tempFolder;
    }
}
