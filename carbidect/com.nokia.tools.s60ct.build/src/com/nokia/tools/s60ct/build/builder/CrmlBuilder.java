/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.tools.s60ct.build.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nokia.tools.s60ct.build.builder.utils.SettingValueCollector;
import com.nokia.tools.s60ct.build.crml.RepositoryWithData;
import com.nokia.tools.s60ct.genconfml.GenconfmlManager;
import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;
import com.nokia.tools.s60ct.resources.model.ELibraryModelFactory;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.crml.crmodel.ERepository;
import com.nokia.tools.vct.crml.crmodel.impl.ECRMLDocumentRootImpl;

public class CrmlBuilder extends IncrementalProjectBuilder {
	
	public static final String BUILDER_ID = "com.nokia.s60ct.build.CenRepBuilder";

	//private List<String> cenrepRfsContent = new ArrayList<String>();

//	private IbyFileManager ibyManager = IbyFileManager.getInstance();
	private GenconfmlManager genconfManager = GenconfmlManager.getInstance();
	
//	private List<String> crmlFilePaths = new ArrayList<String>();
	private List<String> genconFilePaths = new ArrayList<String>();
//	private List<String> rfsFilePaths = new ArrayList<String>();
	
	private static final  String workspaceRoot =  ResourcesPlugin.getWorkspace().getRoot().getLocationURI().getPath();
	
	private static File rootCpfTempDir = null;
	
	private static EObject view = null;
	private boolean firstBuild = true;
	

	//private static ConfmlEditor editor = null;
	
	private static ELibraryRoot resModelRoot = null;

	

	class DeltaCrmlVisitor implements IResourceDeltaVisitor {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			//System.out.println("\n*** visit ***\n");
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				checkCrml(resource);
				initializeResourceModel();
				break;
			case IResourceDelta.REMOVED:
				checkCrml(resource);
				initializeResourceModel();
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				checkCrml(resource);
				break;
			}
			//return true to continue visiting children.
			return true;
		}
	}

	class FullCrmlResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			
			//System.out.println("\n*** FullCrmlResourceVisitor ***\n");
			checkCrml(resource);
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("unchecked")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
	throws CoreException {
		
		if (kind == FULL_BUILD || firstBuild) 
		{
			firstBuild = false;
			//System.out.println("\nFULL BUILD\n");
			fullBuild(monitor);
			initializeResourceModel();
		} 
		else 
		{
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) 
			{
				//System.out.println("\nFULL BUILD\n");
				fullBuild(monitor);
			} 
			else 
			{
				//System.out.println("\nINCREMENTAL BUILD\n");
				incrementalBuild(delta, monitor);
			}
		}

		//fullBuild(monitor);
		
		
		//saveCenrepRfsFile();
		//ibyManager.saveIbyFile(getProject(), crmlFilePaths, rfsFilePaths, genconFilePaths);
		
//		if (editor!=null)
//		{
//			editor.updateErrors();
//		}
		
		return null;
	}

//	private void saveCenrepRfsFile() {
//		URI topLayerUri = getConfigurationProject().getLastLayer().getLayerURI();
//		String fileLocation = CommonFolderApis.getFileSaveLayer(topLayerUri.toString());
//		
//		StringBuilder filecontent = new StringBuilder();
//		for (Iterator<String> iterator = cenrepRfsContent.iterator(); iterator.hasNext();) {
//			String val = iterator.next();
//			filecontent.append(val + System.getProperty("line.separator"));
//		}
//		saveCenrepFile(filecontent.toString(), "cenrep_rfs.txt", fileLocation);
//		rfsFilePaths.add(fileLocation+"/"+"cenrep_rfs.txt");
//	}

