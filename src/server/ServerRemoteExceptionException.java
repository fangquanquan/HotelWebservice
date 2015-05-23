
/**
 * ServerRemoteExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package server;

public class ServerRemoteExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1432271353667L;
    
    private server.ServerRemoteException faultMessage;

    
        public ServerRemoteExceptionException() {
            super("ServerRemoteExceptionException");
        }

        public ServerRemoteExceptionException(java.lang.String s) {
           super(s);
        }

        public ServerRemoteExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServerRemoteExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(server.ServerRemoteException msg){
       faultMessage = msg;
    }
    
    public server.ServerRemoteException getFaultMessage(){
       return faultMessage;
    }
}
    