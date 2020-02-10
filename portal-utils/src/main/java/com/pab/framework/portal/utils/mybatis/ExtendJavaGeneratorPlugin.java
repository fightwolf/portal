package com.pab.framework.portal.utils.mybatis;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.maven.MavenShellCallback;
import org.mybatis.generator.maven.MyBatisGeneratorMojo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExtendJavaGeneratorPlugin extends PluginAdapter {
    private static HashMap<String, ArrayList<String>> generatedEntityCache;

    static {
        generatedEntityCache = new HashMap<>();
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.modelPrimaryKeyClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        boolean returnValue = super.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
        ArrayList<String> names = generatedEntityCache.get(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        if (names == null) {
            names = new ArrayList<>();
            generatedEntityCache.put(introspectedTable.getFullyQualifiedTableNameAtRuntime(), names);
        }
        String name = method.getName().substring(3);
        if (!names.contains(name)) {
            names.add(name);
        }
        return returnValue;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        ArrayList<GeneratedJavaFile> files = new ArrayList<>();
        GeneratedJavaFile clientExtendFile = generateClientExtendFile(introspectedTable);
        if (clientExtendFile != null) {
            files.add(clientExtendFile);
        }
        GeneratedJavaFile entityExtendFile = generateEntityExtendFile(introspectedTable);
        if (entityExtendFile != null) {
            files.add(entityExtendFile);
        }
        files.add(generateOriginEntityBuilder(introspectedTable));
        return files;
    }

    @Override
    public boolean providerSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        boolean returnValue = super.providerSelectByExampleWithoutBLOBsMethodGenerated(method, topLevelClass, introspectedTable);
        if (returnValue) {
            addPaginationForSelectByExample(method);
        }
        return returnValue;
    }

    @Override
    public boolean providerSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        boolean returnValue = super.providerSelectByExampleWithBLOBsMethodGenerated(method, topLevelClass, introspectedTable);
        if (returnValue) {
            addPaginationForSelectByExample(method);
        }
        return returnValue;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        boolean returnValue = super.modelExampleClassGenerated(topLevelClass, introspectedTable);
        if (returnValue) {
            addPaginationForModel(topLevelClass);
            addJsonSupport(topLevelClass);
        }
        return returnValue;
    }

    private void addJsonSupport(TopLevelClass topLevelClass) {
        topLevelClass.addImportedType("org.codehaus.jackson.annotate.JsonIgnoreProperties");
        topLevelClass.addImportedType("org.codehaus.jackson.annotate.JsonIgnore");
        topLevelClass.addAnnotation("@JsonIgnoreProperties(ignoreUnknown = true)");
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
            innerClass.addAnnotation("@JsonIgnoreProperties(ignoreUnknown = true)");
        }
        addGeneratedCriteriaJsonSupport(topLevelClass.getInnerClasses().get(0));
        addCriterionJsonSupport(topLevelClass.getInnerClasses().get(2));
    }

    private void addCriterionJsonSupport(InnerClass innerClass) {
        Method constructor = new Method("Criterion");
        constructor.setConstructor(true);
        constructor.setVisibility(JavaVisibility.PUBLIC);
        constructor.addBodyLine("super();");
        innerClass.addMethod(constructor);
    }

    private void addGeneratedCriteriaJsonSupport(InnerClass innerClass) {
        Method setCriteria = new Method("setCriteria");
        setCriteria.addBodyLine("this.criteria=criteria;");
        setCriteria.addParameter(new Parameter(new FullyQualifiedJavaType("List<Criterion>"), "criteria"));
        innerClass.addMethod(setCriteria);
        Method getAllCriteria = innerClass.getMethods().get(2);
        getAllCriteria.addAnnotation("@JsonIgnore");
    }

    private void addPaginationForSelectByExample(Method method) {
        int lastIndex = method.getBodyLines().size() - 1;
        String lastBodyLine = method.getBodyLines().get(lastIndex);
        lastBodyLine = lastBodyLine.replace("return SQL();", "String returnValue=SQL();");
        method.getBodyLines().set(lastIndex, lastBodyLine);
        method.addBodyLine("if(example != null && example.getPageIndex()!=null && example.getPageCount() != null){");
        method.addBodyLine("int pageCount = example.getPageCount();");
        method.addBodyLine("int pageStart = (example.getPageIndex() - 1)*pageCount;");
        method.addBodyLine("returnValue += String.format(\" limit %1$d,%2$d\", pageStart, pageCount);");
        method.addBodyLine("}");
        method.addBodyLine("return returnValue;");
    }

    private void addPaginationForModel(TopLevelClass topLevelClass) {
        FullyQualifiedJavaType intType = new FullyQualifiedJavaType(Integer.class.getTypeName());
        Field field = new Field();
        field.setName("pageIndex");
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(intType);
        topLevelClass.addField(field);
        field = new Field();
        field.setName("pageCount");
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(intType);
        topLevelClass.addField(field);
        Method method = new Method();
        method.setName("setPageIndex");
        method.addParameter(new Parameter(intType, "pageIndex"));
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addBodyLine("this.pageIndex=pageIndex;");
        topLevelClass.addMethod(method);
        method = new Method();
        method.setName("getPageIndex");
        method.setReturnType(intType);
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addBodyLine("return this.pageIndex;");
        topLevelClass.addMethod(method);
        method = new Method();
        method.setName("setPageCount");
        method.addParameter(new Parameter(intType, "pageCount"));
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addBodyLine("this.pageCount=pageCount;");
        topLevelClass.addMethod(method);
        method = new Method();
        method.setName("getPageCount");
        method.setReturnType(intType);
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addBodyLine("return this.pageCount;");
        topLevelClass.addMethod(method);
    }

    private GeneratedJavaFile generateOriginEntityBuilder(IntrospectedTable introspectedTable) {
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
        String packageName = javaModelGeneratorConfiguration.getTargetPackage();
        String targetProjectName = javaModelGeneratorConfiguration.getTargetProject();
        String fileName = getOriginBuilderName(introspectedTable);
        String extendName = getExtendName(introspectedTable);
        String newPackageName = getOriginBuilderPackageName(packageName);
        String originBuilderName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        String originBuilderTypeName = packageName + "." + originBuilderName;
        TopLevelClass compilationUnit = new TopLevelClass(newPackageName + "." + fileName);
        compilationUnit.addImportedType(new FullyQualifiedJavaType(originBuilderTypeName));
        compilationUnit.setVisibility(JavaVisibility.PUBLIC);
        compilationUnit.addImportedType(new FullyQualifiedJavaType(getExtendPackageName(packageName) + "." + getExtendName(introspectedTable)));
        compilationUnit.setSuperClass(new FullyQualifiedJavaType(originBuilderName));
        compilationUnit.addMethod(generateBuildOriginMethod(introspectedTable, extendName, originBuilderName));
        GeneratedJavaFile javaFile = new GeneratedJavaFile(compilationUnit, targetProjectName, context.getJavaFormatter());
        return javaFile;
    }

    private GeneratedJavaFile generateEntityExtendFile(IntrospectedTable introspectedTable) {
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
        String packageName = javaModelGeneratorConfiguration.getTargetPackage();
        String targetProjectName = javaModelGeneratorConfiguration.getTargetProject();
        String fileName = getExtendName(introspectedTable);
        String newPackageName = getExtendPackageName(packageName);
        String originBuilderPackageName = getOriginBuilderPackageName(packageName);
        String entityName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        String entityType = packageName + "." + entityName;
        if (!fileExist(newPackageName, targetProjectName, fileName)) {
            TopLevelClass compilationUnit = new TopLevelClass(newPackageName + "." + fileName);
            compilationUnit.addImportedType(new FullyQualifiedJavaType(entityType));
            compilationUnit.addImportedType(new FullyQualifiedJavaType(originBuilderPackageName + "." + getOriginBuilderName(introspectedTable)));
            compilationUnit.setVisibility(JavaVisibility.PUBLIC);
            compilationUnit.setSuperClass(new FullyQualifiedJavaType(entityName));
            compilationUnit.addMethod(generateInitFromOriginEntityMethod(introspectedTable, fileName, entityName));
            GeneratedJavaFile javaFile = new GeneratedJavaFile(compilationUnit, targetProjectName, context.getJavaFormatter());
            return javaFile;
        } else {
            System.out.println(String.format("package:%1$s,extendObject:%2$s exists skip generate", newPackageName, fileName));
        }
        return null;
    }

    private Method generateBuildOriginMethod(IntrospectedTable introspectedTable, String extendTypeName, String originTypeName) {
        Method returnValue = new Method();
        String setTemplate = "returnValue.set%1$s(origin.get%1$s());";
        returnValue.setName("buildOrigin");
        returnValue.setStatic(true);
        returnValue.setReturnType(new FullyQualifiedJavaType(extendTypeName));
        returnValue.addParameter(new Parameter(new FullyQualifiedJavaType(originTypeName), "origin"));
        returnValue.addBodyLine("if (origin == null){");
        returnValue.addBodyLine("return null;");
        returnValue.addBodyLine("}");
        returnValue.addBodyLine(String.format("%1$s returnValue=new %1$s();", extendTypeName));
        ArrayList<String> names = generatedEntityCache.get(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        for (String name : names) {
            returnValue.addBodyLine(String.format(setTemplate, name));
        }
        returnValue.addBodyLine("return returnValue;");
        returnValue.setVisibility(JavaVisibility.PUBLIC);
        return returnValue;
    }

    private Method generateInitFromOriginEntityMethod(IntrospectedTable introspectedTable, String extendTypeName, String originTypeName) {
        Method returnValue = new Method();
        returnValue.setName("generateFromOriginEntity");
        returnValue.setStatic(true);
        returnValue.setReturnType(new FullyQualifiedJavaType(extendTypeName));
        returnValue.addParameter(new Parameter(new FullyQualifiedJavaType(originTypeName), "origin"));
        returnValue.addBodyLine(String.format("return %1$s.buildOrigin(origin);", getOriginBuilderName(introspectedTable)));
        returnValue.setVisibility(JavaVisibility.PUBLIC);
        return returnValue;
    }

    private String getOriginBuilderPackageName(String baseEntityPackage) {
        return baseEntityPackage + ".handwrite.originEntityBuilder";
    }

    private String getExtendPackageName(String baseEntityPackage) {
        return baseEntityPackage + ".handwrite";
    }

    private String getOriginBuilderName(IntrospectedTable introspectedTable) {
        return introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "OriginBuilder";
    }

    private String getExtendName(IntrospectedTable introspectedTable) {
        return introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "Extend";
    }

    private GeneratedJavaFile generateClientExtendFile(IntrospectedTable introspectedTable) {
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = context.getJavaClientGeneratorConfiguration();
        String packageName = javaClientGeneratorConfiguration.getTargetPackage();
        String newPackageName = packageName.replace("autogenerate", "handwrite");
        String fileName = introspectedTable.getMyBatis3XmlMapperFileName();
        String clientName = fileName.replace(".xml", "");
        String clientTypeName = packageName + "." + clientName;
        String targetProjectName = javaClientGeneratorConfiguration.getTargetProject();
        if (packageName.contains(".write.") || packageName.endsWith(".write")) {
            fileName = fileName.replace("Mapper.xml", "WriteMapper");
        } else {
            fileName = fileName.replace("Mapper.xml", "ReadMapper");
        }
        if (!fileExist(newPackageName, targetProjectName, fileName)) {
            Interface compilationUnit = new Interface(newPackageName + "." + fileName);
            compilationUnit.addImportedType(new FullyQualifiedJavaType(clientTypeName));
            compilationUnit.setVisibility(JavaVisibility.PUBLIC);
            compilationUnit.addSuperInterface(new FullyQualifiedJavaType(clientName));
            GeneratedJavaFile javaFile = new GeneratedJavaFile(compilationUnit, targetProjectName, context.getJavaFormatter());
            return javaFile;
        } else {
            System.out.println(String.format("package:%1$s,mapper:%2$s exists skip generate", newPackageName, fileName));
        }
        return null;
    }

    private boolean fileExist(String targetPackage, String targetProject, String fileName) {
        try {
            MyBatisGeneratorMojo myBatisGeneratorMojo = new MyBatisGeneratorMojo();
            MavenShellCallback mavenShellCallback = new MavenShellCallback(myBatisGeneratorMojo, false);
            File dicFile = mavenShellCallback.getDirectory(targetProject, targetPackage);
            File file = new File(dicFile, fileName + ".java");
            return file.exists();
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}