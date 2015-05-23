
/**
 * ServerIOExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package server;

public class ServerIOExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1432271353657L;
    
    private server.ServerIOException faultMessage;

    
        public ServerIOExceptionException() {
            super("ServerIOExceptionException");
        }

        public ServerIOExceptionException(java.lang.String s) {
           super(s);
        }

        public ServerIOExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServerIOExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(server.ServerIOException msg){
       faultMessage = msg;
    }
    
    public server.ServerIOException getFaultMessage(){
       return faultMessage;
    }
}
    