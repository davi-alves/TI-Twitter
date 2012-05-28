/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author davi
 */
public class Helper {

    /**
     * @param request
     * @return 
     */
    public static void getMessage(HttpServletRequest request) {
        Message m = (Message) request.getAttribute("message");
        if(m == null){
            m = new Message();
        }
        request.setAttribute("message", m);
    }
}
