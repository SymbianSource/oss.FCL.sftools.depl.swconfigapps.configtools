/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.carbidev component.
 */

package com.nokia.tools.variant.carbidev;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubToolBarManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.SubActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.nokia.tools.variant.carbidev.perspective.actions.CarbideVResetPerspectiveAction;
import com.nokia.tools.variant.editor.actions.DeselectAllSettingsAction;
import com.nokia.tools.variant.editor.actions.ExportDataAsConfML;
import com.nokia.tools.variant.editor.actions.HideSettingsFromViewAction;
import com.nokia.tools.variant.editor.actions.ResetToDefaultAction;
import com.nokia.tools.variant.editor.actions.SaveActionUI;
import com.nokia.tools.variant.editor.actions.SelectAllSettingsAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private Composite propertiesControl;
	private IContributionItem reopen;
	private ActionSetRegistry reg;
	private IActionSetDescriptor[] actionSets;
	private IWorkbenchAction saveAsAction;
	private IWorkbenchAction saveAction;
	private IWorkbenchAction closeAction;
	private IWorkbenchAction closeAllAction;
	private ExportDataAsConfML exportDataAsConfML;

	// not working actions
	private IWorkbenchAction cutAction;
	private IWorkbenchAction copyAction;
	private IWorkbenchAction pasteAction;
	private IWorkbenchAction deleteAction;

	private SelectAllSettingsAction selectAllAction;
	private DeselectAllSettingsAction deselectAllAction;
	private HideSettingsFromViewAction hideSelectedSettingsAction;
	private ResetToDefaultAction resetToDefaultAction;

	// private UpdateAction updateAction;

	private IWorkbenchAction toolbarAction;
	private IWorkbenchAction resetPerspectiveAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);

		reg = WorkbenchPlugin.getDefault().getActionSetRegistry();
		actionSets = reg.getActionSets();
	}

	private IWorkbenchAction undoAction;

	private IWorkbenchAction redoAction;
	private IWorkbenchAction exitAction;
	private IWorkbenchAction helpAction;
	private IWorkbenchAction aboutAction;
	private MenuManager showViewMenuMgr;

	protected void makeActions(IWorkbenchWindow window) {
		undoAction = ActionFactory.UNDO.create(window);
		register(undoAction);
		// saveAction = ActionFactory.SAVE.create(window);
		saveAction = new SaveActionUI(window);
		register(saveAction);
		saveAsAction = ActionFactory.SAVE_AS.create(window);
		register(saveAsAction);
		redoAction = ActionFactory.REDO.create(window);
		register(redoAction);
		closeAction = ActionFactory.CLOSE.create(window);
		register(closeAction);
		closeAllAction = ActionFactory.CLOSE_ALL.create(window);
		register(closeAllAction);


		copyAction = ActionFactory.COPY.create(window);		
		register(copyAction);
		cutAction = ActionFactory.CUT.create(window);		
		register(cutAction);
		pasteAction = ActionFactory.PASTE.create(window);		
		register(pasteAction);
		deleteAction = ActionFactory.DELETE.create(window);		
		register(deleteAction);


		selectAllAction = SelectAllSettingsAction.getInstance();//new SelectAllSettingsAction();
		selectAllAction.init(window);
		selectAllAction.setEnabled(false);
		deselectAllAction = new DeselectAllSettingsAction();
		deselectAllAction.init(window);
		deselectAllAction.setEnabled(false);
		hideSelectedSettingsAction = new HideSettingsFromViewAction();
		hideSelectedSettingsAction.init(window);
		hideSelectedSettingsAction.setEnabled(false);
		resetToDefaultAction = new ResetToDefaultAction();
		resetToDefaultAction.init(window);
		resetToDefaultAction.setEnabled(false);
		exportDataAsConfML = new ExportDataAsConfML(window);
		register(exportDataAsConfML);

		toolbarAction = ActionFactory.TOGGLE_COOLBAR.create(window);
		register(toolbarAction);
		// resetPerspectiveAction =
		// ActionFactory.RESET_PERSPECTIVE.create(window);
		resetPerspectiveAction = RESET_PERSPECTIVE.create(window);
		register(resetPerspectiveAction);

		reopen = new BetterReopenEditorMenu(window, "reopen", true);

		helpAction = ActionFactory.HELP_CONTENTS.create(window);

		String appName = (String) Activator.getPluginProperties().getObject(
				"appName");
		helpAction.setText(appName + " &Help ...");
		helpAction.setAccelerator(SWT.F1);
		register(helpAction);
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		// ConfigurationManagerWindow configurationManagerWindow=new
		// ConfigurationManagerWindow(window.getShell());

		// updateAction=new UpdateAction();
		// updateAction.setId(UpdateAction.ID);
		// updateAction.setText("Update Action");
		// findUpdatesAction =
		// new FindUpdatesAction( configurationManagerWindow,
		// UpdateUIMessages.ConfigurationView_findUpdates);

		// findUpdatesAction=new
		// FindUpdatesAction(configurationManagerWindow,"fshgbfdh");
		// findUpdatesAction.setEnabled(true);
		// findUpdatesAction.setId("sgbfdfabda");

		// ConfigurationView configurationView=new
		// ConfigurationView(configurationManagerWindow);

		// register( updateAction);

		hackProperties(window);
	}

	private void hackProperties(IWorkbenchWindow window) {

		window.addPageListener(new IPageListener() {

			public void pageActivated(IWorkbenchPage page) {

				getAndHideProperties(page);

			}

			public void pageClosed(IWorkbenchPage page) {

			}

			public void pageOpened(IWorkbenchPage page) {
				getAndHideProperties(page);

			}

		});

		window.getPartService().addPartListener(new IPartListener() {

			public void partActivated(IWorkbenchPart part) {
				getAndHideProperties(part.getSite().getPage());
			}

			public void partBroughtToTop(IWorkbenchPart part) {
				getAndHideProperties(part.getSite().getPage());
			}

			public void partClosed(IWorkbenchPart part) {
				handlePropertiesVisibility(part);

			}

			private void handlePropertiesVisibility(IWorkbenchPart part) {
				IWorkbench workbench = PlatformUI.getWorkbench();
				if (workbench != null) {
					IWorkbenchWindow activeWorkbenchWindow = workbench
							.getActiveWorkbenchWindow();
					if (activeWorkbenchWindow != null) {
						IWorkbenchPage activePage = activeWorkbenchWindow
								.getActivePage();
						if (activePage != null) {
							IEditorPart activeEditor = activePage
									.getActiveEditor();
							if (activeEditor != null) {
								return;
							}
						}
					}
				}
				if (propertiesControl != null
						&& !propertiesControl.isDisposed()) {
					propertiesControl.setVisible(false);
				} else {
					getAndHideProperties(part.getSite().getPage());
				}
			}

			public void partDeactivated(IWorkbenchPart part) {
				IWorkbench workbench = PlatformUI.getWorkbench();
				if (workbench != null) {
					IWorkbenchWindow activeWorkbenchWindow = workbench
							.getActiveWorkbenchWindow();
					if (activeWorkbenchWindow != null) {
						IWorkbenchPage activePage = activeWorkbenchWindow
								.getActivePage();
						if (activePage != null) {
							IEditorPart activeEditor = activePage
									.getActiveEditor();
							if (activeEditor != null) {
								return;
							}
						}
					}
				}
				if (propertiesControl != null
						&& !propertiesControl.isDisposed()) {
					propertiesControl.setVisible(false);
				} else {
					getAndHideProperties(part.getSite().getPage());
				}
			}

			public void partOpened(IWorkbenchPart part) {
				IWorkbench workbench = PlatformUI.getWorkbench();
				if (workbench != null) {
					IWorkbenchWindow activeWorkbenchWindow = workbench
							.getActiveWorkbenchWindow();
					if (activeWorkbenchWindow != null) {
						IWorkbenchPage activePage = activeWorkbenchWindow
								.getActivePage();
						if (activePage != null) {
							IEditorPart activeEditor = activePage
									.getActiveEditor();
							if (activeEditor != null) {
								return;
							}
						}
					}
				}
				if (part instanceof PropertySheet) {
					PageBookView findView = (PageBookView) part;
					if (findView.getCurrentPage() instanceof PropertySheetPage) {
						PropertySheetPage currentPage = (PropertySheetPage) findView
								.getCurrentPage();
						SubActionBars actionBars = (SubActionBars) currentPage
								.getSite().getActionBars();
						SubToolBarManager toolBarManager = (SubToolBarManager) actionBars
								.getToolBarManager();
						IContributionManager parent2 = toolBarManager
								.getParent();
						parent2.removeAll();
						parent2.update(true);
						propertiesControl = (Composite) currentPage
								.getControl();
						propertiesControl.setVisible(false);
						propertiesControl.addPaintListener(new PaintListener() {

							public void paintControl(PaintEvent e) {
								propertiesControl.setVisible(false);

							}

						});
					}
				}
			}

		});

	}

	protected void fillMenuBar(IMenuManager menuBar) {
		menuBar.add(createFileMenu());
		menuBar.add(createEditMenu());
		menuBar.add(createToolsMenu());
		menuBar.add(createViewMenu());
		menuBar.add(createHelpMenu());

		// removing unwanted actions
		removeAction("org.eclipse.search.searchActionSet");
	}

	private MenuManager createEditMenu() {
		MenuManager editMenu = new MenuManager("&Edit", "rcpEdit");
		editMenu.add(undoAction);
		editMenu.add(redoAction);
		editMenu.add(new Separator());
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		editMenu.add(deleteAction);
		editMenu.add(new Separator());
		editMenu.add(selectAllAction);
		editMenu.add(deselectAllAction);
		editMenu.add(hideSelectedSettingsAction);
		editMenu.add(resetToDefaultAction);
		editMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		editMenu.add(new Separator());
		editMenu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
		return editMenu;
	}

	private MenuManager createViewMenu() {
		MenuManager viewMenu = new MenuManager("&View", "rcpView");
		viewMenu.add(new GroupMarker("views"));
		viewMenu.add(new Separator());
		viewMenu.add(new GroupMarker("errorview"));
		viewMenu.add(new GroupMarker("notesview"));
		viewMenu.add(new GroupMarker("changesview"));
		viewMenu.add(new GroupMarker("searchresultview"));
		viewMenu.add(new Separator());
		toolbarAction.setText("Toolbar");
		toolbarAction.setToolTipText("Displays / hides Toolbar");
		toolbarAction.setChecked(true);
		viewMenu.add(toolbarAction);
		viewMenu.add(new GroupMarker("bars"));
		viewMenu.add(new Separator());
		resetPerspectiveAction.setText("Reset Layout");
		resetPerspectiveAction.setImageDescriptor(Activator
				.getImageDescriptor("icons/carbide_v_16x16.png"));
		viewMenu.add(resetPerspectiveAction);
		viewMenu.add(new Separator());
		viewMenu.add(new GroupMarker(IWorkbenchActionConstants.WINDOW_EXT));
		return viewMenu;
	}

	private MenuManager createHelpMenu() {
		MenuManager helpMenu = new MenuManager("&Help", "rcpHelp");
		helpMenu.add(helpAction);
		helpMenu.add(new Separator());
		helpMenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
		helpMenu.add(new Separator());
		helpMenu.add(new GroupMarker("middlepart"));
		helpMenu.add(new Separator());
		helpMenu.add(aboutAction);

		helpMenu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		return helpMenu;
	}

	private MenuManager createFileMenu() {
		MenuManager fileMenu = new MenuManager("&File", "rcpFile");
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.OPEN_EXT));
		fileMenu.add(new GroupMarker("openasnew"));
		fileMenu.add(closeAction);
		fileMenu.add(closeAllAction);
		fileMenu.add(new Separator());
		fileMenu.add(saveAction);
		fileMenu.add(saveAsAction);
		fileMenu.add(exportDataAsConfML);
		// Copy and Report moved to Tools
		// fileMenu.add(new Separator());
		// fileMenu.add(new GroupMarker("copy"));
		// fileMenu.add(new
		// GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		fileMenu.add(new Separator());
		fileMenu.add(exitAction);
		fileMenu.add(new Separator());
		fileMenu.add(reopen);
		return fileMenu;
	}

	private MenuManager createToolsMenu() {
		MenuManager toolsMenu = new MenuManager("&Tools", "rcpTools");
		toolsMenu.add(new GroupMarker("copy"));
		toolsMenu.add(new GroupMarker("report"));

		return toolsMenu;
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager tb = new ToolBarManager(coolBar.getStyle());
		tb.add(new GroupMarker(IWorkbenchActionConstants.OPEN_EXT));
		tb.add(saveAction);
		tb.add(saveAsAction);
		tb.add(exportDataAsConfML);
		tb.add(new Separator());
		tb.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		coolBar.add(new ToolBarContributionItem(tb, "rcpMain"));

		// IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
		// coolBar.add(new ToolBarContributionItem(toolbar, "rcpMain"));
		// toolbar.add(saveAction);
		// toolbar.add(saveAsAction);
		// removing unwanted actions
		removeAction("org.eclipse.ui.edit.text.actionSet.navigation");
		removeAction("org.eclipse.ui.edit.text.actionSet.annotationNavigation");
	}

	/**
	 * Removing native Jazz or Eclipse buttons from toolbar and menu.
	 * 
	 * @param actionSetId
	 */
	private void removeAction(String actionSetId) {

		for (int i = 0; i < actionSets.length; i++)

		{

			if (!actionSets[i].getId().equals(actionSetId))

				continue;

			IExtension ext = actionSets[i].getConfigurationElement()

			.getDeclaringExtension();

			reg.removeExtension(ext, new Object[] { actionSets[i] });

		}

	}

	private void getAndHideProperties(IWorkbenchPage page) {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (activeWorkbenchWindow != null) {
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if (activePage != null) {
				IEditorPart activeEditor = activePage.getActiveEditor();
				if (activeEditor != null) {
					return;
				}
			}
		}
		PageBookView findView = (PageBookView) page
				.findView("org.eclipse.ui.views.PropertySheet");
		if (findView != null
				&& findView.getCurrentPage() instanceof PropertySheetPage) {
			PropertySheetPage currentPage = (PropertySheetPage) findView
					.getCurrentPage();
			SubActionBars actionBars = (SubActionBars) currentPage.getSite()
					.getActionBars();
			SubToolBarManager toolBarManager = (SubToolBarManager) actionBars
					.getToolBarManager();
			IContributionManager parent2 = toolBarManager.getParent();
			parent2.removeAll();
			parent2.update(true);
			propertiesControl = (Composite) currentPage.getControl();
			propertiesControl.setVisible(false);
			propertiesControl.addPaintListener(new PaintListener() {

				public void paintControl(PaintEvent e) {
					propertiesControl.setVisible(false);

				}

			});
		}
	}

	/**
	 * Workbench action (id "resetPerspective"): Resets the current perspective.
	 * This action maintains its enablement state.
	 */
	public static final ActionFactory RESET_PERSPECTIVE = new ActionFactory(
			"resetPerspective") {//$NON-NLS-1$

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.eclipse.ui.actions.ActionFactory#create(org.eclipse.ui.
		 * IWorkbenchWindow)
		 */
		public IWorkbenchAction create(IWorkbenchWindow window) {
			if (window == null) {
				throw new IllegalArgumentException();
			}
			IWorkbenchAction action = new CarbideVResetPerspectiveAction(window);
			action.setId(getId());
			return action;
		}
	};
}
