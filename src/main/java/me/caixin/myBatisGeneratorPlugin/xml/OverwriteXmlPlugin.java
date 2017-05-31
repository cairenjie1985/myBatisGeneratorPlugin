package me.caixin.myBatisGeneratorPlugin.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.internal.DefaultShellCallback;


public class OverwriteXmlPlugin extends PluginAdapter {

	private ShellCallback shellCallback;

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	public OverwriteXmlPlugin() {
		shellCallback = new DefaultShellCallback(false);
	}

	
	@Override
	public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable) {
		List<GeneratedXmlFile> xmlFiles = introspectedTable.getGeneratedXmlFiles();
		List<GeneratedXmlFile> newXmlFiles = new ArrayList<GeneratedXmlFile>();
		try {
			for (GeneratedXmlFile gxf : xmlFiles) {
				File directory = shellCallback.getDirectory(gxf.getTargetProject(), gxf.getTargetPackage());
				File targetFile = new File(directory, gxf.getFileName());
				if(targetFile.exists()){
					targetFile.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newXmlFiles;

	}

}
