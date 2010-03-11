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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.editors.composites;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.ViewPart;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.actions.CopyAction;
import com.nokia.tools.variant.editor.actions.CutAction;
import com.nokia.tools.variant.editor.actions.DeleteAction;
import com.nokia.tools.variant.editor.actions.PasteAction;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.views.searchresultsview.SearchResultsView;
import com.nokia.tools.variant.views.searchresultsview.SearchResultsViewPage;

/**
 * Component allowing searching of the confml settings
 * 
 */
public class SearchComposite {

	private static Font boldFont = null;
	private CPFEditor editor;

	private CutAction cutAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private DeleteAction deleteAction;

	private boolean focused = false;

	/**
	 * 
	 * @param editor
	 */
	public SearchComposite(CPFEditor editor) {
		this.editor = editor;
	}

	public static Font getBoldFont() {
		if (boldFont == null) {
			FontData fd = JFaceResources.getDefaultFont().getFontData()[0];

			boldFont = new Font(Display.getDefault(), fd.getName(), 8, SWT.BOLD);
		}
		return boldFont;
	}

	/**
	 * Text field with autocomplete feature with supplied content
	 * 
	 * 
	 * 
	 */
	public class AutoCompleteTextField {

		private Text text;

		public AutoCompleteTextField(Composite parent, int style) {

			text = new Text(parent, SWT.NONE);

			SearchContentProposalProvider proposalProvider = new SearchContentProposalProvider(
					view);
			// proposalProvider.setFiltering(false);

			final org.eclipse.jface.fieldassist.ContentProposalAdapter adapter = new org.eclipse.jface.fieldassist.ContentProposalAdapter(
					text, new TextContentAdapter(), proposalProvider, null,
					null);
			adapter.setLabelProvider(new LabelProvider() {

				public String getText(Object element) {
					IContentProposal proposal = (IContentProposal) element;
					String content = proposal.getContent();
					return content;
				}
			});
			text.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent es) {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							try {
								// acquire nested private proposalTable in popup
								Field declaredField = org.eclipse.jface.fieldassist.ContentProposalAdapter.class
										.getDeclaredField("popup");
								declaredField.setAccessible(true);
								Object popup = declaredField.get(adapter);
								if (popup == null) {
									return;
								}
								Class<?> popupClass = org.eclipse.jface.fieldassist.ContentProposalAdapter.class
										.getDeclaredClasses()[0];

								Field popupTableField = popupClass
										.getDeclaredField("proposalTable");
								popupTableField.setAccessible(true);
								final Table table = (Table) popupTableField
										.get(popup);

								Color blue = new Color(Display.getDefault(),
										232, 242, 255);
								table.setBackground(blue);
								blue.dispose();

								table.addMouseListener(new MouseListener() {

									public void mouseUp(MouseEvent e) {
									}

									public void mouseDown(MouseEvent e) {
									}

									public void mouseDoubleClick(MouseEvent e) {
										int selectionIndex = table
												.getSelectionIndex();
										TableItem item = table
												.getItem(selectionIndex);
										Display.getDefault().asyncExec(
												new Runnable() {

													public void run() {
														showSearchResult();
													}
												});
									}
								});

								table.addListener(SWT.MeasureItem,
										new Listener() {

											public void handleEvent(Event event) {

												Font bold = getBoldFont();
												event.gc.setFont(bold);
												Widget i = event.item;
												Point stringExtent = event.gc
														.stringExtent(i
																.toString());
												event.width = Math.max(
														event.width,
														stringExtent.x);
												event.height = Math.max(
														stringExtent.y,
														event.height);
											}
										});

								table.addListener(SWT.PaintItem,
										new Listener() {

											public void handleEvent(Event event) {
												TableItem item = (TableItem) event.item;

												// clear original default font
												// text
												Rectangle bounds = item
														.getBounds();

												// clear item area - fill it
												// with white color
												event.gc.fillRectangle(bounds);

												// item text
												String proposalText = item
														.getText();
												proposalText = proposalText
														.trim();

												// searched keyword
												String searchedKeyword = ((Text) text)
														.getText();

												// textFieldText =
												// textFieldText.trim();
												String lowerCase = proposalText
														.toLowerCase();

												// starting index of bold text
												int indexOf = lowerCase
														.indexOf(searchedKeyword
																.toLowerCase());
												if (indexOf == -1) {// if not
													// found
													// return
													return;
												}

												// write first non bold text
												int diffX = 0;
												if (indexOf > 0) {
													String firstNonBoldString = proposalText
															.substring(0,
																	indexOf);
													Point firstTextSize = event.gc
															.stringExtent(firstNonBoldString);
													diffX = firstTextSize.x;

													event.gc.drawText(
															firstNonBoldString,
															event.x, event.y);
												}

												// create bold font
												FontData fd = JFaceResources
														.getDefaultFont()
														.getFontData()[0];
												final Font boldFont = new Font(
														Display.getDefault(),
														fd.getName(), 8,
														SWT.BOLD);

												// bold text size
												Point textExtent2 = event.gc
														.textExtent(proposalText
																.substring(0,
																		indexOf));

												String searchedBoldText = proposalText
														.substring(
																indexOf,
																indexOf
																		+ searchedKeyword
																				.length());
												// set bold font & draw bold
												// text
												event.gc.setFont(boldFont);
												event.gc
														.drawText(
																searchedBoldText,
																event.x
																		+ textExtent2.x,
																event.y);

												// get default font
												Font defaultFont = JFaceResources
														.getDefaultFont();

												// draw default font text
												Point normalFont = event.gc
														.textExtent(searchedBoldText);
												event.gc.setFont(defaultFont);
												event.gc
														.drawText(
																proposalText
																		.substring(
																				indexOf
																						+ searchedKeyword
																								.length(),
																				proposalText
																						.length()),
																event.x
																		+ textExtent2.x
																		+ normalFont.x,
																event.y);
												boldFont.dispose();

												// make new item width according
												// to enlarged text
												int width = normalFont.x
														+ textExtent2.x;
												Widget w = event.item;
												if (w instanceof TableItem) {
													TableItem tableItem = (TableItem) w;
													// tableItem.set
												}
											}

										});
							} catch (SecurityException e) {

								e.printStackTrace();
							} catch (NoSuchFieldException e) {
								e.printStackTrace();
							} catch (IllegalArgumentException e) {

								e.printStackTrace();
							} catch (IllegalAccessException e) {

								e.printStackTrace();
							}

						}

					});
				}

			});
			adapter
					.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

		}

		public Text getText() {
			return text;
		}
	}

	public void setSelectedSettingInCPFEditor(Setting s) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (activePage != null) {
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor instanceof ISelectionProvider) {
				ISelectionProvider provider = (ISelectionProvider) activeEditor;
				provider.setSelection(new StructuredSelection(s));
			}
		}

	}

	private static final String SEARCH = "Search";

	private AutoCompleteTextField autocmpleteText;

	private Composite searchComposite;

	private View view;

	private Button searchBtn;

	/**
	 * Create search UI
	 * 
	 * @param formToolkit
	 *            form toolkit
	 * @param parent
	 *            parent composite
	 * @param view
	 *            confml model View
	 */
	public Composite createSearchComposite(FormToolkit formToolkit,
			Composite parent, View view) {
		searchComposite = formToolkit.createComposite(parent, SWT.BORDER);

		this.view = view;
		searchComposite.setBackground(ColorConstants.white);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.numColumns = 2;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 5;
		searchComposite.setLayout(gridLayout);

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		searchComposite.setLayoutData(gridData);

		autocmpleteText = new AutoCompleteTextField(searchComposite, SWT.BORDER);
		autocmpleteText.getText().setLayoutData(
				new GridData(GridData.FILL_HORIZONTAL));

		formToolkit.paintBordersFor(searchComposite);

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.minimumWidth = 100;
		gridData.horizontalIndent = 5;
		autocmpleteText.getText().setLayoutData(gridData);

		autocmpleteText.getText().addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13 || e.keyCode == 16777296) {
					showSearchResult();
				} else {
				}
			}

			public void keyReleased(KeyEvent e) {

			}
		});

		autocmpleteText.getText().addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {				
				focused = true;
				editor.setSelection(new StructuredSelection(autocmpleteText));	
				enableEditActions(true);						
			}

			public void focusLost(FocusEvent e) {
				focused = false;
			}
		});

		/*
		 * titleText.addModifyListener(new ModifyListener() {
		 * 
		 * public void modifyText(ModifyEvent e) { if (previousText == null) {
		 * previousText = titleText.getText(); comboViewer.refresh(); } else if
		 * (previousText != null && !previousText.equals(titleText.getText())) {
		 * previousText = titleText.getText(); comboViewer.refresh(); }
		 * 
		 * } });
		 */
		searchBtn = formToolkit.createButton(searchComposite, SEARCH, SWT.PUSH);

		gridData = new GridData();
		gridData.minimumWidth = 60;
		searchBtn.setLayoutData(gridData);
		searchBtn.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				showSearchResult();
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		createActions(autocmpleteText.getText());

		MenuManager mm = new MenuManager();
		mm.addMenuListener(new MenuListener(autocmpleteText.getText()));
		mm.setRemoveAllWhenShown(true);
		Menu menu = mm.createContextMenu(autocmpleteText.getText());
		autocmpleteText.getText().setMenu(menu);

		return searchComposite;

	}

	private void createActions(Object control) {
		
		cutAction = (CutAction) editor.getEditorSite().getActionBars()
				.getGlobalActionHandler(ActionFactory.CUT.getId());
		copyAction = (CopyAction) editor.getEditorSite().getActionBars()
				.getGlobalActionHandler(ActionFactory.COPY.getId());
		pasteAction = (PasteAction) editor.getEditorSite().getActionBars()
				.getGlobalActionHandler(ActionFactory.PASTE.getId());
		deleteAction = (DeleteAction) editor.getEditorSite().getActionBars()
				.getGlobalActionHandler(ActionFactory.DELETE.getId());
	}
	
	public void enableEditActions(boolean enable) {
		cutAction.setEnabled(enable);
		copyAction.setEnabled(enable);
		pasteAction.setEnabled(enable);
		deleteAction.setEnabled(enable);
		editor.getEditorSite().getActionBars().updateActionBars();
	}

	class MenuListener implements IMenuListener {
		private Control parent;

		public MenuListener(Control parent) {
			this.parent = parent;
		}

		public void menuAboutToShow(IMenuManager menu) {
			contextMenuAboutToShow(menu, parent);
		}

		protected void contextMenuAboutToShow(IMenuManager menu, Control parent) {
			menu.add(new Separator());
			menu.add(cutAction);
			menu.add(copyAction);
			menu.add(pasteAction);
			menu.add(deleteAction);
			menu.add(new Separator());
			
			editor.enableEditActions(true);
		}
	}

	/**
	 * Displays result of the search in search view
	 */
	private void showSearchResult() {
		String searchText = autocmpleteText.getText().getText();
		List<Setting> foundSettings = new ArrayList<Setting>();
		if (searchText != null && !searchText.equals("")) {
			// now search from viewmodel

			EList<Setting> viewSettings = view.getSharedSettingInstances();
			boolean contains;
			for (Setting setting : viewSettings) {
				if (!setting.isVisible()) {
					continue;
				}
				if (setting instanceof SequenceSetting) {
					SequenceSetting ss = (SequenceSetting) setting;

					if (ss.getName() != null
							&& ss.getName().toLowerCase().contains(
									searchText.toLowerCase())) {
						contains = true;
					} else {
						contains = false;
					}

					if (contains) {
						foundSettings.add(ss);
					} else {
						if (ss.getDescription() != null) {
							contains = ss.getDescription().toLowerCase()
									.contains(searchText.toLowerCase());
							if (contains) {
								foundSettings.add(ss);
							}
						}
					}

					EList<SequenceItem> sequenceItems = ss.getSequenceItem();
					for (SequenceItem si : sequenceItems) {
						EList<Setting> subSettings = si.getSetting();
						for (Setting subSetting : subSettings) {
							if (subSetting.getName() != null
									&& subSetting.getName().toLowerCase()
											.contains(searchText.toLowerCase())) {
								contains = true;
							} else {
								contains = false;
							}

							if (contains) {
								foundSettings.add(subSetting);
							} else {
								if (subSetting.getDescription() != null) {
									contains = subSetting.getDescription()
											.toLowerCase().contains(
													searchText.toLowerCase());
									if (contains) {
										foundSettings.add(subSetting);
									}
								}
							}
						}
					}
				} else {
					contains = setting.getName().toLowerCase().contains(
							searchText.toLowerCase());
					if (contains) {
						foundSettings.add(setting);
					} else {
						if (setting.getDescription() != null) {
							contains = setting.getDescription().toLowerCase()
									.contains(searchText.toLowerCase());
							if (contains) {
								foundSettings.add(setting);
							}
						}
					}
				}
			}

		}
		// switch to searchresult view
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		if (window != null) {
			IWorkbenchPage wPage = window.getActivePage();
			if (wPage != null) {
				IViewPart view = wPage.findView(SearchResultsView.VIEW_ID);
				if (view == null) {

					try {
						view = wPage.showView(SearchResultsView.VIEW_ID);
					} catch (PartInitException pie) {
					}
				} else {
					wPage.bringToTop(view);
					view.setFocus();
				}
				// show results in table
				SearchResultsView searchView = (SearchResultsView) view;
				SearchResultsViewPage viewPage = (SearchResultsViewPage) searchView
						.getCurrentPage();
				viewPage.setKeyword(searchText);
				viewPage.setInput(foundSettings);

				if (foundSettings.size() == 1) {// selected one setting in
					// editor
					setSelectedSettingInCPFEditor(foundSettings.get(0));
				}
			}
		}

	}

	/**
	 * Dispose
	 */
	public void dispose() {
		view = null;
		if (!searchComposite.isDisposed()) {
			searchComposite.dispose();
		}
		searchComposite = null;

		if (!searchBtn.isDisposed()) {
			searchBtn.dispose();
		}
		searchBtn = null;

		if (!autocmpleteText.getText().isDisposed()) {
			autocmpleteText.getText().dispose();
		}
		autocmpleteText = null;
	}

	public Control getControl() {
		return searchComposite;
	}

	class SearchFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {

			if (element instanceof String) {
				String name = (String) element;
				String searchedText = autocmpleteText.getText().getText();
				if (name.contains(searchedText)) {
					System.out
							.println(name + " contains(" + searchedText + ")");
					return true;
				}
			}

			System.out.println("false");
			return false;
		}

	}

	public AutoCompleteTextField getAutocmpleteText() {
		return autocmpleteText;
	}

	public boolean isFocused() {
		return focused;
	}

}