//	private void initializeBuild() {
//		cenrepRfsContent.clear();
//		ibyManager.clear();
//		crmlFilePaths.clear();
//		genconFilePaths.clear();
//		rfsFilePaths.clear();
//		
//		EConfigurationProject cp = getConfigurationProject();
//		EList<EConfMLLayer> layers = cp.getLayers();
//		for (EConfMLLayer layer : layers) {
//			createBuildFolder(layer);
//		}
//	}

//	private void createBuildFolder(EConfMLLayer layer) {
//		String layerUri = layer.getLayerURI().toString();
//		String buildUri = CommonFolderApis.getFileSaveLayer(layerUri);
//		
//		IFolder folder = getProject().getFolder(new Path(buildUri));
//		if(folder.exists()) {
//			try {
//				folder.delete(true, null);
//			} catch (CoreException e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			if(folder.exists())
//				System.out.println("delete doesnt work");
//			folder.create(false, true, null);
//		} catch (CoreException e1) {
//			e1.printStackTrace();
//		}			
//	}

	void checkCrml(IResource resource) {
		EConfigurationProject configurationProject = getConfigurationProject();		
		if (resource instanceof IFile && resource.getName().endsWith(".crml")) {
			
			try {
				//System.out.println("building file: " + resource.getName());
				ResourceSet resourceSet = new ResourceSetImpl();
				
				// Get the URI of the model file.
				URI fileURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
				
				// Create a resource for this file.
				Resource crmlResource = resourceSet.getResource(fileURI,true);
				
				ECRMLDocumentRootImpl crmlDoc = (ECRMLDocumentRootImpl) crmlResource.getContents().get(0);
				ERepository repo = crmlDoc.getRepository();
				
				RepositoryWithData rWithData = new RepositoryWithData(repo,configurationProject,
						SettingValueCollector.getInstance());
				
//				if(repo.isRfs())
//					cenrepRfsContent.add(rWithData.getRfsContent());
//				
//				String layerUri = rWithData.getOutputLayer().getLayerURI().toString();
//				
//				CRTemplate crTemplate = new CRTemplate();
//				String cenrepFileContent = crTemplate.generate(rWithData);
//				
//				String cenrepFilename = getCenrepFileName(resource.getName());
//				
//				String buildUri = CommonFolderApis.getFileSaveLayer(layerUri);
//				
//				saveCenrepFile(cenrepFileContent,cenrepFilename,buildUri);
//				crmlFilePaths.add(buildUri+"/"+cenrepFilename);
				
			} catch (Exception e) {
//				System.err.println("problems with file:"+resource.getName());
			}
		}
//		else if(resource instanceof IFile && resource.getName().endsWith(".ibyml")){
			//ibyManager.processIbymlFile(getProject(), resource);
		
			
//		}
		else if (resource instanceof IFile && resource.getName().endsWith(".gcfml")) {
			String output = genconfManager.processGcfmlFile(getProject(), resource);
			//genconFilePaths .add(output);
		}
	}

	
