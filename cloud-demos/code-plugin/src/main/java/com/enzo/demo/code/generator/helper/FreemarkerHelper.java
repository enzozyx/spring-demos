package com.enzo.demo.code.generator.helper;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.enzo.demo.code.entity.DaoDesc;
import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.entity.ServiceDesc;
import com.enzo.demo.code.generator.config.FreemarkerConfiguration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author zhangyx
 * @desccription free marker模板辅助类
 * @date 2018-06-2018/6/21-9:18
 */
@Service
public class FreemarkerHelper {

    @Autowired
    private FreemarkerConfiguration cfg;

    public File getDomainFile(DomainDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template domainTemplate = cfg.getCfg().getTemplate("domain.ftlh");
        // TODO: 2018/6/21 准备输出资源
        File folder = new File(cfg.getTempFolder() + File.separator + "entity");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder() + File.separator + "entity" + File.separator + desc.getName() + ".java");
        return writeFile(desc, domainTemplate, file);
    }

    public File getMapperFile(DaoDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template mapperTemplate = cfg.getCfg().getTemplate("mapper.ftlh");
        // TODO: 2018/6/21 输出dao xml资源
        File folder = new File(cfg.getTempFolder() + File.separator + "mapper");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder() + File.separator + "mapper" + File.separator + desc.getDomain().getName() + "Dao.xml");
        return writeFile(desc, mapperTemplate, file);
    }

    public File getDaoFile(DaoDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template daoTemplate = cfg.getCfg().getTemplate("dao.ftlh");
        // TODO: 2018/6/21 输出dao xml资源
        File folder = new File(cfg.getTempFolder() + File.separator + "dao");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder() + File.separator + "dao" + File.separator + desc.getDomain().getName() + "Dao.java");
        return writeFile(desc, daoTemplate, file);
    }

    private File writeFile(Object model, Template template, File file) throws IOException {
        Writer out = null;
        try {
            out = new FileWriter(file);
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
        return file;
    }

    public File getIserviceFile(ServiceDesc serviceDesc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template iserviceTemplate = cfg.getCfg().getTemplate("iservice.ftlh");
        // TODO: 2018/6/21 输出iservice xml资源
        File folder = new File(cfg.getTempFolder() + File.separator + "service");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder() + File.separator + "service" + File.separator + "I"+ serviceDesc.getDomain().getName() + "Service.java");
        return writeFile(serviceDesc, iserviceTemplate, file);
    }

    public File getServiceFile(ServiceDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template iserviceTemplate = cfg.getCfg().getTemplate("service.ftlh");
        // TODO: 2018/6/21 输出iservice xml资源
        File folder = new File(cfg.getTempFolder() + File.separator + "service" + File.separator + "impl");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder() + File.separator + "service" + File.separator + "impl" + File.separator + desc.getDomain().getName() + "Service.java");
        return writeFile(desc, iserviceTemplate, file);
    }
}
