package com.oopsconsultancy.xmltask;

import org.w3c.dom.*;

/**
 * pastes a buffer below the nominated node and its children
 *
 * @author <a href="mailto:brian@oopsconsultancy.com">Brian Agnew</a>
 * @version $Id: PasteAction.java,v 1.2 2003/08/08 21:01:49 bagnew Exp $
 */
public class PasteAction extends Action {

  private String buffer = null;

  public PasteAction(String buffer) {
    this.buffer = buffer;
  }

  public boolean apply(Node node) throws Exception {
    return true;
  }

  public String toString() {
    return "PasteAction(" + buffer +")";
  }
}

