package de.bht.fpa.mail.s770656.fsnavigation;

import java.io.File;
import java.net.MalformedURLException;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class NavigationView extends ViewPart {
  public static final String ID = "de.bht.fpa.s<MATRIKELNUMMER>.fsnavigation.NavigationView";
  private TreeViewer viewer;

  /**
   * This is a callback that will allow us to create the viewer and initialize
   * it.
   */
  @Override
  public void createPartControl(Composite parent) {
    // a TreeViewer is a Jface widget, which shows trees
    viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

    // We set the ContentProvider for the TreeViewer. This class prepares data
    // to be shown by the TreeViewer.
    viewer.setContentProvider(new ViewContentProvider());

    // We set the LabelProvider. This class decides how elements in the tree are
    // shown by returning a text and an optional icon.
    viewer.setLabelProvider(new ViewLabelProvider());

    // Here we set the root of the tree. The framework will ask for more data
    // when the user expands tree items.
    viewer.setInput(createModel());
  }

  /**
   * We will set up a model to initialize tree hierarchy.
   */
  private Object createModel() {
    // Our root item is simply a dummy Object. Here you need to provide your own
    // root class.
    try {

      File verzeichnis = new File("C:/Users/Dodo");
      Object verObject = verzeichnis.toURI().toURL();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return new Object();
  }

  /**
   * Passing the focus request to the viewer's control.
   */
  @Override
  public void setFocus() {
    viewer.getControl().setFocus();
  }
}