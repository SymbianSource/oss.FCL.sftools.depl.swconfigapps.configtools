package com.nokia.tools.carbidect.cone.core.internal.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.service.datalocation.Location;

import com.nokia.tools.carbidect.cone.core.ConeCore;
import com.nokia.tools.carbidect.cone.core.actions.IConeAction;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionConfiguration;


public abstract class ConeAction implements IConeAction {
	private String actionName = null;
	private IConeActionConfiguration actionConfig;
	private String usedConeTool;
	
	protected ConeAction(String name) {
		this.setActionName(name);
		this.actionConfig = new ConeActionConfiguration();
	}

	private void setActionName(String name) {
		this.actionName = name;
	}

	public String getActionName() {
		return actionName;
	}
	
	public IConeActionConfiguration getActionConfigiration() {
		return actionConfig;
	}

	public int run(OutputStream outputStream, IProgressMonitor monitor) {
		List<String> command = prepareCommand();
		return run(command, outputStream);
	}

	/**
	 * @return
	 */
	protected List<String> prepareCommand() {
		List<String> command = new ArrayList<String>();
		command.add(getUsedConeTool());
		command.add(getActionName());
		command.addAll(getActionConfigiration().parseArguments());
		return command;
	}
	
	protected int run(List<String> command, OutputStream outputStream) {
		try {
			ProcessBuilder pb = new ProcessBuilder(command.toArray(new String[0]));
			pb.directory(getWorkingDirectory());
			pb.redirectErrorStream(true);
			pb.environment().put("CONE_EXITSHELL", "1");

			Process process = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while((line = br.readLine()) != null) {
				if (outputStream!=null) {
					outputStream.write(line.getBytes());
					outputStream.write("\n".getBytes());
				}
			}
			return process.exitValue();
		} catch (IOException e) {
			e.printStackTrace();
			return 1;
		}
	}

	protected File getWorkingDirectory() {
		File f = new File(getUsedConeTool());
		return f.getParentFile();
	}

	public static String getDefaultConeInstallation() {
		File f;
		try {			
			Location location = Platform.getInstallLocation();	
			URL url = location.getURL();
			f = new File("C:/dev/tools/Carbide.ct_1.1.0DEV-20091222-53"+File.separator+"cone/cone.cmd");
		} catch (Exception e) {
			f = new File("cone/cone.cmd");
		}
		String absolutePath = f.getAbsolutePath();
		ILog log = ConeCore.getDefault().getLog();
		log.log(new Status(IStatus.INFO,ConeCore.PLUGIN_ID,"Using following ConE installation: "+absolutePath));
		return absolutePath;
	}

	public String getUsedConeTool() {
		if(usedConeTool==null) {
			return getDefaultConeInstallation();
		} else {
			return usedConeTool;			
		}
	}

	public void setUsedConeTool(String pathToConeCmd) {
		usedConeTool = pathToConeCmd;
	}
}
