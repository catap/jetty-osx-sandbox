package com.github.catap.jetty_osx_sandbox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Launcher {

    static String loginItemID = "com.github.catap.jetty_osx_sandbox_daemon";

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);

        Button button = new Button(shell, SWT.TOGGLE);
        button.setSelection(LoginItemHelper.getEnabled(loginItemID));
        button.setLocation(170, 150);
        button.setText("Launch on startup");
        button.pack();
        button.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (button.getSelection()) {
                    if (!LoginItemHelper.setEnabled(loginItemID)) {
                        System.err.println("Can't register Login Item");
                    }
                    button.setSelection(true);
                } else {
                    if (!LoginItemHelper.setDisabled(loginItemID)) {
                        System.err.println("Can't deregister Login Item");
                    }
                    button.setSelection(false);
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {

            }
        });

        shell.setSize(500, 500);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }

        display.dispose();
    }
}