//	private void saveCenrepFile(String cenrepFileContent,
//			String cenrepFilename, String buildUri) {
//		IProject pr = getProject();
//		IFile file = pr.getFile(buildUri+"/"+cenrepFilename);
//		if(!file.exists()) {
//			try {
//				file.create(new ByteArrayInputStream(cenrepFileContent.getBytes(CommonFolderApis.UTF_16LE_ID)),true,null);
//			} catch (CoreException e) {
//				e.printStackTrace();
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	private String getCenrepFileName(String name) {
//		int underScore = name.lastIndexOf('_');
//		int pointLoc = name.lastIndexOf('.');
//
//		return name.substring(underScore+1,pointLoc+1)+"txt";
//	}

	protected void fullBuild(final IProgressMonitor monitor)
	throws CoreException {
		try 
		{
			//initializeBuild();
			getProject().accept(new FullCrmlResourceVisitor());
		} 
		catch (CoreException e)
		{
		}
		NotesBuilder.getNotesBuilder().setProject(getProject());
		NotesBuilder.getNotesBuilder().buildNotes();
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		//System.out.println(cenrepRfsContent);
		delta.accept(new DeltaCrmlVisitor());
	}

	protected EConfigurationProject getConfigurationProject() {
		
		return ConfMLCore.getProjectModel(getProject());
	}
	
	public static void setView(EObject v)
	{
		view = v;
	}
	
//	public static void setEditor(ConfmlEditor e)
//	{
//		editor = e;
//	}
	
	public static EObject getView()
	{
		return view;
	}
	
	public static ELibraryRoot getResourceModelRoot()
	{
		return resModelRoot;
	}
	
	private void initializeResourceModel()
	{
		System.out.println("\n*** initializeResourceModel ***\n");
		
			//final URI inputURI = EditUIUtil.getURI(input);
			String file = getProject().getLocationURI().getPath();
			URI inputURI = URI.createFileURI(file);
//			File tempDefaultResourceLibraryFilesDir;
			try 
			{
//				tempDefaultResourceLibraryFilesDir = File.createTempFile("defaultResources", "");
//				tempDefaultResourceLibraryFilesDir.delete();
//				tempDefaultResourceLibraryFilesDir.mkdirs();
				
				resModelRoot = loadResourceModel(inputURI,getConfigurationProject());
			} catch (Exception e) 
			{

				e.printStackTrace();
			}
	
	}
	
		
	public static void removeTempResources()
	{
		if (rootCpfTempDir != null)
		{
			recursiveDeleteFile(rootCpfTempDir);

		}
	}
	
	private static void recursiveDeleteFile(File file)
	{
		File[] files = file.listFiles();
		if (files!=null)
			for (int i = 0 ; i < files.length ; i++)
			{
				if (files[i].isDirectory())
				{
					recursiveDeleteFile(files[i]);
					files[i].delete();
				}
				else
				{
					files[i].delete();
				}
			}
		file.delete();
	}
	
	
	private static void createEmptyFolders(EList<EConfMLLayer> layers)
	{
		for (EConfMLLayer layer : layers)
		{
			 URI contentURI = layer.getLayerURI().appendSegment("content");
			 File contentFolder = new File(workspaceRoot, contentURI.toPlatformString(false));
			 File[] files = contentFolder.listFiles();
			 createEmptyFolders(files);
		}
	}
	
	private static void createEmptyFolders(File[] files)
	{
		 if (files!=null) 
			for (int i = 0 ; i < files.length ; i++)
			 {
				 if (files[i].isDirectory()) 
				 {
					 File[] file = files[i].listFiles();
					 
					 if (file.length == 0)
					 {
						 //empty folder
						String localPath = files[i].getPath();
						localPath = localPath.substring(localPath.indexOf("content")+8);
						File emptyDir = new File(rootCpfTempDir, localPath);
						emptyDir.mkdirs();
					 }
					 else
					 {
						 createEmptyFolders(file);
					 }
				 }
			 }
	}

	
	/**
	 * Loads {@link ELibraryRoot} from given URI and
	 * {@link EConfigurationProject}
	 * 
	 * @param input
	 * @param configurationProject
	 * @param tempDefaultResourceLibraryFilesDir
	 * @return ResourceModelRoot
	 * @throws IOException
	 */
	public static ELibraryRoot loadResourceModel(URI input,
			EConfigurationProject configurationProject
			) throws IOException {

//		long start = System.currentTimeMillis();

		// create temporary resource library location
		ELibraryRoot resourceModelRoot = ELibraryModelFactory.eINSTANCE
				.createELibraryRoot();

		if (rootCpfTempDir!=null)
		{
			removeTempResources();
		}
		
		rootCpfTempDir = File.createTempFile("cpf", "_content");

		rootCpfTempDir.delete();
		rootCpfTempDir.mkdirs();
		
		System.out.println("Created "+rootCpfTempDir.getName());

		resourceModelRoot.setTempDirPath(rootCpfTempDir.getAbsolutePath());

		// LOAD COMPLETE RESOURCE MAP INTO TMP
		// entry.key == Resource Path relative to CONTENT
		// entry.value == Resource Path relative CPF ROOT
		EConfMLLayer lastLayer = configurationProject.getLastLayer();
		if (lastLayer != null) {
			EMap<URI, URI> resourceMap = lastLayer.getResourceMap();

			
			
			Map<URI, List<URI>> reverseMap = new HashMap<URI, List<URI>>();
			for (Map.Entry<URI, URI> entry : resourceMap) {
				URI local = entry.getKey();
				URI global = entry.getValue();
				List<URI> list = reverseMap.get(global);
				if (list == null) {
					list = new ArrayList<URI>();
					reverseMap.put(global, list);
				}
				list.add(local);
			}

			Iterator<Entry<URI, List<URI>>> iter = reverseMap.entrySet().iterator();

			while (iter.hasNext())
			{
				Entry<URI, List<URI>> entry = iter.next();
				if (entry==null)
					continue;
				List<URI> targets = entry.getValue();

				if (targets == null) {
					continue;
				}
				for (URI targetURI : targets) {
					
					//String targetPath = targetURI.path();
					String targetPath = URI.decode(targetURI.path());

					File file = new File(rootCpfTempDir, targetPath);
				
					if (file.isDirectory()) 
					{
						file.mkdirs();
					} 
					else 
					{
						File parent = file.getParentFile();
					
						parent.mkdirs();
						FileOutputStream os = new FileOutputStream(file);
						
						String isString = entry.getKey().toPlatformString(true);
						String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
						
						FileInputStream is = new FileInputStream(workspace+isString);
						
						FileUtils.copyStream(is, os);
						FileUtils.closeStream(os);
					}
				}
			}
			// create resource library model
			createEmptyFolders(configurationProject.getLayers());
			processResourceLibrary(configurationProject, resourceModelRoot,	rootCpfTempDir, resourceMap, lastLayer);
		}
		//long end = System.currentTimeMillis();
		// System.out.println("Load Resource Model:" + (end - start));
		System.out.println("\n*** return resourceModelRoot, size:"+resourceModelRoot.getSize()+" ***\n");
		return resourceModelRoot;
	}
	
	private static void processResourceLibrary(
			EConfigurationProject configurationProject, ELibraryDirectory toDirectory,
			File fromDirectory, EMap<URI, URI> resourceMap,
			EConfMLLayer lastLayer) {
		File[] listFiles = fromDirectory.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			File file = listFiles[i];
			
			ELibraryElement f;
			if (file.isDirectory()) {
				f = ELibraryModelFactory.eINSTANCE.createELibraryDirectory();
				f.setName(file.getName());
				toDirectory.getChildren().add(f);

				processResourceLibrary(configurationProject, (ELibraryDirectory) f,
						file, resourceMap, lastLayer);
			} else {
				
				f = ELibraryModelFactory.eINSTANCE.createELibraryFile();
				
				f.setName(file.getName());
				toDirectory.getChildren().add(f);

				String path = f.getPath();
				path = path.replace('\\', '/');
				
				URI tempUri = URI.createURI(URI.encodeFragment(path, true));
				URI uri = resourceMap.get(tempUri);
				if (uri.path().startsWith(lastLayer.getLayerURI().path())) {
					f.setReadOnly(false);
				} else {
					f.setReadOnly(true);
				}

				((ELibraryFile) f)
						.setSize(file.length());
			}

			EList<ELibraryElement> children = toDirectory.getChildren();
			boolean readOnly = false;
			for (ELibraryElement fse : children) {
				if (fse.isReadOnly()) {
					readOnly = true;
					break;
				}
			}
			toDirectory.setReadOnly(readOnly);

			if (toDirectory instanceof ELibraryRoot
					&& f instanceof ELibraryDirectory) {
				// f.setReadOnly(true);
			}
		}
	}

}
