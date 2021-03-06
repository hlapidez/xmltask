package com.oopsconsultancy.xmltask.jdk15;

import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.oopsconsultancy.xmltask.*;
import com.sun.org.apache.xpath.internal.objects.*;
import com.sun.org.apache.xpath.internal.*;

/**
 * uses the JDK 1.5 XPath API
 * to analyse XML docs
 *
 * @author <a href="mailto:brian@oopsconsultancy.com">Brian Agnew</a>
 * @version $Id: XPathAnalyser15.java,v 1.2 2004/05/18 08:42:17 bagnew Exp $
 */
public class XPathAnalyser15 implements XPathAnalyser {

  private XPathAnalyserClient client;
  private Object callback;

  public void registerClient(XPathAnalyserClient client, Object callback) {
    this.client = client;
    this.callback = callback;
  }

  public int analyse(Node node, String xpath) throws Exception {
    int count = 0;
    XObject result = XPathAPI.eval(node, xpath);
    if (result instanceof XNodeSet) {
      NodeIterator nl = result.nodeset();
      Node n;
      while ((n = nl.nextNode()) != null) {
        client.applyNode(n, callback);
        count++;
      }
    }
    else if (result instanceof XBoolean ||
             result instanceof XNumber ||
             result instanceof XString) {
      String str = result.str();
      client.applyNode(str, callback);
      count++;
    }
    return count;
  }
}

