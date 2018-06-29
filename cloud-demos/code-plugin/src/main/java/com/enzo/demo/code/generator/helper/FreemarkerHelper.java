package com.enzo.demo.code.generator.helper;/**
 * Created by LENOVO on 2018/6/21.
 */

import com.enzo.demo.code.entity.DaoDesc;
import com.enzo.demo.code.entity.DomainDesc;
import com.enzo.demo.code.entity.FileAndString;
import com.enzo.demo.code.entity.ServiceDesc;
import com.enzo.demo.code.generator.config.FreemarkerConfiguration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;

/**
 * @author zhangyx
 * @desccription free marker模板辅助类
 * @date 2018-06-2018/6/21-9:18
 */
@Service
public class FreemarkerHelper {

    @Autowired
    private FreemarkerConfiguration cfg;

    public FileAndString getDomainFile(DomainDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template domainTemplate = cfg.getCfg().getTemplate("domain.ftlh");
        // TODO: 2018/6/21 准备输出资源
        String packagePath = getPackagePath(desc);
        File folder = new File(cfg.getTempFolder()+ packagePath + File.separator + "entity");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder()+ packagePath + File.separator + "entity" + File.separator + desc.getName() + ".java");
        return writeFile(desc, domainTemplate, file);
    }

    private String getPackagePath(DomainDesc desc) {
        if(desc != null && desc.getPackageName() != null){
            return File.separator + desc.getPackageName().replace(".", File.separator);
        }else{
            return "";
        }
    }

    public FileAndString getMapperFile(DaoDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template mapperTemplate = cfg.getCfg().getTemplate("mapper.ftlh");
        // TODO: 2018/6/21 输出dao xml资源
        File folder = new File(cfg.getTempFolder() + File.separator + "mapper");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder() + File.separator + "mapper" + File.separator + desc.getDomain().getName() + "Dao.xml");
        return writeFile(desc, mapperTemplate, file);
    }

    public FileAndString getDaoFile(DaoDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template daoTemplate = cfg.getCfg().getTemplate("dao.ftlh");
        // TODO: 2018/6/21 输出dao xml资源
        String packagePath = getPackagePath(desc.getDomain());
        File folder = new File(cfg.getTempFolder()+ packagePath + File.separator + "dao");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder()+ packagePath + File.separator + "dao" + File.separator + desc.getDomain().getName() + "Dao.java");
        return writeFile(desc, daoTemplate, file);
    }

    private FileAndString writeFile(Object model, Template template, File file) throws IOException {
        Writer out = null;
        StringWriter strWriter = new StringWriter();
        try {
            out = new FileWriter(file);
            template.process(model, out);
            template.process(model, strWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
        return new FileAndString(file, strWriter.toString());
    }

    public FileAndString getIserviceFile(ServiceDesc serviceDesc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template iserviceTemplate = cfg.getCfg().getTemplate("iservice.ftlh");
        // TODO: 2018/6/21 输出iservice xml资源
        String packagePath = getPackagePath(serviceDesc.getDomain());
        File folder = new File(cfg.getTempFolder()+ packagePath + File.separator + "service");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder()+ packagePath + File.separator + "service" + File.separator + "I"+ serviceDesc.getDomain().getName() + "Service.java");
        return writeFile(serviceDesc, iserviceTemplate, file);
    }

    public FileAndString getServiceFile(ServiceDesc desc) throws IOException {
        // TODO: 2018/6/21 获取模板
        Template iserviceTemplate = cfg.getCfg().getTemplate("service.ftlh");
        // TODO: 2018/6/21 输出iservice xml资源
        String packagePath = getPackagePath(desc.getDomain());
        File folder = new File(cfg.getTempFolder()+ packagePath + File.separator + "service" + File.separator + "impl");
        if(!folder.exists()) folder.mkdirs();
        File file = new File(cfg.getTempFolder()+ packagePath + File.separator + "service" + File.separator + "impl" + File.separator + desc.getDomain().getName() + "Service.java");
        return writeFile(desc, iserviceTemplate, file);
    }

    /**
    * @author zhangyx
    * @description 依据模板解析list查询代码
    * @date 2018/6/29 17:23
    * @todo
    * @param 
    * @return 
    * @exception 
    */
    public Map<String,String> getQueryListDesc(DomainDesc domain) {
        return null;
    }
}
