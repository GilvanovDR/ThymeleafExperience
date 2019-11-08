/*
 * Gilvanov DR 2019.
 */

package ru.GilvanovDR;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

public enum ThymeLeafConfig {
    INSTANCE;
    private TemplateEngine templateEngine;

    ThymeLeafConfig(){
        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix(getTemplatePath());
        templateResolver.setTemplateMode("HTML5");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public static String getTemplatePath(){
        return "template";
    }

    public static TemplateEngine getTemplateEngine(){
        return INSTANCE.templateEngine;
    }
}